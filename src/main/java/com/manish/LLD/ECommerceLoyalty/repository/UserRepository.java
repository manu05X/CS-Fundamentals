package com.manish.LLD.ECommerceLoyalty.repository;


import com.manish.LLD.ECommerceLoyalty.model.User;

public interface UserRepository {
    void save(User user);
    User findByName(String name);
    boolean exists(String name);
}