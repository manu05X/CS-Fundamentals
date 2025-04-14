package com.manish.CoreJava.ArchitecturalPatterns;

import java.util.List;

interface UserDAO {
    void insert(User1 user);

    void update(User1 user);

    void delete(User1 user);

    User1 getById(int id);

    List<User1> getAll();
}
