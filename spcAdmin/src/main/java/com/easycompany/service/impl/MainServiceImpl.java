package com.easycompany.service.impl;

import java.util.List;
import java.util.Map;



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
		return mainMapper.insertCommon(mainVo);
	}
	
	}
