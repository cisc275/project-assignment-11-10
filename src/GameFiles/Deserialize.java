package GameFiles;

import java.io.*;
import java.util.ArrayList;

public class Deserialize
{
	/**
	 * deserializes a saved game
	 * @author mark wolgin
	 * @return Model from disk
	 * @throws Exception
	 */
    public static Model grabGame() throws Exception
    {
        FileInputStream fis = new FileInputStream("dump/gameDump.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Model model = (Model) ois.readObject();
        ois.close();
        
        return model;
    }
}
