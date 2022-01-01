package com.ds_and_algo.sorting;

import java.util.Arrays;

/**Merge sort uses divide and conquer theory to
 * MergeSort(arr[], l,  r)
 * If r > l
 *      1. Find the middle point to divide the array into two halves:
 *              middle m = l+ (r-l)/2
 *      2. Call mergeSort for first half:
 *              Call mergeSort(arr, l, m)
 *      3. Call mergeSort for second half:
 *              Call mergeSort(arr, m+1, r)
 *      4. Merge the two halves sorted in step 2 and 3:
 *              Call merge(arr, l, m, r)
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] input = {1,-1};
        MergeSort ms = new MergeSort();
        //Initiating func with begin and end indexes of array.
        ms.sort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
    }

    /**
     *
     * @param input - arr
     * @param left - begin index
     * @param right - end index
     *  This is a recursive function
     *  calls merge function to
     *  merge with different begin and end indexes.
     */
    public void sort(int[] input,int left , int right){
        if (left< right){
            int mid = left  + (right - left)/2;
            sort(input,left,mid);
            sort(input,mid+1,right);
            merge(input,left,mid , right);
        }
    }

    /**
     *
     * @param input - input array
     * @param l - left index of sub array
     * @param m - mid-index of sub array
     * @param r - right index of sub array
     */
    public void merge(int[] input, int l,int m,int r){
        //Getting lengths of left and right sub arrays
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        //populate left&right array with input array
        for(int i=0;i<n1;i++){
            L[i] = input[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = input[m+i+1];
        }

        //Sorting happens here
        //populate input array with left and right
        //sub arrays,
        int i=0,j=0;
        int k=l;
        while(n1 > i && n2 > j){
            if (L[i] < R[j]){
                input[k] = L[i];
                i++;
            }else{
                input[k] = R[j];
                j++;
            }
            k++;
        }
        //fill input with remaining of L[]
        while(n1 > i){
            input[k] = L[i];
            i++;
            k++;
        }
        //fill input with remaining pf R[]
        while(n2 > j){
            input[k] = R[j];
            j++;
            k++;
        }
        //Done.
    }
}
