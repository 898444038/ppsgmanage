package com.ming.ppsg.admin.vo;

/**
 * 登录接口封装对象
 * @author Louis
 * @date Oct 29, 2018
 */
public class LoginBean {

	private String account;
	private String password;
	private String captcha;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("LoginBean{");
		sb.append("account='").append(account).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", captcha='").append(captcha).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
