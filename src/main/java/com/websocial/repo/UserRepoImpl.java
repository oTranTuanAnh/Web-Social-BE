package com.websocial.repo;

import com.websocial.model.User;

import java.util.Optional;

public class UserRepoImpl implements IUserRepo{
    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public Iterable<User> findFriendRecmt(Long id) {
        return null;
    }

//    @Override
//    public Iterable<User> findFriendRecmt(Long id1, Long id2) {
//        return null;
//    }
    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
