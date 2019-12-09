import java.util.*;
import java.util.function.*;

public class Sample {  
  public static int totalValues(List<Integer> numbers,
    Predicate<Integer> selector) {
    int result = 0;
    
    for(int e : numbers) {
      if(selector.test(e)) result += e;
    }
    
    return result;
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    System.out.println(totalValues(numbers, e -> true));
    //we took the normal function totalValues and changed it into
    //a higher-order function.
  }
}

//violates DRY even further.