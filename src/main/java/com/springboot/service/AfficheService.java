package com.springboot.service;

import com.springboot.model.Affiche;

import java.util.List;

public interface AfficheService {
    List<Affiche> findAll();
    Affiche save(Affiche affiche);

}
