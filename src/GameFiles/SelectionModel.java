package GameFiles;
/**
 * 
 * Model for the selection screen
 */
public class SelectionModel extends Model {
	String game1 = "scroll";
	String game2 = "td";
	boolean scroll = false;
	boolean td = false;
	
	
	
	public static void main(String[] args) {
		Controller c = new Controller("sel");	
	}
}
