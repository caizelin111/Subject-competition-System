package com.springboot.service;

import com.springboot.model.AyUserRoleRel;

import java.util.List;

public interface AyUserRoleRelService {
    List<AyUserRoleRel> findByUserId(int userId);
}
