package com.websocial.service.impl;

import com.websocial.model.Likes;
import com.websocial.model.dto.CountLikes;
import com.websocial.repo.LikesRepo;
import com.websocial.service.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class LikesServiceImpl implements ILikesService {
    @Autowired
    private LikesRepo likesRepo;


    @Override
    public Iterable<Likes> findAll() {
        return likesRepo.findAll();
    }

    @Override
    public Optional<Likes> findById(Long id) {
        return likesRepo.findById(id);
    }

    @Override
    public Likes save(Likes likes) {
        return likesRepo.save(likes);
    }

    @Override
    public void remove(Long id) {
        likesRepo.deleteById(id);
    }

    public Long getTotalLike(Long id) {
        return likesRepo.likesOfPost(id);
    }
    public void deleteByPostId(Long id){
        likesRepo.deleteByPostId(id);
    }

}
