package com.example.postgres.demo.controller;

import com.example.postgres.demo.model.User;
import com.example.postgres.demo.repository.ContactRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yanggt
 * @date 19-8-8
 */
@RestController
@RequestMapping("/t")
public class Test {

    @Resource
    private ContactRepository contactRepository;

    @GetMapping("/q")
    public String get(){
        return contactRepository.get().toString();
    }


    @GetMapping("/in")
    public int insert(){
        return contactRepository.insert(123,"jetty","apache");
    }

    @GetMapping("/save")
    public void save(){
        User u = new User();
        u.setAddress("apache");
        u.setName("tomcat");
        User user = contactRepository.saveAndFlush(u);
        System.out.println(user.toString());
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable("id") int id){
        User u = contactRepository.getOneById(id);
        u.setAddress("k3s");
        contactRepository.saveAndFlush(u);
    }
}
