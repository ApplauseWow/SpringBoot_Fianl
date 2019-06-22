package cn.applausewow.spring_final.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Integer user_id; // 用户ID
	private String user_name; // 用户名，登录用
	private String passwd; // 登录密码
	private String name; // 用户昵称

	public User() {
	}

	public User(Integer user_id, String user_name, String passwd, String name) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.passwd = passwd;
		this.name = name;
	}
}
