package cn.applausewow.spring_final.service.impl;

import cn.applausewow.spring_final.bean.Bill;
import cn.applausewow.spring_final.bean.BillTypeCount;
import cn.applausewow.spring_final.bean.Type;
import cn.applausewow.spring_final.dao.BillDao;
import cn.applausewow.spring_final.dao.TypeDao;
import cn.applausewow.spring_final.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private final BillDao billDao;

    private final TypeDao typeDao;

    public BillServiceImpl(BillDao billDao, TypeDao typeDao) {
        this.billDao = billDao;
        this.typeDao = typeDao;
    }

    @Override
    public Integer addNewBill(Bill bill) {
        Integer row  = billDao.insertBill(bill);
        return row;
    }

    @Override
    public List<Bill> getBillsById(Integer user_id) {
        return billDao.getBillsById(user_id);
    }

    @Override
    public List<BillTypeCount> getTypePercentage(Integer user_id) {
        List<BillTypeCount> list =  billDao.getBillPercentage(user_id);
        List<Type> typeList = typeDao.getAllTypes();
        int sum = 0;
        for (BillTypeCount billTypeCount: list){
            sum += billTypeCount.getNum();
        }
        List<Boolean> booleanList = new ArrayList<>();
        for (int i = 0; i < typeList.size(); i++){
            booleanList.add(false);
        }
        for (Type type: typeList){
            for (BillTypeCount billTypeCount: list){
                if (type.getType_id().equals(billTypeCount.getType_id())){
                    double p = (double)billTypeCount.getNum() / (double)sum;
                    p *= 100;
                    p += 0.5;
                    billTypeCount.setPercentage((int)p);
                    int index = typeList.indexOf(type);
                    booleanList.set(index, true);
                    break;
                }
            }
        }
        for (int i = 0; i<booleanList.size(); i++){
            if(!booleanList.get(i)){
                Type t = typeList.get(i);
                BillTypeCount b = new BillTypeCount();
                b.setType_id(t.getType_id());
                b.setType_name(t.getType_name());
                b.setNum(0);
                b.setPercentage(0);
                list.add(b);
            }
        }

        return list;
    }
}
