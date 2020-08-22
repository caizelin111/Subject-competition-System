package com.springboot.service;

import com.springboot.model.InforTbl;

import java.util.List;

public interface InforTblService {
    InforTbl save(InforTbl inforTbl);
    List<InforTbl> findByContestnameLike(String contestname);
    int updateInforTbl(String flag, String suggest,String contestname,String workname);
}
