package com.manish.LLD.ECommerceLoyalty.Type2.repository;


import com.manish.LLD.ECommerceLoyalty.Type2.model.User;

public interface UserRepository {
    void save(User user);
    User findByName(String name);
    boolean exists(String name);
}