package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanpingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanpingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanpingjiaView;


/**
 * 订单评价
 *
 * @author 
 * @email 
 * @date 2024-03-29 22:30:36
 */
public interface DingdanpingjiaService extends IService<DingdanpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanpingjiaVO> selectListVO(Wrapper<DingdanpingjiaEntity> wrapper);
   	
   	DingdanpingjiaVO selectVO(@Param("ew") Wrapper<DingdanpingjiaEntity> wrapper);
   	
   	List<DingdanpingjiaView> selectListView(Wrapper<DingdanpingjiaEntity> wrapper);
   	
   	DingdanpingjiaView selectView(@Param("ew") Wrapper<DingdanpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanpingjiaEntity> wrapper);

   	

}

