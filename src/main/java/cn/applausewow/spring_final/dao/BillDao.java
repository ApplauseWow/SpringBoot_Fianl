package cn.applausewow.spring_final.dao;

import cn.applausewow.spring_final.bean.Bill;
import cn.applausewow.spring_final.bean.BillTypeCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface BillDao {
    Integer insertBill(Bill bill);
    List<Bill> getBillsById(@Param("user_id")Integer user_id);
    List<BillTypeCount> getBillPercentage(@Param("user_id")Integer user_Id);
}
