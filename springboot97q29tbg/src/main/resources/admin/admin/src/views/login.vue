<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230831/206c5946d0df4398889fb00c865fccd6.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form :style='{"border":"0px solid #f6f6f6","minHeight":"1000px","padding":"0px 20px 20px","boxShadow":"0 0px 0px rgba(0, 0, 0, .2)","margin":"0 auto","borderRadius":"0px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230811/c518cf0ec8c5434facdea340da558cd1.png) no-repeat 64% 240px,url(http://codegen.caihongy.cn/20230811/35998be3b95844a68cab0b7410497ea1.png) no-repeat center top / 100% 100%","width":"40%","fontSize":"16px","position":"relative","height":"auto"}'>
        <div v-if="true" :style='{"padding":"0px","margin":"180px auto 230px","borderColor":"#ddd","color":"#333","background":"none","borderWidth":"0px","display":"inline-block","width":"80%","lineHeight":"auto","fontSize":"26px","borderStyle":"solid","fontWeight":"600"}' class="title-container">酒店管理系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"50%","margin":"0 auto 30px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>用户名：</div>
          <input :style='{"border":"0px solid rgba(167,142,68,.2)","padding":"0 10px","boxShadow":"0 0px 0px rgba(60, 60, 60, .1)","borderColor":"#ddd","color":"#666","outline":"0px solid #efefef","outlineOffset":"0px","borderRadius":"0px","background":"none","borderWidth":"1px","width":"100%","fontSize":"inherit","borderStyle":"solid","height":"44px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"50%","margin":"0 auto 30px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>密码：</div>
          <input :style='{"border":"0px solid rgba(167,142,68,.2)","padding":"0 10px","boxShadow":"0 0px 0px rgba(60, 60, 60, .1)","borderColor":"#ddd","color":"#666","outline":"0px solid #efefef","outlineOffset":"0px","borderRadius":"0px","background":"none","borderWidth":"1px","width":"100%","fontSize":"inherit","borderStyle":"solid","height":"44px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

        <div :style='{"boxShadow":"0 0px 0px rgba(60, 60, 60, .1)","padding":"0 0px","margin":"10px auto","borderColor":"#bfbfbf","borderRadius":"0px","textAlign":"left","borderWidth":"0px","width":"50%","fontSize":"inherit","lineHeight":"44px","borderStyle":"solid"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>

		
        <div :style='{"margin":"20px auto 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"50%","fontSize":"16px","position":"relative","justifyContent":"flex-start"}'>
          <el-button v-if="loginType==1" :style='{"border":"0px solid #fff","cursor":"pointer","padding":"0 0 0 20px","margin":"0 0 20px","color":"#fff","textAlign":"center","letterSpacing":"10px","outline":"none","borderRadius":"10px","background":"linear-gradient(180deg, rgba(163,207,63,1) 0%, rgba(99,126,36,1) 100%)","width":"100%","fontSize":"20px","height":"50px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 8px","margin":"0 5px 10px","borderColor":"rgba(167,142,68,1)","color":"#333","outline":"none","borderRadius":"0px","background":"none","borderWidth":"0px","width":"auto","fontSize":"inherit","borderStyle":"solid","fontWeight":"500","height":"40px"}' type="primary" @click="register('jiudianguanliyuan')" class="register">注册酒店管理员</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20230831/206c5946d0df4398889fb00c865fccd6.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 0px solid rgba(167,142,68,.2);
		padding: 0 10px;
		color: #666;
		font-size: inherit;
		border-color: #ddd;
		outline-offset: 0px;
		border-radius: 0px;
		box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
		outline: 0px solid #efefef;
		background: none;
		width: 100%;
		border-width: 1px;
		border-style: solid;
		height: 44px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 1px solid rgba(64, 158, 255, 1);
		padding: 0 10px;
		box-shadow: 0 0 6px rgba(64, 158, 255, .5);
		outline: 1px solid #efefef;
		color: rgba(64, 158, 255, 1);
		width: 288px;
		font-size: 14px;
		outline-offset: 4px;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border-radius: 0px;
  	  	padding: 0 10px;
  	  	box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
  	  	outline: none;
  	  	color: #666;
  	  	background: none;
  	  	width: calc(100% - 90px);
  	  	font-size: inherit;
  	  	border-color: #ddd;
  	  	border-width: 1px;
  	  	border-style: solid;
  	  	height: 44px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #bfbfbf;
        border-color: #bfbfbf;
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 16px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgba(50,50,50,1);
        font-size: 16px;
      }
}

</style>
