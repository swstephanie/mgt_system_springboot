package com.example.demo.dao;

import com.example.demo.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> getAllByName (@Param(value = "name") String name);

    //Page<Student> getAllByName (@Param(value = "name") String name, Pageable pageable);
}
