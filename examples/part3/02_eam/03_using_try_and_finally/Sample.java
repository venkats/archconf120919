import java.util.*;
    
class Resource {
  public Resource() { System.out.println("created resource"); }
  public Resource op1() { System.out.println("op1"); return this; }
  public Resource op2() { System.out.println("op2"); return this; }
  public void close() { System.out.println("clean up external resources"); }
}

public class Sample {  
  public static void main(String[] args) {
    Resource resource = new Resource();
    try {
      resource.op1();
      resource.op2();      
    } finally {
      resource.close();
    }
  }
}


//Good news: The resource is cleaned up even if there was an exception

//Bad news:
//The programmer may forget to call try and finally
//The code is verbose