package com.easycompany.cmm.excel;

import com.easycompany.service.vo.CategoryVo;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class EgovoOLineEducationExcel extends AbstractExcelView
{
  protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook wb, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    CategoryVo categoryVo = (CategoryVo)model.get("categoryVo");

    response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(categoryVo.getExcelFileName(), "UTF-8").replaceAll("\\+", "\\ ") + ".xls\"");

    String sheetName = "온라인교육";
    String[] cellNameArr = { "No.", "분류1", "분류2", "분류3", "강사명", "교육기간", "학습시간", "교육대상", "신청인원", "교육상태", "노출여부" };
    if ("eduInfoOffline".equals(categoryVo.getGubun2())) {
      sheetName = "오프라인 교육(기관)";
      cellNameArr = new String[] { "No.", "기관명", "교육명", "교육대상", "교육시간", "교육신청 인원", "교육상태", "노출여부" };
    }

    HSSFCell cell = null;

    HSSFSheet sheet = wb.createSheet(sheetName);
    sheet.setDefaultColumnWidth(12);

    cell = getCell(sheet, 0, 0);
    setText(cell, sheetName);

    for (int i = 0; i < cellNameArr.length; i++) {
      setText(getCell(sheet, 2, i), cellNameArr[i]);
    }

    List list = (List)model.get("list");

    for (int i = 0; i < list.size(); i++)
    {
      CategoryVo categVo = (CategoryVo)list.get(i);

      if ("eduInfoOnline".equals(categoryVo.getGubun2()))
      {
        cell = getCell(sheet, 3 + i, 0);
        setText(cell, Integer.toString(i + 1));

        cell = getCell(sheet, 3 + i, 1);
        setText(cell, categVo.getCategory1_name());

        cell = getCell(sheet, 3 + i, 2);
        setText(cell, categVo.getCategory2_name());

        cell = getCell(sheet, 3 + i, 3);
        setText(cell, categVo.getCategory3_name());

        cell = getCell(sheet, 3 + i, 4);
        setText(cell, categVo.getInst_nm());

        cell = getCell(sheet, 3 + i, 5);
        setText(cell, categVo.getTrain_s_date() + "~" + categVo.getTrain_e_date());

        cell = getCell(sheet, 3 + i, 6);
        setText(cell, String.valueOf(categVo.getEdu_time()) + "분");

        cell = getCell(sheet, 3 + i, 7);
        setText(cell, categVo.getEdu_target());

        cell = getCell(sheet, 3 + i, 8);
        setText(cell, String.valueOf(categVo.getEdu_garden()));

        cell = getCell(sheet, 3 + i, 9);
        setText(cell, categVo.getEdu_status());

        cell = getCell(sheet, 3 + i, 10);
        setText(cell, categVo.getExp_use_yn());
      }

      if ("eduInfoOffline".equals(categoryVo.getGubun2()))
      {
        cell = getCell(sheet, 3 + i, 0);
        setText(cell, Integer.toString(i + 1));

        cell = getCell(sheet, 3 + i, 1);
        setText(cell, categVo.getCoper_nm());

        cell = getCell(sheet, 3 + i, 2);
        setText(cell, categVo.getCategory3_name());

        cell = getCell(sheet, 3 + i, 3);
        setText(cell, categVo.getEdu_target());

        cell = getCell(sheet, 3 + i, 4);
        setText(cell, String.valueOf(categVo.getEdu_time()) + "분");

        cell = getCell(sheet, 3 + i, 5);
        setText(cell, String.valueOf(categVo.getEdu_garden()));

        cell = getCell(sheet, 3 + i, 6);
        setText(cell, categVo.getEdu_status());

        cell = getCell(sheet, 3 + i, 7);
        setText(cell, categVo.getExp_use_yn());
      }
    }
  }
}