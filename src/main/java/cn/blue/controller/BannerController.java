package cn.blue.controller;

import cn.blue.service.BannerService;
import cn.blue.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Banner")
/**
 * @author 蔡荣镔
 */
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/getBanners")
    public void getBanners(@RequestParam(value="visible") String visible, HttpServletResponse response) throws IOException {
        if(visible==null||!visible.equals("1")) visible="0";
        boolean visity=Integer.parseInt(visible)!=0;
        Map values=new HashMap<String,Object>(2);
        values.put("data",bannerService.getBanner(visity));
        values.put("number",bannerService.getCount(visity));
        Response.sendJSONObject(values,response);
    }

}
