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
		if("banner".equals(mainVo.getGubun2())){
			sqlName = "insertBanner";
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
		if("banner".equals(mainVo.getGubun2())){
			sqlName = "getBannerDetail";
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
	
	public int deleteCommonFile(MainVo mainVo) {		
		String sqlName = "deleteCommonFile";
		return (Integer) delete(nameSpace + "." + sqlName, mainVo);
	}
	
	public int updateCommon(MainVo mainVo) {
		
		String sqlName = "updateLogo";
		
		if("img".equals(mainVo.getGubun2())){
			sqlName = "updateImg";
		}
		if("banner".equals(mainVo.getGubun2())){
			sqlName = "updateBanner";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "updatePopUp";
		}
		return (Integer) update(nameSpace + "." + sqlName, mainVo);
	}
	
	public int updateCommonFile(MainVo mainVo) {
		
		String sqlName = "updateCommonFile";
		return (Integer) update(nameSpace + "." + sqlName, mainVo);
	}
	
	public int deleteCommon(MainVo mainVo) {
	
		String sqlName = "deleteLogo";
		
		if("img".equals(mainVo.getGubun2())){
			sqlName = "deleteImg";
		}
		if("banner".equals(mainVo.getGubun2())){
			sqlName = "deleteBanner";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "deletePopUp";
		}
		return (Integer) update(nameSpace + "." + sqlName, mainVo);
	}
	
	public List<MainVo> getCommonList(MainVo mainVo) throws DataAccessException {
		
		String sqlName = "getImgist";

		if("banner".equals(mainVo.getGubun2())){
			sqlName = "getBannerList";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "getPopUpList";
		}
		return selectList(nameSpace + "." + sqlName, mainVo);
	}
	
	public int getCommonCount(MainVo mainVo) {
		
		String sqlName = "getImgCount";
		
		if("banner".equals(mainVo.getGubun2())){
			sqlName = "getBannerCount";
		}
		if("popUp".equals(mainVo.getGubun2())){
			sqlName = "getPopUpCount";
		}
		
		return (Integer)selectOne(nameSpace + "." + sqlName, mainVo);
	}
	
	
}
