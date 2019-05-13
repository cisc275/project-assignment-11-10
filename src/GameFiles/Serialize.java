package GameFiles;

import java.io.*;
import java.util.ArrayList;
//import com.tedneward.*;

public class Serialize
{
    public static void dumpGame(ArrayList<GameObject> game) throws Exception
    {
        FileOutputStream fos = new FileOutputStream("/dump/gameDump.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(game);
        oos.close();
    }
}
