import java.awt.Color;

class Camera {
  public Color snap(Color input) {
    return input;
  }
}

public class Sample { 
  public static void printIt(Camera camera) {
    System.out.println(camera.snap(new Color(125, 125, 125)));
  }
   
  public static void main(String[] args) {
    printIt(new Camera());
  }
}