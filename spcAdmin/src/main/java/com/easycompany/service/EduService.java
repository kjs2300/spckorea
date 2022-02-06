package com.easycompany.service;

import java.util.List;

import com.easycompany.service.vo.CategoryVo;;


public interface EduService {
	
	
	public List<CategoryVo> getCategoryList(CategoryVo categoryVo) throws Exception;
	public int getCategoryExist(CategoryVo categoryVo);
	public int insertCatgegory(CategoryVo categoryVo);
	
	public int getCategoryCount(CategoryVo      categoryVo);
	public CategoryVo getCategoryDetail(CategoryVo categoryVo);
	public int deleteCategory(CategoryVo        categoryVo);	
	public int updateCategory(CategoryVo        categoryVo);
	public int insertCatgegory3(CategoryVo categoryVo);
	public List<CategoryVo> getCategoryCodeList(CategoryVo categoryVo) throws Exception;
	public int deleteSchedule(CategoryVo        categoryVo);	
	public int updateSchedule(CategoryVo        categoryVo);
	public int insertSchedule(CategoryVo categoryVo);
	
	public List<CategoryVo> getEducationList(CategoryVo categoryVo) throws Exception;
	public int getEducationCount(CategoryVo      categoryVo);	
	public int insertEducation(CategoryVo categoryVo);
	public int getEducationNo(CategoryVo categoryVo);
	public int insertEducationSub(CategoryVo categoryVo);
	public int deleteEduCation(CategoryVo        categoryVo);	
	public String getEduCationFile(CategoryVo categoryVo);
	public CategoryVo getEduCationDetail(CategoryVo categoryVo);
	public List<CategoryVo>  getEduCationDetailSub(CategoryVo categoryVo);
}
