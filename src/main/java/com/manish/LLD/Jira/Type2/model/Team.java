package com.manish.LLD.Jira.Type2.model;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private int teamId;
    private String name;
    private Set<User> members = new HashSet<>();

    public Team(int teamId, String name){
        this.teamId = teamId;
        this.name = name;
    }

    public void addMembers(User user){
        members.add(user);
        user.getTeams().add(this);
    }

    // Getters and Setters
    public int getTeamId() { return teamId; }
    public String getName() { return name; }
    public Set<User> getMembers() { return members; }


}
