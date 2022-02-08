package com.easycompany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycompany.mapper.AdBoardMapper;
import com.easycompany.service.AdBoardService;
import com.easycompany.service.vo.AdBoardVo;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("adBoardService")
@Transactional
public class AdBoardServiceImpl extends EgovAbstractServiceImpl implements AdBoardService {
	
	@Autowired
	private AdBoardMapper adBoardMapper;

	@Override
	public List<AdBoardVo> getBoardList(AdBoardVo adBoardVo) {
		return adBoardMapper.getBoardList(adBoardVo);
	}

	@Override
	public int getBoardCount(AdBoardVo adBoardVo) {
		return adBoardMapper.getBoardCount(adBoardVo);
	}

	@Override
	public AdBoardVo selectDetailBoard(AdBoardVo adBoardVo) {
		return adBoardMapper.selectDetailBoard(adBoardVo);
	}

}
