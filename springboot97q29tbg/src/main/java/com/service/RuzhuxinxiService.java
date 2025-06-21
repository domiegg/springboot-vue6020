package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RuzhuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RuzhuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RuzhuxinxiView;


/**
 * 入住信息
 *
 * @author 
 * @email 
 * @date 2024-03-29 22:30:35
 */
public interface RuzhuxinxiService extends IService<RuzhuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RuzhuxinxiVO> selectListVO(Wrapper<RuzhuxinxiEntity> wrapper);
   	
   	RuzhuxinxiVO selectVO(@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);
   	
   	List<RuzhuxinxiView> selectListView(Wrapper<RuzhuxinxiEntity> wrapper);
   	
   	RuzhuxinxiView selectView(@Param("ew") Wrapper<RuzhuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RuzhuxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<RuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<RuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<RuzhuxinxiEntity> wrapper);



}

