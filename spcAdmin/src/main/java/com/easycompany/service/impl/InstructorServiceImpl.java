package com.easycompany.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycompany.mapper.InstructorMapper;
import com.easycompany.service.InstructorService;
import com.easycompany.service.vo.AdBoardVo;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("instructorService")
@Transactional
public class InstructorServiceImpl extends EgovAbstractServiceImpl implements InstructorService {
	
	@Autowired
	private InstructorMapper instructorMapper;

	@Override
	public List<AdBoardVo> getBoardList(AdBoardVo adBoardVo) {
		return instructorMapper.getBoardList(adBoardVo);
	}

	@Override
	public int getBoardCount(AdBoardVo adBoardVo) {
		return instructorMapper.getBoardCount(adBoardVo);
	}

	@Override
	public AdBoardVo selectDetailBoard(AdBoardVo adBoardVo) {
		return instructorMapper.selectDetailBoard(adBoardVo);
	}

	@Override
	public int insertBoard(AdBoardVo adBoardVo) {
		return instructorMapper.insertBoard(adBoardVo);
	}

	@Override
	public int updateBoard(AdBoardVo adBoardVo) {
		return instructorMapper.updateBoard(adBoardVo);
	}

	@Override
	public int delBoard(HashMap<String, Object> map) {
		return instructorMapper.delBoard(map);
	}

}
