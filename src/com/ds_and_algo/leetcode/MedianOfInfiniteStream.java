package com.ds_and_algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class MedianOfInfiniteStream {
    //Hold max of minHeap
    //3 in case of 1,2,3 ___ 4,5
    static PriorityQueue<Integer> large = new PriorityQueue();
    //Hold min of Max heap
    //4 in case of 1,2,3 ____4,5
    static PriorityQueue<Integer> small = new PriorityQueue(Collections.reverseOrder());

    public static void addNum(int num) {
        int size = large.size() + small.size();
        //If size is even
        //new number will be added to large
        //and top of large is sent to small
        // e.g when 1,2,3____4,5,6 gets num=7,
        // it becomes 1,2,3 ___ 4,5,6,7
        //then becomes
        //1,2,3,4 ____ 5,6,7
        if (size % 2 == 0) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            //add to small whe size is odd
            //then pop top of small and add to large
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public static double findMedian() {
        int size = large.size() + small.size();
        if(size % 2 == 0){
            //if even
            return (large.peek() + small.peek())/2.0;
        }
        //if odd
        return small.peek();
    }

    public static void main(String[] args) {
        ArrayList<Integer> pair = new ArrayList<>();
        Stream<Integer> stream = Stream.of(2,3,4);
        stream.forEach(a -> {
        addNum(a);
            System.out.println(findMedian());
        });
    }
}
