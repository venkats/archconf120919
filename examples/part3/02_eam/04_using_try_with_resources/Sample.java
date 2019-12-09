import java.util.*;
    
class Resource implements AutoCloseable {
  public Resource() { System.out.println("created resource"); }
  public Resource op1() { System.out.println("op1"); return this; }
  public Resource op2() { System.out.println("op2"); return this; }
  public void close() { System.out.println("clean up external resources"); }
}

public class Sample {  
  public static void main(String[] args) {
    try(Resource resource = new Resource()) {
      resource.op1();
      resource.op2();      
    }
  }
}

//Good news, code is less verbose

//Bad news: The programmer may forget to use try