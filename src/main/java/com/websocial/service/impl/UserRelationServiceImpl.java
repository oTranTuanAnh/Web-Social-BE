package com.websocial.service.impl;

import com.websocial.model.UserRelationShip;
import com.websocial.model.dto.GetFriendsListOfUser;
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
    public Iterable<UserRelationShip> findAll() {
        return null;
    }

    @Override
    public Optional<UserRelationShip> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserRelationShip save(UserRelationShip userRelationship) {
        return null;
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
}
