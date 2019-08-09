package com.example.postgres.demo.controller;

import com.example.postgres.demo.repository.ContactRepository;
import org.springframework.web.bind.annotation.GetMapping;
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
//        return contactRepository.getAllById(123).toString();
    }


    @GetMapping("/in")
    public int insert(){
        return contactRepository.insert(123,"tom",456,789);
    }
}
