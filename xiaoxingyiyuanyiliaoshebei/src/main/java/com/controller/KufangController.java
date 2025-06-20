
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
 * 库房
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kufang")
public class KufangController {
    private static final Logger logger = LoggerFactory.getLogger(KufangController.class);

    private static final String TABLE_NAME = "kufang";

    @Autowired
    private KufangService kufangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaigoujihuaService caigoujihuaService;//设备采购
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private LingdaoService lingdaoService;//领导
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private ShebeiService shebeiService;//设备
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
        params.put("kufangDeleteStart",1);params.put("kufangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = kufangService.queryPage(params);

        //字典表数据转换
        List<KufangView> list =(List<KufangView>)page.getList();
        for(KufangView c:list){
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
        KufangEntity kufang = kufangService.selectById(id);
        if(kufang !=null){
            //entity转view
            KufangView view = new KufangView();
            BeanUtils.copyProperties( kufang , view );//把实体数据重构到view中
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
    public R save(@RequestBody KufangEntity kufang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kufang:{}",this.getClass().getName(),kufang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KufangEntity> queryWrapper = new EntityWrapper<KufangEntity>()
            .eq("kufang_name", kufang.getKufangName())
            .eq("kufang_types", kufang.getKufangTypes())
            .eq("kufang_address", kufang.getKufangAddress())
            .eq("kufang_delete", kufang.getKufangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KufangEntity kufangEntity = kufangService.selectOne(queryWrapper);
        if(kufangEntity==null){
            kufang.setKufangDelete(1);
            kufang.setInsertTime(new Date());
            kufang.setCreateTime(new Date());
            kufangService.insert(kufang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KufangEntity kufang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,kufang:{}",this.getClass().getName(),kufang.toString());
        KufangEntity oldKufangEntity = kufangService.selectById(kufang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            kufangService.updateById(kufang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<KufangEntity> oldKufangList =kufangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<KufangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            KufangEntity kufangEntity = new KufangEntity();
            kufangEntity.setId(id);
            kufangEntity.setKufangDelete(2);
            list.add(kufangEntity);
        }
        if(list != null && list.size() >0){
            kufangService.updateBatchById(list);
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
            List<KufangEntity> kufangList = new ArrayList<>();//上传的东西
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
                            KufangEntity kufangEntity = new KufangEntity();
//                            kufangEntity.setKufangUuidNumber(data.get(0));                    //库房编号 要改的
//                            kufangEntity.setKufangName(data.get(0));                    //库房名称 要改的
//                            kufangEntity.setKufangTypes(Integer.valueOf(data.get(0)));   //库房类型 要改的
//                            kufangEntity.setKufangAddress(data.get(0));                    //库房地址 要改的
//                            kufangEntity.setKufangContent("");//详情和图片
//                            kufangEntity.setKufangDelete(1);//逻辑删除字段
//                            kufangEntity.setInsertTime(date);//时间
//                            kufangEntity.setCreateTime(date);//时间
                            kufangList.add(kufangEntity);


                            //把要查询是否重复的字段放入map中
                                //库房编号
                                if(seachFields.containsKey("kufangUuidNumber")){
                                    List<String> kufangUuidNumber = seachFields.get("kufangUuidNumber");
                                    kufangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kufangUuidNumber = new ArrayList<>();
                                    kufangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kufangUuidNumber",kufangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //库房编号
                        List<KufangEntity> kufangEntities_kufangUuidNumber = kufangService.selectList(new EntityWrapper<KufangEntity>().in("kufang_uuid_number", seachFields.get("kufangUuidNumber")).eq("kufang_delete", 1));
                        if(kufangEntities_kufangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KufangEntity s:kufangEntities_kufangUuidNumber){
                                repeatFields.add(s.getKufangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [库房编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kufangService.insertBatch(kufangList);
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

