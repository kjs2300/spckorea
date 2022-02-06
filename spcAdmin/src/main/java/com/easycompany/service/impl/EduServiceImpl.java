package com.easycompany.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycompany.mapper.EduMapper;
import com.easycompany.mapper.MainMapper;
import com.easycompany.service.EduService;
import com.easycompany.service.vo.CategoryVo;
import com.easycompany.service.vo.MainVo;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("eduService")
@Transactional
public  class EduServiceImpl extends EgovAbstractServiceImpl implements EduService {
	
	
	@Autowired
	private EduMapper eduMapper;
	
	@Autowired
	private MainMapper mainMapper;
	
	
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

	public int insertEducation(CategoryVo categoryVo) {

		int cnt = 1 ;
		//저장할 키 가져오기
		categoryVo.setEdu_no(eduMapper.getEducationNo(categoryVo));
		
		if("YES".equals(categoryVo.getFileExit())) {
			MainVo mainVo = new MainVo();
			mainVo.setGubun2(categoryVo.getGubun2());
			mainVo.setFile_id(categoryVo.getFile_uuid());
			mainVo.setFile_name(categoryVo.getFile_name());
			mainVo.setFile_full_path(categoryVo.getFile_full_path());
			mainVo.setFile_size(categoryVo.getFile_size());			
			cnt = mainMapper.insertCommonFile(mainVo);
		}
		//온라인 서브 등록
		if(cnt > 0) {
			 if(categoryVo.getEdu_curr1_arr() !=null && categoryVo.getEdu_curr1_arr().length > 0) {
				
				 for (int i = 0; i < categoryVo.getEdu_curr1_arr().length; i++) {				     
					 categoryVo.setEdu_curr1((categoryVo.getEdu_curr1_arr() !=null ? categoryVo.getEdu_curr1_arr()[i] : ""));
					 categoryVo.setEdu_curr2((categoryVo.getEdu_curr2_arr() !=null ? categoryVo.getEdu_curr2_arr()[i] : ""));
					 categoryVo.setEdu_curr3((categoryVo.getEdu_curr3_arr() !=null ? categoryVo.getEdu_curr3_arr()[i] : ""));
					 cnt = eduMapper.insertEducationSub(categoryVo);					 
			     }
			 }
		}
		if (cnt > 0) {
			return eduMapper.insertEducation(categoryVo);
		}
		return 0;
	}
	
	public List<CategoryVo> getEducationList(CategoryVo categoryVo) throws Exception{
		return eduMapper.getEducationList(categoryVo);
	}
	
	public int getEducationCount(CategoryVo categoryVo) {
		return eduMapper.getEducationCount(categoryVo);
	}
	
	public int insertEducationSub(CategoryVo categoryVo) {
		return eduMapper.insertEducationSub(categoryVo);
	}
	
	public int getEducationNo(CategoryVo categoryVo) {
		return eduMapper.getEducationNo(categoryVo);
	}
	
	public String getEduCationFile(CategoryVo categoryVo) {
		return eduMapper.getEduCationFile(categoryVo);
	}
	
	public int deleteEduCation(CategoryVo categoryVo) {
		
		if("eduInfoOnline".equals(categoryVo.getGubun2())){
			eduMapper.deleteEduCationFile(categoryVo);
			eduMapper.deleteEduCationDetail(categoryVo);
		}		
		return eduMapper.deleteEduCation(categoryVo);
	}

	public CategoryVo getCategoryDetail(CategoryVo categoryVo) {
		return (CategoryVo)eduMapper.getCategoryDetail(categoryVo);
	}
	
	public CategoryVo getEduCationDetail(CategoryVo categoryVo) {
		return (CategoryVo)eduMapper.getEduCationDetail(categoryVo);
	}
	
	public  List<CategoryVo>  getEduCationDetailSub(CategoryVo categoryVo) {
		return eduMapper.getEduCationDetailSub(categoryVo);
	}
	
	
	public int deleteCategory(CategoryVo categoryVo) {
		
		if("category1".equals(categoryVo.getGubun2())){
			eduMapper.deleteCategory1Sub2(categoryVo);
			eduMapper.deleteCategory1Sub3(categoryVo);
		}		
		if("category2".equals(categoryVo.getGubun2())){
			eduMapper.deleteCategory2Sub3(categoryVo);
		}
		if("category4".equals(categoryVo.getGubun2())){
			eduMapper.deleteClassCategory1Sub2(categoryVo);
			eduMapper.deleteClassCategory1Sub3(categoryVo);
		}
		
		if("category5".equals(categoryVo.getGubun2())){
			eduMapper.deleteClassCategory2Sub3(categoryVo);
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
