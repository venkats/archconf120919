import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    //Thread thread = new Thread(new Runnable() {
    //  public void run() {
    //    System.out.println("In another thread");
    //  }
    //});                                      

    Thread thread = new Thread(() -> System.out.println("In another thread"));                                      

    //Whereas we may pass an anonymous inner class with only one method,
    //we can now pass a lambda expression - anonymous function.
    
    thread.start();
    System.out.println("In main");
  }
}