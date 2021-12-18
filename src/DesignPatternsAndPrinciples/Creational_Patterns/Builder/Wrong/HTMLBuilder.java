package DesignPatternsAndPrinciples.Creational_Patterns.Builder.Wrong;

 class HTMLBuilder {
     //Objective we need to design oom model for HTML printing
     public static void main(String[] args) {
         //For just one tag
         //Below is fine
         String word = "Hello world";
         System.out.println("<ul>\n" + "    <li>" + word + " </li>\n"+ "</ul>");

         //For a list we have to change to below
         String [] words = {"Hello",  "World !!"};
         System.out.println("<ul>");
         for(String s : words){
             System.out.print(String.format("   <li> %s</li>\n",s));
         }
         System.out.println("</ul>");

         // We can clearly see that in bits and pieces we won't be
         // able to manage or scale variety of HTML Tags, hence we will move
         // to the Object-Oriented Paradigm

     }
}
