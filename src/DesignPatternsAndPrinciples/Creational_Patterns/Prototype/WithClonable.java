package DesignPatternsAndPrinciples.Creational_Patterns.Prototype;

import java.util.Arrays;

class Address implements Cloneable{
     public String streetName;
     public int houseNumber;

     Address(String streetName, int hno){
         this.streetName = streetName;
         this.houseNumber = hno;
     }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
    //Deep copy
    @Override
    public Object clone() throws CloneNotSupportedException{
         return new Address(this.streetName,this.houseNumber);
    }
}

class Person implements Cloneable{
     public String[] names;
     public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
    //Deep copy
    @Override
    public Object clone() throws CloneNotSupportedException{
        return new Person(names.clone(),(Address) address.clone());
    }
}
class WithCloneable {
    public static void main(String[] args) throws Exception{
        Person john = new Person(new String []{"John","Schmidt"},new Address("London road", 123));
        //Now try to clone above
        //And set new Name
        Person changed = john;
        changed.names[0] = "JANE";
        System.out.println(john);
        System.out.println(changed);
        //Above code does not work as expected since we altered the john object through its reference.
        //Now we will use cloneable interfaces of class and use clone() method to
        //actually clone the object.
        //After implementing deep copy cloning can be done like below
        Person pc1 = new Person(new String[]{"Clonable "," sirname"},new Address("Birla nagar",124));

        Person cloned = (Person)pc1.clone();
        System.out.println(pc1);
        System.out.println(cloned);
        //If we alter 1 obj other will not be impacted
        pc1.names[0] = "James";
        System.out.println(pc1);
        System.out.println(cloned);
    }
}
