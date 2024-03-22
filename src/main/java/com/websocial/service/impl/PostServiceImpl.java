package com.websocial.service.impl;

import com.websocial.model.Post;
import com.websocial.model.dto.GetFriendsListOfUser;
import com.websocial.repo.PostRepo;
import com.websocial.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRelationServiceImpl userRelationService;
    @Override
    public Iterable<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepo.deleteById(id);
    }

    public Iterable<Post> postList(Long id) {
        return postRepo.findPostByUserIdOrderByCreateDateDesc(id);
    }

    public Iterable<Post> postListByFr(Long id) {
        return postRepo.findPostByUserId(id);
    }

    public List<Post> getPostOfFr(Long id) {

        List<Post> postList = new ArrayList<>();
        List<Long> idFr = new ArrayList<>();
        for (GetFriendsListOfUser i: userRelationService.getIdOfFriends(id)) {
            idFr.add(i.getU_id());
        }
        for (Long j : idFr) {
            for (Post p : postListByFr(j)){
                postList.add(p);
            }
        }

        return postList;
    }
}
