package com.easycompany.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.easycompany.service.vo.WarrantVo;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("warrantMapper")
public class WarrantMapper extends EgovAbstractMapper {
	
	String nameSpace = "com.easycompany.mapper.WarrantMapper";

	public List<WarrantVo> warrantOnlineList(WarrantVo warrantVo) {
		return selectList(nameSpace + ".warrantOnlineList", warrantVo);
	}

	public int warrantOnlineListCnt(WarrantVo warrantVo) {
		return selectOne(nameSpace + ".warrantOnlineListCnt", warrantVo);
	}

	public WarrantVo selectDetailOnline(WarrantVo warrantVo) {
		return selectOne(nameSpace + ".selectDetailOnline", warrantVo);
	}

	public int warrantSave(WarrantVo warrantVo) {
		return insert(nameSpace + ".warrantSave", warrantVo);
	}

	public int warrantUpdate(WarrantVo warrantVo) {
		return (Integer) update(nameSpace + ".warrantUpdate", warrantVo);
	}

	public int warrantDel(HashMap<String, Object> map) {
		return (Integer) update(nameSpace + ".warrantDel", map);
	}

}
