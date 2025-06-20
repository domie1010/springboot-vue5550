
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 设备
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shebei")
public class ShebeiController {
    private static final Logger logger = LoggerFactory.getLogger(ShebeiController.class);

    private static final String TABLE_NAME = "shebei";

    @Autowired
    private ShebeiService shebeiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaigoujihuaService caigoujihuaService;//设备采购
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private KufangService kufangService;//库房
    @Autowired
    private LingdaoService lingdaoService;//领导
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private ShebeichurukuService shebeichurukuService;//设备出入库房
    @Autowired
    private ShebeizhuankeService shebeizhuankeService;//设备转科
    @Autowired
    private ShebiebaosunService shebiebaosunService;//设备报损
    @Autowired
    private ShebiejianceService shebiejianceService;//质量检测登记
    @Autowired
    private ShebieweixiuService shebieweixiuService;//设备维修
    @Autowired
    private YonghuService yonghuService;//科室职员
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("科室职员".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("领导".equals(role))
            params.put("lingdaoId",request.getSession().getAttribute("userId"));
        params.put("shebeiDeleteStart",1);params.put("shebeiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shebeiService.queryPage(params);

        //字典表数据转换
        List<ShebeiView> list =(List<ShebeiView>)page.getList();
        for(ShebeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShebeiEntity shebei = shebeiService.selectById(id);
        if(shebei !=null){
            //entity转view
            ShebeiView view = new ShebeiView();
            BeanUtils.copyProperties( shebei , view );//把实体数据重构到view中
            //级联表 库房
            //级联表
            KufangEntity kufang = kufangService.selectById(shebei.getKufangId());
            if(kufang != null){
            BeanUtils.copyProperties( kufang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKufangId(kufang.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeiEntity shebei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shebei:{}",this.getClass().getName(),shebei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShebeiEntity> queryWrapper = new EntityWrapper<ShebeiEntity>()
            .eq("shebei_name", shebei.getShebeiName())
            .eq("shebei_types", shebei.getShebeiTypes())
            .eq("shebei_kucun_number", shebei.getShebeiKucunNumber())
            .eq("kufang_id", shebei.getKufangId())
            .eq("keshi_types", shebei.getKeshiTypes())
            .eq("shangxia_types", shebei.getShangxiaTypes())
            .eq("shebei_delete", shebei.getShebeiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebeiEntity shebeiEntity = shebeiService.selectOne(queryWrapper);
        if(shebeiEntity==null){
            shebei.setShangxiaTypes(1);
            shebei.setShebeiDelete(1);
            shebei.setInsertTime(new Date());
            shebei.setCreateTime(new Date());
            shebeiService.insert(shebei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShebeiEntity shebei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shebei:{}",this.getClass().getName(),shebei.toString());
        ShebeiEntity oldShebeiEntity = shebeiService.selectById(shebei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            shebeiService.updateById(shebei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShebeiEntity> oldShebeiList =shebeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShebeiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShebeiEntity shebeiEntity = new ShebeiEntity();
            shebeiEntity.setId(id);
            shebeiEntity.setShebeiDelete(2);
            list.add(shebeiEntity);
        }
        if(list != null && list.size() >0){
            shebeiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShebeiEntity> shebeiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShebeiEntity shebeiEntity = new ShebeiEntity();
//                            shebeiEntity.setShebeiUuidNumber(data.get(0));                    //设备编号 要改的
//                            shebeiEntity.setShebeiName(data.get(0));                    //设备名称 要改的
//                            shebeiEntity.setShebeiTypes(Integer.valueOf(data.get(0)));   //设备类型 要改的
//                            shebeiEntity.setShebeiKucunNumber(Integer.valueOf(data.get(0)));   //设备库存 要改的
//                            shebeiEntity.setKufangId(Integer.valueOf(data.get(0)));   //库房 要改的
//                            shebeiEntity.setKeshiTypes(Integer.valueOf(data.get(0)));   //所在科室 要改的
//                            shebeiEntity.setShebeiContent("");//详情和图片
//                            shebeiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            shebeiEntity.setShebeiDelete(1);//逻辑删除字段
//                            shebeiEntity.setInsertTime(date);//时间
//                            shebeiEntity.setCreateTime(date);//时间
                            shebeiList.add(shebeiEntity);


                            //把要查询是否重复的字段放入map中
                                //设备编号
                                if(seachFields.containsKey("shebeiUuidNumber")){
                                    List<String> shebeiUuidNumber = seachFields.get("shebeiUuidNumber");
                                    shebeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shebeiUuidNumber = new ArrayList<>();
                                    shebeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shebeiUuidNumber",shebeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //设备编号
                        List<ShebeiEntity> shebeiEntities_shebeiUuidNumber = shebeiService.selectList(new EntityWrapper<ShebeiEntity>().in("shebei_uuid_number", seachFields.get("shebeiUuidNumber")).eq("shebei_delete", 1));
                        if(shebeiEntities_shebeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShebeiEntity s:shebeiEntities_shebeiUuidNumber){
                                repeatFields.add(s.getShebeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [设备编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shebeiService.insertBatch(shebeiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

