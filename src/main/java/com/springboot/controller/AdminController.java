package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.model.Affiche;
import com.springboot.model.AyUser;
import com.springboot.model.Form;
import com.springboot.model.InforTbl;
import com.springboot.service.AfficheService;
import com.springboot.service.AyUserService;
import com.springboot.service.InforTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Controller


public class AdminController {
    @Autowired
    AyUserService ayUserService;
    @Autowired
    AfficheService afficheService;
    @Autowired
    InforTblService inforTblService;


    @GetMapping("/toNotice")
    public String toNotice() {
        return "admin/notice";
    }


    /**
     * 用户更改个人基本信息
     *
     * @Valid 开启对AyUser对象的数据校验
     * BindingResult:封装了校验的结果
     */


    @RequestMapping("/publish")
    @ResponseBody
    public void publish(@RequestBody Affiche affiche) {
        System.out.println("请求到了...");
        System.out.println(":" + affiche.toString());
        if (affiche != null) {

            //从安全框架中拉取用户名称，设置作者名字
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                String author = ((UserDetails) principal).getUsername();
                affiche.setAuthor(author);
            }
            System.out.println(affiche.toString());
            affiche.setDate(new Timestamp(System.currentTimeMillis()));
            afficheService.save(affiche);
        }


    }


}
//// 字符串转list<String>
//
//    String str = "aaa,bbb,ccc";
//    List<String> lis = Arrays.asList(str.split(","));
//for (String string : lis) {
//
//        System.out.println(string);
//
//        }