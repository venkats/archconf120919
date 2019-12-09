import java.util.*;

public class Sample {  
  public static int totalValues(List<Integer> numbers) {
    int result = 0;
    
    for(int e : numbers) {
      result += e;
    }
    
    return result;
  }

  public static int totalEvenValues(List<Integer> numbers) {
    int result = 0;
    
    for(int e : numbers) {
      if(e % 2 == 0) result += e;
    }
    
    return result;
  }

  public static int totalOddValues(List<Integer> numbers) {
    int result = 0;
    
    for(int e : numbers) {
      if(e % 2 != 0) result += e;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    System.out.println(totalValues(numbers));
    System.out.println(totalEvenValues(numbers));
    System.out.println(totalOddValues(numbers));
  }
}

//violates DRY even further.