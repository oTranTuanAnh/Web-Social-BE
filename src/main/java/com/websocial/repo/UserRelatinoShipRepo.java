package com.websocial.repo;

import com.websocial.model.UserRelationShip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRelatinoShipRepo extends CrudRepository<UserRelationShip,Long> {
    @Query(nativeQuery = true,value = "insert into user_relation_ship(user_id1,user_id2) values (?1,?2)")
    void addFriendRequest(Long idSource,Long idTarget);
}
