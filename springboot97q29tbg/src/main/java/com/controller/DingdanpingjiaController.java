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

import com.entity.DingdanpingjiaEntity;
import com.entity.view.DingdanpingjiaView;

import com.service.DingdanpingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单评价
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-29 22:30:36
 */
@RestController
@RequestMapping("/dingdanpingjia")
public class DingdanpingjiaController {
    @Autowired
    private DingdanpingjiaService dingdanpingjiaService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanpingjiaEntity dingdanpingjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingdanpingjia.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiudianguanliyuan")) {
			dingdanpingjia.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanpingjiaEntity> ew = new EntityWrapper<DingdanpingjiaEntity>();

		PageUtils page = dingdanpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanpingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanpingjiaEntity dingdanpingjia, 
		HttpServletRequest request){
        EntityWrapper<DingdanpingjiaEntity> ew = new EntityWrapper<DingdanpingjiaEntity>();

		PageUtils page = dingdanpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanpingjia), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanpingjiaEntity dingdanpingjia){
       	EntityWrapper<DingdanpingjiaEntity> ew = new EntityWrapper<DingdanpingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanpingjia, "dingdanpingjia")); 
        return R.ok().put("data", dingdanpingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanpingjiaEntity dingdanpingjia){
        EntityWrapper< DingdanpingjiaEntity> ew = new EntityWrapper< DingdanpingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanpingjia, "dingdanpingjia")); 
		DingdanpingjiaView dingdanpingjiaView =  dingdanpingjiaService.selectView(ew);
		return R.ok("查询订单评价成功").put("data", dingdanpingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanpingjiaEntity dingdanpingjia = dingdanpingjiaService.selectById(id);
        return R.ok().put("data", dingdanpingjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanpingjiaEntity dingdanpingjia = dingdanpingjiaService.selectById(id);
        return R.ok().put("data", dingdanpingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanpingjiaEntity dingdanpingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanpingjia);
        dingdanpingjiaService.insert(dingdanpingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanpingjiaEntity dingdanpingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanpingjia);
        dingdanpingjiaService.insert(dingdanpingjia);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanpingjiaEntity dingdanpingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanpingjia);
        dingdanpingjiaService.updateById(dingdanpingjia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanpingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
