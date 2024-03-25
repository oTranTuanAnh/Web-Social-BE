package com.websocial.controller;

import com.websocial.service.impl.UserRelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/friendrequest")
public class UserRlsController {
    @Autowired
    private UserRelationShipService userRelationShipService;
    @GetMapping("/add/{id}")
    public ResponseEntity<Long> addFriendRequest(@PathVariable("id")Long idTarget){
        Long idSource = AuthController.current_id;
        userRelationShipService.addFriendRequest(idSource, idTarget);
        return new ResponseEntity(idTarget,HttpStatus.OK);
    }
}
