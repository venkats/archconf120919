import java.util.*;

class Mailer {
  public Mailer from(String addr) { System.out.println("from"); return this; }
  public Mailer to(String addr) { System.out.println("to"); return this; }
  public Mailer subject(String line) { System.out.println("subject"); return this; }
  public Mailer body(String msg) { System.out.println("body"); return this; }
  public void send() { System.out.println("sending..."); }
}    

public class Sample {  
  public static void main(String[] args) {
    Mailer mailer = new Mailer();
    mailer.from("builder@agiledeveloper.com")
      .to("venkats@agiledeveloper.com")
      .subject("Your code sucks")
      .body("...details...")
      .send();
  }
}
