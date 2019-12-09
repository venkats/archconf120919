import java.util.*;
import java.util.function.Consumer;

class Mailer {
  private Mailer() {}
  public Mailer from(String addr) { System.out.println("from"); return this; }
  public Mailer to(String addr) { System.out.println("to"); return this; }
  public Mailer subject(String line) { System.out.println("subject"); return this; }
  public Mailer body(String msg) { System.out.println("body"); return this; }
  public static void send(Consumer<Mailer> block) {
    Mailer mailer = new Mailer();
    
    block.accept(mailer);
    
    System.out.println("sending...");
  }
}    

public class Sample {  
  public static void main(String[] args) {
    Mailer.send(mailer -> 
      mailer.from("builder@agiledeveloper.com")
        .to("venkats@agiledeveloper.com")
        .subject("Your code sucks")
        .body("...details..."));      
  }
}

/*
The code is less verbose
We may reuse the mailer or not, but that is a decision, rightfully so,
of the author of the class rather than the user of the class.
*/