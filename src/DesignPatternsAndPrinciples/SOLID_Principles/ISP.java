package DesignPatternsAndPrinciples.SOLID_Principles;

 class ISP {
}
class Document{

}
//Bad implementation
//Below interface is violating Interface segregation
//by defining more than 1 responsibility
interface Machine{
     public void print(Document d);
     public void scan(Document d);
     public void fax(Document d);
}
class OldPrinter implements Machine{

    @Override
    public void print(Document d) {
        //Valid
    }

    @Override
    public void scan(Document d) {
        // What to write here ?
    }

    @Override
    public void fax(Document d) {
        //wht to write here ?
    }
}
//Since we wanted to implement only printer
//Due to bad design of Machine interface we have to
//provide dummy or empty implementation of scan and fax too.

//Now correcting the above flaw.
interface Printer{
     public void print(Document d);
}

interface Scanner{
     public void scan(Document d);
}

interface FaxMachine{
     public void fax(Document d);
}

class OldSchoolPrinter implements Printer{

    @Override
    public void print(Document d) {
        //Some valid implementation.
    }
}
interface MultifunctionDevice extends Printer,Scanner{

}
class PhotoCopyMachine implements MultifunctionDevice{

     private Scanner scanner;
     private Printer printer;

     PhotoCopyMachine(Scanner sc, Printer printer){
         this.scanner = sc;
         this.printer =printer;
     }

    @Override
    public void print(Document d) {
        //Call this for printing
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        //Call this for scanning
        scanner.scan(d);
    }
}