package com.websocial.controller;

import com.websocial.model.Post;
import com.websocial.model.dto.GetFriendsListOfUser;
import com.websocial.service.impl.PostServiceImpl;
import com.websocial.service.impl.UserRelationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private UserRelationServiceImpl userRelationService;
    @Autowired
    private PostServiceImpl postService;
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Post>> listPosts(@PathVariable Long id) {
        return new ResponseEntity<>(postService.postList(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody Post post){
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> delete(@PathVariable Long id) {
        Optional<Post> customerOptional = postService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<>(customerOptional.get(),HttpStatus.OK);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<Iterable<Post>> listPostAtHome(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostOfFr(id), HttpStatus.OK);
    }

}
