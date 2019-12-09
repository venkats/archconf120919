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

  public static boolean isOdd(int number) {
    return number % 2 != 0;
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    System.out.println(totalValues(numbers, e -> true));
    System.out.println(totalValues(numbers, e -> e % 2 == 0));
    System.out.println(totalValues(numbers, Sample::isOdd));
  }
}

//violates DRY even further.