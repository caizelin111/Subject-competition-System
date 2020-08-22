package com.springboot.repository;

import com.springboot.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AyUserRepository extends JpaRepository<AyUser,String> {
//这三个方法是新定义的，由于japReposity没有现成的，因此需要按照命名规范定义在这边，让springData jpa 生成SQL语句并且进行数据库查询
//    List<AyUser> findByName(String name);
//    List<AyUser> findByNameLike(String name);
//    List<AyUser> findByIdIn(Collection<String> ids);
    AyUser findByName(String name);

}

