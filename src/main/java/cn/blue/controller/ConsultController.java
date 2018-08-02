package cn.blue.controller;

import cn.blue.domain.Consult;
import cn.blue.service.ConsultService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Consult")
public class ConsultController {

    @Autowired
    private ConsultService consultService;

    @RequestMapping("/addConsult")
    public void addConsult(Consult consult,HttpServletResponse response) throws IOException {
        if(consultService.addConsult(consult))
            response.getWriter().println(1);
        else
            response.getWriter().println(0);
    }

    @RequestMapping("/deleteConsult")
    public void deleteConsult(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        if(consultService.deleteConsult(id))
            success(response);
        else
            fail(response);
    }

    @RequestMapping("/getConsults")
    public void getConsults(int page,int limit,HttpServletResponse response) throws IOException {
        List<Consult> consults=consultService.getConsults(page,limit);
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("count",consultService.getAllCount());
        json.put("msg","");
        json.put("data",consults);
        response.getWriter().println(json);
    }

    @RequestMapping("/getConsultsLimit")
    public void getConsultsLimit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id=null;
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        if(request.getParameter("id")!=null)
            id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String remark=request.getParameter("remark");
        String phoneNumber=request.getParameter("phoneNumber");

        List<Consult> consults=consultService.selectConsults(id,name,remark,phoneNumber,page,limit);

        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("count",consultService.getAllCount());
        json.put("msg","");
        json.put("data",consults);
        response.getWriter().println(json);
    }

    public void getConsultById(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        response.getWriter().println(JSONObject.fromObject(consultService.getConsultById(id)));
    }

    @RequestMapping("/updateConsult")
    public void updateConsult(Consult consult,HttpServletResponse response) throws IOException {
        if(consultService.updateConsult(consult))
            success(response);
        else
            fail(response);
    }

    private void success(HttpServletResponse response) throws IOException {
        response.getWriter().println(1);
    }

    private void fail(HttpServletResponse response) throws IOException {
        response.getWriter().println(0);
    }

}
