package DesignPatternsAndPrinciples.Creational_Patterns.Factory;

enum CoordinateSystem{
    CARTESIAN,
    POLAR
}

 class Point {
     private double x;
     private double y;
     //Below constructor is for cartesian coordinates system
     Point(double x,double y){
         this.x =x;
         this.y =y;
     }
     //Now for representing polar coordinates we cannot have
     //same constructor signature
     //below is illegal
     /*
      * Point(double rho,double theta){
      *          this.x = rho* Math.cos(theta);
      *          this.y = rho* Math.sin(theta);
      *      }
      */
     //Thus we have to add some identifier Enum for identifying coordinate systems
     Point(int a,int b, CoordinateSystem cs){
         switch (cs){
             case CARTESIAN :
                 this.x =a;this.y=b;
             case POLAR:
                 this.x = a*Math.cos(b);this.y=a*Math.sin(b);
         }
     }
     //Above constructor will compile, but it looks ugly and
     //just not the oops way of doing things, we will now see how
     //Factory pattern helps in achieving this in oo fashion
 }

 class PointFactory{
    public static Point newCartesianPoint(double x , double y){
        return new Point(x,y);
    }

    public static Point newPolarPoint(double rho, double theta){
        return new Point(rho*Math.cos(theta),rho*Math.sin(theta));
    }

    //By marking methods static we are facilitating object creation without
     //separately initiating factory class
     //At this stage our only concern is not letting external world
     //use the 'public' constructor, thus we will
     //make it private, now since it cannot be accessed by external world
     //only place to put whole Factory class is within point class -refer below
 }

 class MyPoint{
    private double x;
    private double y;

    private MyPoint(double x,double y){
        this.x= x;
        this.y= y;
    }

   static class Factory{
        public static MyPoint newCartesianPoint(double x , double y){
            return new MyPoint(x,y);
        }

        public static MyPoint newPolarPoint(double rho, double theta){
            return new MyPoint(rho*Math.cos(theta),rho*Math.sin(theta));
        }
    }
 }
 class Demo{
     public static void main(String[] args) {
         Point point = PointFactory.newCartesianPoint(1,2);

         MyPoint myPoint = MyPoint.Factory.newPolarPoint(2,30);
     }
 }
