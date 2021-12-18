public class FizzBuzz {
    public static void main(String[] args) {
        int input = 46;
        for(int i=1;i<=input;i++){
            String result = ""+i;
            if (i %3 == 0 && i%5 ==0)
                result = "FizzBuzz";
            else if (i%3 ==0 )
                result = "Fizz";
            else if (i%5 == 0)
                result = "Buzz";
            System.out.println(result);
        }
    }

}
