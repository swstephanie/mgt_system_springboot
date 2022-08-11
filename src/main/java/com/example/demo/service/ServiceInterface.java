package com.example.demo.service;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentRequest;

import java.util.List;
import java.util.Set;

public interface ServiceInterface {
    void create(StudentRequest request);

    void update(int id,String name);

    Student getById(int id);

    List<Student> getAllByName(String name);
    List<Student> getAll();

    void deleteById(int id);
}
