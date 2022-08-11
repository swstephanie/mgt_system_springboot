package com.example.demo.service;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentRequest;

import java.util.List;
import java.util.Set;

public interface ServiceInterface {
    void create(StudentRequest request);

    void update(int id,String name);
    void registerClass(Integer id, List<Integer> classIdList);
    Student getById(int id);

    List<Student> getAllByName(String name);
    List<Student> getAll();
    String getOnlyNameById(Integer id);


    void deleteById(int id);
}
