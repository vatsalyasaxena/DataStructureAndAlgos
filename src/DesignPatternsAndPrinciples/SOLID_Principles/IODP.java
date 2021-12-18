package DesignPatternsAndPrinciples.SOLID_Principles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Inversion of Dependency or
//Dependency inversion principle
 class IODP {
  /*
  So Part A is the idea that high level modules should not depend on low level modules that both should depend on abstractions.
  And the second idea is that abstractions should not depend on the details, but details should depend on abstraction.
  */
}
enum Relation{
  PARENT,
 SIBLINGS,
 CHILD
}
class Triplet<Person>{
  Person p1;
  Relation relation;
  Person p2;
  public Person getP1(){
      return p1;
  }
    public Person getP2(){
        return p2;
    }
  Triplet(Person p1, Relation r, Person p2){
   this.p1 = p1;
   this.p2 = p2;
   relation = r;
  }
}
//In our example Relationships is a low-level module
//Because it is just a data storage
class Relationships implements RelationshipBrowser {
 private List<Triplet<Person>> relations = new ArrayList<>();
 public List<Triplet<Person>> getRelations(){
  return this.relations;
 }
 void addParentAndChild(Person p, Person q){
   relations.add(new Triplet(p,Relation.PARENT,q));
  relations.add(new Triplet<>(q,Relation.CHILD,p));
 }

 @Override
 public List<Person> findAllChildrenOf(String name) {
  return relations.stream().filter(e -> e.p1.getName().equals(name) && e.relation.equals(Relation.PARENT)).
          map(Triplet::getP2).collect(Collectors.toList());
 }
}
class Person{
  private String name;
  public String getName(){
   return this.name;
  }
  Person(String name){
   this.name = name;
  }
}

//In our example Research is
//a high level module - as it is close to user,
// user don't care about storage ,only cares about research
//We are violating RuleA of DIP
//By making high level module
//get the object of low level module
class Research{

  Research(Relationships r){
    List<Triplet<Person>> relations = r.getRelations();
    relations.stream().filter( x -> x.p1.getName().equals("Jack"))
            .forEach(e -> System.out.println(" Jack is "+ e.relation.name() + " of "+ e.p2.getName()));
    //With above construct if somthing changes in storage , say from list to array
   //Above code willa lso change
   //hence we would make use of abstraction, both high and low level modules will depend on abstraction.

  }
}
class Demo4{
 public static void main(String[] args) {
   Person a = new Person("Jack");
  Person b = new Person("Jill");
  Person c = new Person("Hill");


  Relationships relationships = new Relationships();
  relationships.addParentAndChild(a,b);
  relationships.addParentAndChild(a,c);
  new Research(relationships);
     System.out.println("---------- After implementing browser --------");
  // After implementing browser
     List<Person> list = relationships.findAllChildrenOf("Jack");
     for(Person person : list){
         System.out.println("Jack is Parent of "+ person.getName());
     }
 }

}
interface RelationshipBrowser{
 List<Person> findAllChildrenOf(String name);
}