package DesignPatternsAndPrinciples.Creational_Patterns.Builder.Correct;

import java.util.ArrayList;
import java.util.Collections;

class HTMLElement{
  public String name,text;
  public ArrayList<HTMLElement> elements = new ArrayList();
  private final int indentation=2;
  private final String newLine = System.lineSeparator();

  public HTMLElement(){

  }
 public HTMLElement(String name, String text){
   this.name = name;
   this.text = text;
 }

 private String toStringImpl(int indent){
  StringBuilder sb = new StringBuilder();
  String i = String.join("", Collections.nCopies(indent * indent, " "));
  sb.append(String.format("%s<%s>%s", i, name, newLine));
  if (text != null && !text.isEmpty())
  {
   sb.append(String.join("", Collections.nCopies(indent*(indent+1), " ")))
           .append(text)
           .append(newLine);
  }

  for (HTMLElement e : elements)
   sb.append(e.toStringImpl(indent + 1));

  sb.append(String.format("%s</%s>%s", i, name, newLine));
  return sb.toString();
 }
 @Override
 public String toString(){
  return toStringImpl(0);
 }

}

class HtmlBuilder{
 public String rootName;
 public HTMLElement root = new HTMLElement();

 public HtmlBuilder(String name){
  this.rootName = name;
  this.root.name = name;
 }
//Adding HtmlBulder in return type instead
 //of void and then returning this, makes this simple builder
 //a FLUENT builder. This makes writing long chains possible and readable.
 public HtmlBuilder addChild(String childName, String childText){
  HTMLElement h = new HTMLElement(childName,childText);
  this.root.elements.add(h);
  return this;
 }

 public void clear(){
  this.root = new HTMLElement();
 }

 @Override
 public String toString(){
  return root.toString();
 }

}


 class Demo {
  public static void main(String[] args) {
   HtmlBuilder builder = new HtmlBuilder("ul");
   builder.addChild("li","Hello");
   builder.addChild("li","world!!!");
   System.out.println(builder);
  }

}
