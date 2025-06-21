package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiudianguanliyuanEntity;
import com.entity.view.JiudianguanliyuanView;

import com.service.JiudianguanliyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 酒店管理员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-29 22:30:35
 */
@RestController
@RequestMapping("/jiudianguanliyuan")
public class JiudianguanliyuanController {
    @Autowired
    private JiudianguanliyuanService jiudianguanliyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JiudianguanliyuanEntity u = jiudianguanliyuanService.selectOne(new EntityWrapper<JiudianguanliyuanEntity>().eq("guanlizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"jiudianguanliyuan",  "酒店管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JiudianguanliyuanEntity jiudianguanliyuan){
    	//ValidatorUtils.validateEntity(jiudianguanliyuan);
    	JiudianguanliyuanEntity u = jiudianguanliyuanService.selectOne(new EntityWrapper<JiudianguanliyuanEntity>().eq("guanlizhanghao", jiudianguanliyuan.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		jiudianguanliyuan.setId(uId);
        jiudianguanliyuanService.insert(jiudianguanliyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        JiudianguanliyuanEntity u = jiudianguanliyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JiudianguanliyuanEntity u = jiudianguanliyuanService.selectOne(new EntityWrapper<JiudianguanliyuanEntity>().eq("guanlizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        jiudianguanliyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiudianguanliyuanEntity jiudianguanliyuan,
		HttpServletRequest request){
        EntityWrapper<JiudianguanliyuanEntity> ew = new EntityWrapper<JiudianguanliyuanEntity>();

		PageUtils page = jiudianguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudianguanliyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiudianguanliyuanEntity jiudianguanliyuan, 
		HttpServletRequest request){
        EntityWrapper<JiudianguanliyuanEntity> ew = new EntityWrapper<JiudianguanliyuanEntity>();

		PageUtils page = jiudianguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudianguanliyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiudianguanliyuanEntity jiudianguanliyuan){
       	EntityWrapper<JiudianguanliyuanEntity> ew = new EntityWrapper<JiudianguanliyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiudianguanliyuan, "jiudianguanliyuan")); 
        return R.ok().put("data", jiudianguanliyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiudianguanliyuanEntity jiudianguanliyuan){
        EntityWrapper< JiudianguanliyuanEntity> ew = new EntityWrapper< JiudianguanliyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiudianguanliyuan, "jiudianguanliyuan")); 
		JiudianguanliyuanView jiudianguanliyuanView =  jiudianguanliyuanService.selectView(ew);
		return R.ok("查询酒店管理员成功").put("data", jiudianguanliyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiudianguanliyuanEntity jiudianguanliyuan = jiudianguanliyuanService.selectById(id);
        return R.ok().put("data", jiudianguanliyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiudianguanliyuanEntity jiudianguanliyuan = jiudianguanliyuanService.selectById(id);
        return R.ok().put("data", jiudianguanliyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiudianguanliyuanEntity jiudianguanliyuan, HttpServletRequest request){
        if(jiudianguanliyuanService.selectCount(new EntityWrapper<JiudianguanliyuanEntity>().eq("guanlizhanghao", jiudianguanliyuan.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
    	jiudianguanliyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiudianguanliyuan);
    	JiudianguanliyuanEntity u = jiudianguanliyuanService.selectOne(new EntityWrapper<JiudianguanliyuanEntity>().eq("guanlizhanghao", jiudianguanliyuan.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jiudianguanliyuan.setId(new Date().getTime());
        jiudianguanliyuanService.insert(jiudianguanliyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiudianguanliyuanEntity jiudianguanliyuan, HttpServletRequest request){
        if(jiudianguanliyuanService.selectCount(new EntityWrapper<JiudianguanliyuanEntity>().eq("guanlizhanghao", jiudianguanliyuan.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
    	jiudianguanliyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiudianguanliyuan);
    	JiudianguanliyuanEntity u = jiudianguanliyuanService.selectOne(new EntityWrapper<JiudianguanliyuanEntity>().eq("guanlizhanghao", jiudianguanliyuan.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jiudianguanliyuan.setId(new Date().getTime());
        jiudianguanliyuanService.insert(jiudianguanliyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiudianguanliyuanEntity jiudianguanliyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiudianguanliyuan);
        if(jiudianguanliyuanService.selectCount(new EntityWrapper<JiudianguanliyuanEntity>().ne("id", jiudianguanliyuan.getId()).eq("guanlizhanghao", jiudianguanliyuan.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
        jiudianguanliyuanService.updateById(jiudianguanliyuan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JiudianguanliyuanEntity> list = new ArrayList<JiudianguanliyuanEntity>();
        for(Long id : ids) {
            JiudianguanliyuanEntity jiudianguanliyuan = jiudianguanliyuanService.selectById(id);
            jiudianguanliyuan.setSfsh(sfsh);
            jiudianguanliyuan.setShhf(shhf);
            list.add(jiudianguanliyuan);
        }
        jiudianguanliyuanService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiudianguanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
