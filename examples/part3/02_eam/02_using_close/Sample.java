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
    resource.op1();
    resource.op2();
    resource.close();
  }
}


//Good news: The resource is cleaned up.

//Bad news:
//The programmer may forget to call close
//There may be an exception that is thrown and so the close may not get called.