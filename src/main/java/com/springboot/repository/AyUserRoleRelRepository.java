package com.springboot.repository;

import com.springboot.model.AyUserRoleRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRel,String> {
    List<AyUserRoleRel> findByUserId(@Param("userId")int userId);
}
