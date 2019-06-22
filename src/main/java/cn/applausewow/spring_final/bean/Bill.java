package cn.applausewow.spring_final.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Bill {
	private Integer bill_id; // 账单ID
	private Integer user_id; // 用户ID
	private Double cost; // 支出金额
	private Date cost_date; // 支出日期
	private Integer cost_type; // 支出类型
	private String  note; // 支出备注

	public Bill() {
	}

	public Bill(Integer bill_id, Integer user_id, Double cost, Date cost_date, Integer cost_type, String note) {
		this.bill_id = bill_id;
		this.user_id = user_id;
		this.cost = cost;
		this.cost_date = cost_date;
		this.cost_type = cost_type;
		this.note = note;
	}
}
