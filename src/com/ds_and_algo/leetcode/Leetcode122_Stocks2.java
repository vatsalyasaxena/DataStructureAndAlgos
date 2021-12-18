package com.ds_and_algo.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Leetcode122_Stocks2 {

    public int getMaxProfit(int [] prices){
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if (prices[i] - prices[i-1] > 0){
                max = max + prices[i]-prices[i-1];
            }
        }
        return max;
    }

    public List<List<Integer>> getMaxProfitNumberOfDays(int [] prices){
        int max = 0;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<prices.length;i++){
            if (prices[i] - prices[i-1] > 0){
                List<Integer> list = new ArrayList();
                max = max + prices[i]-prices[i-1];
                list.add(i-1);list.add(i);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode122_Stocks2 obj = new Leetcode122_Stocks2();
        int [] prices = {7,1,5,3,6,4};
        System.out.println(obj.getMaxProfit(prices));
        System.out.println(obj.getMaxProfitNumberOfDays(prices));
    }
}
