package com.websocial.config.service;

import com.websocial.config.UserPrinciple;
import com.websocial.model.appUser.AppUser;
import com.websocial.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    AppUserRepo appUserRepo;
    public AppUser findByUsername(String name) {
        return appUserRepo.findByUsername(name);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserPrinciple.build(appUserRepo.findByUsername(username));
    }
}
