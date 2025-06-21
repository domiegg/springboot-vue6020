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


import com.dao.JiudianguanliyuanDao;
import com.entity.JiudianguanliyuanEntity;
import com.service.JiudianguanliyuanService;
import com.entity.vo.JiudianguanliyuanVO;
import com.entity.view.JiudianguanliyuanView;

@Service("jiudianguanliyuanService")
public class JiudianguanliyuanServiceImpl extends ServiceImpl<JiudianguanliyuanDao, JiudianguanliyuanEntity> implements JiudianguanliyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiudianguanliyuanEntity> page = this.selectPage(
                new Query<JiudianguanliyuanEntity>(params).getPage(),
                new EntityWrapper<JiudianguanliyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiudianguanliyuanEntity> wrapper) {
		  Page<JiudianguanliyuanView> page =new Query<JiudianguanliyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiudianguanliyuanVO> selectListVO(Wrapper<JiudianguanliyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiudianguanliyuanVO selectVO(Wrapper<JiudianguanliyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiudianguanliyuanView> selectListView(Wrapper<JiudianguanliyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiudianguanliyuanView selectView(Wrapper<JiudianguanliyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
