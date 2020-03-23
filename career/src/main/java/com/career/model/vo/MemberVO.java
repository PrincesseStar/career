package com.career.model.vo;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

/**
 * 
 * @author ChangHyun
 *
 */

@Entity
public class MemberVO {

	@NotEmpty(message="ID를 입력해주세요")
	private String userId;
	
	@NotEmpty(message="패스워드를 입력해주세요")	
	private String userPw;
	
	private String userName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
