package FailFastVsFailSafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafe {

    public void failFast(Map<String,String> map){

    }

    public static void main(String[] args) {
        //FailSafe

        CopyOnWriteArrayList<String> safeList= new CopyOnWriteArrayList<>();
        safeList.add("Something 1");
        safeList.add("Something 3");
        safeList.add("Something 2");
        Iterator<String> itr1 =  safeList.iterator();
        while(itr1.hasNext()){
            if(itr1.next().equals("Something 1")){
                safeList.add("Something 4");
            }
        }
        System.out.println(safeList);
        System.out.println("Successfully passed fail safe thingy");
        //For maps use ConcurrentHashMap
        //FailFast

            List<String> integers = new ArrayList<>();
            integers.add("1");
            integers.add("2");
            integers.add("3");
            Iterator<String> itr = integers.iterator();
            while(itr.hasNext()){
                if (itr.next().equals("1")) {
                    // will throw Exception on
                    // next call of next() method
                    integers.add("4");
                }
            }
        System.out.println("You wont reach till here");
    }
}
