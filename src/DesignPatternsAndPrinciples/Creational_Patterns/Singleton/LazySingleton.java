package DesignPatternsAndPrinciples.Creational_Patterns.Singleton;

 class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){
        System.out.println("Initializing lazy singleton");

    }
    public LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
    //Avoid race condition by using synchronized in getInstance()
}

class InnerStaticSingleton{
     private InnerStaticSingleton(){};
     public InnerStaticSingleton getInstance(){
         return Impl.INSTANCE;
     }
     private static class Impl{
         private static InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
     }
}
