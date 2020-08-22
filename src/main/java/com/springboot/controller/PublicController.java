package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.model.Affiche;
import com.springboot.model.AyUser;
import com.springboot.service.AfficheService;
import com.springboot.service.AyUserService;
import com.springboot.service.InforTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller

public class PublicController {
    @Autowired
    AyUserService ayUserService;
    @Autowired
    AfficheService afficheService;
    @Autowired
    InforTblService inforTblService;

    @GetMapping("/index")
    public String login() {
        return "public/index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }

    @GetMapping("/toRead")
    public String toRead() {
        return "public/read";
    }

    @GetMapping("/main")
    public String tomain() {
        return "public/main";
    }

    /**
     * 用户更改个人基本信息
     *
     * @Valid 开启对AyUser对象的数据校验
     * BindingResult:封装了校验的结果
     */
    @RequestMapping("/update")
    public String update(@Valid AyUser ayUser, BindingResult result, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            return "public/main";
        }
        System.out.println(ayUser);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            System.out.println();
            String name = ((UserDetails) principal).getUsername();
            //查找出来的对象,把表单中的数据更改进去这个对象并且保存
            AyUser ayUser1 = ayUserService.findByName(name);
            ayUser1.setPassword(ayUser.getPassword());
            ayUser1.setEmail(ayUser.getEmail());
            ayUser1.setPhoneNumber(ayUser.getPhoneNumber());
            AyUser ayUser2 = ayUserService.save(ayUser1);
            String msg;
            if (ayUser2 != null) {
                model.addAttribute("ayUser", ayUser1);
                msg = "保存成功";

            } else {
                msg = "保存失败";
            }
            model.addAttribute("msg", msg);

        }
        return "public/main";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public String getAllNotice() {
        List<Affiche> affiches = afficheService.findAll();
        Gson gson = new Gson();
        String affichesStr = gson.toJson(affiches);
        System.out.println(affichesStr);
        return affichesStr;

    }

    @GetMapping("/toOwn")
    public String toOwn(AyUser ayUser, Model model) {//加入AyUser对象可以重新定位到该页面

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String name = ((UserDetails) principal).getUsername();//获得名字
            AyUser ayUser1 = ayUserService.findByName(name);
            model.addAttribute("ayUser", ayUser1);
        }


        return "public/main";
    }

}
