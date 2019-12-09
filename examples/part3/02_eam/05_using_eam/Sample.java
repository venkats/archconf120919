import java.util.*;
import java.util.function.Consumer;
    
class Resource {
  private Resource() { System.out.println("created resource"); }
  public Resource op1() { System.out.println("op1"); return this; }
  public Resource op2() { System.out.println("op2"); return this; }
  private void close() { System.out.println("clean up external resources"); }
  
  public static void use(Consumer<Resource> block) {
    Resource resource = new Resource();
    
    block.accept(resource);
    
    resource.close();
  }
}

public class Sample {  
  public static void main(String[] args) {
    Resource.use(resource -> 
      resource.op1()
        .op2());
  }
}

//Let's use Execute Around Method Pattern (EAM)
//This is also called as Loan Pattern in some language.

//The code is concise
//The programmer has nothing to forget, the code works only if written
//this way. The programmer can't call close and can't create an object
//of Resource directly. The programmer is forced to use the use method.