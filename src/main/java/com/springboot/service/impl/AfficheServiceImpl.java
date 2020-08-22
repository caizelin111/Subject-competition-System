package com.springboot.service.impl;

import com.springboot.model.Affiche;
import com.springboot.repository.AfficheRepository;
import com.springboot.service.AfficheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfficheServiceImpl implements AfficheService {

    @Autowired
    AfficheRepository afficheRepository;

    @Override
    public List<Affiche> findAll() {
        return afficheRepository.findAll();
    }

    @Override
    public Affiche save(Affiche affiche) {
        return afficheRepository.save(affiche);
    }


}
