import java.io.*;
//import com.tedneward.*;

public class SerializeToDisk
{
    public static void main(String[] args)
        throws Exception
    {
        {
            Person ted = new Person("Ted", "Neward", 39);
            Person charl = new Person("Charlotte", "Neward", 38);
            ted.setSpouse(charl); charl.setSpouse(ted);
            
            FileOutputStream fos = new FileOutputStream(args[0]);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ted);
            oos.close();
        }
        
        {
            FileInputStream fis = new FileInputStream(args[0]);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person ted = (Person) ois.readObject();
            ois.close();
            
            System.out.println(ted);
            
            assert ted.getFirstName().equals("Ted");
            assert ted.getSpouse().getFirstName().equals("Charlotte");

            // Clean up the file
            new File(args[0]).delete();
        }
    }
}
