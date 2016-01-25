package com.hv678.testmvp_rxandroid_okhttp.bean;


/**
 * @author wuxm
 * @mail 380510218@qq.com
 * @version 1.0
 * @description 登錄返回的個人信息
 */
public class MeDetailBean {
	private int id;
	private String name;// 用户名称
	private int student_id;// 用户id
	private String code;// 用户code
	private String photo;// 用户图片URL
	private String email;// 用户email
	private String qq;// 用户qq
	private String phone;// 用户电话
	private String level;// 学院级别
	private String username;
	
	
	public MeDetailBean() {
	}
	
	public MeDetailBean(String name, int student_id, String code, String photo, String email, String qq, String phone, String level, String username) {
		this.name = name;
		this.student_id = student_id;
		this.code = code;
		this.photo = photo;
		this.email = email;
		this.qq = qq;
		this.phone = phone;
		this.level = level;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
