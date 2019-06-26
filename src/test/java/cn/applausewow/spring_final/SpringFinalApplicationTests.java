package cn.applausewow.spring_final;

import cn.applausewow.spring_final.bean.Bill;
import cn.applausewow.spring_final.bean.BillTypeCount;
import cn.applausewow.spring_final.bean.User;
import cn.applausewow.spring_final.dao.BillDao;
import cn.applausewow.spring_final.service.BillService;
import cn.applausewow.spring_final.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFinalApplicationTests {
@Autowired
private UserService service;



    @Test
    public void contextLoads() {
//        for (int i = 0; i<=3; i++){
//            Bill bill=new Bill();
//            bill.setUser_id(1);
//            bill.setCost_type(-1);
//            if (i % 2 == 0){
//                bill.setCost((double) 34534 + i *13);
//            }else {
//                bill.setCost((double) 135433 - i * i * i);
//            }
//            bill.setCost_date(new Date());
//            bill.setNote("how are you?~");
//            service.addNewBill(bill);
//        }
//        List<BillTypeCount> list =  service.getTypePercentage(1);
//        for (BillTypeCount billTypeCount: list){
//            System.out.println(billTypeCount.getNum());
//
//        }
//        User user = new User();
//        user.setName("app");
//        user.setUser_name("app");
//        user.setLocation("上海");
//        user.setJob("架构师");
//        user.setPasswd("123");
//        boolean b = service.modifySelfInfo(user);
//        if (b){
//            System.out.println("ok");
//        }else {
//            System.out.println("no");
//        }
//    }
        if (service.deleteUserByUserId(7)) {
            System.out.println("ok");
        } else System.out.println("NO");
    }
}
