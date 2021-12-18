package com.ds_and_algo.searching;

import java.util.Arrays;

/**
 * S0...
 * WE have seen Time Complexity - O(N) in linear search
 * & O(logN) in binary search.
 * We can extend the idea of  binary search for sorted arrays,
 * of selecting a range by making jumps of M indexes.
 * If target is still greater than value at current index we can
 * continue the pursuit. On exceeding the target,
 * we can start linear search from previous index.
 * Complexity in best case - O(√N)
 * For best case Jump size M = √N
 */
public class JumpSearch {
    public static void main(String[] args) {
        int [] array = {1,2,3,5,7,8,13,1,6,19,25,29,31,33,48,50,69,71};
        JumpSearch js = new JumpSearch();
        int M = (int)Math.sqrt(array.length);
        int target = 5;
        int indexOfTarget = js.jumpSearch(array,array.length,target,array.length);
        System.out.println("Jump size is "+ M + " and index of target "+ target + " is "+ indexOfTarget);
    }

    public int jumpSearch(int[] array , int len, int target,int jumpLength){
        int left = 0;
        int right = len;
        while(left+jumpLength <= right){
             if (left + jumpLength > target){
                 return JumpSearch.linearSearch(array,left,left+jumpLength,target);
             }else if (left + jumpLength < target){
                 left = left + jumpLength;
             }else{
                 return (left+jumpLength);
             }
        }
        return JumpSearch.linearSearch(array,left-jumpLength,left,target);
    }

    public static int linearSearch(int[] arr,int startIndex, int endIndex, int target){
        int end = endIndex < arr.length ? endIndex : arr.length;
        for(int i=startIndex;i<end;i++){
            if (target == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
