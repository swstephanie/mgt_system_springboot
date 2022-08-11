package com.example.demo.dao;

import com.example.demo.pojo.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClassInfoRepository extends JpaRepository<ClassInfo,Integer> {
    Set<ClassInfo> findAllByIdIn(List<Integer> idList);
}
