package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiudiankefangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiudiankefangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiudiankefangView;


/**
 * 酒店客房
 *
 * @author 
 * @email 
 * @date 2024-03-29 22:30:35
 */
public interface JiudiankefangService extends IService<JiudiankefangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiudiankefangVO> selectListVO(Wrapper<JiudiankefangEntity> wrapper);
   	
   	JiudiankefangVO selectVO(@Param("ew") Wrapper<JiudiankefangEntity> wrapper);
   	
   	List<JiudiankefangView> selectListView(Wrapper<JiudiankefangEntity> wrapper);
   	
   	JiudiankefangView selectView(@Param("ew") Wrapper<JiudiankefangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiudiankefangEntity> wrapper);

   	

}

