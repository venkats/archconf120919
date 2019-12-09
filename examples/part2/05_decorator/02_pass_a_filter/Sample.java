import java.awt.Color;
import java.util.function.Function;

class Camera {
  private Function<Color, Color> filter = input -> input;
  
  public Camera() {}
  public Camera(Function<Color, Color> aFilter) {
    filter = aFilter;
  }
  
  public Color snap(Color input) {
    return filter.apply(input);
  }
}

public class Sample { 
  public static void printIt(Camera camera) {
    System.out.println(camera.snap(new Color(125, 125, 125)));
  }
   
  public static void main(String[] args) {
    printIt(new Camera());
    
    printIt(new Camera(color -> color.brighter()));
    printIt(new Camera(Color::brighter));
  }
}