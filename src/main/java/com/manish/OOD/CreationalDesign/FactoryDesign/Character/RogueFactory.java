package com.manish.OOD.CreationalDesign.FactoryDesign.Character;

// Concrete factory for creating Rogue characters
public class RogueFactory implements CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Rogue(name, 75, 7, 10, 3);
    }
}
