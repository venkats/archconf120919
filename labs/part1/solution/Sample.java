import java.util.*;
import java.util.function.Function;

interface Algorithms {
  public static String fastAlgorithm(int value) {
    return "fast algorithm to compute " + value;
  }

  public static String preciseAlgorithm(int value) {
    return "precision algorithm to compute " + value;
  }
}

interface NewAlgorithm {
  public static String fastAlgorithm(int value) {
    return "new algorithm to compute " + value;
  }  
}

public class Sample {                                     
  public static String doWork(Function<Integer, String> algorithm) {
    return "doWork with " + algorithm.apply(42);
  }
  
  public static void main(String[] args) {
    //we may use either of the algorithms for computation.
                                    
    Function<Integer, String> func = input -> "you called...";
    
    if(Math.random() > 0.5) {
      System.out.println(doWork(func));
    } else {
      System.out.println(doWork(Algorithms::preciseAlgorithm));
    }
  }
}