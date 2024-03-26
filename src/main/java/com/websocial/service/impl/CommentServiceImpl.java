package com.websocial.service.impl;

import com.websocial.model.Comment;
import com.websocial.repo.CommentRepo;
import com.websocial.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostServiceImpl postService;
    @Override
    public Iterable<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepo.findById(id);
    }
    public Iterable<Comment> findByPostId(Long id) {
        return commentRepo.findCommentByPostId(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }
//    public Comment saveCommentByPostId(Comment comment, Long id) {
//        return commentRepo.save(comment);
//    }

    @Override
    public void remove(Long id) {
        commentRepo.deleteById(id);
    }

    public Long countComment(Long id) {
        return commentRepo.countCommentByPostId(id);
    }
}
