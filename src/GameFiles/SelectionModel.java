package GameFiles;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * Model for the selection screen
 */
public class SelectionModel extends Model {
	
	
	public SelectionModel() {
		game = new ArrayList<>();
	}
	/**
	 * starts our game
	 * @param args
	 */
	public static void main(String[] args) {
		Controller c = new Controller("sel");	
	}
	
	/**
	 * decides what to do with the user's key presses
	 * @param a HashSet<Integer> of key presses
	 * @author andrew thompson
	 */
	public void handleMove(HashSet<Integer> keyPresses) {
		for(Integer key: keyPresses) {
			switch(key) {
			case Constants.LEFT_KEY_CODE:
				SelectionView.osprey.doClick();
				break;
			case Constants.RIGHT_KEY_CODE:
				SelectionView.clapperRail.doClick();
				break;
			}
		}
	}
}
