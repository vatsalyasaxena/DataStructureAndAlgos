package com.ds_and_algo.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int [] input = {1,-1};
        MergeSort ms = new MergeSort();
        ms.sort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
    }

    public void sort(int[] input,int left , int right){
        if (left< right){
            int mid = left  + (right - left)/2;
            sort(input,left,mid);
            sort(input,mid+1,right);
            merge(input,left,mid , right);
        }

    }

    public void merge(int[] input, int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = input[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = input[m+i+1];
        }
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
        while(n1 > i){
            input[k] = L[i];
            i++;
            k++;
        }
        while(n2 > j){
            input[k] = R[j];
            j++;
            k++;
        }

    }
}
