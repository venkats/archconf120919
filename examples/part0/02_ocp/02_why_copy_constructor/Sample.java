import java.util.*;
                   
class Engine {
  
}

class Car {
  private int year;
  private Engine engine;
  
  public Car(int theYear, Engine theEngine) {
    year = theYear;
    engine = theEngine;
  }                    
  
  public String toString() {
    return year + ":"  + engine;
  }
}

public class Sample {  
  public static void main(String[] args) {
    Car car1 = new Car(2019, new Engine());
    System.out.println(car1);
    
    Car car2 = new Car(car1);
    System.out.println(car2);
  }
}
//This code does not compile, but why not use a clone
//instead of creting and using a copy constructor?

/*
Take a look at the book "Effective Java"

"Use copy constructor instead of using clone"

Why?

If a class has a final field (read only) and if that field
is supposed to be unique, then...

A final field can be set in
1. At the point of declaration
2. Within an instance initializer
3. Within a constructor

But, you can't change or set a final field anywhere else, including
the clone method.

*/