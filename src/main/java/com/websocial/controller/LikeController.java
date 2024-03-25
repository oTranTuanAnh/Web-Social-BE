package com.websocial.controller;

import com.websocial.model.Likes;
import com.websocial.model.Post;
import com.websocial.model.User;
import com.websocial.model.dto.CountLikes;
import com.websocial.service.impl.LikesServiceImpl;
import com.websocial.service.impl.PostServiceImpl;
import com.websocial.service.impl.UserServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikesServiceImpl likesService;

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<Long> countLikeOfPost(@PathVariable Long id) {
        return new ResponseEntity<>(likesService.getTotalLike(id), HttpStatus.OK);
    }

    private boolean checkLikeStatus(User user, Post post, Iterable<Likes> likeStatuses) {
        for (Likes i : likeStatuses) {
            if (i.getPost() == post && i.getUser() == user && i.getId() == null) {
                return false;
            }
        }
        return true;
    }

    @PostMapping("/create/{pId}/{uId}")
    public ResponseEntity<Likes> likeStatus(@PathVariable Long pId, @PathVariable Long uId) {
        Likes likes = new Likes();
        Post post = postService.findById(pId).get();
        User user = userService.findById(uId).get();
        Likes likeStatus = likesService.findByUserIdAndPostId(user.getId(),post.getId());
        if (checkLikeStatus(user,post,likesService.findAll())) {
            if (likeStatus == null) {
                likes.setUser(user);
                likes.setPost(post);
                likesService.save(likes);
            } else {
                likesService.remove(likeStatus.getId());
            }
        }
        return new ResponseEntity<>(likeStatus, HttpStatus.OK);
    }
}
