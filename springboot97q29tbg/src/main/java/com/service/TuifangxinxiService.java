package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuifangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuifangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuifangxinxiView;


/**
 * 退房信息
 *
 * @author 
 * @email 
 * @date 2024-03-29 22:30:35
 */
public interface TuifangxinxiService extends IService<TuifangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuifangxinxiVO> selectListVO(Wrapper<TuifangxinxiEntity> wrapper);
   	
   	TuifangxinxiVO selectVO(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
   	
   	List<TuifangxinxiView> selectListView(Wrapper<TuifangxinxiEntity> wrapper);
   	
   	TuifangxinxiView selectView(@Param("ew") Wrapper<TuifangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuifangxinxiEntity> wrapper);

   	

}

