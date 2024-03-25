package com.websocial.repo;

import com.websocial.model.UserRelationShip;
import com.websocial.model.dto.GetFriendsListOfUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRelationRepo extends CrudRepository<UserRelationShip, Long> {
    @Query(nativeQuery = true, value = "select user_id1 as u_id from user_relation_ship where user_id2=:id and status=1")
    Iterable<GetFriendsListOfUser> friendsOfColUser1(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select user_id2 as u_id from user_relation_ship where user_id1=:id and status=1")
    Iterable<GetFriendsListOfUser> friendsOfColUser2(@Param("id") Long id);

    @Query(value = "select * from user_relation_ship where ((user_id1 = :id1 and user_id2 = :id2) or (user_id1 = :id2 and user_id2 = :id1))", nativeQuery = true)
    UserRelationShip findRelationship(@Param("id1") Long id1, @Param("id2") Long id2);
}
