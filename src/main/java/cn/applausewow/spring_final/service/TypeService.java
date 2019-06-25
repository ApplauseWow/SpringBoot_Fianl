package cn.applausewow.spring_final.service;

import cn.applausewow.spring_final.bean.Type;
import cn.applausewow.spring_final.dao.TypeDao;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TypeService {
    List<Type> getAllTypes();
}
