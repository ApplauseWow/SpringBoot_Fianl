package cn.applausewow.spring_final.controller;

import cn.applausewow.spring_final.bean.Type;
import cn.applausewow.spring_final.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

    final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping("/allTypes")
    @ResponseBody
    public List<Type> getAllTypes(){
        return typeService.getAllTypes();
    }
}
