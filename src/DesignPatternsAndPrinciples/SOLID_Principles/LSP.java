package DesignPatternsAndPrinciples.SOLID_Principles;

 class LSP {
     //There is no separate need of creating a square class in example below
     //we could achieve same with a fucn inside Rectangle class
     //Here we are using 1 rect. object to get correct area of both squares and rectangles
     // Square sq = new Square(); if replaced by
     // Rectangle rc = new Square() (Sq child of Rect)
     //things should work properly.
}

class Rectangle{
     int width;
     int height;
     Rectangle(int w , int h){
         width = w;
         height = h;
     }
     public int area(){
         return height*width;
     }
     public boolean isSquare(){
         return height == width;
     }
}
class RectangleFactory{
     public static Rectangle newRectangle(int width,int height){
         return new Rectangle(width,height);
     }
     public static Rectangle newSquare(int side){
         return new Rectangle(side,side);
     }
}

class Demo2{
    public static void main(String[] args) {
        Rectangle rc = RectangleFactory.newRectangle(10,8);
        System.out.println("Area of rectangle is "+ rc.area());
        rc = RectangleFactory.newSquare(23);
        System.out.println("Area of rectangle is "+ rc.area());
    }
}
