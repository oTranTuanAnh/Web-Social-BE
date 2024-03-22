package com.websocial.controller;

import com.websocial.model.User;
import com.websocial.repo.IUserRepo;
import com.websocial.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRepo IUserRepo;
    @Autowired
    private UserServiceImpl userService;
    @GetMapping
    public ResponseEntity<Iterable<User>> listUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable Long id){
        Optional<User> customerOptional = userService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = customerOptional.get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
//        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
//    }
}
