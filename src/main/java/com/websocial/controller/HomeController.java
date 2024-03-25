package com.websocial.controller;

import com.websocial.model.User;
import com.websocial.model.UserRelationShip;
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
        Long id = AuthController.current_id;
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//        return new ResponseEntity<>(userService.findFriendRecmt(id), HttpStatus.OK);
    }
    @GetMapping("/friendrequest/add/{id}")
    public ResponseEntity<Long> addFriendRequest(@PathVariable("id")Long idTarget){
        Long idSource = AuthController.current_id;
        userRelationShipService.addFriendRequest(idSource, idTarget);
        return new ResponseEntity(idTarget,HttpStatus.OK);
    }
    @GetMapping("/friendrequest/{id}")
    public ResponseEntity<Iterable<UserRelationShip>> showAddFriendRequest(@PathVariable("id") Long id){
        return new ResponseEntity<>(userRelationShipService.showAddFriendRequest(id),HttpStatus.OK);
    }
    @PutMapping("/friendrequest/{id}")
    public ResponseEntity<Long> successRequest(@PathVariable("id")Long id){
        userRelationShipService.successRequest(id,AuthController.current_id);
        System.out.println(id);
        System.out.println(AuthController.current_id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
