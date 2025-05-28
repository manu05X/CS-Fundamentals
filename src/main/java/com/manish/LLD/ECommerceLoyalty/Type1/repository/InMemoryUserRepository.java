package com.manish.LLD.ECommerceLoyalty.Type1.repository;


import com.manish.LLD.ECommerceLoyalty.Type1.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User findByName(String name) {
        return users.get(name);
    }

    @Override
    public boolean exists(String name) {
        return users.containsKey(name);
    }
}