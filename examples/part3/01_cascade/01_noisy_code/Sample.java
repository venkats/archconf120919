import java.util.*;

class Mailer {
  public void from(String addr) { System.out.println("from"); }
  public void to(String addr) { System.out.println("to"); }
  public void subject(String line) { System.out.println("subject"); }
  public void body(String msg) { System.out.println("body"); }
  public void send() { System.out.println("sending..."); }
}    

public class Sample {  
  public static void main(String[] args) {
    Mailer mailer = new Mailer();
    mailer.from("builder@agiledeveloper.com");
    mailer.to("venkats@agiledeveloper.com");
    mailer.subject("Your code sucks");
    mailer.body("...details...");
    mailer.send();
  }
}

/*
Mailer may be used to send out emails, but

the code is noisy, with repated use of mailer
Not clear if we should reuse mailer at the end or not
*/