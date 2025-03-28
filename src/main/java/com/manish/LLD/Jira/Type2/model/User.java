package com.manish.LLD.Jira.Type2.model;

import com.manish.LLD.Jira.Type2.constants.Enums.Role;

import java.util.HashSet;
import java.util.Set;

public class User {
    private int userId;
    private String name;
    private String email;
    private Role role;
    private Set<Team> teams = new HashSet<>();

    public User(int userId, String name, String email, Role role){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
    }


    public boolean canCreateTask() {
        return role == Role.PRODUCT_OWNER || role == Role.SCRUM_MASTER || role == Role.ADMIN;
    }

    public boolean canCreateSprint() {
        return role == Role.SCRUM_MASTER || role == Role.ADMIN;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Role getRole() { return role; }
    public Set<Team> getTeams() { return teams; }

}
