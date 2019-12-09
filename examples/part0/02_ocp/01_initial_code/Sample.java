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
  }
}