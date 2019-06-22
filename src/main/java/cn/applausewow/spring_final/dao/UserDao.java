package cn.applausewow.spring_final.dao;


import cn.applausewow.spring_final.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

	List<User> getAllUsers();
	User getUserByUserName(@Param("user_name") String username);


}
