package com.ds_and_algo.leetcode;
/*
 Given a string s consisting of some words separated by some number of spaces,
 return the length of the last word in the string.
 A word is a maximal substring consisting of non-space characters only.
 */
public class Leetcode56 {

    public static void main(String[] args) {
        Leetcode56 lc = new Leetcode56();
        System.out.println(lc.lengthOfLastWord(" "));
    }
    public int lengthOfLastWord(String s) {
        int firstNonSpace=s.length();
        for(int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)==' '){
                continue;
            }else{
                if(firstNonSpace == s.length()) {
                    firstNonSpace = i;
                    break;
                }
            }
        }
        int size=0;
        //System.out.println("First non spae character "+ firstNonSpace);
        for(int j = firstNonSpace;j>=0;j--){
            System.out.println("s.charAt j "+ s.charAt(j));
            if (s.charAt(j)!=' ')
                size++;
            else{
                break;
            }
        }
        return size;
    }
}
