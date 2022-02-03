package com.easycompany.service;

import java.util.List;


import com.easycompany.service.vo.MainVo;;


public interface MainService {
	
	

	public MainVo getCommonDetail(MainVo mainVo);
	public int insertCommon(MainVo mainVo);
	public int deleteCommon(MainVo mainVo);	
	public int updateCommon(MainVo mainVo);	

	
}
