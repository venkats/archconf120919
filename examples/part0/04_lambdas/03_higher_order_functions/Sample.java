import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    //Normal function:
    //we can pass a object to a function
    //we can create a object in a function
    //we may return a object from a function
    
    //Higher-order function:
    //we can pass a function to a function
    //we can create a function in a function
    //we may return a function from a function
    
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
                                                    
    System.out.println(
      numbers.stream() //internal iterator
        .filter(e -> e % 2 == 0) //filter is a higher-order function
        .mapToInt(e -> e * 2) //map is a higher-order function
        .sum());        
        
   //we are passing a lambda (an anonymous function) to filter,
   //and thus filter is a higher-order function
  }
}