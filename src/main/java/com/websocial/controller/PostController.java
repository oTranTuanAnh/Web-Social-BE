package com.websocial.controller;

import com.websocial.model.Post;
import com.websocial.model.dto.GetPostFromUser;
import com.websocial.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

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
    public ResponseEntity<Post> create(@RequestBody Post post){
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> delete(@PathVariable Long id) {
        Optional<Post> postOptional = postService.findById(id);
        if (!postOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<>(postOptional.get(),HttpStatus.OK);
    }
    @GetMapping("/home/{id}")
    public ResponseEntity<Iterable<Post>> listPostAtHome(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostOfFr(id), HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Post> updateStatus(@PathVariable Long id, @RequestBody Post post) {
        Optional<Post> postOptional = postService.findById(id);
        if (!postOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Date current_date = new Date();
//        giữ nguyên đối tượng ko thay đổi
        post.setId(postOptional.get().getId());
        post.setCreateDate(current_date);
        post.setUser(postOptional.get().getUser());
        postService.save(post);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}