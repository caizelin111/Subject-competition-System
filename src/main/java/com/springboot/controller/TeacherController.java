package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.model.Form;
import com.springboot.model.InforTbl;
import com.springboot.service.AfficheService;
import com.springboot.service.AyUserService;
import com.springboot.service.InforTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

@Controller

public class TeacherController {
    @Autowired
    AyUserService ayUserService;
    @Autowired
    AfficheService afficheService;
    @Autowired
    InforTblService inforTblService;

    @GetMapping("/toContest")
    public String toContest() {
        return "teacher/contest";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("form") String form, @RequestParam("stuList") String stuList, @RequestParam("teacherList") String teacherList, HttpServletRequest request, @RequestParam("files") MultipartFile[] files) throws IOException {
        System.out.println("请求过来了。。。");
        System.out.println(form);
        InforTbl inforTbl = new InforTbl();
        Gson gson = new Gson();
        Form form1 = gson.fromJson(form, Form.class);

        System.out.println("form转换为" + form1);
        inforTbl.setId(null);
        inforTbl.setContestname(form1.getContestname());
        inforTbl.setWorkname(form1.getWorkname());
        inforTbl.setSponsor(form1.getSponsor());
        inforTbl.setPosition(form1.getPosition());
        inforTbl.setDatetime(new Timestamp(form1.getDatetime().getTime()));
        inforTbl.setBelong(form1.getBelong());
        inforTbl.setNums(Integer.parseInt(form1.getNums()));
        inforTbl.setScore(Double.parseDouble(form1.getScore()));
        inforTbl.setType(form1.getType());
        inforTbl.setEventcategory(form1.getEventcategory());
        inforTbl.setAwardgrade(form1.getAwardgrade());
        inforTbl.setAwardlevel(form1.getAwardlevel());
        inforTbl.setFlag("待审核");


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            System.out.println();
            String author = ((UserDetails) principal).getUsername();
            inforTbl.setAuthor(author);
        }


        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            StringBuilder urls = new StringBuilder();
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String basepath = "D:\\WorkSpace\\SpringbootWorkspace\\securitydemo\\src\\main\\resources\\static\\images\\";
                System.out.println("第" + i + "文件为" + file.getOriginalFilename());
                File newfile = new File(basepath + form1.getContestname());
                if (!newfile.exists()) {//如果文件夹不存在
                    newfile.mkdir();//创建文件夹
                }
                file.transferTo(new File(newfile + "\\" + file.getOriginalFilename()));

                //拼接每一个图片的路径到url属性中，用','隔开
                if (urls.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                    urls.append(",");
                }
                urls.append("\\images\\" + form1.getContestname() + "\\" + file.getOriginalFilename());

            }
            System.out.println(urls.toString());
            inforTbl.setFileurl(urls.toString());
        } else {
            System.out.println("文件为空");
            inforTbl.setFileurl(null);
        }

        System.out.println(stuList.toString());
        System.out.println(teacherList.toString());
        //这两个为json字符串
        inforTbl.setStumsg(stuList);
        inforTbl.setTecmsg(teacherList);
        System.out.println("整个表单为：" + inforTbl.toString());
        if (inforTblService.save(inforTbl) != null) {
            System.out.println("成功添加到数据库");
            return "成功了";
        } else {
            System.out.println("添加到数据库失败");
            return "失败";
        }

    }


}
