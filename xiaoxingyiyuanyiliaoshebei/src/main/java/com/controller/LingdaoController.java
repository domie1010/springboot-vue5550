
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
 * 领导
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/lingdao")
public class LingdaoController {
    private static final Logger logger = LoggerFactory.getLogger(LingdaoController.class);

    private static final String TABLE_NAME = "lingdao";

    @Autowired
    private LingdaoService lingdaoService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaigoujihuaService caigoujihuaService;//设备采购
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private KufangService kufangService;//库房
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
        params.put("lingdaoDeleteStart",1);params.put("lingdaoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = lingdaoService.queryPage(params);

        //字典表数据转换
        List<LingdaoView> list =(List<LingdaoView>)page.getList();
        for(LingdaoView c:list){
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
        LingdaoEntity lingdao = lingdaoService.selectById(id);
        if(lingdao !=null){
            //entity转view
            LingdaoView view = new LingdaoView();
            BeanUtils.copyProperties( lingdao , view );//把实体数据重构到view中
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
    public R save(@RequestBody LingdaoEntity lingdao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,lingdao:{}",this.getClass().getName(),lingdao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LingdaoEntity> queryWrapper = new EntityWrapper<LingdaoEntity>()
            .eq("username", lingdao.getUsername())
            .or()
            .eq("lingdao_phone", lingdao.getLingdaoPhone())
            .or()
            .eq("lingdao_id_number", lingdao.getLingdaoIdNumber())
            .andNew()
            .eq("lingdao_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LingdaoEntity lingdaoEntity = lingdaoService.selectOne(queryWrapper);
        if(lingdaoEntity==null){
            lingdao.setLingdaoDelete(1);
            lingdao.setInsertTime(new Date());
            lingdao.setCreateTime(new Date());
            lingdao.setPassword("123456");
            lingdaoService.insert(lingdao);
            return R.ok();
        }else {
            return R.error(511,"账户或者领导手机号或者领导身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LingdaoEntity lingdao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,lingdao:{}",this.getClass().getName(),lingdao.toString());
        LingdaoEntity oldLingdaoEntity = lingdaoService.selectById(lingdao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(lingdao.getLingdaoPhoto()) || "null".equals(lingdao.getLingdaoPhoto())){
                lingdao.setLingdaoPhoto(null);
        }

            lingdaoService.updateById(lingdao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LingdaoEntity> oldLingdaoList =lingdaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<LingdaoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LingdaoEntity lingdaoEntity = new LingdaoEntity();
            lingdaoEntity.setId(id);
            lingdaoEntity.setLingdaoDelete(2);
            list.add(lingdaoEntity);
        }
        if(list != null && list.size() >0){
            lingdaoService.updateBatchById(list);
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
            List<LingdaoEntity> lingdaoList = new ArrayList<>();//上传的东西
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
                            LingdaoEntity lingdaoEntity = new LingdaoEntity();
//                            lingdaoEntity.setUsername(data.get(0));                    //账户 要改的
//                            //lingdaoEntity.setPassword("123456");//密码
//                            lingdaoEntity.setLingdaoName(data.get(0));                    //领导名称 要改的
//                            lingdaoEntity.setLingdaoPhone(data.get(0));                    //领导手机号 要改的
//                            lingdaoEntity.setLingdaoIdNumber(data.get(0));                    //领导身份证号 要改的
//                            lingdaoEntity.setLingdaoPhoto("");//详情和图片
//                            lingdaoEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            lingdaoEntity.setLingdaoEmail(data.get(0));                    //领导邮箱 要改的
//                            lingdaoEntity.setLingdaoDelete(1);//逻辑删除字段
//                            lingdaoEntity.setInsertTime(date);//时间
//                            lingdaoEntity.setCreateTime(date);//时间
                            lingdaoList.add(lingdaoEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //领导手机号
                                if(seachFields.containsKey("lingdaoPhone")){
                                    List<String> lingdaoPhone = seachFields.get("lingdaoPhone");
                                    lingdaoPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> lingdaoPhone = new ArrayList<>();
                                    lingdaoPhone.add(data.get(0));//要改的
                                    seachFields.put("lingdaoPhone",lingdaoPhone);
                                }
                                //领导身份证号
                                if(seachFields.containsKey("lingdaoIdNumber")){
                                    List<String> lingdaoIdNumber = seachFields.get("lingdaoIdNumber");
                                    lingdaoIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> lingdaoIdNumber = new ArrayList<>();
                                    lingdaoIdNumber.add(data.get(0));//要改的
                                    seachFields.put("lingdaoIdNumber",lingdaoIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<LingdaoEntity> lingdaoEntities_username = lingdaoService.selectList(new EntityWrapper<LingdaoEntity>().in("username", seachFields.get("username")).eq("lingdao_delete", 1));
                        if(lingdaoEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LingdaoEntity s:lingdaoEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //领导手机号
                        List<LingdaoEntity> lingdaoEntities_lingdaoPhone = lingdaoService.selectList(new EntityWrapper<LingdaoEntity>().in("lingdao_phone", seachFields.get("lingdaoPhone")).eq("lingdao_delete", 1));
                        if(lingdaoEntities_lingdaoPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LingdaoEntity s:lingdaoEntities_lingdaoPhone){
                                repeatFields.add(s.getLingdaoPhone());
                            }
                            return R.error(511,"数据库的该表中的 [领导手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //领导身份证号
                        List<LingdaoEntity> lingdaoEntities_lingdaoIdNumber = lingdaoService.selectList(new EntityWrapper<LingdaoEntity>().in("lingdao_id_number", seachFields.get("lingdaoIdNumber")).eq("lingdao_delete", 1));
                        if(lingdaoEntities_lingdaoIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LingdaoEntity s:lingdaoEntities_lingdaoIdNumber){
                                repeatFields.add(s.getLingdaoIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [领导身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        lingdaoService.insertBatch(lingdaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        LingdaoEntity lingdao = lingdaoService.selectOne(new EntityWrapper<LingdaoEntity>().eq("username", username));
        if(lingdao==null || !lingdao.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(lingdao.getLingdaoDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(lingdao.getId(),username, "lingdao", "领导");
        R r = R.ok();
        r.put("token", token);
        r.put("role","领导");
        r.put("username",lingdao.getLingdaoName());
        r.put("tableName","lingdao");
        r.put("userId",lingdao.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody LingdaoEntity lingdao, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<LingdaoEntity> queryWrapper = new EntityWrapper<LingdaoEntity>()
            .eq("username", lingdao.getUsername())
            .or()
            .eq("lingdao_phone", lingdao.getLingdaoPhone())
            .or()
            .eq("lingdao_id_number", lingdao.getLingdaoIdNumber())
            .andNew()
            .eq("lingdao_delete", 1)
            ;
        LingdaoEntity lingdaoEntity = lingdaoService.selectOne(queryWrapper);
        if(lingdaoEntity != null)
            return R.error("账户或者领导手机号或者领导身份证号已经被使用");
        lingdao.setLingdaoDelete(1);
        lingdao.setInsertTime(new Date());
        lingdao.setCreateTime(new Date());
        lingdaoService.insert(lingdao);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        LingdaoEntity lingdao = lingdaoService.selectById(id);
        lingdao.setPassword("123456");
        lingdaoService.updateById(lingdao);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        LingdaoEntity lingdao = lingdaoService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(lingdao.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(lingdao.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        lingdao.setPassword(newPassword);
		lingdaoService.updateById(lingdao);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        LingdaoEntity lingdao = lingdaoService.selectOne(new EntityWrapper<LingdaoEntity>().eq("username", username));
        if(lingdao!=null){
            lingdao.setPassword("123456");
            lingdaoService.updateById(lingdao);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrLingdao(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        LingdaoEntity lingdao = lingdaoService.selectById(id);
        if(lingdao !=null){
            //entity转view
            LingdaoView view = new LingdaoView();
            BeanUtils.copyProperties( lingdao , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}

