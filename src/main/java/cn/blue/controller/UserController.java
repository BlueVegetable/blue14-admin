package cn.blue.controller;

import cn.blue.domain.User;
import cn.blue.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public void getUser(HttpServletResponse response) throws IOException {
        JSONObject json=JSONObject.fromObject(userService.getUser());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(json);
    }

    @RequestMapping(value="/getAllUser",produces = "application/json; charset=utf-8")
    public void getAllUser(int page,int limit,HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<User> users=userService.getAllUser((page-1)*limit,limit);
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("count",userService.getUserCount());
        json.put("msg","");
        json.put("data",users);
        response.getWriter().println(json);
    }

    @RequestMapping("/regist")
    public void regist(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.getWriter().println(request.getParameter("test"));
    }

}