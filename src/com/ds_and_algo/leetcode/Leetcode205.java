package com.ds_and_algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length())
            return false;
        Map<Character,Character> map = new HashMap<>();
        int i= 0;
        for(;i<s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (a == b){
                if (map.values().contains(b)){
                    return false;
                }else {
                    map.put(a,b);
                }
            }else{
                if (map.containsKey(a)){
                    if (map.get(a) != b){
                        return false;
                    }
                }else{
                    if (map.values().contains(b)){
                        return false;
                    }else {
                        map.put(a,b);
                    }
                }
            }
            System.out.println(map);
        }
        return true;
    }
}
