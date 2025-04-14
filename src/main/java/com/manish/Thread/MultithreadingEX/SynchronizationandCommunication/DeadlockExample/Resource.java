package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.DeadlockExample;

class Resource {
    Resource() {
    }

    // Synchronized method1 - locks on the current object (this)
    public synchronized void method1(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " is executing method1");

        try {
            Thread.sleep(100L); // Simulate some processing time
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

        resource.method2(this); // Calls method2 on the other resource while still holding this lock
    }

    // Synchronized method2 - locks on the current object (this)
    public synchronized void method2(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " is executing method2");

        try {
            Thread.sleep(100L); // Simulate some processing time
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

        resource.method1(this); // Calls method1 on the other resource while still holding this lock
    }
}



/*
// Consistent Lock Ordering (Recommended)

class Resource {
    // Add an ID to establish ordering
    private final int id;

    Resource(int id) {
        this.id = id;
    }

    public void method1(Resource other) {
        // Determine which resource to lock first based on ID
        Resource first = this.id < other.id ? this : other;
        Resource second = this.id < other.id ? other : this;

        synchronized(first) {
            synchronized(second) {
                System.out.println(Thread.currentThread().getName() + " is executing method1");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                other.method2(this);
            }
        }
    }

    public void method2(Resource other) {
        // Same locking order as method1
        Resource first = this.id < other.id ? this : other;
        Resource second = this.id < other.id ? other : this;

        synchronized(first) {
            synchronized(second) {
                System.out.println(Thread.currentThread().getName() + " is executing method2");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                other.method1(this);
            }
        }
    }
}
 */