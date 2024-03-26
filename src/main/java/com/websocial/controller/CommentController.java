package com.websocial.controller;

import com.websocial.model.Comment;
import com.websocial.model.Post;
import com.websocial.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Comment>> listComments(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.findByPostId(id), HttpStatus.OK);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Comment> create(@RequestBody Comment comment, @PathVariable Long id){
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Comment> delete(@PathVariable Long id) {
        Optional<Comment> comOptional = commentService.findById(id);
        if (!comOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.remove(id);
        return new ResponseEntity<>(comOptional.get(),HttpStatus.OK);
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<Long> countComment(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.countComment(id), HttpStatus.OK);
    }

}
