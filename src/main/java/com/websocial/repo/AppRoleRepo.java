package com.websocial.repo;


import com.websocial.model.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends CrudRepository<AppRole, Long> {
}