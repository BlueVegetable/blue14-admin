package cn.blue.service;

import cn.blue.dao.ConsultDao;
import cn.blue.domain.Consult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsultService {

    @Autowired
    private ConsultDao consultDao;

    public boolean addConsult(Consult consult){
        return consultDao.addConsult(consult)>0;
    }

    public boolean deleteConsult(int id){
        return consultDao.deleteConsult(id)>0;
    }

    public int getAllCount(){
        return consultDao.getAllCount();
    }

    public Consult getConsultById(int consultId){
        return consultDao.getConsultById(consultId);
    }

    public List<Consult> getConsults(int page,int number){
        int start=(page-1)*number;
        return consultDao.getAllConsult(start,number);
    }

    public List<Consult> selectConsults(Map map) {
        return consultDao.getConsultLimited(map);
    }

    public int limitConsultCount(Integer consultId,String name,String remark,String phoneNumber) {
        Map<String,Object>map=new LinkedHashMap<>();

        map.put("id",consultId);
        map.put("name",name);
        map.put("remark",remark);
        map.put("phoneNumber",phoneNumber);

        return consultDao.getLimitedCount(map);
    }

    public boolean updateConsult(Consult consult){
        return consultDao.updateConsult(consult)>0;
    }

    public boolean alterState(int id,int state) { return consultDao.alterState(id,state)>0; }

}
