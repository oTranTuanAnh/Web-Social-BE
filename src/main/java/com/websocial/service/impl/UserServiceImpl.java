package com.websocial.service.impl;

import com.websocial.RoleType;
import com.websocial.model.User;
import com.websocial.model.appUser.AppRole;
import com.websocial.model.appUser.AppUser;
import com.websocial.repo.AppRoleRepo;
import com.websocial.repo.AppUserRepo;
import com.websocial.repo.IUserRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements com.websocial.service.IUserService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private AppRoleRepo appRoleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserRepo IUserRepo;
    @Override
    public Iterable<User> findAll() {
        return IUserRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        //check thong tin da ton tai chua
        validateInfor(user);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        AppUser appUser = new AppUser();
        appUser.setUsername(user.getEmail());
        appUser.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Long> rolesIDs = Arrays.asList(appRoleRepo.findOneByName(RoleType.ROLE_USER.getName()).getId());
        Set<AppRole> roles = appRoleRepo.findAllByIdIn(rolesIDs);
        appUser.setRoles(roles);
        appUserRepo.save(appUser);
        return IUserRepo.save(user);
    }

    @Override
    public void remove(Long id) {

    }


    private void validateInfor(User user){
        if (exitsByUsername(user.getEmail()))
            try {
                throw new BadRequestException("Email đã tồn tại");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }

    }
    public Iterable<User> findFriendRecmt(Long id){
//        System.out.println(IUserRepo.findFriendRecmt(1L));
        return IUserRepo.findFriendRecmt(id);
    }

    private boolean exitsByUsername(String email) {
        return IUserRepo.existsByEmail(email);
    }

}
