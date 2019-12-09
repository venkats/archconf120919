import java.util.*;
                   
class Engine {
  public Engine() {}
  protected Engine(Engine other) {} 
  
  public Engine clone() {
    return new Engine(this);
  }
}

class TurboEngine extends Engine {
  public TurboEngine() { super(); }
  protected TurboEngine(TurboEngine other) {
    super(other);
  }        
  
  public Engine clone() {
    return new TurboEngine(this);
  }
} 

class PistonEngine extends Engine {
  public PistonEngine() {}
  protected PistonEngine(PistonEngine other) {
    super(other);
  }              
  
  public Engine clone() {
    return new PistonEngine(this);
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
    
    //if(other.engine instanceof TurboEngine) {
    //  engine = new TurboEngine((TurboEngine)(other.engine));
    //} else {
    //  engine = new Engine(other.engine);
    //}
    
    engine = other.engine.clone();
  }                    
  
  public String toString() {
    return year + ":"  + engine;
  }
}

public class Sample {  
  public static void main(String[] args) {
    Car car1 = new Car(2019, new PistonEngine());
    System.out.println(car1);
    
    Car car2 = new Car(car1);
    System.out.println(car2);   

    //We can use the prototype pattern to solve this problem.
    //Prototype pattern say we can use a prototype or a sample
    //object to create a new object. In other words, make a copy
    //from a prototype or sample.
    
    //This is where the clone method comes in.
    
    //But the clone as implemented in Java is broken, that is,
    //it can't handle final fields that need unique values for
    //different objects.
    
    //We can create our own clone, but that can tactfully use 
    //a copy constructor, a double dispatching mechanism, to
    //solve this problem.
    
    //clone is polymorphic. Constructors in Java are not polymorphic.
    //we will use clone to dynamically dispatch a different implementation
    //and from within that different implementation we will use a different
    //constructor. Thus, we make constructor polymorphic so to say.
  }
}
