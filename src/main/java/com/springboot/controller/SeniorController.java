package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.model.Affiche;
import com.springboot.model.InforTbl;
import com.springboot.service.AfficheService;
import com.springboot.service.InforTblService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SeniorController {
    @Resource
    InforTblService inforTblService;
    @Resource
    AfficheService afficheService;

    @GetMapping("/toCheck")
    public String toCheck() {
        return "senior/check";
    }

    @RequestMapping("/search")
    @ResponseBody
    public String search(@RequestParam("param") String param) {
        System.out.println(param);
        Gson gson = new Gson();

        List<InforTbl> lists = inforTblService.findByContestnameLike(param);
        if (lists.size() > 0) {
            return gson.toJson(lists);
        } else {
            return "0";
        }
    }


    @RequestMapping("/submit")
    @ResponseBody
    public void submit(HttpServletRequest request) {
        System.out.println("请求到达了。。。");

        String flag = request.getParameter("flag");
        String suggest = request.getParameter("suggest");
        String contestname = request.getParameter("contestname");
        String workname = request.getParameter("workname");
        System.out.println(request.getParameter("flag"));
        System.out.println(request.getParameter("suggest"));
        System.out.println(request.getParameter("contestname"));
        System.out.println(request.getParameter("workname"));
        if (inforTblService.updateInforTbl(flag, suggest, contestname, workname) == 1) {
            System.out.println("修改成功！！！！");
        } else {
            System.out.println("修改失败");
        }

    }


}
