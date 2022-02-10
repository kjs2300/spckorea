package com.easycompany.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.easycompany.service.vo.AdBoardVo;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("instructorMapper")
public class InstructorMapper extends EgovAbstractMapper {
	
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

	public int insertBoard(AdBoardVo adBoardVo) {
		return (Integer) insert(nameSpace + ".insertBoard", adBoardVo);
	}

	public int updateBoard(AdBoardVo adBoardVo) {
		return (Integer) update(nameSpace + ".updateBoard", adBoardVo);
	}

	public int delBoard(HashMap<String, Object> map) {
		return (Integer) update(nameSpace + ".delBoard", map);
	}
	

}
