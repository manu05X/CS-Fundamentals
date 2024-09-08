package com.manish.OOD.CreationalDesign.FactoryDesign.Character;

// Main class to test the factory method pattern
public class Game {
    public static void main(String[] args) {
        // Creating factories for different character types
        CharacterFactory warriorFactory = new WarriorFactory();
        CharacterFactory mageFactory = new MageFactory();
        CharacterFactory rogueFactory = new RogueFactory();

        // Creating characters using respective factories
        Character warrior = warriorFactory.createCharacter("Thor");
        Character mage = mageFactory.createCharacter("Gandalf");
        Character rogue = rogueFactory.createCharacter("Legolas");

        // Displaying and using each character
        warrior.display();
        warrior.attack();

        mage.display();
        mage.attack();

        rogue.display();
        rogue.attack();
    }
}
