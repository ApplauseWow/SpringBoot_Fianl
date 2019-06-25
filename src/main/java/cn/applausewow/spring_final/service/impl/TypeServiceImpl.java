package cn.applausewow.spring_final.service.impl;

import cn.applausewow.spring_final.bean.Type;
import cn.applausewow.spring_final.dao.TypeDao;
import cn.applausewow.spring_final.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    final TypeDao typeDao;

    public TypeServiceImpl(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public List<Type> getAllTypes() {
        return typeDao.getAllTypes();
    }
}
