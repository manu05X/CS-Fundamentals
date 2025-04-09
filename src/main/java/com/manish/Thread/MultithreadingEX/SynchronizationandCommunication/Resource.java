package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

class Resource {
    Resource() {
    }

    public synchronized void method1(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " is executing method1");

        try {
            Thread.sleep(100L);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

        resource.method2(this);
    }

    public synchronized void method2(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " is executing method2");

        try {
            Thread.sleep(100L);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

        resource.method1(this);
    }
}