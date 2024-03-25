package com.websocial.service;

import com.websocial.model.UserRelationShip;

public interface IUserRelationShipService<u> extends GeneralService<UserRelationShip>{
     void addFriendRequest(Long idSource, Long idTarget);

    boolean isFriendRequest(Long idSource, Long idTarget);
}
