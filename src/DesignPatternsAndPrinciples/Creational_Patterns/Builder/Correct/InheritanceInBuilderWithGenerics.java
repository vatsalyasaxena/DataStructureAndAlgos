package DesignPatternsAndPrinciples.Creational_Patterns.Builder.Correct;

class InheritanceInBuilderWithGenerics {
    //If you want a fluent interface to propagate across
    //inheritance - you need to have recursive geenrics
}
class Person{
    public String name;
    public String designation;

    @Override
    public String toString(){
        return "Person {" +
                "name = "+ this.name+
                "," + "designation = " + this.designation;
    }
}
class PersonBuilder<SELF extends PersonBuilder<SELF>>{
    protected Person person = new Person();
    public SELF withName(String name){
        person.name = name;
        return self();
    }

    public Person build(){
        return person;
    }
    protected SELF self(){
        return (SELF)this;
    }
}
class Demo1{
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        //Person dmitri  = pb.withName("Dimitri").build();
        //Good till now with only person builder, lets try extending it to EmployeeBuilder
        Person dimitri = pb.withName("Dimitri").worksAs("SDE1").build();
        System.out.println(dimitri);
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
    public EmployeeBuilder worksAs(String designation){
        person.designation = designation;
        return this;
    }

    @Override
    protected EmployeeBuilder self(){
        return super.self();
    }
}
/*
With above construct only , i.e. without Generic Recurrence we cannot create Person with a designation
as it return EmployeeBuilder

 */