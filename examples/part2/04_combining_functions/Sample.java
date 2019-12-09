import java.util.*;
import java.util.function.Function;

public class Sample {  
  public static void printInfo(int number, String msg, 
    Function<Integer, Integer> func) {
    
    System.out.println(
      number + " " + msg + ":" + func.apply(number));
  }
  
  public static void main(String[] args) {
    Function<Integer, Integer> inc = e -> e + 1;
    printInfo(5, "incremented", inc);

    Function<Integer, Integer> doubled = e -> e * 2;
    printInfo(5, "doubled", doubled);
    
    printInfo(5, "incremeted and doubled", inc.andThen(doubled));
  }
}