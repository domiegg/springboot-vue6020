<template>
<div>
	<div :style='{"padding":"20px 7%","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"none","borderWidth":"0 0 1px","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/jiudiankefang"><a>{{item.name}}</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"padding":"20px 7%","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"none","borderWidth":"0 0 1px","width":"100%","borderStyle":"solid"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="detail-preview" :style='{"padding":"0 7%","margin":"40px auto","alignItems":"flex-start","flexWrap":"wrap","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
		<div class="attr" :style='{"padding":"0","margin":"0","flexWrap":"wrap","background":"none","flex":"1","display":"flex","width":"55%","position":"relative","justifyContent":"space-between","order":"2"}'>

			<div class="info" :style='{"width":"100%","padding":"0px","margin":"0","background":"#fff","flex":"1","order":"2"}'>
				<div class="item" :style='{"padding":"0 40px 0 20px","margin":"0 0 10px 0","overflow":"hidden","alignItems":"center","background":"linear-gradient(180deg, rgba(88,242,214,1) 0%, rgba(26,188,158,1) 50%),#1abc9e","display":"flex","clipPath":"polygon(100% 65%, 97% 100%, 0% 100%, 0% 0%, 100% 0%)","lineHeight":"50px","justifyContent":"space-between","height":"50px"}'>
					<div :style='{"width":"calc(100% - 300px)","fontSize":"16px","overflow":"hidden","color":"#fff"}'>
                    {{detail.jiudianmingcheng}}
                    </div>
					<div @click="storeup(1)" v-show="!isStoreup" :style='{"border":"1px solid #ffffff50","cursor":"pointer","padding":"0 10px","lineHeight":"32px","borderRadius":"30px","background":"#ffffff20"}'><i v-if="false" :style='{"color":"#fff","fontSize":"16px"}' class="el-icon-star-off"></i><span :style='{"color":"#fff","fontSize":"14px"}'>点我收藏({{detail.storeupnum}})</span></div>
					<div @click="storeup(-1)" v-show="isStoreup" :style='{"border":"1px solid #ffffff50","cursor":"pointer","padding":"0 10px","lineHeight":"32px","borderRadius":"30px","background":"#ffffff20"}'><i v-if="false" :style='{"color":"#fff","fontSize":"16px"}' class="el-icon-star-on"></i><span :style='{"color":"#fff","fontSize":"14px"}'>取消收藏({{detail.storeupnum}})</span></div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>酒店编号</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.jiudianbianhao}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>酒店类别</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.jiudianleibie}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>酒店星级</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.jiudianxingji}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>房间类型</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.fangjianleixing}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>数量</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.shuliang}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>价格（天）</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.jiage}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>房间状态</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.fangjianzhuangtai}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>联系电话</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.lianxidianhua}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>酒店地址</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.jiudiandizhi}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>管理账号</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.guanlizhanghao}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>管理姓名</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.guanlixingming}}</div>
				</div>
				<div class="item" :style='{"padding":"0 10px","margin":"0 0 0px 0","borderColor":"#eee","background":"none","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#999","textAlign":"right","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}'>点击次数</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.clicknum}}</div>
				</div>
				<div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#333","borderRadius":"0px","background":"#009cf530","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('jiudiankefang','修改')" @click="editClick">修改</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#333","borderRadius":"0px","background":"#f5340030","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('jiudiankefang','删除')" @click="delClick">删除</el-button>
					
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#333","borderRadius":"0px","background":"#1abc9e30","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('jiudiankefang','一键预订')" @click="onAcross('yudingxinxi','','','','')" type="warning">一键预订</el-button>
				</div>
			</div>
		</div>
		
			<div class="swiper3" v-if="detailBanner.length" :style='{"width":"100%","margin":"0 0 30px 0","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
			  <div class="big" :style='{"border":"1px solid #1abc9e50","width":"48%","margin":"0 0 20px","position":"relative","background":"#fff","height":"400px"}'>
				<img id="big" :style='{"boxShadow":"0 1px 8px rgba(0,0,0,.3)","objectFit":"cover","top":"10px","left":"10px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' :src="swiperBigUrl" class="image">
			  </div>
			  <div class="samll" :style='{"padding":"0 0px","overflow":"hidden","flexWrap":"wrap","background":"#fff","display":"flex","width":"48%","justifyContent":"space-between","height":"412px"}'>
			    <div :style='{"border":"1px solid #1abc9e50","width":"48%","margin":"0 0px 20px","position":"relative","background":"#fff","height":"190px"}' v-for="item in detailBanner" :key="item.id">
				  <img :style='{"boxShadow":"0 1px 8px rgba(0,0,0,.2)","objectFit":"cover","top":"5px","left":"5px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' v-if="item.substr(0,4)=='http'" :src="item" @click="swiperClick3(item)" class="image">
				  <img :style='{"boxShadow":"0 1px 8px rgba(0,0,0,.2)","objectFit":"cover","top":"5px","left":"5px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' v-else :src="baseUrl + item" @click="swiperClick3(baseUrl + item)" class="image">
			    </div>
			  </div>
			</div>


		

		<div class="detail2" :style='{"border":"0px solid #ddd","padding":"0px","margin":"40px 0","borderRadius":"0px","background":"#fff","width":"100%","order":"50"}'>
			<div :style='{"border":"1px solid #f6f6f6","padding":"10px","boxShadow":"0px 6px 6px -6px #999","margin":"0 0 16px 0","borderRadius":"4px","background":"#fcfcfc"}'>
				<div :style='{"color":"#333","fontSize":"16px","fontWeight":"600"}'>酒店介绍</div>
			</div>
			<div :style='{"background":"#FFF"}' v-html="detail.jiudianjieshao"></div>
		</div>
		
		<el-tabs class="detail" :style='{"border":"1px solid #1abc9e20","boxShadow":"none","margin":"20px auto","background":"#fff","display":"block","width":"100%","order":"10"}' v-model="activeName" type="border-card">
		</el-tabs>
	</div>
	<div class="share_view" :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","position":"fixed","right":"0","bottom":"20%","background":"#fff","zIndex":"11"}'>
	</div>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  import axios from 'axios'
  import Swiper from "swiper";
  
  export default {
    //数据集合
    data() {
      return {
        tablename: 'jiudiankefang',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '酒店客房'
          }
        ],
        title: '',
        detailBanner: [],
		userid: localStorage.getItem('frontUserid'),
		id: 0,
        detail: {},
        activeName: 'first',
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        storeupParams: {
          name: '',
          picture: '',
          refid: 0,
          tablename: 'jiudiankefang',
          userid: localStorage.getItem('frontUserid')
        },
        isStoreup: false,
        storeupInfo: {},
        buynumber: 1,
		centerType: false,
		shareUrl: location.href,
		swiperBigUrl: null,
      }
    },
    created() {
		if(this.$route.query.centerType) {
			this.centerType = true
		}
		
        this.init();
    },
	mounted() {
	},
    //方法集合
    methods: {
		swiperClick3(src) {
			this.swiperBigUrl = src
		},
        init() {
		  this.id = this.$route.query.id
          this.baseUrl = this.$config.baseUrl;
          this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.title = this.detail.jiudianmingcheng;
              this.detailBanner = this.detail.tupian ? this.detail.tupian.split(",") : [];
              this.$forceUpdate();

				if(localStorage.getItem('frontToken')){
					this.getStoreupStatus();
				}

            }
			if (this.detailBanner.length) {
				if (this.detailBanner[0].substr(0,4)=='http') {
					this.swiperBigUrl = this.detailBanner[0]
				} else {
					this.swiperBigUrl = this.baseUrl + this.detailBanner[0]
				}
			}
          });
        },
      async onAcross(acrossTable,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
        localStorage.setItem('crossTable',`jiudiankefang`);
        localStorage.setItem('crossObj', JSON.stringify(this.detail));
        localStorage.setItem('statusColumnName',statusColumnName);
        localStorage.setItem('statusColumnValue',statusColumnValue);
        localStorage.setItem('tips',tips);
        if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
            var obj = JSON.parse(localStorage.getItem('crossObj'));
            for (var o in obj){
                if(o==statusColumnName && obj[o]==statusColumnValue){
                    this.$message({
                        type: 'error',
                        message: tips,
                        duration: 1500
                    });
                    return
                }
            }
        }
        this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
      },
      storeup(type) {
        if (type == 1 && !this.isStoreup) {
          this.storeupParams.name = this.title;
          this.storeupParams.picture = this.detailBanner[0];
          this.storeupParams.refid = this.detail.id;
          this.storeupParams.type = type;
          this.$http.post('storeup/add', this.storeupParams).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = true;
			  this.detail.storeupnum++
			  this.$http.post('jiudiankefang/update', this.detail).then(res => {});
              this.$message({
                type: 'success',
                message: '收藏成功!',
                duration: 1500,
              });
            }
          });
        }
        if (type == -1 && this.isStoreup) {
          this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'jiudiankefang', userid: localStorage.getItem('frontUserid')}}).then(res => {
            if (res.data.code == 0 && res.data.data.list.length > 0) {
              this.isStoreup = true;
              this.storeupInfo = res.data.data.list[0];
              let delIds = new Array();
              delIds.push(this.storeupInfo.id);
              this.$http.post('storeup/delete', delIds).then(res => {
                if (res.data.code == 0) {
                  this.isStoreup = false;
				  this.detail.storeupnum--
				  this.$http.post('jiudiankefang/update', this.detail).then(res => {});
                  this.$message({
                    type: 'success',
                    message: '取消成功!',
                    duration: 1500,
                  });
                }
              });
            }
          });
        }
      },
      getStoreupStatus(){
        if(localStorage.getItem("frontToken")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'jiudiankefang', userid: localStorage.getItem('frontUserid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isStoreup = true;
                this.storeupInfo = res.data.data.list[0];
              }
            });
        }
      },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
		// 返回按钮
		backClick(){
			history.back()
		},
		// 下载
		download(file){
			if(!file) {
				this.$message({
				  type: 'error',
				  message: '文件不存在',
				  duration: 1500,
				});
				return;
			}
		  let arr = file.replace(new RegExp('upload/', "g"), "")
		  axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: localStorage.getItem("frontToken")
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  },err=>{
			  axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
			  	headers: {
			  		token: localStorage.getItem("frontToken")
			  	},
			  	responseType: "blob"
			  }).then(({
			  	data
			  }) => {
			  	const binaryData = [];
			  	binaryData.push(data);
			  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
			  		type: 'application/pdf;chartset=UTF-8'
			  	}))
			  	const a = document.createElement('a')
			  	a.href = objectUrl
			  	a.download = arr
			  	// a.click()
			  	// 下面这个写法兼容火狐
			  	a.dispatchEvent(new MouseEvent('click', {
			  		bubbles: true,
			  		cancelable: true,
			  		view: window
			  	}))
			  	window.URL.revokeObjectURL(data)
			  })
		  })
      },


		// 权限判断
		btnAuth(tableName,key){
			if(this.centerType){
				return this.isBackAuth(tableName,key)
			}else{
				return this.isAuth(tableName,key)
			}
		},
		// 修改
		editClick(){
			this.$router.push(`/index/jiudiankefangAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		async delClick(){
			await this.$confirm('是否删除此酒店客房？')
			  .then(_ => {
			    this.$http.post('jiudiankefang/delete', [this.detail.id]).then(async res => {
					if (res.data.code == 0) {
						this.$http.get('storeup/list',{params:{
							page: 1,
							limit: 100,
							refid: this.detail.id,
							tablename: 'jiudiankefang',
						}}).then(async obj=>{
							if(obj.data&&obj.data.code==0){
								let arr = []
								for(let x in obj.data.data.list){
									arr.push(obj.data.data.list[x].id)
								}
								await this.$http.post('storeup/delete',arr).then(()=>{})
								this.$message({
									type: 'success',
									message: '删除成功!',
									duration: 1500,
									onClose: () => {
										history.back()
									}
								});
							}
						})
					}
			    });
			  }).catch(_ => {});
		},
    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 0px 0 0 0px;
		top: 2px;
		left: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 32px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #666;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		right: 1px;
		border-radius: 0 0px 0px 0;
		top: 2px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 32px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #666;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		border-radius: 0px;
		padding: 0 10px;
		outline: none;
		color: #666;
		background: #fff;
		display: inline-block;
		width: 100%;
		font-size: 14px;
		line-height: 34px;
		text-align: center;
		height: 34px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		margin: 0;
		background: #1abc9e10;
		border-color: #1abc9e20;
		border-width: 0 0 1px 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 0;
		padding: 0 20px;
		margin: 0;
		color: #999;
		background: transparent;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		line-height: 40px;
		position: relative;
		list-style: none;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		border: 0;
		color: #1abc9e;
		background: #fff;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		color: #1abc9e;
		background: #fff;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #ccc;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #333;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #666;
		display: inline-block;
	}
		
	.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #1abc9e;
		text-align: center;
		min-width: 30px;
		height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #1abc9e;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	.share_view{
		position: fixed;
		right:0;
		bottom: 20%;
		background: #fff;
		box-shadow: 0 4px 6px rgba(0,0,0,.1);
		.share{
			width: 40px;
			height: 40px;
			display: flex;
			align-items: center;
			justify-content: center;
			border-bottom: 1px solid #eee;
			cursor: pointer;
		}
		.share:last-of-type{
			border:none;
		}
	}


	.detail-preview .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	
	.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
