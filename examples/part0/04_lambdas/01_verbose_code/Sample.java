import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      public void run() {
        System.out.println("In another thread");
      }
    });                                      
    
    thread.start();
    System.out.println("In main");
  }
}