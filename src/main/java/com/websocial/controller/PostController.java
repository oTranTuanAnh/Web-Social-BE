package com.websocial.controller;

import com.websocial.model.Post;
import com.websocial.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostServiceImpl postService;
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Post>> listPosts(@PathVariable Long id) {
        return new ResponseEntity<>(postService.postList(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Post> createUser(@RequestBody Post post){
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }
}
