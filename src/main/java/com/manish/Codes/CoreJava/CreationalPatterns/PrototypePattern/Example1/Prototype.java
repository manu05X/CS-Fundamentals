package com.manish.Codes.CoreJava.CreationalPatterns.PrototypePattern.Example1;

// Prototype interface
interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}
