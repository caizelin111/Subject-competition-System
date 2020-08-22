package com.springboot.service.impl;

import com.springboot.model.InforTbl;
import com.springboot.repository.InforTblRepository;
import com.springboot.service.InforTblService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class InforTblServiceImpl implements InforTblService {
    @Resource
    private InforTblRepository inforTblRepository;

    @Override
    public InforTbl save(InforTbl inforTbl) {

        return inforTblRepository.save(inforTbl);
    }

    @Override
    public List<InforTbl> findByContestnameLike(String contestname) {
        return inforTblRepository.findByContestnameLike("%"+contestname+"%");
    }

    @Transactional
    @Override
    public int updateInforTbl(String flag, String suggest, String contestname, String workname) {
        return inforTblRepository.updateInforTbl(flag,suggest,contestname,workname);
    }
}
