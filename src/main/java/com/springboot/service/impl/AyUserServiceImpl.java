package com.springboot.service.impl;

import com.springboot.model.AyUser;
import com.springboot.repository.AyUserRepository;
import com.springboot.service.AyUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class AyUserServiceImpl implements AyUserService {
    @Resource
    private AyUserRepository ayUserRepository;

//    @Override
//    public AyUser findById(String id){
//
//        return ayUserRepository.findById(id).get();
//    }
//
//    @Override
//    public List<AyUser> findAll(){
//        return ayUserRepository.findAll();
//    }

//    @Override
//    public void delete(String id){
//        ayUserRepository.deleteById(id);
//    }
//
//
//
//
//    @Override
//    public Page<AyUser> findAll(Pageable pageable){
//        return ayUserRepository.findAll(pageable);
//    }
//
//
//
//
//
//    @Override
//    public List<AyUser> findByName(String name){
//        return ayUserRepository.findByName(name);
//    }
//    @Override
//    public List<AyUser> findByNameLike(String name){
//        return ayUserRepository.findByNameLike(name);
//    }
//    @Override
//    public List<AyUser> findByIdIn(Collection<String> ids){
//        return ayUserRepository.findByIdIn(ids);
//    }
@Override
public AyUser save(AyUser ayUser){
    return ayUserRepository.save(ayUser);
}
    @Override
    public  AyUser findByName(String name){

    return ayUserRepository.findByName(name);
    }
}
