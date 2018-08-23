package cn.blue.service;

import cn.blue.dao.AdminDao;
import cn.blue.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public boolean addAdmin(Admin admin){
        return adminDao.addAdmin(admin)>0;
    }

    public boolean deleteAdmin(int id) {
        return adminDao.deleteAdmin(id)>0;
    }

    public Admin login(String name,String password) {
        List<Admin> admins = adminDao.getAdminByName(name);
        for(Admin admin:admins) {
            if(admin.getPassword().equals(password))
                return admin;
        }
        return null;
    }

    public Map getAdmins(String name,Integer start,Integer number) {
        Map map=new HashMap<String,Object>(2);
        map.put("data",adminDao.getAllAdmin(name,start,number));
        map.put("count",adminDao.count(name));
        return  map;
    }

    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin)>0;
    }

    public boolean resetPassword(int id,String password) {
        return adminDao.resetPassword(id,password)>0;
    }

}
