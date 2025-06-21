package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TuifangxinxiDao;
import com.entity.TuifangxinxiEntity;
import com.service.TuifangxinxiService;
import com.entity.vo.TuifangxinxiVO;
import com.entity.view.TuifangxinxiView;

@Service("tuifangxinxiService")
public class TuifangxinxiServiceImpl extends ServiceImpl<TuifangxinxiDao, TuifangxinxiEntity> implements TuifangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuifangxinxiEntity> page = this.selectPage(
                new Query<TuifangxinxiEntity>(params).getPage(),
                new EntityWrapper<TuifangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuifangxinxiEntity> wrapper) {
		  Page<TuifangxinxiView> page =new Query<TuifangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TuifangxinxiVO> selectListVO(Wrapper<TuifangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuifangxinxiVO selectVO(Wrapper<TuifangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuifangxinxiView> selectListView(Wrapper<TuifangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuifangxinxiView selectView(Wrapper<TuifangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
