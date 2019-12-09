import java.util.*;

class Heavy {
  public Heavy() {
    System.out.println("Heavy created...");
  }                                     
  
  public int getValue() {
    return 1;
  }
}

class Holder {
  private Heavy heavy = new Heavy();
  
  public Holder() {
    System.out.println("Holder created...");
  }
  
  public int getValue() {
    return heavy.getValue();
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
//Whether we used the value or not, we incurred the overhead
//of creating the Heavy object.

//What if Heavy was an expensive resource that either comsumed
//a lot of resource or increased a cost of use?