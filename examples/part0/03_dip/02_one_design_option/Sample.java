import java.util.*;

interface Appliance {
  
}                            

//While this is a good idea to start with, it poses some challenges.
//Works well for TV and Radio to implement Appliance, but what about
//a Fan or a Garage? They don't have volume. One may have speed,
//the other may have open vs. closed.
                                 
class TV implements Appliance {
  private int volume;
  public int getVolume() { return volume; }
  public void setVolume(int value) { volume = value; }
}

class Remote {
  private TV tv;
  
  public Remote(TV theTV) { tv = theTV; }
  public void increase() { tv.setVolume(tv.getVolume() + 1); }
  public void decrease() { tv.setVolume(tv.getVolume() - 1); }
}

public class Sample {  
  public static void main(String[] args) {
    TV tv = new TV();
    
    Remote remote = new Remote(tv);
    
    System.out.println(tv.getVolume());
    remote.increase();
    System.out.println(tv.getVolume());
    remote.decrease();
    System.out.println(tv.getVolume());
  }
}
