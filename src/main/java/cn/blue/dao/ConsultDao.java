package cn.blue.dao;

import cn.blue.domain.Consult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ConsultDao {

    int addConsult(Consult consult);

    int deleteConsult(int consultId);

    int getAllCount();

    Consult getConsultById(int consultId);

    List<Consult> getAllConsult(@Param("start") int start,@Param("number") int number);

    List<Consult> getConsultLimited(Map<String,Object> parameters);

    int getLimitedCount(Map<String,Object> parameters);

    int updateConsult(Consult consult);

}
