package com.websocial.service.impl;

import com.websocial.model.User;
import com.websocial.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements com.websocial.service.IUserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void remove(Long id) {

    }
}
