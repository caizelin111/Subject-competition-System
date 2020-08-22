package com.springboot.repository;

import com.springboot.model.AyRole;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AyRoleRepository extends JpaRepository<AyRole,String> {
    AyRole findById(int id);

}
