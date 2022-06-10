import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class State implements Serializable {
  public String name;
  public int scores;
  

  public String toString () {
      return "name = " + name + "\nhighscore = " + scores;
  }
  public boolean save () {
    if (name == null)
      return false;

    String fileName = name + "State.ser";
    
    try {
      FileOutputStream fos = new FileOutputStream(fileName);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);
      oos.close();
      fos.close();
      return true;
    } catch (IOException e) {
      System.err.println(e);
      return false;
    }
  }
  public static State restore (String name) {
    String fileName = name + "State.ser";
    
    try {
		  FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      State s = (State) ois.readObject();
	    ois.close();
	    fis.close();
      return s;
	  } catch(Exception e) {
	      return null;
	  }
  }
}