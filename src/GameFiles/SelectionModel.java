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
	
	public SelectionModel() {
		
	}
	
	public void whatGame(String game) {
		if (game.equals(game1)) {	
			scroll = true;
			td = false;
		}
		if (game.equals(game2)) {
			td = true;
			scroll = false;
		}
	}
}
