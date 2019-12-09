import java.util.*;

interface Remote {
  void increase();
  void decrease();
}                            

class TV {
  private int volume;
  public int getVolume() { return volume; }
  public void setVolume(int value) { volume = value; }
  
  public Remote getRemote() {
    return new Remote() {
      public void increase() {
        volume++;
      }                            
      
      public void decrease() {
        volume--;
      }
    };
  }
}

public class Sample {  
  public static void main(String[] args) {
    TV tv = new TV();
    
    Remote remote = tv.getRemote(); 
    
    System.out.println(tv.getVolume());
    remote.increase();
    System.out.println(tv.getVolume());
    remote.decrease();
    System.out.println(tv.getVolume());
    
    Remote remote2 = tv.getRemote();
    remote2.increase();
    System.out.println(tv.getVolume());
  }
}
 
/*
What is good? 
TV, Radio, Fan, etc. do not have to conform to a common interface.
Different devices can have different implementations of the Remote
The implementations can widely different and can also deal with internals
of the appliances (thus providing, possibly, better efficiency).
You may have multiple instances of Remotes for each appliance.

What is not so good?
While the remote may have direct access to the implementation (which is bad)
it is also the author of the TV, etc. that is responsible for implementating
the Remote, so not so bad.

An appliance can't support an arbitrary third-party universal remote.
(Of course we may have a not so efficient universal remote that purely 
works off the public interface).
*/