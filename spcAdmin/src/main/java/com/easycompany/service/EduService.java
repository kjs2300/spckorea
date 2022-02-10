package com.easycompany.service;

import com.easycompany.service.vo.CategoryVo;
import java.util.List;

public abstract interface EduService
{
  public abstract List<CategoryVo> getCategoryList(CategoryVo paramCategoryVo)
    throws Exception;

  public abstract int getCategoryExist(CategoryVo paramCategoryVo);

  public abstract int insertCatgegory(CategoryVo paramCategoryVo);

  public abstract int getCategoryCount(CategoryVo paramCategoryVo);

  public abstract CategoryVo getCategoryDetail(CategoryVo paramCategoryVo);

  public abstract int deleteCategory(CategoryVo paramCategoryVo);

  public abstract int updateCategory(CategoryVo paramCategoryVo);

  public abstract int insertCatgegory3(CategoryVo paramCategoryVo);

  public abstract List<CategoryVo> getCategoryCodeList(CategoryVo paramCategoryVo)
    throws Exception;

  public abstract int deleteSchedule(CategoryVo paramCategoryVo);

  public abstract int updateSchedule(CategoryVo paramCategoryVo);

  public abstract int insertSchedule(CategoryVo paramCategoryVo);

  public abstract List<CategoryVo> getEducationList(CategoryVo paramCategoryVo)
    throws Exception;

  public abstract int getEducationCount(CategoryVo paramCategoryVo);

  public abstract int insertEducation(CategoryVo paramCategoryVo);

  public abstract int getEducationNo(CategoryVo paramCategoryVo);

  public abstract int insertEducationSub(CategoryVo paramCategoryVo);

  public abstract int deleteEduCation(CategoryVo paramCategoryVo);

  public abstract CategoryVo getEduCationFile(CategoryVo paramCategoryVo);

  public abstract CategoryVo getEduCationDetail(CategoryVo paramCategoryVo);

  public abstract List<CategoryVo> getEduCationDetailSub(CategoryVo paramCategoryVo);

  public abstract int updateEduCation(CategoryVo paramCategoryVo);
}