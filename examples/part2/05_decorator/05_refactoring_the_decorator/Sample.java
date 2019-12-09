import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

//We are decorating using the Function's andThen to combine the
//functions to form the decorator pattern.

@SuppressWarnings("unchecked")
class Camera {
  private Function<Color, Color> filter;
  
  public Camera(Function<Color, Color>... filters) {
    //filter = input -> input;
    //
    //for(Function<Color, Color> aFilter : filters) {
    //  filter = filter.andThen(aFilter);
    //}
    
    //filter = Stream.of(filters)
    //  .reduce(input -> input,
    //    (filter, aFilter) -> filter.andThen(aFilter));

    //filter = Stream.of(filters)
    //  .reduce(input -> input, Function::andThen);

    filter = Stream.of(filters)
      .reduce(Function.identity(), Function::andThen);
  }
  
  public Color snap(Color input) {
    return filter.apply(input);
  }
}

@SuppressWarnings("unchecked")
public class Sample { 
  public static void printIt(Camera camera) {
    System.out.println(camera.snap(new Color(125, 125, 125)));
  }
   
  public static void main(String[] args) {
    printIt(new Camera());
    printIt(new Camera(Color::brighter));
    printIt(new Camera(Color::darker));
    
    printIt(new Camera(Color::brighter, Color::darker));
    printIt(new Camera(Color::brighter, Color::brighter));
  }
}