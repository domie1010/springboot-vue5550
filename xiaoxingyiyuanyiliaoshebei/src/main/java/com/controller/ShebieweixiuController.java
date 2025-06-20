
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
 * 设备维修
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shebieweixiu")
public class ShebieweixiuController {
    private static final Logger logger = LoggerFactory.getLogger(ShebieweixiuController.class);

    private static final String TABLE_NAME = "shebieweixiu";

    @Autowired
    private ShebieweixiuService shebieweixiuService;


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
        CommonUtil.checkMap(params);
        PageUtils page = shebieweixiuService.queryPage(params);

        //字典表数据转换
        List<ShebieweixiuView> list =(List<ShebieweixiuView>)page.getList();
        for(ShebieweixiuView c:list){
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
        ShebieweixiuEntity shebieweixiu = shebieweixiuService.selectById(id);
        if(shebieweixiu !=null){
            //entity转view
            ShebieweixiuView view = new ShebieweixiuView();
            BeanUtils.copyProperties( shebieweixiu , view );//把实体数据重构到view中
            //级联表 设备
            //级联表
            ShebeiEntity shebei = shebeiService.selectById(shebieweixiu.getShebeiId());
            if(shebei != null){
            BeanUtils.copyProperties( shebei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShebeiId(shebei.getId());
            }
            //级联表 科室职员
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shebieweixiu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody ShebieweixiuEntity shebieweixiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shebieweixiu:{}",this.getClass().getName(),shebieweixiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("科室职员".equals(role))
            shebieweixiu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShebieweixiuEntity> queryWrapper = new EntityWrapper<ShebieweixiuEntity>()
            .eq("shebei_id", shebieweixiu.getShebeiId())
            .eq("yonghu_id", shebieweixiu.getYonghuId())
            .eq("shebieweixiu_number", shebieweixiu.getShebieweixiuNumber())
            .in("shebieweixiu_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebieweixiuEntity shebieweixiuEntity = shebieweixiuService.selectOne(queryWrapper);
        if(shebieweixiuEntity==null){
            shebieweixiu.setShebieweixiuYesnoTypes(1);
            shebieweixiu.setInsertTime(new Date());
            shebieweixiu.setCreateTime(new Date());
            shebieweixiuService.insert(shebieweixiu);
            return R.ok();
        }else {
            if(shebieweixiuEntity.getShebieweixiuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(shebieweixiuEntity.getShebieweixiuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShebieweixiuEntity shebieweixiu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shebieweixiu:{}",this.getClass().getName(),shebieweixiu.toString());
        ShebieweixiuEntity oldShebieweixiuEntity = shebieweixiuService.selectById(shebieweixiu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("科室职员".equals(role))
//            shebieweixiu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            shebieweixiuService.updateById(shebieweixiu);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShebieweixiuEntity shebieweixiuEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shebieweixiuEntity:{}",this.getClass().getName(),shebieweixiuEntity.toString());

        ShebieweixiuEntity oldShebieweixiu = shebieweixiuService.selectById(shebieweixiuEntity.getId());//查询原先数据

//        if(shebieweixiuEntity.getShebieweixiuYesnoTypes() == 2){//通过
//            shebieweixiuEntity.setShebieweixiuTypes();
//        }else if(shebieweixiuEntity.getShebieweixiuYesnoTypes() == 3){//拒绝
//            shebieweixiuEntity.setShebieweixiuTypes();
//        }
        shebieweixiuService.updateById(shebieweixiuEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShebieweixiuEntity> oldShebieweixiuList =shebieweixiuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shebieweixiuService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShebieweixiuEntity> shebieweixiuList = new ArrayList<>();//上传的东西
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
                            ShebieweixiuEntity shebieweixiuEntity = new ShebieweixiuEntity();
//                            shebieweixiuEntity.setShebeiId(Integer.valueOf(data.get(0)));   //设备 要改的
//                            shebieweixiuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //科室职员 要改的
//                            shebieweixiuEntity.setShebieweixiuNumber(Integer.valueOf(data.get(0)));   //维修数量 要改的
//                            shebieweixiuEntity.setShebieweixiuText(data.get(0));                    //备注 要改的
//                            shebieweixiuEntity.setShebieweixiuYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            shebieweixiuEntity.setShebieweixiuYesnoText(data.get(0));                    //申请结果 要改的
//                            shebieweixiuEntity.setInsertTime(date);//时间
//                            shebieweixiuEntity.setCreateTime(date);//时间
                            shebieweixiuList.add(shebieweixiuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shebieweixiuService.insertBatch(shebieweixiuList);
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

