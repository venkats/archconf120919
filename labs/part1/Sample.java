import java.util.*;

interface Algorithm {
  String compute(int value);
}    

class FastAlgorithm implements Algorithm {
  public String compute(int value) {
    return "fast algorithm to compute " + value;
  }
}

class PrecisionAlgorithm implements Algorithm {
  public String compute(int value) {
    return "precision algorithm to compute " + value;
  }
}

public class Sample {                                     
  public static String doWork(Algorithm algorithm) {
    return "doWork with " + algorithm.compute(42);
  }
  
  public static void main(String[] args) {
    //we may use either of the algorithms for computation.
    
    if(Math.random() > 0.5) {
      System.out.println(doWork(new FastAlgorithm()));
    } else {
      System.out.println(doWork(new PrecisionAlgorithm()));
    }
  }
}