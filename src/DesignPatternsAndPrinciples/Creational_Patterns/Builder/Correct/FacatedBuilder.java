package DesignPatternsAndPrinciples.Creational_Patterns.Builder.Correct;

class Employee{
 //address
  public String streetAddress, postCode, city;

  //employment details
  public String companyName,position;
  public double annualIncome;

 @Override
 public String toString() {
  return "Employee{" +
          "streetAddress='" + streetAddress + '\'' +
          ", postCode='" + postCode + '\'' +
          ", city='" + city + '\'' +
          ", companyName='" + companyName + '\'' +
          ", position='" + position + '\'' +
          ", annualIncome=" + annualIncome +
          '}';
 }
}


 class FEmployeeBuilder {
   protected Employee employee = new Employee();

   public EmployeeAddressBuilder lives(){
      return new EmployeeAddressBuilder(employee);
   }

  public EmployeeDetailsBuilder details(){
   return new EmployeeDetailsBuilder(employee);
  }

   public Employee build(){
    return this.employee;
   }
}
class EmployeeAddressBuilder extends FEmployeeBuilder{
 public EmployeeAddressBuilder(Employee employee){
   this.employee = employee;
 }

 public EmployeeAddressBuilder livesAt(String streetAddress){
    this.employee.streetAddress = streetAddress;
    return this;
 }
 public EmployeeAddressBuilder withPostCode(String code){
  this.employee.postCode = code;
  return this;
 }
 public EmployeeAddressBuilder inCity(String city){
  this.employee.city = city;
  return this;
 }

}

class EmployeeDetailsBuilder extends FEmployeeBuilder{
 EmployeeDetailsBuilder(Employee e){
  this.employee =e;
 }

 public EmployeeDetailsBuilder worksAt(String orgName){
  this.employee.companyName = orgName;
  return this;
 }

 public EmployeeDetailsBuilder worksAs(String designation){
   this.employee.position = designation;
   return this;
 }

 public EmployeeDetailsBuilder makes(double salaryPA){
  this.employee.annualIncome = salaryPA;
  return this;
 }

}
/*
Here we learned when object is more complex and needs further split across distinct builders
make a builder, with other builders as part of it and use inheritance for always updating the same object

here we used

FEmployeeBuilder as Parent and Address and Details builders were extending it.
 */
class FacatedBuilder{
 public static void main(String[] args) {
   FEmployeeBuilder fe = new FEmployeeBuilder();

   Employee e =
   fe.lives()
           .livesAt("232/233 line no2 ")
           .withPostCode("474001")
           .inCity("Gadaipura")
           .details()
           .worksAt("Safaai Org")
           .worksAs("Safaai Karmchaari")
           .makes(12182912)
           .build();
  System.out.println(e);
 }
}