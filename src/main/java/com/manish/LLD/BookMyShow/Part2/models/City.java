package com.manish.LLD.BookMyShow.Part2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "city") // name of the attribute in the other class that is representing the relationship
    private List<Theatre> theatres; //Sometime two class have same entity(in Theatre class and in City class). SO as per ORM both are
    //same thing, ORM need something to make diff between both entity
}
