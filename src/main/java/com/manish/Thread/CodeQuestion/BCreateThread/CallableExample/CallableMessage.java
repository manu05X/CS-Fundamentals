package com.manish.Thread.CodeQuestion.BCreateThread.CallableExample;

import java.util.concurrent.Callable;

public class CallableMessage implements Callable<String> {

    public String call() throws Exception {
        return "This is Future return from CallableMessage Class";
    }
}
