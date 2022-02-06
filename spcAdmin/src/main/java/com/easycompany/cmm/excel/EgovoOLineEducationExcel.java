/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.easycompany.cmm.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.easycompany.service.vo.CategoryVo;

/**
 * 엑셀파일을 생성하는 클래스를 정의한다.
 * @author 실행환경 개발팀 신혜연
 * @since 2011.07.11
 * @version 1.0
 * @see
 * <pre>
 *  == 개정이력(Modification Information) ==
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.07.11  신혜연          최초 생성
 *
 * </pre>
 */
public class EgovoOLineEducationExcel extends AbstractExcelView {

	/**
	 * 엑셀파일을 설정하고 생성한다.
	 * @param model
	 * @param wb
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook wb, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String fileName = (String) model.get("filename");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".xls\"");
		
		//response.setHeader("Content-Disposition", "attachment; filename=\"" + getClass().getSimpleName() + ".xls\"");

		HSSFCell cell = null;

		HSSFSheet sheet = wb.createSheet("온라인교육");
		sheet.setDefaultColumnWidth(12);

		// put text in first cell
		cell = getCell(sheet, 0, 0);
		setText(cell, "온라인 교육");

		// set header information
		setText(getCell(sheet, 2, 0), "No.");
		setText(getCell(sheet, 2, 1), "분류1");
		setText(getCell(sheet, 2, 2), "분류2");
		setText(getCell(sheet, 2, 3), "분류3");
		setText(getCell(sheet, 2, 4), "강사명");
		setText(getCell(sheet, 2, 5), "교육기간");
		setText(getCell(sheet, 2, 6), "학습시간");
		setText(getCell(sheet, 2, 7), "교육대상");		
		setText(getCell(sheet, 2, 8), "신청인원");
		setText(getCell(sheet, 2, 9), "교육상태");
		setText(getCell(sheet, 2, 10), "노출여부");
		

		
		
		List<CategoryVo> list = (List<CategoryVo>) model.get("list");

		for (int i = 0; i < list.size(); i++) {
			CategoryVo categoryVo = list.get(i);

			cell = getCell(sheet, 3 + i, 0);
			setText(cell, Integer.toString(i + 1));

			cell = getCell(sheet, 3 + i, 1);
			setText(cell, categoryVo.getCategory1_name());

			cell = getCell(sheet, 3 + i, 2);
			setText(cell, categoryVo.getCategory2_name());

			cell = getCell(sheet, 3 + i, 3);
			setText(cell, categoryVo.getCategory3_name());
			
			cell = getCell(sheet, 3 + i, 4);
			setText(cell, categoryVo.getInst_nm());

			cell = getCell(sheet, 3 + i, 5);
			setText(cell, String.valueOf(categoryVo.getTrain_s_date() + "~" + categoryVo.getTrain_e_date()));

			cell = getCell(sheet, 3 + i, 6);
			setText(cell, categoryVo.getEdu_time());	
			
			cell = getCell(sheet, 3 + i, 7);
			setText(cell, categoryVo.getEdu_target());
			
			cell = getCell(sheet, 3 + i, 8);
			setText(cell, categoryVo.getEdu_garden());

			cell = getCell(sheet, 3 + i, 9);
			setText(cell, String.valueOf(categoryVo.getEdu_status()));

			cell = getCell(sheet, 3 + i, 10);
			setText(cell, categoryVo.getExp_use_yn());
			

		}

	}

}
