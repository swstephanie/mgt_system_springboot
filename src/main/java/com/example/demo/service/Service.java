package com.example.demo.service;

import com.example.demo.dao.ClassInfoRepository;
import com.example.demo.dao.StudentRepository;
import com.example.demo.pojo.ClassInfo;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassInfoRepository classInfoRepository;

    public void create(StudentRequest request){  // 创建一个学生，插入进数组。如果数组满了，抛出异常，给用户友好提示。要求根据学生的名字，保证数组有序 升序或者降序
        Student student = new Student();
        student.setName(request.getName());
        Date date = new Date();
        int id = (int) date.getTime();
        student.setId(id);
        studentRepository.save(student);
    }

    public void update(int id,String name){  // 根据下标 更新 学生名字。如果学生不存在，抛出异常
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setName(name);
            studentRepository.save(student);
        } else throw new RuntimeException("User not found! id:" + id);
    }

    public void registerClass(Integer id, List<Integer> classIdList) {
        if(classIdList.isEmpty()) return;
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            Set<ClassInfo> classSet = classInfoRepository.findAllByIdIn(classIdList);
            student.getClassInfoSet().addAll(classSet);
            studentRepository.save(student);
        } else throw new RuntimeException("Student not found! id: "+id);
    }
    public void dropClass(Integer id, List<Integer> classIdList) {
        if(classIdList.isEmpty()) return;
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            Set<ClassInfo> classInfoSet = classInfoRepository.findAllByIdIn(classIdList);
            student.getClassInfoSet().removeAll(classInfoSet);
            studentRepository.save(student);
        }else throw new RuntimeException("Student not found! id: "+id);
    }


    public Student getById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        } else throw new RuntimeException("User not found! id:" + id);

    }
    public List<Student> getAllByName(String name) {
        return studentRepository.getAllByName(name);
    }

    public List<Student> getAll(){  // 返回map里面所有学生，打印学生名字。并且保证有序
        return  studentRepository.findAll();
    }
    public String getOnlyNameById(Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get().getName();
        } else throw new RuntimeException("Student not found! id:"+id);
    }


    public void deleteById(int id){ //按id删除学生
        studentRepository.deleteById(id);
    }
    public Page<Student> pagination(int page,int size, String name){
        //Page<T> finaAll(Pageable pageable)
        Sort sort = Sort.by("name");
        //return studentRepository.getAllByName(name, (Pageable) PageRequest.of(page,size));
        return studentRepository.findAll(PageRequest.of(page,size,sort.descending()) );



    }
}
