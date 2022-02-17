package com.easycompany.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.easycompany.cmm.util.FileUtil;
import com.easycompany.mapper.LmsMapper;
import com.easycompany.service.LmsService;
import com.easycompany.service.vo.BoardVo;
import com.easycompany.service.vo.LmsVo;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("lmsService")
@Transactional
public class LmsServiceImpl extends EgovAbstractServiceImpl implements LmsService {
	
	@Autowired
	private LmsMapper lmsMapper;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;

	@Override
	public List<LmsVo> contentsList(LmsVo lmsVo) {
		return lmsMapper.contentsList(lmsVo);
	}

	@Override
	public int contentsListCnt(LmsVo lmsVo) {
		return lmsMapper.contentsListCnt(lmsVo);
	}

	@Override
	public LmsVo selectDetailLms(LmsVo lmsVo) {
		return lmsMapper.selectDetailLms(lmsVo);
	}

	@Override
	public int contentsSave(LmsVo lmsVo, MultipartFile file1, MultipartFile file2, HttpServletRequest request) {
		String fileAddpath = this.filePath + File.separator + "lms";
		
		int result = lmsMapper.insertContents(lmsVo);
//		if (result > 0) {
//			if (file1.getSize() > 0) {
//				Map<String, Object>fileMap1 = FileUtil.uploadFile(file1, fileAddpath, request);
//				System.out.println("+++++++++++++++++++++++++++++"+fileMap1.toString());
//				fileMap1.put("file_oreder_by", 1);
//				fileMap1.put("file_key", lmsVo.getContent_idx());
//				fileMap1.put("file_gubun", "lms");
//				lmsMapper.insertLmsFile(fileMap1);
//			}
//			if (file2.getSize() > 0) {
//				Map<String, Object>fileMap2 = FileUtil.uploadFile(file2, fileAddpath, request);
//				fileMap2.put("file_oreder_by", 2);
//				fileMap2.put("file_key", lmsVo.getContent_idx());
//				fileMap2.put("file_gubun", "lms");
//				lmsMapper.insertLmsFile(fileMap2);
//			}
//			
//		}
		return result;
	}

	@Override
	public int updateContents(LmsVo lmsVo) {
		return lmsMapper.updateContents(lmsVo);
	}


}
