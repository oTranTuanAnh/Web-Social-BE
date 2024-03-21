package com.websocial.controller;

import com.websocial.service.impl.UserRelationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class HomController {
    @Autowired
    private UserRelationServiceImpl userRelationService;

    @GetMapping("/")
    public ResponseEntity<List<String>> listPosts() {
        Long currentId = AuthController.current_id;
        return new ResponseEntity<>(userRelationService.showPostOfFriend(currentId), HttpStatus.OK);
    }
}
