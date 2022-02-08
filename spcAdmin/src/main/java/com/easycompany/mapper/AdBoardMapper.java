package com.easycompany.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.easycompany.service.vo.AdBoardVo;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("adBoardMapper")
public class AdBoardMapper extends EgovAbstractMapper {
	
	String nameSpace = "com.easycompany.mapper.AdBoardMapper";

	public List<AdBoardVo> getBoardList(AdBoardVo adBoardVo) {
		return selectList(nameSpace + ".getBoardList", adBoardVo);
	}

	public int getBoardCount(AdBoardVo adBoardVo) {
		return selectOne(nameSpace + ".getBoardCount", adBoardVo);
	}

	public AdBoardVo selectDetailBoard(AdBoardVo adBoardVo) {
		return selectOne(nameSpace + ".selectDetailBoard", adBoardVo);
	}
	

}
