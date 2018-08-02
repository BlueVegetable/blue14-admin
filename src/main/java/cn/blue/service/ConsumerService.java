package cn.blue.service;

import cn.blue.dao.ConsumerDao;
import cn.blue.domain.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerDao consumerDao;

    public List<Consumer> getAllConsumer(){
        return consumerDao.getAllConsumers();
    }
}
