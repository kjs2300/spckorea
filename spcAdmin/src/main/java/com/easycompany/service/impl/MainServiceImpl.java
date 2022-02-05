package com.easycompany.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycompany.mapper.MainMapper;
import com.easycompany.service.MainService;
import com.easycompany.service.vo.MainVo ;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("mainService")
@Transactional
public  class MainServiceImpl extends EgovAbstractServiceImpl implements MainService {
		
	@Autowired
	private MainMapper mainMapper;
	
	public MainVo  getCommonDetail(MainVo  mainVo) {
		return (MainVo)mainMapper.getCommonDetail(mainVo);
	}
	
	
	public int insertCommon(MainVo mainVo) {
		
		int cnt = mainMapper.insertCommonFile(mainVo);
		if(cnt > 0) {
			return mainMapper.insertCommon(mainVo);
		}
		return 0;
	}
	
	public int updateCommon(MainVo  mainVo) {
		
		if(! "N".equals(mainVo.getGubun3())) {
			int cnt = mainMapper.updateCommonFile(mainVo);
			if(cnt > 0) {
				return mainMapper.updateCommon(mainVo);
			}
		}else {
			return mainMapper.updateCommon(mainVo);
		}
		
		return 0;
	}
	
	public int deleteCommon(MainVo  mainVo) {		
		mainMapper.deleteCommonFile(mainVo);
		return mainMapper.deleteCommon(mainVo);
	}
	
	public List<MainVo> getCommonList(MainVo  mainVo) throws Exception{
		return mainMapper.getCommonList(mainVo);
	}
	
	public int getCommonCount(MainVo  mainVo) {
		return mainMapper.getCommonCount(mainVo);
	}
}
