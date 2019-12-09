import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    
    Iterator<Integer> iterator = numbers.iterator();
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }                                   
    
    //We see that iterator() is like getRemote().
    //Just like Remote interface, Integer<T> is an interface.
    //You can obtain muliple iterators on the same collection, like
    //you can get muliple Remotes on the same appliance.
    
    Iterator<Integer> iterator2 = numbers.iterator();
    while(iterator2.hasNext()) {
      System.out.println(iterator2.next());
    }                                   
    
    //What is the type of the Remote in reality?
    /*
      public Remote getRemote() {
        return new Remote() {
         ...
        }
      }     
      
     Our remote was an inner class of TV, Radio, etc.
    */ 
    
    //The iterators in Java (and C#) follow the same idea of using inner 
    //classes in Java and nested classes in C#.

    System.out.println(numbers.iterator());
    //Different collections return different implementations of the
    //Iterator, which are represented as inner classes in those
    //collections.
  }
}