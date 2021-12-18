package com.ds_and_algo.searching;

/**
 * Linear Search finds the element in O(n) time,
 * Jump Search takes O(√ n) time and Binary Search take O(Log n) time.
 * The Interpolation Search is an improvement over Binary Search for instances,
 * where the values in a sorted array are uniformly distributed.
 * Binary Search always goes to the middle element to check.
 * On the other hand, interpolation search may go to different locations
 * according to the value of the key being searched.
 * For example, if the value of the key is closer to the last element,
 * interpolation search is likely to start search toward the end side.
 *
 * Let's assume that the elements of the array are linearly distributed.
 *
 * General equation of line : y = m*x + c.
 * y is the value in the array and x is its index.
 *
 * Now putting value of lo,hi and x in the equation
 * arr[hi] = m*hi+c ----(1)
 * arr[lo] = m*lo+c ----(2)
 * x = m*pos + c     ----(3)
 *
 * m = (arr[hi] - arr[lo] )/ (hi - lo)
 *
 * subtracting eqxn (2) from (3)
 * x - arr[lo] = m * (pos - lo)
 * lo + (x - arr[lo])/m = pos
 * pos = lo + (x - arr[lo]) *(hi - lo)/(arr[hi] - arr[lo])
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int [] array = {1,2,3,5,7,8,13,1,6,19,25,29,31,33,48,50,69,71};
        int target = -1;
        InterpolationSearch is = new InterpolationSearch();
        int indexOfTarget = is.interpolationSearch(array,target,array.length);
        System.out.println("Index of target "+ target + " is "+ indexOfTarget);
    }

    /**
     *
     * @param array - input arr
     * @param target - target
     * @param len - length of arr
     * @return
     */
    public int interpolationSearch(int [] array , int target , int len){
        int left = 0;
        int right = len-1;
        while(left <= right &&  (target >= array[left] && target <= array[right])){
            int pos = left + ((target-array[left])*(right-left) / (array[right]-array[left]));
            if (array[pos] < target){
                left= pos +1;
            }else if (array[pos] > target){
                right = pos-1;
            }else{
                return pos;
            }
        }
        return -1;
    }
}
