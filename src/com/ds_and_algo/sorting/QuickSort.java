package com.ds_and_algo.sorting;

import java.util.Arrays;

/**
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm.
 * It picks an element as pivot and partitions the given array
 * around the picked pivot. There are different versions of
 * quickSort that pick pivot in different ways.
 *
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 * Pick median as pivot.
 * The key process in quickSort is partition().
 * Target of partitions is, given an array and an element x of array as pivot,
 * put x at its correct position in sorted array and put all smaller elements (smaller than x) before x,
 * and put all greater elements (greater than x) after x. All this should be done in linear time.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] input  = {1,2,3,4,5,6,78,789,567,354,123,531463,574658,796,796};
        QuickSort qs = new QuickSort();
        qs.quickSort(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
    }

    /**
     *
     * @param input - input array
     * @param low - lowest possible index
     * @param high - max index
     *             Gets pivot, i.e. Correct index of considered pivot element
     */
    public void quickSort(int[] input, int low, int high){
        if (low < high){
            int pivot = partition(input,low, high);
            System.out.println("Pivot of Array "+ Arrays.toString(input) + " is "+ pivot);
            quickSort(input,low,pivot-1);
            quickSort(input,pivot+1,high);
        }
    }

    /**
     *
     * @param input
     * @param low
     * @param high
     * @return index of correct position of value at pivot, considered input[high] here.
     * i is actually index of high value on left side of pivot
     * which is swapped with small value on left side of pivot
     */
    public int partition(int[] input, int low , int high){
        int pivot = input[high];
        int i = low-1;
        for(int j = low; j<high;j++){
            if (input[j] < pivot){
                i++;
                swap(input,i,j);
            }
        }
        swap(input,i+1,high);
        return (i+1);
    }

    public void swap(int[] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

}
