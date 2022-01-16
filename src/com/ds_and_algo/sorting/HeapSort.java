package com.ds_and_algo.sorting;

import java.util.Arrays;

/**
 * A Binary Heap is a Complete Binary Tree where items are
 * stored in a special order such that the value in a parent
 * node is greater(or smaller) than the values in its two children nodes.
 * The former is called max heap and the latter is called min-heap.
 * The heap can be represented by a binary tree or array.
 * Time Complexity: Time complexity of heapify is O(Logn).
 * Time complexity of createAndBuildHeap() is O(n) and the
 * overall time complexity of Heap Sort is O(nLogn).
 */
public class HeapSort {
    public static void main(String[] args) {
        int [] input = {78,5,1,5,32,6,3,45,6,87,9,3};
        HeapSort hs = new HeapSort();
        hs.heapSort(input);
        System.out.println(Arrays.toString(input));
    }
    //Creating max heap considering boundary at n
    public void heapify(int[] input, int n, int index){
        int largest = index;
        int l = 2*index +1;
        int r = 2*index +2;
        if (n > l && input[l] > input[largest]){
            largest = l;
        }
        if(n > r && input[r] > input[largest]){
            largest = r;
        }
        //largest element among root,left child, right child is swapped with the
        //root element .
        if (index != largest){
            int temp = input[index];
            input[index] = input[largest];
            input[largest] = temp;
            heapify(input,n,largest);
        }

    }

    public void heapSort(int[] input){
        //Building MaxHeap by running function
        //heapify on all non-leaf nodes

        int n = input.length;
        for(int i = n/2 -1;i>=0;i--){
            heapify(input,n,i);
        }
        //After above operation max element would have come to top
        //of heap now just move it to back ,for sorting array in ascending order
        //and repeat the heapify process considering the largest element
        //is now at correct position.
        for(int i=n-1;i>0;i--){
            int item = input[0];
            input[0] = input[i];
            input[i] = item;
            heapify(input,i,0);
        }
    }
}
