package cn.blue.service;

import cn.blue.dao.UserDao;
import cn.blue.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser() {
        return userDao.getUser();
    }

    public List<User> getAllUser(int start,int number){
        return userDao.getAllUser(start,number);
    }

    public int getUserCount(){
        return userDao.getUserCount();
    }

}
