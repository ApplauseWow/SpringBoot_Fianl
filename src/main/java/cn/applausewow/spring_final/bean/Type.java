package cn.applausewow.spring_final.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Type {
	private Integer type_id; // 支出类型ID
	private String type_name; // 支出类型名称

	public Type() {
	}

	public Type(Integer type_id, String type_name) {
		this.type_id = type_id;
		this.type_name = type_name;
	}
}
