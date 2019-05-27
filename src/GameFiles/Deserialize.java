package GameFiles;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialize
{
	/**
	 * deserializes a saved game
	 * @author mark wolgin
	 * @return Model from disk
	 * @throws Exception if error
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
