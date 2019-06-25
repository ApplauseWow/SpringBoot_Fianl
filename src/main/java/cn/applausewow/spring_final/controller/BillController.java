package cn.applausewow.spring_final.controller;

import cn.applausewow.spring_final.bean.Bill;
import cn.applausewow.spring_final.bean.BillTypeCount;
import cn.applausewow.spring_final.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @ResponseBody
    @RequestMapping("/addNewBill")
    public Boolean addNewBill(@RequestParam(value = "user_id")Integer userId, @RequestParam(value = "cost") Double cost, @RequestParam(value = "cost_date") String  cost_date, @RequestParam(value = "cost_type") Integer cost_type, @RequestParam(value = "note") String note) throws ParseException {

        SimpleDateFormat SFDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = SFDate.parse(cost_date);
        Bill bill = new Bill();
        bill.setUser_id(userId);
        bill.setCost(cost);
        bill.setCost_date(date);
        bill.setCost_type(cost_type);
        bill.setNote(note);
        Integer row = 0;
        try {
            row =  billService.addNewBill(bill);
        }catch (Exception e){
            row = 0;
        }
        return row == 1;
    }

    @ResponseBody
    @RequestMapping("/allBills")
    public List<Bill> getBillsById(@RequestParam(value = "user_id")Integer user_id){
        return billService.getBillsById(user_id);
    }

    @ResponseBody
    @RequestMapping("/billTypePercentage")
    public List<BillTypeCount> getBillTypePercentage(@RequestParam(value = "user_id")Integer user_id){
        return billService.getTypePercentage(user_id);
    }
}
