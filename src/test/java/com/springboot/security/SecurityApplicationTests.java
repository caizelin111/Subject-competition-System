package com.springboot.security;

import com.springboot.SecurityApplication;
import com.springboot.model.Affiche;
import com.springboot.model.AyUser;
import com.springboot.model.InforTbl;
import com.springboot.service.AfficheService;
import com.springboot.service.AyUserService;


import com.springboot.service.InforTblService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)//必须加上这句开启test
@SpringBootTest(classes = SecurityApplication.class)
public  class SecurityApplicationTests {
    @Resource AyUserService ayUserService;
    @Resource InforTblService inforTblService;
    @Resource
    AfficheService afficheService;
    @Test
    public void test1(){
        List<InforTbl> lists=inforTblService.findByContestnameLike("桥");
        System.out.println("查询个数为"+lists.size());
    }

    @Test
   public void contextLoads() {

    }





//    @Test
//    public void test1(){
//        System.out.println(ayUserService.findAll().size());
//        AyUser ayUser=new AyUser();
//        ayUser.setId("7");
//        ayUser.setName("测试1");
//        ayUser.setPassword("123456");
//        if(ayUserService.save(ayUser)!=null){
//
//            System.out.println("添加成功："+ayUser.getName());
//            AyUser  ayUser1=ayUserService.findById("7");
//            System.out.println("通过查找密码为："+ayUser1.getPassword());
//            ayUserService.delete("7");
//
//        }
//
//    }
//    @Test
//    public void test2(){
////        通过name查询
//        List<AyUser> users=ayUserService.findByName("蔡泽林");
//        System.out.println("按名字查询为"+users.get(0).getName()+users.get(0).getPassword());
//        System.out.println("第二个查询到的名字为"+users.get(1).getName());
////通过name模糊查询
//        List<AyUser> users2=ayUserService.findByNameLike("沈%");
//        System.out.println("查到的数据有"+users2.size()+"条");
////通过id列表查询
//        List<String> ids=new ArrayList<String>();
//        ids.add("1");
//        ids.add("2");
//        List<AyUser> users3=ayUserService.findByIdIn(ids);
////        foreach循环，类型+变量+所遍历的对象
//        for (AyUser user:users3
//             ) {
//            System.out.println(user.getName());
//
//        }
////分页查询
//        PageRequest pageRequest=PageRequest.of(5,5);
//        Page<AyUser> users4=ayUserService.findAll(pageRequest);
//        System.out.println("所有页数为"+users4.getTotalPages());
//
//
//
//    }



}
