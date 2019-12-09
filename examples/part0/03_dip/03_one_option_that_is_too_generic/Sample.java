import java.util.*;

interface Appliance {
  void increase();
  void decrease();
}                            

class TV implements Appliance {
  private int volume;
  public int getVolume() { return volume; }
  public void setVolume(int value) { volume = value; }
  
  public void increase() {
    setVolume(getVolume() + 1);
  }
  
  public void decrease() {
    setVolume(getVolume() - 1);
  }
}

class Remote {
  private Appliance appliance;
  
  public Remote(Appliance theAppliance) { appliance = theAppliance; }
  public void increase() { appliance.increase(); }
  public void decrease() { appliance.decrease(); }
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
What is good?
It is a generic way to control appliances.
Remote is no longer tighly coupled to a TV. It may use any Appliance,
like a Radio, Fan, Garage, etc.

What is not that good?
Too generic a way to control appliances, not very specific.
                                                      
Remote is like a view on the Appliance, in a way.
What if we want to have different state for each view?
What if we want to control the implementations using some internal optimization. Right now they can be done in increase and decrease,
but they are too generic to be useful in the long run. We want to
keep the benefit but without the generic implementation.

*/