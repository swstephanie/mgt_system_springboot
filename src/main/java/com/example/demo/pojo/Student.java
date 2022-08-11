package com.example.demo.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="student")
@Entity
public class Student implements Comparable<Student>{
    @Column(name="name")
    private String name;
    @Id
    @Column(name="id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id",referencedColumnName = "id")
    private Card card;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="student_class",//the table we use
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="class_id ")
    )
    private Set<ClassInfo> classInfoSet = new HashSet<>();
    public Student() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Set<ClassInfo> getClassInfoSet() {
        return classInfoSet;
    }

    public void setClassInfoSet(Set<ClassInfo> classInfoSet) {
        this.classInfoSet = classInfoSet;
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
