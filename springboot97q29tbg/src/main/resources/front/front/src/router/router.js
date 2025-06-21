import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import jiudianguanliyuanList from '../pages/jiudianguanliyuan/list'
import jiudianguanliyuanDetail from '../pages/jiudianguanliyuan/detail'
import jiudianguanliyuanAdd from '../pages/jiudianguanliyuan/add'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import jiudiankefangList from '../pages/jiudiankefang/list'
import jiudiankefangDetail from '../pages/jiudiankefang/detail'
import jiudiankefangAdd from '../pages/jiudiankefang/add'
import yudingxinxiList from '../pages/yudingxinxi/list'
import yudingxinxiDetail from '../pages/yudingxinxi/detail'
import yudingxinxiAdd from '../pages/yudingxinxi/add'
import ruzhuxinxiList from '../pages/ruzhuxinxi/list'
import ruzhuxinxiDetail from '../pages/ruzhuxinxi/detail'
import ruzhuxinxiAdd from '../pages/ruzhuxinxi/add'
import tuifangxinxiList from '../pages/tuifangxinxi/list'
import tuifangxinxiDetail from '../pages/tuifangxinxi/detail'
import tuifangxinxiAdd from '../pages/tuifangxinxi/add'
import dingdanpingjiaList from '../pages/dingdanpingjia/list'
import dingdanpingjiaDetail from '../pages/dingdanpingjia/detail'
import dingdanpingjiaAdd from '../pages/dingdanpingjia/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'jiudianguanliyuan',
					component: jiudianguanliyuanList
				},
				{
					path: 'jiudianguanliyuanDetail',
					component: jiudianguanliyuanDetail
				},
				{
					path: 'jiudianguanliyuanAdd',
					component: jiudianguanliyuanAdd
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'jiudiankefang',
					component: jiudiankefangList
				},
				{
					path: 'jiudiankefangDetail',
					component: jiudiankefangDetail
				},
				{
					path: 'jiudiankefangAdd',
					component: jiudiankefangAdd
				},
				{
					path: 'yudingxinxi',
					component: yudingxinxiList
				},
				{
					path: 'yudingxinxiDetail',
					component: yudingxinxiDetail
				},
				{
					path: 'yudingxinxiAdd',
					component: yudingxinxiAdd
				},
				{
					path: 'ruzhuxinxi',
					component: ruzhuxinxiList
				},
				{
					path: 'ruzhuxinxiDetail',
					component: ruzhuxinxiDetail
				},
				{
					path: 'ruzhuxinxiAdd',
					component: ruzhuxinxiAdd
				},
				{
					path: 'tuifangxinxi',
					component: tuifangxinxiList
				},
				{
					path: 'tuifangxinxiDetail',
					component: tuifangxinxiDetail
				},
				{
					path: 'tuifangxinxiAdd',
					component: tuifangxinxiAdd
				},
				{
					path: 'dingdanpingjia',
					component: dingdanpingjiaList
				},
				{
					path: 'dingdanpingjiaDetail',
					component: dingdanpingjiaDetail
				},
				{
					path: 'dingdanpingjiaAdd',
					component: dingdanpingjiaAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
