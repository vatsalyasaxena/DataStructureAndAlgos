package com.ds_and_algo.sorting;

import java.util.Arrays;

/**
 * Bubble Sort is the simplest sorting algorithm
 * that works by repeatedly swapping the adjacent
 * elements if they are in wrong order.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] input = {19,8,7,6,5,4,3,2,10};
        BubbleSort ss = new BubbleSort();
        ss.bubbleSort(input,input.length);
        System.out.println(Arrays.toString(input));
    }

    public void bubbleSort(int[] input,int len){
        for(int i=0;i<len-1;i++){
            for(int j= 0;j<len-1;j++){
                if (input[j] > input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }
}
