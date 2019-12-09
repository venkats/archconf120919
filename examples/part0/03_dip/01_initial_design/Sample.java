import java.util.*;

//Suppose we have a TV class.
//Suppose we want a Remote to control the volume of the TV.
//Let's take a initial design and discuss the pros and cons of it.
//Then we will evolve the design.
                                 
class TV {
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

/*
//What is good about this design?
Simple and straightforward.
Easy to understand.

//What is not so good about this design?
Remote is tightly coupled to TV - can use Remote only with TV
What if we want the Remote to control say a Radio?
or a fan?
or a garage?

You may have multiple remotes attached to the same TV.

Can't easily change volume from the TV, you have to use a Remote.

*/