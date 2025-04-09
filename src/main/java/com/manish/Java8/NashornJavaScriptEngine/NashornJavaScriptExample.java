package com.manish.Java8.NashornJavaScriptEngine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornJavaScriptExample {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // Example 1: Simple script evaluation
        try {
            engine.eval("print('Hello from Nashorn!');");
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        // Example 2: Calling a JavaScript function
        String script = "function greet(name) { return 'Hello, ' + name; }";
        try {
            engine.eval(script);
            Invocable invocable = (Invocable) engine;
            Object result = invocable.invokeFunction("greet", "world");
            System.out.println(result);
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        // Example 3: Working with JavaScript objects
        try {
            String jsObjectScript = "var obj = { " +
                    "name: 'John', " +
                    "age: 30, " +
                    "greet: function() { return 'Hello, ' + this.name; } " +
                    "};";
            engine.eval(jsObjectScript);
            Object jsObject = engine.get("obj");
            Invocable invocable = (Invocable) engine;
            Object greeting = invocable.invokeMethod(jsObject, "greet");
            System.out.println(greeting);
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}