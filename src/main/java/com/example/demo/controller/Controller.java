package com.example.demo.controller;

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
    //POST -- create
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String create(@RequestBody StudentRequest request){
        service.create(request);
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
