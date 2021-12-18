package com.ds_and_algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode121_Stocks1 {

    public static void main(String[] args) {
        Leetcode121_Stocks1 obj = new Leetcode121_Stocks1();
        int [] prices = {3,2,6,5,0,3};
        System.out.println(" Max profit is = "+ obj.getMaximumProfitOnSingleBuySell(prices));
        System.out.println(" Index of max profit days = "+ obj.getDaysOfMaxProfit(prices));
    }

    public int getMaximumProfitOnSingleBuySell(int [] prices){
        int minima = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            if (prices[i] < minima){
                minima = prices[i];
            }
            if (max < prices[i] -minima){
                max = prices[i] -minima;
            }
        }
        return max;
    }

    public List<Integer> getDaysOfMaxProfit(int [] prices){
        List<Integer> list = new ArrayList<Integer>();
        int minima = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            if (prices[i] < minima){
                minima = prices[i];
                if (list.size()>0){
                    list.remove(0);
                    list.add(0,i);
                }else{
                    list.add(0,i);
                }
            }
            if (max < prices[i] -minima){
                max = prices[i] -minima;
                if(list.size() >1) {
                    list.remove(1);
                    list.add(1, i);
                }else{
                    list.add(1, i);
                }
            }
            System.out.println(list);
        }
        return list;
    }
}
