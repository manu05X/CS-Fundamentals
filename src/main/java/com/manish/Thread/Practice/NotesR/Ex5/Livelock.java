package com.manish.Thread.Practice.NotesR.Ex5;

public class Livelock {
    static class Spoon {
        private Diner owner;
        
        public Spoon(Diner d) { 
            owner = d; 
        }
        
        public Diner getOwner() { 
            return owner; 
        }
        
        public synchronized void setOwner(Diner d) { 
            owner = d; 
        }

        public synchronized void use() { 
            System.out.printf("%s has eaten!\n", owner.name); 
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;
        
        public Diner(String n) { 
            name = n; 
            isHungry = true; 
        }       
        
        public String getName() { 
            return name; 
        }
        
        public boolean isHungry() { 
            return isHungry; 
        }
        
        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // Don't have the spoon, wait for spouse
                if (spoon.getOwner() != this) {
                    try { 
                        Thread.sleep(1); 
                    } catch(InterruptedException e) { 
                        continue; 
                    }
                    continue;
                }                       

                // If spouse is hungry, pass the spoon
                if (spouse.isHungry()) {                    
                    System.out.printf("%s: You eat first my darling %s!\n", 
                                     name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                // Spouse isn't hungry, so eat
                spoon.use();
                isHungry = false;               
                System.out.printf("%s: I am stuffed, my darling %s!\n", 
                                 name, spouse.getName());                
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Husband");
        final Diner wife = new Diner("Wife");
        final Spoon spoon = new Spoon(husband);

        // Thread husbandThread = new Thread(husband::eatWith(spoon,wife));
        //        husbandThread.start(); // if eatWith function took no argument then we can use this way else use as  below

        new Thread(() -> husband.eatWith(spoon, wife)).start();
        new Thread(() -> wife.eatWith(spoon, husband)).start();
    }
}

/*
 public static void main(String[] args) {
        final Diner husband = new Diner("husband");
        final Diner wife = new Diner("wife");

        final Spoon s = new Spoon(husband);

        new Thread(new Runnable() {
            public void run() { husband.eatWith(s, wife); }
        }).start();


        new Thread(new Runnable() {
            public void run() { wife.eatWith(s, husband); }
        }).start();

    }
 */