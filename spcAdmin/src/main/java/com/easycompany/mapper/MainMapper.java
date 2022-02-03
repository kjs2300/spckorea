package com.easycompany.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.easycompany.service.vo.CategoryVo;
import com.easycompany.service.vo.MainVo;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("mainMapper")
public class MainMapper extends EgovAbstractMapper{

	//private static final Logger LOGGER = LoggerFactory.getLogger(BoardMapper.class);
	
	String nameSpace = "com.easycompany.mapper.MainMapper";
	
	public int insertCommon(MainVo mainVo) {
		
		String sqlName = "insertLogo";

		if("img".equals(mainVo.getGubun2())){
			sqlName = "insertImg";
		}
		if("baner".equals(mainVo.getGubun2())){
			sqlName = "insertBaner";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "insertPopUp";
		}
		return (Integer) insert(nameSpace + "." + sqlName, mainVo);
	}


	public MainVo getCommonDetail(MainVo mainVo) {
		
		String sqlName = "getLogoDetail";

		if("img".equals(mainVo.getGubun2())){
			sqlName = "getImgDetail";
		}
		if("baner".equals(mainVo.getGubun2())){
			sqlName = "getBanerDetail";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "getPopUpDetail";
		}
		return (MainVo)selectOne(nameSpace + "." + sqlName, mainVo);
	}
	
	public int insertCommonFile(MainVo mainVo) {		
		String sqlName = "insertCommonFile";
		return (Integer) insert(nameSpace + "." + sqlName, mainVo);
	}
	
	
	public int updateCommon(MainVo mainVo) {
		
		String sqlName = "updateLogo";
		
		if("img".equals(mainVo.getGubun2())){
			sqlName = "updateImg";
		}
		if("baner".equals(mainVo.getGubun2())){
			sqlName = "updateBaner";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "updatePopUp";
		}
		return (Integer) update(nameSpace + "." + sqlName, mainVo);
	}
	
	public int deleteCommon(MainVo mainVo) {
	
		String sqlName = "deleteLogo";
		
		if("img".equals(mainVo.getGubun2())){
			sqlName = "deleteImg";
		}
		if("baner".equals(mainVo.getGubun2())){
			sqlName = "deleteBaner";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "deletePopUp";
		}
		return (Integer) update(nameSpace + "." + sqlName, mainVo);
	}
}
