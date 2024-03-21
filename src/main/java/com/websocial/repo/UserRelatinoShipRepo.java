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
}
