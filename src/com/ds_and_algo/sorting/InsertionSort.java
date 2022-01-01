package com.ds_and_algo.sorting;

import java.util.Arrays;

/**
 * Here
 * we sort back.
 * If i=x
 * values before index x will be sorted with inner while loop
 * and after break,the lowest value will come to minimum index.
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] input = {9,0};
        InsertionSort is = new InsertionSort();
        is.insertionSort(input,input.length);
        System.out.println(Arrays.toString(input));
    }

    public void insertionSort(int [] input, int len){
        for(int i=1;i<len;i++){
            int key = input[i];
            int j = i-1;
            while(j >= 0 && input[j] > key){
                input[j +1] = input[j];
                j=j-1;
            }
            input[j+1] = key;
        }
    }

}
