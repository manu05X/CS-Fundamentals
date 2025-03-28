package com.manish.LLD.BookMyShow.Part2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
   private String name;
   private String address;

   @OneToMany
   private List<Auditorium> auditoriums;

   @ManyToOne
   private City city; //referenceCity-> Sometime two class have same entity(in Theatre class and in City class). SO as per ORM both are
   //same thing, ORM need something to make diff between both entity
}
