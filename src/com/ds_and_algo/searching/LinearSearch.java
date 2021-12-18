package com.ds_and_algo.searching;


import java.util.Arrays;

/**
 *     //Searching an element in an array
 *     //If array of N length is to be searched ,
 *     //time complexity of linear search will be
 *     //Time complexity - O(N)
 */
public class LinearSearch {


    public static void main(String[] args) {
        int [] arr = {2,3,1,4,5,6,7,8,12,23,34,45,56,56,765,342,564,897,231,234,534,645,576};
        LinearSearch ls = new LinearSearch();
        int target = 0;
        int indexOfTarget = ls.linearSearch(arr, arr.length, target);
        System.out.println("Index of Target "+ target + " is "+ indexOfTarget);
    }

    /**
     *
     * @param arr - input array tio be searched
     * @param N - length of input array
     * @param target - target element to be searched
     * @return - index of arr where element is present, -1 if element is not found
     */
    public int linearSearch(int[] arr,int N, int target){
        for(int i=0;i<N;i++){
            if (target == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
