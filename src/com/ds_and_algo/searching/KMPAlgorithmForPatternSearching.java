package com.ds_and_algo.searching;

import java.util.Arrays;

public class KMPAlgorithmForPatternSearching {
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMPAlgorithmForPatternSearching().KMPSearch(pat, txt);
    }

    public void KMPSearch(String pattern, String text){
        int M = pattern.length();
        int N = text.length();
        //Longest proper suffix array
        int[] lps = new int[M];
        int j=0;//index for pattern
        computeLPSArray(pattern,M,lps);
        System.out.println("lps = "+ Arrays.toString(lps));
        int i=0;//Index for text
        while(i<N){
            if (pattern.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }
            if (j == M){
                System.out.println("Pattern match found at "+ (i-j));
                j= lps[j-1];
            }else if (i < N && pattern.charAt(j) != text.charAt(i)){
                if (j!=0){
                    j = lps[j-1];
                }else{
                    i = i+1;
                }
            }
        }
    }

    public void computeLPSArray(String pattern, int M, int[] lps){
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while(i<M){
            if (pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if (len !=0){
                    len = lps[len-1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
