package javaAssignment1;

//Parent class
class Parent {
 public Parent() {
     System.out.println("Parent constructor invoked");
 }
}

//Child class
class Child extends Parent {
 public Child() {
     super(); // Invoking the parent class constructor
     System.out.println("Child constructor invoked");
 }
}

//Main class
public class Constructor {
 public static void main(String[] args) {
     // Creating a child class object
     Child child = new Child();
 }
}

// key poiints related to constructor

// *constructors are the special methidss in a class thet are used to intalise objects of that class
/// * the name of the constructor is same as the class name
// *constructors do not have any return type
// *if axonstructors in not explicitly defined then java provides a default constructor
// *constructors can be overloaded
// *super() method is used ivoke the parent constructor from a child constructor
// *super() method should be the first statement
// *super() is not explicitly called...the defaault constructor of a parent class is invoked automatically
// *constructors of same class can be called using this() mehthod.
// *constructors can have acess modifiers
