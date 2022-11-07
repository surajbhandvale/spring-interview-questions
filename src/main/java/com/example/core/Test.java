package com.example.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class A{

    public void additon(int x, long y){

    }

    public void additon(long x, int y){

    }
}

class B{
    B(){
        System.out.println("I am from B");
    }
}

class C extends B{
    {
        System.out.println("From instance inilizer block");
    }
    C(){
        super();
        System.out.println("I am from C");
    }

    static {
        System.out.println("From static block");
    }
}

interface First{
    int x = 10;
    int y = 20;
}

interface Second{
    int x = 11;
    int y = 21;
}

interface Base extends First, Second{
    int x = 13;
    int y = 23;
}

public class Test {

    public static void main(String [] args){
        A a = new A();
        a.additon(20, 20L);

        C c = new C();

        System.out.println(First.x);
        System.out.println(First.y);

        System.out.println(Base.x);
        System.out.println(Base.y);

        List<String> fruits = List.of("apple", "apple", "banana","apple", "papaya", "orange", "banana", "papaya");

        Map<String, Long> mapData = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       Map<String, Long> mapData1 = fruits.stream().map(e -> e).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println(mapData);
        System.out.println();
        System.out.println(mapData1);

        List<Integer> numbers = List.of(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765);

        int [] arr = new int[]{3,5,6,7,8,2,1,10,9};


    }
}
