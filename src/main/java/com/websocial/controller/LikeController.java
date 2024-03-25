package com.websocial.controller;

import com.websocial.model.Likes;
import com.websocial.model.dto.CountLikes;
import com.websocial.service.impl.LikesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikesServiceImpl likesService;

    @PostMapping("/create")
    public ResponseEntity<Likes> create(@RequestBody Likes likes){
        return new ResponseEntity<>(likesService.save(likes), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Long> countLikeOfPost(@PathVariable Long id) {
        return new ResponseEntity<>(likesService.getTotalLike(id), HttpStatus.OK);
    }

}
