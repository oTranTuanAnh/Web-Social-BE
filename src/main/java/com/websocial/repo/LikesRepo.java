package com.websocial.repo;

import com.websocial.model.Likes;
import com.websocial.model.dto.CountLikes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepo extends CrudRepository<Likes, Long> {
    @Query(nativeQuery = true, value = "select count(user_id) as C from likes where post_id=:id")
    Iterable<CountLikes> likesOfPost(@Param("id") Long id);

}
