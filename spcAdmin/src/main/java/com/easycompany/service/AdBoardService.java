package com.easycompany.service;

import java.util.HashMap;
import java.util.List;

import com.easycompany.service.vo.AdBoardVo;

public interface AdBoardService {

	List<AdBoardVo> getBoardList(AdBoardVo adBoardVo);

	int getBoardCount(AdBoardVo adBoardVo);

	AdBoardVo selectDetailBoard(AdBoardVo adBoardVo);

	int insertBoard(AdBoardVo adBoardVo);

	int updateBoard(AdBoardVo adBoardVo);

	int delBoard(HashMap<String, Object> map);

}
