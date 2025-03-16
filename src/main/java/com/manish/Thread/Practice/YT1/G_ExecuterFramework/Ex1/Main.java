package com.manish.Thread.Practice.YT1.G_ExecuterFramework.Ex1;

public class Main {

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        /* creating a array of 10 thread and but here we cannot reuse the idle threads*/
        Thread[] threads = new Thread[9];
        for(int i = 1; i < 10; i++){
            int finalI = i;
            threads[i-1] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );

            threads[i-1].start();
        }
        for(Thread th : threads){
            try{
                th.join();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
    }


}


/*3 */


//public class Main {
//
//    private static long factorial(int n) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        long result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//        }
//        return result;
//    }
//
//
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        for(int i = 0; i < 10; i++){
//            int finalI = i;
//            Thread thread = new Thread(
//                    () -> {
//                        long result = factorial(finalI);
//                        System.out.println(result);
//                    }
//            );
//
//            thread.start();
//        }
//        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
//    }
//
//
//}

/*2*/

//public class Main {
//
//    private static long factorial(int n) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        long result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        for(int i = 0; i < 10; i++){
//            System.out.println(factorial(i));
//        }
//        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
//    }
//
//    /*
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        for(int i = 0; i < 10; i++){
//            int finalI = i;
//            Thread thread = new Thread(
//                    () -> {
//                        long result = factorial(finalI);
//                        System.out.println(result);
//                    }
//            );
//
//            thread.start();
//        }
//        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
//    }
//
//     */
//
//}


/*1*/


//public class Main {
//
//    private static long factorial(int n) {
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//        long result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        for(int i = 0; i < 10; i++){
//            System.out.println(factorial(i));
//        }
//        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
//    }
//
//    /*
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        for(int i = 0; i < 10; i++){
//            int finalI = i;
//            Thread thread = new Thread(
//                    () -> {
//                        long result = factorial(finalI);
//                        System.out.println(result);
//                    }
//            );
//
//            thread.start();
//        }
//        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
//    }
//
//     */
//
//}
