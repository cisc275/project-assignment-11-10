package GameFiles;

import java.io.*;
import java.util.ArrayList;

public class Deserialize
{
    public static void grabGame() throws Exception
    {
        FileInputStream fis = new FileInputStream("dump/gameDump.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Model model = (Model) ois.readObject();
        ois.close();
        
        System.out.println(model);
    }
}
