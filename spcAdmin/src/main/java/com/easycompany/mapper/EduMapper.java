package com.easycompany.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.easycompany.cmm.util.StringUtil;
import com.easycompany.service.vo.CategoryVo;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("eduMapper")
public class EduMapper extends EgovAbstractMapper{

	//private static final Logger LOGGER = LoggerFactory.getLogger(BoardMapper.class);
	
	String nameSpace = "com.easycompany.mapper.EduMapper";
	
	public List<CategoryVo> getCategoryList(CategoryVo categoryVo) throws DataAccessException {
		

		String sqlName = "getCategoryList1";

		if("category2".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryList2";
		}
		
		if("category3".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryList3";
		}
		if("category".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryList";
		}
	
		if("eduInfoScheduleList".equals(categoryVo.getGubun2())){
			sqlName = "eduInfoScheduleList";
		}
		
		if("categoryClass".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassList";
		}
		
		if("category4".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassList1";
		}
		
		if("category5".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassList2";
		}
		
		if("category6".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassList3";
		}
		
		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "getEeuInfoOnlineLList";
		}
		
		
		return selectList(nameSpace + "." + sqlName, categoryVo);
	}


	public int getCategoryExist(CategoryVo categoryVo) {
		
		String sqlName = "getCategoryExist1";

		if("category2".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryExist2";
		}
		
		if("category3".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryExist3";
		}
		if("category4".equals(categoryVo.getGubun2())){
			sqlName = "getClassCategoryExist1";
		}
		
		if("category5".equals(categoryVo.getGubun2())){
			sqlName = "getClassCategoryExist2";
		}
		
		if("category6".equals(categoryVo.getGubun2())){
			sqlName = "getClassCategoryExist3";
		}
		return (Integer)selectOne(nameSpace + "." + sqlName , categoryVo);
	}
	
	
	public int insertCatgegory(CategoryVo categoryVo) {
		
		String sqlName = "insertCategory1";

		if("category2".equals(categoryVo.getGubun2())){
			sqlName = "insertCategory2";
		}
		
		if("category3".equals(categoryVo.getGubun2())){
			sqlName = "insertCategory3";
		}
		if("category4".equals(categoryVo.getGubun2())){
			sqlName = "insertClassCategory1";
		}
		
		if("category5".equals(categoryVo.getGubun2())){
			sqlName = "insertClassCategory2";
		}
		
		if("category6".equals(categoryVo.getGubun2())){
			sqlName = "insertClassCategory3";
		}
		
		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "insertEduInfoOnline";
		}
		
		return (Integer) insert(nameSpace + "." + sqlName, categoryVo);
	}

	public int insertEducation(CategoryVo categoryVo) {
		
		String sqlName = "insertEduInfoOnline";

		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "insertEduInfoOnline";
		}
		
		return (Integer) insert(nameSpace + "." + sqlName, categoryVo);
	}
	
	public int insertEducationSub(CategoryVo categoryVo) {
		
		String sqlName = "insertEduInfoOnlineSub";

		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "insertEduInfoOnlineSub";
		}
		
		return (Integer) insert(nameSpace + "." + sqlName, categoryVo);
	}
	
	public int getEducationNo(CategoryVo categoryVo) {
		
		String sqlName = "getEduInfoOnlineNo";
		
		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "getEduInfoOnlineNo";
		}
		return (Integer)selectOne(nameSpace + "." + sqlName , categoryVo);
	}
	
	

	public int getCategoryCount(CategoryVo categoryVo) {
		
		String sqlName = "getCategoryCount1";

		if("category2".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryCount2";
		}
		
		if("category3".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryCount3";
		}
		
		if("category".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryCount";
		}
		if("eduInfoScheduleList".equals(categoryVo.getGubun2())){
			sqlName = "eduInfoScheduleCount";
		}
		
		if("categoryClass".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassCount";
		}
		
		if("category4".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassCount1";
		}
		
		if("category5".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassCount2";
		}
		
		if("category6".equals(categoryVo.getGubun2())){
			sqlName = "getCategoryClassCount3";
		}
		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "getEeuInfoOnlineCount";
		}
		
		return (Integer)selectOne(nameSpace + "." + sqlName, categoryVo);
	}
	
	public CategoryVo getCategoryDetail(CategoryVo categoryVo) {
		

		String sqlName = "getCategoryDetail";

		if("eduInfoScheduleList".equals(categoryVo.getGubun2())){
			sqlName = "getEduInfoDetail";
		}
		
		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "getEeuInfoOnlineDetail";
		}
		return (CategoryVo)selectOne(nameSpace + "." + sqlName, categoryVo);
	}
	
	public int deleteCategory(CategoryVo categoryVo) {
		
		String sqlName = "deleteCategory1";

		if("category2".equals(categoryVo.getGubun2())){
			sqlName = "deleteCategory2";
		}
		
		if("category3".equals(categoryVo.getGubun2())){
			sqlName = "deleteCategory3";
		}
		if("category4".equals(categoryVo.getGubun2())){
			sqlName = "deleteClassCategory1";
		}
		if("category5".equals(categoryVo.getGubun2())){
			sqlName = "deleteClassCategory2";
		}
		if("category6".equals(categoryVo.getGubun2())){
			sqlName = "deleteClassCategory3";
		}
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
	}
	
	public int updateCategory(CategoryVo categoryVo) {
		
		String sqlName = "updateCategory1";

		if("category2".equals(categoryVo.getGubun2())){
			sqlName = "updateCategory2";
		}
		
		if("category3".equals(categoryVo.getGubun2())){
			sqlName = "updateCategory3";
		}
		
		if("category4".equals(categoryVo.getGubun2())){
			sqlName = "updateClassCategory1";
		}
		
		if("category5".equals(categoryVo.getGubun2())){
			sqlName = "updateClassCategory2";
		}
		
		if("category6".equals(categoryVo.getGubun2())){
			sqlName = "updateClassCategory3";
		}
		return (Integer) update(nameSpace + "." + sqlName, categoryVo);
	}

	
   public int deleteCategory1Sub2(CategoryVo categoryVo) {
		String sqlName = "deleteCategory1Sub2";
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
	}
	
   public int deleteCategory1Sub3(CategoryVo categoryVo) {
		String sqlName = "deleteCategory1Sub3";
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
	}
   
   public int deleteCategory2Sub3(CategoryVo categoryVo) {
		String sqlName = "deleteCategory2Sub3";
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
	}
   
   public int deleteClassCategory1Sub2(CategoryVo categoryVo) {
		String sqlName = "deleteClassCategory1Sub2";
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
	}
	
   public int deleteClassCategory1Sub3(CategoryVo categoryVo) {
		String sqlName = "deleteClassCategory1Sub3";
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
	}
   
   public int deleteClassCategory2Sub3(CategoryVo categoryVo) {
		String sqlName = "deleteClassCategory2Sub3";
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
	}
   
   public int insertCatgegory3(CategoryVo categoryVo) {
		
		String sqlName = "insertCategory3";
		
		return (Integer) insert(nameSpace + "." + sqlName, categoryVo);
	}
   
	public List<CategoryVo> getCategoryCodeList(CategoryVo categoryVo) throws DataAccessException {
		String sqlName = "getCategoryCodeList";
	
		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			sqlName = "getOnlineCategoryCodeList";
		}
		
		return selectList(nameSpace + "." + sqlName, categoryVo);
	}
	
   public int deleteSchedule(CategoryVo categoryVo) {
		String sqlName = "deleteSchedule";
		return (Integer) delete(nameSpace + "." + sqlName, categoryVo);
   }
   
   public int insertSchedule(CategoryVo categoryVo) {
		String sqlName = "insertSchedule";
		return (Integer) insert(nameSpace + "." + sqlName, categoryVo);
	}
   
	public int updateSchedule(CategoryVo categoryVo) {
		String sqlName = "updateSchedule";
		return (Integer) update(nameSpace + "." + sqlName, categoryVo);
	}
}
