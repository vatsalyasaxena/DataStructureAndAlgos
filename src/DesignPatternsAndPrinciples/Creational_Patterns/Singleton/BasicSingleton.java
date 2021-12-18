package DesignPatternsAndPrinciples.Creational_Patterns.Singleton;

 class BasicSingleton {
    private int value=0;
    public int getValue(){
        return value;
    }

    public void setValue(int val){
        this.value = val;
     }
     private BasicSingleton(){
    }
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    public static BasicSingleton getInstance(){
        return INSTANCE;
    }
}
class Demo{
    public static void main(String[] args) {
        //Problem 1 . This purpose of single instance can be defeated by using reflection
        //problem 2 . And also by using Serialization.- however
        // serialization can be stopped by implementing readResolve in singleton class
        BasicSingleton bs = BasicSingleton.getInstance();
        bs.setValue(321);
        System.out.println(bs.getValue());
    }
}