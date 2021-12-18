package com.ds_and_algo.searching;

/**
 * TO be used when input array provided
 * is sorted.
 * This algo utilises the advantage of knowing
 * that only greater values lies on indexes
 * higher than current Index and lower values on
 * lower indexes.
 * Time Complexity - O(logN)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1,2,3,5,7,8,13,1,6,19,25,29,31,33,48,50,69,71};
        int target = 71;
        BinarySearch bs = new BinarySearch();
        int indexOfTarget = bs.binarySearch(sortedArray,target,sortedArray.length);
        System.out.println("index of target "+ target + " is "+ indexOfTarget);
    }

    /**
     *
     * @param array - input
     * @param target - target
     * @param len - length of array
     * @return  - index of target element in array,
     */
    public int binarySearch(int[] array,int target,int len){
        int left = 0;
        int right =len;
        while(left<=right){
            int mid = left + (right-left)/2;
            if (array[mid] > target){
                right = mid-1;
            }else if(array[mid] < target){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
