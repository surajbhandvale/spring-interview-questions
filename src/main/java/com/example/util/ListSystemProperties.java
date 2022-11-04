package com.example.util;
import java.util.Properties;
 
public class ListSystemProperties {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println("Display or print all System properties :\n");
        properties.forEach(
                        (key,value)
                              ->
                        System.out.println(key + "=" +value)
                );
    }
}