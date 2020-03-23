package com.career.model.vo;

/**
 * 
 * @author ChangHyun
 *
 */
public class ProjectVO {
	
	private int seq;
	private String siteId;
	private String prjName;
	private String state;
	private String keyword;
	private String prjMemo;
	private String createDt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	private String editDt;
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPrjMemo() {
		return prjMemo;
	}
	public void setPrjMemo(String prjMemo) {
		this.prjMemo = prjMemo;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getEditDt() {
		return editDt;
	}
	public void setEditDt(String editDt) {
		this.editDt = editDt;
	}
	
}
