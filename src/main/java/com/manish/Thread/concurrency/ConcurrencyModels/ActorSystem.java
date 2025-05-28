package com.manish.Thread.concurrency.ConcurrencyModels;


/*

package com.manish.Thread.concurrency.ConcurrencyModels;


public class HelloWorldActor extends UntypedAbstractActor {
    public void onReceive(Object message){
        if(message instanceof String){
            System.out.println("Hello " +message);
        }
    }
}



public class ActorSystem {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("Hello System");
        ActorRef helloActor = system.actorOf(Props.create(HelloWorldActor.class), "helloactor");

        helloActor.tell("World", ActorRef.noSender());

        system.terminate();
    }
}

correct the above code

 */


//
//import akka.actor.AbstractActor;
//import akka.actor.Props;
//
//public class HelloWorldActor extends AbstractActor {
//
//    // Define how to create Props
//    public static Props props() {
//        return Props.create(HelloWorldActor.class);
//    }
//
//    @Override
//    public Receive createReceive() {
//        return receiveBuilder()
//                .match(String.class, message -> {
//                    System.out.println("Hello " + message);
//                })
//                .build();
//    }
//}
//
//
//
//public class ActorSystem {
//    public static void main(String[] args) {
//        ActorSystem system = ActorSystem.create("HelloSystem");
//
//        ActorRef helloActor = system.actorOf(HelloWorldActor.props(), "helloactor");
//
//        helloActor.tell("World", ActorRef.noSender());
//
//        // Allow actor to finish before termination
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        system.terminate();
//    }
//}
