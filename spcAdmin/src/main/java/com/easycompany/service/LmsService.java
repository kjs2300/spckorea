package com.easycompany.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.easycompany.service.vo.LmsVo;

public interface LmsService {

	List<LmsVo> contentsList(LmsVo lmsVo);

	int contentsListCnt(LmsVo lmsVo);

	LmsVo selectDetailLms(LmsVo lmsVo);

	int contentsSave(LmsVo lmsVo, MultipartFile file1, MultipartFile file2);

}
