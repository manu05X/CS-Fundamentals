package com.manish.Thread.CodeQuestion.FLiveLock;


// Demonstrates a livelock scenario where two threads (husband and wife) try to eat using a shared resource (a spoon).
public class Livelock {

    // Represents the shared resource (Spoon) used by the diners.
    static class Spoon {

        private Diner owner; // The current owner of the spoon.

        // Constructor to set the initial owner of the spoon.
        public Spoon(Diner d) {
            owner = d;
        }

        // Getter to retrieve the current owner of the spoon.
        public Diner getOwner() {
            return owner;
        }

        // Synchronized method to change the owner of the spoon.
        public synchronized void setOwner(Diner d) {
            owner = d;
        }

        // Synchronized method to simulate using the spoon.
        public synchronized void use() {
            System.out.printf("%s has eaten!%n", owner.getName());
        }
    }

    // Represents a diner (husband or wife) who tries to eat using the spoon.
    static class Diner {

        private String name;      // Name of the diner.
        private boolean isHungry; // Indicates if the diner is still hungry.

        // Constructor to initialize the diner's name and hunger status.
        public Diner(String n) {
            name = n;
            isHungry = true;
        }

        // Getter to retrieve the diner's name.
        public String getName() {
            return name;
        }

        // Getter to check if the diner is hungry.
        public boolean isHungry() {
            return isHungry;
        }

        // Method where the diner tries to eat using the spoon.
        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // If the diner doesn't have the spoon, wait for their spouse to give it.
                if (spoon.getOwner() != this) {
                    try {
                        Thread.sleep(1); // Simulate waiting.
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                // If the spouse is hungry, pass the spoon to them.
                if (spouse.isHungry()) {
                    System.out.printf("%s: You eat first, my darling %s!%n", name, spouse.getName());
                    spoon.setOwner(spouse); // Pass the spoon to the spouse.
                    continue;
                }

                // If the spouse is not hungry, eat and then pass the spoon.
                spoon.use(); // Use the spoon to eat.
                isHungry = false; // The diner is no longer hungry.
                System.out.printf("%s: I am stuffed, my darling %s!%n", name, spouse.getName());
                spoon.setOwner(spouse); // Pass the spoon to the spouse.
            }
        }
    }

    public static void main(String[] args) {
        // Create two diners: husband and wife.
        final Diner husband = new Diner("husband");
        final Diner wife = new Diner("wife");

        // Create a shared spoon and assign it initially to the husband.
        final Spoon spoon = new Spoon(husband);

        // Start a thread for the husband to try and eat using the spoon.
        new Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWith(spoon, wife);
            }
        }).start();

        // Start a thread for the wife to try and eat using the spoon.
        new Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWith(spoon, husband);
            }
        }).start();
    }
}
