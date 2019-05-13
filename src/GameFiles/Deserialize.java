import java.io.*;
//import com.tedneward.*;

public class Deserialize
{
    public static void main(String[] args)
        throws Exception
    {
        FileInputStream fis = new FileInputStream(args[0]);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person ted = (Person) ois.readObject();
	Person charl = (Person) ois.readObject();
        ois.close();
        
        System.out.println(ted);
	System.out.println(charl);
    }
}
