package com.springboot.service;

import com.springboot.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface AyUserService {
//    AyUser findById(String id);
//    List<AyUser> findAll();

//    void delete(String id);
//
//    Page<AyUser> findAll(Pageable pageable);
////    下面的三个方法是按照jpa规则命名的，resposity会根据规范生成对应的SQL语句进行数据库查询，因此在reposity需要定义一下
//    List<AyUser> findByName(String name);
//    List<AyUser> findByNameLike(String name);
//    List<AyUser> findByIdIn(Collection<String> ids);
//
    AyUser save(AyUser ayUser);
    AyUser findByName(String name);
}
