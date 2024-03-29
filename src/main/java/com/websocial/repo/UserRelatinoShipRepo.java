package com.websocial.repo;

import com.websocial.model.User;
import com.websocial.model.UserRelationShip;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRelatinoShipRepo extends CrudRepository<UserRelationShip,Long> {
    @Modifying
    @Query(nativeQuery = true,value = "insert into user_relation_ship(user_id1,user_id2)value (:id1,:id2);")
     void addFriendRequest(@Param("id1")Long idSource,@Param("id2") Long idTarget);
    @Modifying
    @Query(nativeQuery = true,value = "call deleteAddFriendRequest(:id3,:id4);")
    void removeFriendRequest(@Param("id3")Long id3,@Param("id4")Long id4);
    @Query(nativeQuery = true,value = "select * from user_relation_ship where user_id2 = :id AND status = 0")
    Iterable<UserRelationShip> showAddFriendRequestById(@Param("id")Long id);
    @Modifying
    @Query(nativeQuery = true,value = "update user_relation_ship set status = 1 where user_id1=:id1 and user_id2=:id2")
    void successRequest(@Param("id1") Long idRequest,@Param("id2")Long idSuccess);
}
