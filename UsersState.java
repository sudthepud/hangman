import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class UsersState implements Serializable {
  public HashMap<String, Integer> users;
  private static final String fileName = "UsersState.ser";
  

  public String toString () {
      return users.toString();
  }
  public boolean save () {
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
  public static UsersState restore () {
    try {
		  FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      UsersState s = (UsersState) ois.readObject();
	    ois.close();
	    fis.close();
      return s;
	  } catch(Exception e) {
	      return null;
	  }
  }
}