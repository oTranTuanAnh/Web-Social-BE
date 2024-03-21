package com.websocial.repo;


import com.websocial.model.appUser.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AppRoleRepo extends CrudRepository<AppRole, Long> {
    AppRole findOneByName(String name);
    Set<AppRole> findAllByIdIn(List<Long> ids);
}