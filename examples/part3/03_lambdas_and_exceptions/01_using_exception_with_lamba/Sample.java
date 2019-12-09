import java.util.*;

/*
Exceptions are an imperative style of programming idea.
Functional programming does not deal with exceptions.

In Functional programming we do a series of transformations.
It is a flow. It makes zero sense to blow up the stack and reverse
the flow.

In FP, we deal with errors downstream.

FP and exceptions are mutually exclusive.

Having said that:
1. If you are using lambdas in a functional style flow, as in a Stream
like API, then do not use exceptions.

2. If you are using lambdas in a traditional function call scenarios,
then it is OK to use exception.

In this case, since the Java builtin Functional interfaces do not support
exceptions (they do not use throws), we will have to build out own
Functional interfaces whose methods have a throw.
*/

import java.io.IOException;
        
interface ConsumerWithException<T, E extends Exception> {
  void accept(T input) throws E;
}
        
class Resource {
  private Resource() {}
  public Resource op1() throws IOException { System.out.println("op1"); return this; }
  public Resource op2() throws IOException { System.out.println("op1"); return this; }
  private void close() throws IOException {
    System.out.println("clean up external resource");
  }
  
  public static void use(ConsumerWithException<Resource, IOException> block) throws IOException {
    Resource resource = new Resource();
          
    try {
      block.accept(resource);      
    } finally {
      resource.close();
    }
  }
}

public class Sample {  
  public static void main(String[] args) {
    try {
      Resource.use(resource ->
        resource.op1()
          .op2());
    } catch(Exception ex) {
      System.out.println(ex);
    }
  }
}