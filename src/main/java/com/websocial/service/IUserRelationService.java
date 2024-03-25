package com.websocial.service;

import com.websocial.model.User;
import com.websocial.model.UserRelationShip;


public interface IUserRelationService extends GeneralService<UserRelationShip>{
    UserRelationShip findRelationship(Long id1, Long id2);
}
