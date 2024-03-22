package com.websocial.repo;

import com.websocial.model.Post;
import com.websocial.model.dto.GetPostFromUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepo extends CrudRepository<Post,Long> {

    @Query(nativeQuery = true, value = "select * from post where user_id =:id order by create_date desc;")
    Iterable<GetPostFromUser> getPostFromUser(@Param("id") Long id);
    Iterable<Post> findPostByUserId(Long id);
    Iterable<Post> findPostByUserIdOrderByCreateDateDesc(Long id);

    void deleteById(Long id);
}
