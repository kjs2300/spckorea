package com.easycompany.service.impl;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycompany.mapper.EduMapper;
import com.easycompany.service.EduService;
import com.easycompany.service.vo.CategoryVo;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("eduService")
@Transactional
public  class EduServiceImpl extends EgovAbstractServiceImpl implements EduService {
	
	
	@Autowired
	private EduMapper eduMapper;
	
	
	public List<CategoryVo> getCategoryList(CategoryVo categoryVo) throws Exception{
		return eduMapper.getCategoryList(categoryVo);
	}
	
	public int getCategoryCount(CategoryVo categoryVo) {
		return eduMapper.getCategoryCount(categoryVo);
	}
	
	public int getCategoryExist(CategoryVo categoryVo) {
		return eduMapper.getCategoryExist(categoryVo);
	}
	
	  
	public int insertCatgegory(CategoryVo categoryVo) {
		return eduMapper.insertCatgegory(categoryVo);
	}

	public CategoryVo getCategoryDetail(CategoryVo categoryVo) {
		return (CategoryVo)eduMapper.getCategoryDetail(categoryVo);
	}
	
	public int deleteCategory(CategoryVo categoryVo) {
		
		if("category1".equals(categoryVo.getGubun2())){
			eduMapper.deleteCategory1Sub2(categoryVo);
			eduMapper.deleteCategory1Sub3(categoryVo);
		}
		
		if("category2".equals(categoryVo.getGubun2())){
			eduMapper.deleteCategory2Sub3(categoryVo);
		}
		return eduMapper.deleteCategory(categoryVo);
	}
	
	public int updateCategory(CategoryVo categoryVo) {
		return eduMapper.updateCategory(categoryVo);
	}
	
	public int insertCatgegory3(CategoryVo categoryVo) {
		return eduMapper.insertCatgegory3(categoryVo);
	}
	
	public List<CategoryVo> getCategoryCodeList(CategoryVo categoryVo) throws Exception{
		return eduMapper.getCategoryCodeList(categoryVo);
	}
	
   public int deleteSchedule(CategoryVo categoryVo) {

		return eduMapper.deleteSchedule(categoryVo);
	}
	
	public int updateSchedule(CategoryVo categoryVo) {
		return eduMapper.updateSchedule(categoryVo);
	}
	
	public int insertSchedule(CategoryVo categoryVo) {
		return eduMapper.insertSchedule(categoryVo);
	}
}
