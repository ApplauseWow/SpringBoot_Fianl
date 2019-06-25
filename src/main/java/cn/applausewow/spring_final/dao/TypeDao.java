package cn.applausewow.spring_final.dao;

import cn.applausewow.spring_final.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeDao {
    List<Type> getAllTypes();
}
