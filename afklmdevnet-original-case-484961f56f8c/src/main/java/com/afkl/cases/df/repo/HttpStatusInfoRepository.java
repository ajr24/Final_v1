package com.afkl.cases.df.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afkl.cases.df.entity.HttpStatusInfoEntity;

@Repository
public interface HttpStatusInfoRepository  extends JpaRepository<HttpStatusInfoEntity, Integer>{ 

}








