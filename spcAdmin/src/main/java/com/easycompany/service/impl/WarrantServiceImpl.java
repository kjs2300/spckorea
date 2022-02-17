package com.easycompany.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycompany.mapper.WarrantMapper;
import com.easycompany.service.WarrantService;
import com.easycompany.service.vo.WarrantVo;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("warrantService")
@Transactional
public class WarrantServiceImpl extends EgovAbstractServiceImpl implements WarrantService {
	
	@Autowired
	private WarrantMapper warrantMapper;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;

	@Override
	public List<WarrantVo> warrantOnlineList(WarrantVo warrantVo) {
		return warrantMapper.warrantOnlineList(warrantVo);
	}

	@Override
	public int warrantOnlineListCnt(WarrantVo warrantVo) {
		return warrantMapper.warrantOnlineListCnt(warrantVo);
	}

	@Override
	public WarrantVo selectDetailOnline(WarrantVo warrantVo) {
		return warrantMapper.selectDetailOnline(warrantVo);
	}

	@Override
	public int warrantSave(WarrantVo warrantVo) {
		return warrantMapper.warrantSave(warrantVo);
	}

	@Override
	public int warrantUpdate(WarrantVo warrantVo) {
		return warrantMapper.warrantUpdate(warrantVo);
	}

	@Override
	public int warrantDel(HashMap<String, Object> map) {
		return warrantMapper.warrantDel(map);
	}


}
