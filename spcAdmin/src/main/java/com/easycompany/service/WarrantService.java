package com.easycompany.service;

import java.util.HashMap;
import java.util.List;

import com.easycompany.service.vo.WarrantVo;

public interface WarrantService {

	List<WarrantVo> warrantOnlineList(WarrantVo warrantVo);

	int warrantOnlineListCnt(WarrantVo warrantVo);

	WarrantVo selectDetailOnline(WarrantVo warrantVo);

	int warrantSave(WarrantVo warrantVo);

	int warrantUpdate(WarrantVo warrantVo);

	int warrantDel(HashMap<String, Object> map);

}
