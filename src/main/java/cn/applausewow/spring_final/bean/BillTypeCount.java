package cn.applausewow.spring_final.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillTypeCount extends Type{

    private Integer num;
    private Integer percentage;

    public BillTypeCount(Integer num, Integer percentage) {
        this.num = num;
        this.percentage = percentage;
    }


    public BillTypeCount() {
    }
}
