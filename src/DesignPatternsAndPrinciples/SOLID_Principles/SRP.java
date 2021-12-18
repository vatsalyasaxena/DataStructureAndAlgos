package DesignPatternsAndPrinciples.SOLID_Principles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class SRP {
//Below classes show that Journal should have only functionalities related to journal,
//    wrong design would have Persistence method save and load inside Journal class
    //here we defined journal class and persistence class separately .
}
class Journal{
    List<String> entries = new ArrayList<>();

    public void addEntry(String entry){
        entries.add(entry);
    }
    public void removeEntry(int index){
        entries.remove(index);
    }

   @Override
    public String toString(){
        return entries.toString();
   }
}
class Persistence{
    Journal journal ;
    Persistence(Journal j){
        journal = j;
    }
    public void saveToFile(String fileName) throws FileNotFoundException {
        try(PrintStream out = new PrintStream(fileName)){
            out.println(journal.toString());
        }
    }
}
class Demo{
    public static void main(String[] args) throws FileNotFoundException{
        Journal journal  = new Journal();
        journal.addEntry("I am feeling sleepy.");
        journal.addEntry("I am a retard.");

        Persistence p = new Persistence(journal);
        p.saveToFile("someRandomFileName");
    }
}