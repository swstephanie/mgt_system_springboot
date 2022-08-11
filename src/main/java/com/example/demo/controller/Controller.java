package com.example.demo.controller;

import com.example.demo.pojo.ClassInfo;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentRequest;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class  Controller  {
    @Autowired
    private Service service;

    @RequestMapping(value =  "/student", method = RequestMethod.GET)
    public List<Student> getAll(){
        return service.getAll();
    }
    //GET -- byID
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Student getByID(@PathVariable(value = "id") int id){
        return service.getById(id);
    }
    //GET -- byName
    @RequestMapping(value = "/student/byname", method = RequestMethod.GET)
    public List<Student> getByName(@RequestParam(value = "name") String name) {
        return service.getAllByName(name);
    }
    //GET --- page
    @RequestMapping(value = "/student/page", method = RequestMethod.GET)
    public Page<Student> getAll(@RequestParam(value="size") int size,
                                @RequestParam(value="page") int page,
                                @RequestParam(value="name") String name) {
        return service.pagination(page,size,name);
    }
    //GET -- Only Name
    @RequestMapping(value = "/studentName/{id}",method = RequestMethod.GET)
    public String getOnlyNameById(@PathVariable(value ="id") int id) {
        return service.getOnlyNameById(id);
    }
    //POST -- create
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String create(@RequestBody StudentRequest request){
        service.create(request);
        return "success";
    }
    //POST
    @RequestMapping(value = "/student/register", method = RequestMethod.POST)
    public String register(@RequestParam(value = "id") Integer id,@RequestBody List<Integer> classIdList) {
        service.registerClass(id,classIdList);
        return "success";
    }

    @RequestMapping(value = "/student/drop", method = RequestMethod.PUT)
    public String dropClass(@RequestParam(value = "id") int id, @RequestBody List<Integer> classIdList) {
        service.dropClass(id,classIdList);
        return "success";
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String update(@RequestParam(value = "id") int id,@RequestParam(value = "username") String name){
        service.update(id,name);
        return "success";
    }
    @RequestMapping(value = "/student", method = RequestMethod.DELETE)
    public String delete(@RequestParam(value = "id") int id){
        service.deleteById(id);
        return "success";
    }




}
