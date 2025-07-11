package com.entity.view;

import com.entity.TuifangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 退房信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-29 22:30:35
 */
@TableName("tuifangxinxi")
public class TuifangxinxiView  extends TuifangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TuifangxinxiView(){
	}
 
 	public TuifangxinxiView(TuifangxinxiEntity tuifangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tuifangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
