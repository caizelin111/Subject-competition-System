package com.springboot.service.impl;

import com.springboot.model.AyRole;
import com.springboot.model.AyUserRoleRel;
import com.springboot.repository.AyRoleRepository;
import com.springboot.repository.AyUserRoleRelRepository;
import com.springboot.service.AyRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyRoleServiceImpl implements AyRoleService {
    @Resource
    AyRoleRepository ayRoleRepository;
    @Override
    public AyRole find(int id){
        return ayRoleRepository.findById(id);
    }
}
