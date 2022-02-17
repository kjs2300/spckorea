package com.easycompany.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.easycompany.service.vo.LmsVo;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("lmsMapper")
public class LmsMapper extends EgovAbstractMapper {
	
	String nameSpace = "com.easycompany.mapper.LmsMapper";

	public List<LmsVo> contentsList(LmsVo lmsVo) {
		return selectList(nameSpace + ".contentsList", lmsVo);
	}

	public int contentsListCnt(LmsVo lmsVo) {
		return selectOne(nameSpace + ".contentsListCnt", lmsVo);
	}

	public LmsVo selectDetailLms(LmsVo lmsVo) {
		return selectOne(nameSpace + ".selectDetailLms", lmsVo);
	}

	public int insertContents(LmsVo lmsVo) {
		return (Integer) insert(nameSpace + ".insertContents", lmsVo);
	}

	public void insertLmsFile(Map<String, Object> map) {
		insert(nameSpace + ".insertLmsFile", map);
	}

	public int updateContents(LmsVo lmsVo) {
		return (Integer) update(nameSpace + ".updateContents", lmsVo);
	}

}
