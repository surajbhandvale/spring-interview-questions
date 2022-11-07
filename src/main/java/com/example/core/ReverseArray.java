package com.example.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReverseArray {

    public static void main(String [] args){
      int arr [] = {3,4,7,1,2,8,3,5,2};
      reserse(arr);
      System.out.println();
      Map<Integer, Long> resultMap = countByStreamGroupBy(List.of(1,1,3,4,7,1,2,8,3,5,2));
      System.out.println(resultMap);
    }

    public static void reserse(int [] arr){
        int length = arr.length;
        int middle = length / 2;
        int j = length-1;
        int temp;
        for(int i=0; i<length; i++){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }

        for(int no: arr){
            System.out.print(no);
            System.out.print(",");
        }
    }

    public static <T> Map<T, Long> countByStreamGroupBy(List<T> inputList) {
        return inputList.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    }

}
