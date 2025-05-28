package com.manish.Thread.concurrency.ConcurrencyModels;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Stage1 implements Runnable {
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public Stage1(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue){
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i < 10; i++){
                String item = "Data "+ i;
                System.out.println("Stage 1: Reading " + item);
                outputQueue.put(item);
            }
            outputQueue.put("EOF");
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}


class Stage2 implements Runnable {
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public Stage2(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue){
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run(){
        try{
            while (true){
                String item = inputQueue.take();
                if("EOF".equals(item)){
                    outputQueue.put("EOF");
                    break;
                }

                String processedItem = item + " Processwd ";
                System.out.println("Stage 2: Processing "+processedItem);
                outputQueue.put(processedItem);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}


class Stage3 implements Runnable {
    private final BlockingQueue<String> inputQueue;

    public Stage3(BlockingQueue<String> inputQueue){
        this.inputQueue = inputQueue;
    }

    @Override
    public void run(){
        try{
            while (true){
                String item = inputQueue.take();
                if("EOF".equals(item)){
                    break;
                }
                System.out.println("Stage 3: Writing "+item);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}



public class AssemblyLineExample {
    public static void main(String[] args) {
        BlockingQueue<String> stage1Queue = new LinkedBlockingQueue<>();
        BlockingQueue<String> stage2Queue = new LinkedBlockingQueue<>();
        BlockingQueue<String> stage3Queue = new LinkedBlockingQueue<>();

        Thread stage1 = new Thread(new Stage1(stage1Queue, stage2Queue));
        Thread stage2 = new Thread(new Stage2(stage2Queue, stage3Queue));
        Thread stage3 = new Thread(new Stage3(stage3Queue));

        stage1.start();
        stage2.start();
        stage3.start();

        try{
            stage1.join();
            stage2.join();
            stage3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
