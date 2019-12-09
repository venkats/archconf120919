import java.util.*;
import java.util.function.Predicate;

public class Sample {  
  public static void printInfo(int number, String msg, 
    Predicate<Integer> predicate) {
    
    System.out.println(
      number + " " + msg + ":" + predicate.test(number));
  }
  
  public static void main(String[] args) {
    Predicate<Integer> isEven = n -> n % 2 == 0;
    
    printInfo(5, "is even", isEven);
    printInfo(6, "is even", isEven);
    
    Predicate<Integer> isGT3 = n -> n > 3;
    printInfo(5, "is > 5", isGT3);
    printInfo(6, "is > 5", isGT3);
    
    
    
    printInfo(5, "is even and > 3", isEven.and(isGT3));
    printInfo(6, "is even and > 3", isEven.and(isGT3));

    printInfo(5, "is even or > 3", isEven.or(isGT3));
    printInfo(6, "is even or > 3", isEven.or(isGT3));
  }
}