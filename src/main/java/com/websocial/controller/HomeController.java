package com.websocial.controller;

import com.websocial.model.User;
import com.websocial.service.impl.UserRelationShipService;
import com.websocial.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRelationShipService userRelationShipService;
    @GetMapping("/friend")
    public ResponseEntity<Iterable<User>> showAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/friendrequest/add/{id}")
    public ResponseEntity<Long> addFriendRequest(@PathVariable("id")Long idTarget){
        Long idSource = AuthController.current_id;
        userRelationShipService.addFriendRequest(idSource, idTarget);
        return new ResponseEntity(idTarget,HttpStatus.OK);
    }
}
