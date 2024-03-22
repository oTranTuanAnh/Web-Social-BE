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
    @Query(nativeQuery = true, value = "select id1 from UserRelationship where id2=:id and status=1")
    Iterable<GetFriendsListOfUser> friendsOfColUser1(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select id2 from UserRelationship where id1=:id and status=1")
    Iterable<GetFriendsListOfUser> friendsOfColUser2(@Param("id") Long id);


}
