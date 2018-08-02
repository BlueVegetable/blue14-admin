package cn.blue.dao;

import cn.blue.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User getUser();

    List<User> getAllUser(@Param("start")int start,@Param("page")int page);

    int getUserCount();

}
