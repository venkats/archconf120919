import java.util.*;
    
class Resource {
  public Resource() { System.out.println("created resource"); }
  public Resource op1() { System.out.println("op1"); return this; }
  public Resource op2() { System.out.println("op2"); return this; }
  public void finalize() { System.out.println("clean up external resources"); }
}

public class Sample {  
  public static void main(String[] args) {
    Resource resource = new Resource();
    resource.op1();
    resource.op2();
  }
}

//The finalize method may not be called if there was a lot of memory.
//Thus, an external resource may not be cleaned up, if we rely on finalize,
//at the approriate time.