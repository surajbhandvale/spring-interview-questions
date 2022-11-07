package com.example.core;

class Aa{
   public void m1(){
       System.out.println("A--m1");
   }

    public void m2(){
        System.out.println("A--m2");
    }
}



public class InheritanceTest extends Aa{

    public void m2(){
        System.out.println("B--m2");
    }
    public void m3(){
        System.out.println("B--m3");
    }
    public static void main(String [] args){
        Aa a1=new InheritanceTest(); //parent - child
        a1.m2();


       // InheritanceTest b1=new Aa(); //child - parent
       // b1.m2();

        InheritanceTest b2=new InheritanceTest(); // child - child
        b2.m2();
    }
}
