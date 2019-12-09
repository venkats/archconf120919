import java.util.*;
import java.util.function.Supplier;

class Lazy<T> {
  private T instance;      
  private Supplier<T> supplier;
  
  public Lazy(Supplier<T> theSupplier) {
    supplier = theSupplier;
  }
  
  public T get() {
    if(instance == null) {
      instance = supplier.get();
      supplier = null;
    }                 
    
    return instance;
  }
}

class Heavy {
  public Heavy() {
    System.out.println("Heavy created...");
  }                                     
  
  public int getValue() {
    return 1;
  }
}

class Holder {
  private Lazy<Heavy> heavy = new Lazy<>(() -> new Heavy());
  //Lazy acts as a virtual proxy for the Heavy. It postpones
  //creating Heavy until it can no longer be postponed.
  
  public Holder() {
    System.out.println("Holder created...");
  }
  
  public int getValue() {
    return heavy.get().getValue();
  }
}

public class Sample {  
  public static void main(String[] args) {
    Holder holder = new Holder();
    
    if(Math.random() > 0.5) {
      System.out.println("get value");
      System.out.println(holder.getValue());
    } else {
      System.out.println("don't get the value");
    }
  }
}
