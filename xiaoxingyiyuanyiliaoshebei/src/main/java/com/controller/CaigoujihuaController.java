
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
 * 设备采购
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caigoujihua")
public class CaigoujihuaController {
    private static final Logger logger = LoggerFactory.getLogger(CaigoujihuaController.class);

    private static final String TABLE_NAME = "caigoujihua";

    @Autowired
    private CaigoujihuaService caigoujihuaService;


    @Autowired
    private TokenService tokenService;

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
        CommonUtil.checkMap(params);
        PageUtils page = caigoujihuaService.queryPage(params);

        //字典表数据转换
        List<CaigoujihuaView> list =(List<CaigoujihuaView>)page.getList();
        for(CaigoujihuaView c:list){
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
        CaigoujihuaEntity caigoujihua = caigoujihuaService.selectById(id);
        if(caigoujihua !=null){
            //entity转view
            CaigoujihuaView view = new CaigoujihuaView();
            BeanUtils.copyProperties( caigoujihua , view );//把实体数据重构到view中
            //级联表 设备
            //级联表
            ShebeiEntity shebei = shebeiService.selectById(caigoujihua.getShebeiId());
            if(shebei != null){
            BeanUtils.copyProperties( shebei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShebeiId(shebei.getId());
            }
            //级联表 科室职员
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(caigoujihua.getYonghuId());
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
    public R save(@RequestBody CaigoujihuaEntity caigoujihua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caigoujihua:{}",this.getClass().getName(),caigoujihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("科室职员".equals(role))
            caigoujihua.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<CaigoujihuaEntity> queryWrapper = new EntityWrapper<CaigoujihuaEntity>()
            .eq("shebei_id", caigoujihua.getShebeiId())
            .eq("yonghu_id", caigoujihua.getYonghuId())
            .eq("caigoujihua_number", caigoujihua.getCaigoujihuaNumber())
            .in("caigoujihua_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaigoujihuaEntity caigoujihuaEntity = caigoujihuaService.selectOne(queryWrapper);
        if(caigoujihuaEntity==null){
            caigoujihua.setCaigoujihuaYesnoTypes(1);
            caigoujihua.setInsertTime(new Date());
            caigoujihua.setCreateTime(new Date());
            caigoujihuaService.insert(caigoujihua);
            return R.ok();
        }else {
            if(caigoujihuaEntity.getCaigoujihuaYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(caigoujihuaEntity.getCaigoujihuaYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaigoujihuaEntity caigoujihua, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,caigoujihua:{}",this.getClass().getName(),caigoujihua.toString());
        CaigoujihuaEntity oldCaigoujihuaEntity = caigoujihuaService.selectById(caigoujihua.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("科室职员".equals(role))
//            caigoujihua.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            caigoujihuaService.updateById(caigoujihua);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody CaigoujihuaEntity caigoujihuaEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,caigoujihuaEntity:{}",this.getClass().getName(),caigoujihuaEntity.toString());

        CaigoujihuaEntity oldCaigoujihua = caigoujihuaService.selectById(caigoujihuaEntity.getId());//查询原先数据

        if(caigoujihuaEntity.getCaigoujihuaYesnoTypes() == 2){//通过
            ShebeiEntity shebeiEntity = shebeiService.selectById(oldCaigoujihua.getShebeiId());
            shebeiEntity.setShebeiKucunNumber(shebeiEntity.getShebeiKucunNumber() + oldCaigoujihua.getCaigoujihuaNumber());
            shebeiService.updateById(shebeiEntity);
        }
        caigoujihuaService.updateById(caigoujihuaEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CaigoujihuaEntity> oldCaigoujihuaList =caigoujihuaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        caigoujihuaService.deleteBatchIds(Arrays.asList(ids));

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
            List<CaigoujihuaEntity> caigoujihuaList = new ArrayList<>();//上传的东西
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
                            CaigoujihuaEntity caigoujihuaEntity = new CaigoujihuaEntity();
//                            caigoujihuaEntity.setShebeiId(Integer.valueOf(data.get(0)));   //设备 要改的
//                            caigoujihuaEntity.setYonghuId(Integer.valueOf(data.get(0)));   //科室职员 要改的
//                            caigoujihuaEntity.setCaigoujihuaNumber(Integer.valueOf(data.get(0)));   //采购数量 要改的
//                            caigoujihuaEntity.setCaigoujihuaText(data.get(0));                    //备注 要改的
//                            caigoujihuaEntity.setCaigoujihuaYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            caigoujihuaEntity.setCaigoujihuaYesnoText(data.get(0));                    //申请结果 要改的
//                            caigoujihuaEntity.setInsertTime(date);//时间
//                            caigoujihuaEntity.setCreateTime(date);//时间
                            caigoujihuaList.add(caigoujihuaEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        caigoujihuaService.insertBatch(caigoujihuaList);
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

