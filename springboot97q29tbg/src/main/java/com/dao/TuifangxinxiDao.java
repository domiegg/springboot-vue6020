package com.dao;

import com.entity.TuifangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuifangxinxiVO;
import com.entity.view.TuifangxinxiView;


/**
 * 退房信息
 * 
 * @author 
 * @email 
 * @date 2024-03-29 22:30:35
 */
public interface TuifangxinxiDao extends BaseMapper<TuifangxinxiEntity> {
	
	List<TuifangxinxiVO> selectListVO(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
	
	TuifangxinxiVO selectVO(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
	
	List<TuifangxinxiView> selectListView(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);

	List<TuifangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);

	
	TuifangxinxiView selectView(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
	

}
