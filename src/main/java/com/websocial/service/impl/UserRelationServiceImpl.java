package com.websocial.service.impl;

import com.websocial.model.entity.UserRelationship;
import com.websocial.model.dto.GetFriendsListOfUser;
import com.websocial.model.dto.GetPostFormUser;
import com.websocial.repo.UserRelationRepo;
import com.websocial.service.IUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserRelationServiceImpl implements IUserRelationService {
    @Autowired
    private UserRelationRepo userRelationRepo;
    @Override
    public List<UserRelationship> findAll() {
        return null;
    }

    @Override
    public UserRelationship findById(Long id) {
        return null;
    }

    @Override
    public void save(UserRelationship userRelationship) {
    }

    @Override
    public void remove(Long id) {
    }

    public List<Long> getIdOfFriends(Long id){
        List<Long> idFriends = new ArrayList<>();
        Iterable<GetFriendsListOfUser> friendCol1 = userRelationRepo.friendsOfColUser1(id);
        Iterable<GetFriendsListOfUser> friendCol2 = userRelationRepo.friendsOfColUser2(id);
        for (GetFriendsListOfUser i : friendCol1) {
            idFriends.add(i.getIdFriends());
        }
        for (GetFriendsListOfUser i : friendCol2) {
            idFriends.add(i.getIdFriends());
        }
        System.out.println(idFriends);
        return idFriends;
    }

    public List<String> showPostOfFriend(Long id) {
        List<String> post = new ArrayList<>();
        List<Long> friends = getIdOfFriends(id);
        for (Long i : friends) {
            Iterable<GetPostFormUser> posts = userRelationRepo.getPostFromUser(i);
            for (GetPostFormUser j : posts) {
                post.add(j.getContent());
            }
        }
        return post;
    }
}
