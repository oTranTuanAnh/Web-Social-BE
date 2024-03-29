package com.websocial.service.impl;

import com.websocial.model.User;
import com.websocial.model.UserRelationShip;
import com.websocial.repo.UserRelatinoShipRepo;
import com.websocial.service.IUserRelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRelationShipService implements IUserRelationShipService<UserRelationShip> {
    @Autowired
    private UserRelatinoShipRepo userRelatinoShipRepo;
    @Autowired UserServiceImpl userService;
    @Override
    public Iterable<UserRelationShip> findAll() {
     return    userRelatinoShipRepo.findAll();
    }

    @Override
    public Optional<UserRelationShip> findById(Long id) {
     return    userRelatinoShipRepo.findById(id);
    }

    @Override
    public UserRelationShip save(UserRelationShip userRelationShip) {
      return   userRelatinoShipRepo.save(userRelationShip);
    }

    @Override
    public void remove(Long id) {
        userRelatinoShipRepo.deleteById(id) ;
    }
    @Override
    public void addFriendRequest(Long idSource, Long idTarget) {
        if (isMe(idSource,idTarget)){
            System.out.println("trung");
        }else {
            userRelatinoShipRepo.addFriendRequest(idSource,idTarget);
        }
    }
    @Override
    public boolean isFriendRequest(Long idSource, Long idTarget){
        return false;
    }
    public boolean isMe(Long idSource,Long idTarget){
        if (idSource == idTarget){
            return true;
        }
        else {
            return false;
        }
    }
    public void successRequest(Long idRequest,Long idSuccess){
        userRelatinoShipRepo.successRequest(idRequest,idSuccess);
    }
    public Iterable<UserRelationShip> showAddFriendRequest(Long id){
      return   userRelatinoShipRepo.showAddFriendRequestById(id);
    }
    public void removeAddFriendRequest(Long id1,Long id2){
        userRelatinoShipRepo.removeFriendRequest(id1,id2);
    }
}
