package com.websocial.controller;

import com.websocial.service.impl.UserRelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/friend")
public class UserRlsController {
    @Autowired
    private UserRelationShipService userRelationShipService;
    @GetMapping("")
    public void request(){
        userRelationShipService.addFriendRequest(1L, 2L);
        System.out.println("OK");
    }
}

