package com.ds_and_algo.leetcode;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Leetcode187 {
    public static void main(String[] args) {
        Leetcode187 lc = new Leetcode187();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.println(lc.findRepeatedDnaSequences(input));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();
        int i=0;
        while(i+10 <= s.length()){
            String sub = s.substring(i,i+10);
            if (!seen.add(sub)){
                result.add(sub);
            }
            i++;
        }
        return new ArrayList<String>(result);
    }
}

/*
for(int j=10+i;j<=s.length();j++){
                if (j-i == 10) {
                    String sub = s.substring(i, j);
                    String remaining = s.substring(j, s.length());
                    System.out.println("sub " + sub + " rem " + remaining);
                    if (remaining.contains(sub)) {
                        result.add(sub);
                    }
                }
            }
 */
