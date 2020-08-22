package com.springboot.service.impl;

import com.springboot.model.AyUserRoleRel;
import com.springboot.repository.AyUserRoleRelRepository;
import com.springboot.service.AyUserRoleRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AyUserRoleRelServiceImpl implements AyUserRoleRelService {
    @Resource
    AyUserRoleRelRepository ayUserRoleRelRepository;
    @Override
    public List<AyUserRoleRel> findByUserId(int userId){
        return ayUserRoleRelRepository.findByUserId(userId);
    }

}
