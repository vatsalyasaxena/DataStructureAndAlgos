package com.ds_and_algo.leetcode;

import java.util.Arrays;

public class Leetcode165 {
    public static void main(String[] args) {
        Leetcode165 lc = new Leetcode165();
        String inp1 = "1.0.1.0.0.1";
        String inp2 = "1.0.1";
        System.out.println(lc.compareVersion(inp1,inp2));
    }
    public int compareVersion(String version1, String version2) {
        System.out.println("1 = "+ version1 +" 2="+ version2);
        String [] s1 = version1.split("\\.");
        String [] s2 = version2.split("\\.");

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
        int l = s1.length > s2.length ? s2.length : s1.length;
        int i;
        for(i=0;i<l;i++){
            if(Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])){
                return -1;
            }else if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])){
                return 1;
            }
        }
        System.out.println("l="+l );
        if (l == s1.length && l == s2.length){
            return 0;
        }else if (l== s1.length){
            return trailingZeroes(s2,i,-1);
        }else {
            return trailingZeroes(s1, i,1);
        }
    }

    public int trailingZeroes(String[] s , int index, int result){
        System.out.println(Arrays.toString(s));
        while(index < s.length && Integer.parseInt(s[index])==0){
            index++;
        }
        //System.out.println("Index is "+ index);
        if (index == s.length ){
            return 0;
        }else{
            return result;
        }
    }

}
