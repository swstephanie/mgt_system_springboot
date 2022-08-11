package com.example.demo.dao;

import com.example.demo.pojo.Student;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

@org.springframework.stereotype.Repository
public class Repository {
    private static Map<Integer,Student> map = new Hashtable<>();
    static {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Suwei");
        map.put(s1.getId(),s1);
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Chunchen");
        map.put(s2.getId(),s2);
    }

    public void insert(int id, Student student) {
        map.put(id,student);
    }
    public Student getById(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        } else return null;
    }
    public Set<Student> getAll() {
        Set<Student> set = new HashSet<>();
        for (Map.Entry<Integer,Student> entry: map.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    public void update(int id, String name) {
        if(!map.containsKey(id)) {
            System.out.println("The student does not exist.");
        } else {
            Student student = new Student();
            student.setName(name);
            student.setId(id);
            map.put(id,student);
        }
    }
    public void delete(int id) {
        if(map.containsKey(id)) {
            map.remove(id);
        } else {
            System.out.println("The student does not exist.");
        }
    }

}
