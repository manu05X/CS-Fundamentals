package com.manish.OOD.CreationalDesign.FactoryDesign.Character;

// Concrete factory for creating Mage characters
public class MageFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Mage(name, 50, 5, 5, 10);
    }
}
