package com.manish.OOD.CreationalDesign.FactoryDesign.Character;

// Concrete factory for creating Warrior characters
public class WarriorFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Warrior(name, 100, 10, 5, 5);
    }
}
