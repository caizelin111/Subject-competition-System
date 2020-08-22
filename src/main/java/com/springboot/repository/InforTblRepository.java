package com.springboot.repository;

import com.springboot.model.InforTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface InforTblRepository extends JpaRepository<InforTbl,String> {

    List<InforTbl> findByContestnameLike(String contestname);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update InforTbl u set u.flag = ?1 ,u.suggest=?2 where u.contestname = ?3 and u.workname=?4")
    int updateInforTbl(String flag, String suggest,String contestname,String workname);
}
