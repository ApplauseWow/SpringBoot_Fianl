package cn.applausewow.spring_final.service;

import cn.applausewow.spring_final.bean.Bill;
import cn.applausewow.spring_final.bean.BillTypeCount;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BillService {
    Integer addNewBill(Bill bill);
    List<Bill> getBillsById(Integer user_id);
    List<BillTypeCount> getTypePercentage(Integer user_id);
}
