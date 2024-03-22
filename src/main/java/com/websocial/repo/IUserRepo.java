package com.websocial.repo;

import com.websocial.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IUserRepo extends CrudRepository<User, Long> {
    Boolean existsByEmail(String email);
}
