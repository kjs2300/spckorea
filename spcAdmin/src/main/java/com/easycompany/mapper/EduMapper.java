package com.easycompany.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

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
		
		return (Integer) insert(nameSpace + "." + sqlName, categoryVo);
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
		return (Integer)selectOne(nameSpace + "." + sqlName, categoryVo);
	}
	
	public CategoryVo getCategoryDetail(CategoryVo categoryVo) {
		

		String sqlName = "getCategoryDetail";

		if("eduInfoScheduleList".equals(categoryVo.getGubun2())){
			sqlName = "getEduInfoDetail";
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
   
   public int insertCatgegory3(CategoryVo categoryVo) {
		
		String sqlName = "insertCategory3";
		
		return (Integer) insert(nameSpace + "." + sqlName, categoryVo);
	}
   
	public List<CategoryVo> getCategoryCodeList(CategoryVo categoryVo) throws DataAccessException {
		String sqlName = "getCategoryCodeList";
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
