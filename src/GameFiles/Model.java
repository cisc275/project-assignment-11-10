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
			if(arr.get(i).getType().equals(Type.CLAPPERRAIL) || arr.get(i).getType().equals(Type.OSPREY) || arr.get(i).getType().equals(Type.FOX)) {
				for(int j = i+1; j < arr.size(); j++) {
					System.out.println("Collision found between " + i + " and " + j);
					arr.get(i).collidesWith(arr.get(j));
				}
			}
		}
	}
	
	
}
