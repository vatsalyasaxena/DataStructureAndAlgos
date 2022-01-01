package com.ds_and_algo.sorting;

import java.util.Arrays;

/**
 * The selection sort algorithm sorts an array by repeatedly
 * finding the minimum element (considering ascending order)
 * from unsorted part and putting it at the beginning.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int [] input = {9,8,7,6,5,4,3,2,1};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(input);
        System.out.println(Arrays.toString(input));
    }

    public void selectionSort(int[] input){
        for(int i=0;i<input.length;i++){
            for(int j=i+1;j< input.length;j++){
                if(input[i] > input[j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
    }
}
