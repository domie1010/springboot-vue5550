import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import caigoujihua from '@/views/modules/caigoujihua/list'
    import dictionary from '@/views/modules/dictionary/list'
    import kufang from '@/views/modules/kufang/list'
    import lingdao from '@/views/modules/lingdao/list'
    import news from '@/views/modules/news/list'
    import shebei from '@/views/modules/shebei/list'
    import shebeichuruku from '@/views/modules/shebeichuruku/list'
    import shebeizhuanke from '@/views/modules/shebeizhuanke/list'
    import shebiebaosun from '@/views/modules/shebiebaosun/list'
    import shebiejiance from '@/views/modules/shebiejiance/list'
    import shebieweixiu from '@/views/modules/shebieweixiu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryCaigoujihuaYesno from '@/views/modules/dictionaryCaigoujihuaYesno/list'
    import dictionaryKeshi from '@/views/modules/dictionaryKeshi/list'
    import dictionaryKufang from '@/views/modules/dictionaryKufang/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryShebei from '@/views/modules/dictionaryShebei/list'
    import dictionaryShebeichuruku from '@/views/modules/dictionaryShebeichuruku/list'
    import dictionaryShebeichurukuYesno from '@/views/modules/dictionaryShebeichurukuYesno/list'
    import dictionaryShebeizhuankeYesno from '@/views/modules/dictionaryShebeizhuankeYesno/list'
    import dictionaryShebiebaosunYesno from '@/views/modules/dictionaryShebiebaosunYesno/list'
    import dictionaryShebiejianceYesno from '@/views/modules/dictionaryShebiejianceYesno/list'
    import dictionaryShebieweixiuYesno from '@/views/modules/dictionaryShebieweixiuYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryCaigoujihuaYesno',
        name: '申请状态',
        component: dictionaryCaigoujihuaYesno
    }
    ,{
        path: '/dictionaryKeshi',
        name: '科室',
        component: dictionaryKeshi
    }
    ,{
        path: '/dictionaryKufang',
        name: '库房类型',
        component: dictionaryKufang
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryShebei',
        name: '设备类型',
        component: dictionaryShebei
    }
    ,{
        path: '/dictionaryShebeichuruku',
        name: '出入库类型',
        component: dictionaryShebeichuruku
    }
    ,{
        path: '/dictionaryShebeichurukuYesno',
        name: '申请状态',
        component: dictionaryShebeichurukuYesno
    }
    ,{
        path: '/dictionaryShebeizhuankeYesno',
        name: '申请状态',
        component: dictionaryShebeizhuankeYesno
    }
    ,{
        path: '/dictionaryShebiebaosunYesno',
        name: '申请状态',
        component: dictionaryShebiebaosunYesno
    }
    ,{
        path: '/dictionaryShebiejianceYesno',
        name: '申请状态',
        component: dictionaryShebiejianceYesno
    }
    ,{
        path: '/dictionaryShebieweixiuYesno',
        name: '申请状态',
        component: dictionaryShebieweixiuYesno
    }


    ,{
        path: '/caigoujihua',
        name: '设备采购',
        component: caigoujihua
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/kufang',
        name: '库房',
        component: kufang
      }
    ,{
        path: '/lingdao',
        name: '领导',
        component: lingdao
      }
    ,{
        path: '/news',
        name: '公告资讯',
        component: news
      }
    ,{
        path: '/shebei',
        name: '设备',
        component: shebei
      }
    ,{
        path: '/shebeichuruku',
        name: '设备出入库房',
        component: shebeichuruku
      }
    ,{
        path: '/shebeizhuanke',
        name: '设备转科',
        component: shebeizhuanke
      }
    ,{
        path: '/shebiebaosun',
        name: '设备报损',
        component: shebiebaosun
      }
    ,{
        path: '/shebiejiance',
        name: '质量检测登记',
        component: shebiejiance
      }
    ,{
        path: '/shebieweixiu',
        name: '设备维修',
        component: shebieweixiu
      }
    ,{
        path: '/yonghu',
        name: '科室职员',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
