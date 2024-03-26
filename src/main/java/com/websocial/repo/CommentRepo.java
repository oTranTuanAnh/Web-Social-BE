package com.websocial.repo;

import com.websocial.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    Long countCommentByPostId(Long id);

    Iterable<Comment> findCommentByPostId(Long id);

}
