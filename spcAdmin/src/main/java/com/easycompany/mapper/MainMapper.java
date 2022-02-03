package com.easycompany.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.easycompany.service.vo.MainVo;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("mainMapper")
public class MainMapper extends EgovAbstractMapper{

	//private static final Logger LOGGER = LoggerFactory.getLogger(BoardMapper.class);
	
	String nameSpace = "com.easycompany.mapper.MainMapper";
	
	
	
	
	public int insertCommon(MainVo mainVo) {
		
		String sqlName = "insertLogo";

		if("category2".equals(mainVo.getGubun1())){
			sqlName = "insertCategory2";
		}
		return (Integer) insert(nameSpace + "." + sqlName, mainVo);
	}


	public MainVo getCommonDetail(MainVo mainVo) {
		

		String sqlName = "getLogoDetail";

		if("eduInfoScheduleList".equals(mainVo.getGubun1())){
			sqlName = "getLogoDetail";
		}
		
		return (MainVo)selectOne(nameSpace + "." + sqlName, mainVo);
	}
	
	
}
