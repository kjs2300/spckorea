package com.easycompany.service.vo;
import com.easycompany.cmm.vo.DefaultVO;

@SuppressWarnings("serial")
public class CategoryVo extends DefaultVO {

	
	int category1_key;
	String category1_name;
	
	int category2_key;
	String category2_name;
	
	int category3_key;
	String category3_name;
	
	String gubun1;
	String gubun2;

	String categoryName;
	

	String reg_dt;
	String reg_id;
	String chg_id;
	String chg_dt;
	
	String file_uuid;
	String file_name;
	String file_full_path;
	
	String file_seq;
		
	String category3_cont;
	
	long file_size;
	
	String edu_name;
	String edu_start_date;
	String edu_end_date;
	String edu_org_name;
	String edu_target;
	int edu_number;
	String edu_teac_name;
	
	int edu_key;

	int code_cd;
	String code_name;
	String gubun3;
    String checkdstr;
    String checkdate;
    String site;

    int edu_no            ;
    int edu_sub_no ;
    String edu_site       ;
    String edu_ver        ;
    String coper_nm       ;
    String train_s_date   ;
    String train_e_date   ;
    String app_e_date     ;
    String app_s_date     ;    
    String edu_cont       ;
    String edu_method     ;
    String edu_time       ;
    String edu_garden     ;
    String edu_status     ;
    String exp_use_yn     ;
    String edu_notice     ;
    String edu_intro;
    String edu_goals;
    String edu_curr1;
    String edu_curr2;
    String edu_curr3;
    String inst_nm;
    String set_use_yn;
    
    public String getSet_use_yn() {
		return set_use_yn;
	}

	public void setSet_use_yn(String set_use_yn) {
		this.set_use_yn = set_use_yn;
	}

	public String getInst_nm() {
		return inst_nm;
	}

	public void setInst_nm(String inst_nm) {
		this.inst_nm = inst_nm;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}


	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	public String getCheckdstr() {
		return checkdstr;
	}

	public void setCheckdstr(String checkdstr) {
		this.checkdstr = checkdstr;
	}

	public String getGubun3() {
		return gubun3;
	}

	public void setGubun3(String gubun3) {
		this.gubun3 = gubun3;
	}

	public int getCode_cd() {
		return code_cd;
	}

	public void setCode_cd(int code_cd) {
		this.code_cd = code_cd;
	}

	public String getCode_name() {
		return code_name;
	}

	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	public int getCategory1_key() {
		return category1_key;
	}

	public void setCategory1_key(int category1_key) {
		this.category1_key = category1_key;
	}

	public String getCategory1_name() {
		return category1_name;
	}

	public void setCategory1_name(String category1_name) {
		this.category1_name = category1_name;
	}

	public int getCategory2_key() {
		return category2_key;
	}

	public void setCategory2_key(int category2_key) {
		this.category2_key = category2_key;
	}

	public String getCategory2_name() {
		return category2_name;
	}

	public void setCategory2_name(String category2_name) {
		this.category2_name = category2_name;
	}

	public int getCategory3_key() {
		return category3_key;
	}

	public void setCategory3_key(int category3_key) {
		this.category3_key = category3_key;
	}

	public String getCategory3_name() {
		return category3_name;
	}

	public void setCategory3_name(String category3_name) {
		this.category3_name = category3_name;
	}

	public String getGubun1() {
		return gubun1;
	}

	public void setGubun1(String gubun1) {
		this.gubun1 = gubun1;
	}

	public String getGubun2() {
		return gubun2;
	}

