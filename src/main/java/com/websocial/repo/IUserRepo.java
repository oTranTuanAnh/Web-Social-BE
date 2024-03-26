package com.websocial.repo;

import com.websocial.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IUserRepo extends CrudRepository<User, Long> {
    Boolean existsByEmail(String email);
    @Query(nativeQuery = true,value = "select * from user where user.id != :id and user.id not in (select user_id2 from user_relation_ship where user_id1 = :id);")
    Iterable<User> findFriendRecmt(@Param("id")Long id);

}
