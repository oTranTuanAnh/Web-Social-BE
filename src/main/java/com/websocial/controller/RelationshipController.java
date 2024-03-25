package com.websocial.controller;

import com.websocial.model.UserRelationShip;
import com.websocial.service.impl.UserRelationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/relationship")
public class RelationshipController {
    @Autowired
    UserRelationServiceImpl userRelationService;
    @GetMapping("/check-relationship")
    public ResponseEntity<UserRelationShip> checkRelationship(@RequestParam("id2") Long id2) {
        UserRelationShip userRelationShip = userRelationService.findRelationship(AuthController.getId(), id2);
        return new  ResponseEntity<>(userRelationShip, HttpStatus.OK);
    }
}
