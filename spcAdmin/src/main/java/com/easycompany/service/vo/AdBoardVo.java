package com.easycompany.service.vo;

import com.easycompany.cmm.vo.DefaultVO;

@SuppressWarnings("serial")
public class AdBoardVo extends DefaultVO {
	
	Long board_idx;
	String board_type;
	String title;
	String contents;
	String link_url;
	String file_id;
	Long view_cnt;
	String reg_dt;
	String reg_id;
	String chg_id;
	String chg_dt;
	String searchDate;
	String board_start_date;
	String board_end_date;
	
	public Long getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(Long board_idx) {
		this.board_idx = board_idx;
	}
	
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public Long getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(Long view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getChg_id() {
		return chg_id;
	}
	public void setChg_id(String chg_id) {
		this.chg_id = chg_id;
	}
	public String getChg_dt() {
		return chg_dt;
	}
	public void setChg_dt(String chg_dt) {
		this.chg_dt = chg_dt;
	}
	
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	
	public String getBoard_start_date() {
		return board_start_date;
	}
	public void setBoard_start_date(String board_start_date) {
		this.board_start_date = board_start_date;
	}
	public String getBoard_end_date() {
		return board_end_date;
	}
	public void setBoard_end_date(String board_end_date) {
		this.board_end_date = board_end_date;
	}

}
