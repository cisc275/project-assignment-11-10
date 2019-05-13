package GameFiles;

import java.io.*;
import java.util.ArrayList;

public class Deserialize
{
    public static void grabGame() throws Exception
    {
        FileInputStream fis = new FileInputStream("dump/gameDump.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<GameObject> game = (ArrayList<GameObject>) ois.readObject();
        ois.close();
        
        System.out.println(game);
    }
}
