package cn.blue.controller;

import cn.blue.service.ConsumerService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/Consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/getAllConsumer")
    public void getAllConsumer(HttpServletResponse response) throws IOException {
        System.out.println("收到了");
        JSONArray jsonArray=JSONArray.fromObject(consumerService.getAllConsumer());
        response.getWriter().print(jsonArray);
    }
}
