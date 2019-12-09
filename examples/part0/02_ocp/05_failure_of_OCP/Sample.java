import java.util.*;
                   
class Engine {
  public Engine() {}
  public Engine(Engine other) {} 
}

class TurboEngine extends Engine {
  public TurboEngine() { super(); }
  public TurboEngine(TurboEngine other) {
    super(other);
  }
}

class Car {
  private int year;
  private Engine engine;
  
  public Car(int theYear, Engine theEngine) {
    year = theYear;
    engine = theEngine;
  }
  
  public Car(Car other) {
    year = other.year;
    //engine = new Engine(other.engine);
    
    if(other.engine instanceof TurboEngine) {
      engine = new TurboEngine((TurboEngine)(other.engine));
    } else {
      engine = new Engine(other.engine);
    }
  }                    
  
  public String toString() {
    return year + ":"  + engine;
  }
}

public class Sample {  
  public static void main(String[] args) {
    Car car1 = new Car(2019, new TurboEngine());
    System.out.println(car1);
    
    Car car2 = new Car(car1);
    System.out.println(car2);   

    //This code now violates the Open-Closed Principle.
    //If we add yet another class that extends Engine, 
    //we have to open and modify the Car class' copy
    //constructor.
  }
}
