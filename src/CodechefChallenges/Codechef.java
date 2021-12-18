package CodechefChallenges;

import java.util.Scanner;

public class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        String[] obj = sc.nextLine().split(" ");
        int x = Integer.parseInt(obj[0]);
        Double y = Double.parseDouble(obj[1]);
        if (x%5 != 0 || y < (x+0.50)) {
            System.out.println(String.format("%.2f", y));
            return;
        }
        System.out.println(String.format("%.2f",(y-x-0.50)));
    }
}
