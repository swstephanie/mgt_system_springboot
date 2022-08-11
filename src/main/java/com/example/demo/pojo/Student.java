package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="student")
@Entity
public class Student implements Comparable<Student>{
    @Column(name="name")
    private String name;
    @Id
    @Column(name="id")
    private int id;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id  +
                ", name='" + name +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getId()-o.getId();
    }
}
