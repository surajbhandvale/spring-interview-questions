package com.example.core;

class Singleton extends SomeClass {
    public static Singleton instance = new Singleton();
    private Singleton() {}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}