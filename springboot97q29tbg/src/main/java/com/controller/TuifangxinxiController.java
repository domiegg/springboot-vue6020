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

import com.entity.TuifangxinxiEntity;
import com.entity.view.TuifangxinxiView;

import com.service.TuifangxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 退房信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-29 22:30:35
 */
@RestController
@RequestMapping("/tuifangxinxi")
public class TuifangxinxiController {
    @Autowired
    private TuifangxinxiService tuifangxinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuifangxinxiEntity tuifangxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tuifangxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiudianguanliyuan")) {
			tuifangxinxi.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TuifangxinxiEntity> ew = new EntityWrapper<TuifangxinxiEntity>();

		PageUtils page = tuifangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuifangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuifangxinxiEntity tuifangxinxi, 
		HttpServletRequest request){
        EntityWrapper<TuifangxinxiEntity> ew = new EntityWrapper<TuifangxinxiEntity>();

		PageUtils page = tuifangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuifangxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuifangxinxiEntity tuifangxinxi){
       	EntityWrapper<TuifangxinxiEntity> ew = new EntityWrapper<TuifangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuifangxinxi, "tuifangxinxi")); 
        return R.ok().put("data", tuifangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuifangxinxiEntity tuifangxinxi){
        EntityWrapper< TuifangxinxiEntity> ew = new EntityWrapper< TuifangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuifangxinxi, "tuifangxinxi")); 
		TuifangxinxiView tuifangxinxiView =  tuifangxinxiService.selectView(ew);
		return R.ok("查询退房信息成功").put("data", tuifangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuifangxinxiEntity tuifangxinxi = tuifangxinxiService.selectById(id);
        return R.ok().put("data", tuifangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuifangxinxiEntity tuifangxinxi = tuifangxinxiService.selectById(id);
        return R.ok().put("data", tuifangxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuifangxinxiEntity tuifangxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tuifangxinxi);
        tuifangxinxiService.insert(tuifangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuifangxinxiEntity tuifangxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tuifangxinxi);
        tuifangxinxiService.insert(tuifangxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuifangxinxiEntity tuifangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuifangxinxi);
        tuifangxinxiService.updateById(tuifangxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TuifangxinxiEntity> list = new ArrayList<TuifangxinxiEntity>();
        for(Long id : ids) {
            TuifangxinxiEntity tuifangxinxi = tuifangxinxiService.selectById(id);
            tuifangxinxi.setSfsh(sfsh);
            tuifangxinxi.setShhf(shhf);
            list.add(tuifangxinxi);
        }
        tuifangxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuifangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