	public void setGubun2(String gubun2) {
		this.gubun2 = gubun2;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getFile_uuid() {
		return file_uuid;
	}

	public void setFile_uuid(String file_uuid) {
		this.file_uuid = file_uuid;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_full_path() {
		return file_full_path;
	}

	public void setFile_full_path(String file_full_path) {
		this.file_full_path = file_full_path;
	}

	public String getFile_seq() {
		return file_seq;
	}

	public void setFile_seq(String file_seq) {
		this.file_seq = file_seq;
	}

	public String getTrain_e_date() {
		return train_e_date;
	}

	public void setTrain_e_date(String train_e_date) {
		this.train_e_date = train_e_date;
	}

	public String getApp_s_date() {
		return app_s_date;
	}

	public void setApp_s_date(String app_s_date) {
		this.app_s_date = app_s_date;
	}

	public String getCategory3_cont() {
		return category3_cont;
	}

	public void setCategory3_cont(String category3_cont) {
		this.category3_cont = category3_cont;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public String getEdu_name() {
		return edu_name;
	}

	public void setEdu_name(String edu_name) {
		this.edu_name = edu_name;
	}

	public String getEdu_start_date() {
		return edu_start_date;
	}

	public void setEdu_start_date(String edu_start_date) {
		this.edu_start_date = edu_start_date;
	}

	public String getEdu_end_date() {
		return edu_end_date;
	}

	public void setEdu_end_date(String edu_end_date) {
		this.edu_end_date = edu_end_date;
	}

	public String getEdu_org_name() {
		return edu_org_name;
	}

	public void setEdu_org_name(String edu_org_name) {
		this.edu_org_name = edu_org_name;
	}

	public String getEdu_target() {
		return edu_target;
	}

	public void setEdu_target(String edu_target) {
		this.edu_target = edu_target;
	}

	public int getEdu_number() {
		return edu_number;
	}

	public void setEdu_number(int edu_number) {
		this.edu_number = edu_number;
	}

	public String getEdu_teac_name() {
		return edu_teac_name;
	}

	public void setEdu_teac_name(String edu_teac_name) {
		this.edu_teac_name = edu_teac_name;
	}

	public int getEdu_key() {
		return edu_key;
	}

	public void setEdu_key(int edu_key) {
		this.edu_key = edu_key;
	}

	public int getEdu_no() {
		return edu_no;
	}

	public void setEdu_no(int edu_no) {
		this.edu_no = edu_no;
	}

	public int getEdu_sub_no() {
		return edu_sub_no;
	}

	public void setEdu_sub_no(int edu_sub_no) {
		this.edu_sub_no = edu_sub_no;
	}

	public String getEdu_site() {
		return edu_site;
	}

	public void setEdu_site(String edu_site) {
		this.edu_site = edu_site;
	}

	public String getEdu_ver() {
		return edu_ver;
	}

	public void setEdu_ver(String edu_ver) {
		this.edu_ver = edu_ver;
	}

	public String getCoper_nm() {
		return coper_nm;
	}

	public void setCoper_nm(String coper_nm) {
		this.coper_nm = coper_nm;
	}

	public String getTrain_s_date() {
		return train_s_date;
	}

	public void setTrain_s_date(String train_s_date) {
		this.train_s_date = train_s_date;
	}

	public String getApp_e_date() {
		return app_e_date;
	}

	public void setApp_e_date(String app_e_date) {
		this.app_e_date = app_e_date;
	}

	public String getEdu_cont() {
		return edu_cont;
	}

	public void setEdu_cont(String edu_cont) {
		this.edu_cont = edu_cont;
	}

	public String getEdu_method() {
		return edu_method;
	}

	public void setEdu_method(String edu_method) {
		this.edu_method = edu_method;
	}

	public String getEdu_time() {
		return edu_time;
	}

	public void setEdu_time(String edu_time) {
		this.edu_time = edu_time;
	}

	public String getEdu_garden() {
		return edu_garden;
	}

	public void setEdu_garden(String edu_garden) {
		this.edu_garden = edu_garden;
	}

	public String getEdu_status() {
		return edu_status;
	}

	public void setEdu_status(String edu_status) {
		this.edu_status = edu_status;
	}

	public String getExp_use_yn() {
		return exp_use_yn;
	}

	public void setExp_use_yn(String exp_use_yn) {
		this.exp_use_yn = exp_use_yn;
	}

	public String getEdu_notice() {
		return edu_notice;
	}

	public void setEdu_notice(String edu_notice) {
		this.edu_notice = edu_notice;
	}

	public String getEdu_intro() {
		return edu_intro;
	}

	public void setEdu_intro(String edu_intro) {
		this.edu_intro = edu_intro;
	}

	public String getEdu_goals() {
		return edu_goals;
	}

	public void setEdu_goals(String edu_goals) {
		this.edu_goals = edu_goals;
	}

	public String getEdu_curr1() {
		return edu_curr1;
	}

	public void setEdu_curr1(String edu_curr1) {
		this.edu_curr1 = edu_curr1;
	}

	public String getEdu_curr2() {
		return edu_curr2;
	}

	public void setEdu_curr2(String edu_curr2) {
		this.edu_curr2 = edu_curr2;
	}

	public String getEdu_curr3() {
		return edu_curr3;
	}

	public void setEdu_curr3(String edu_curr3) {
		this.edu_curr3 = edu_curr3;
	}
	
	
	
	
}
