package GameFiles;
import java.util.ArrayList;

public class Model {
	/**
	 * a list of the objects in our game
	 */
	ArrayList<GameObject> game;
	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<GameObject> getGame() {
		return game;
	}

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	} 
	
	
	public void collide(ArrayList<GameObject> arr) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).type.equals(Type.CLAPPERRAIL) || arr.get(i).type.equals(Type.OSPREY) || arr.get(i).type.equals(Type.FOX)) {
				for(int j = i+1; j < arr.size(); j++) {
					arr.get(i).collidesWith(arr.get(j));
				}
			}
		}
	}
	
	
}
