package GameFiles;
import java.util.ArrayList;


/**
 * all logic for the side scroll game
 *
 */
public class SideScrollModel extends Model {
		
	/**
	 * a list of the buttons in our game
	 */
	private Fish fish;
	private Trash trash1;
	private Trash trash2;
	private Trash trash3;
	private Osprey osprey;
	ArrayList<GameObject> gol;
	
	
	
	public SideScrollModel(Fish fish, Trash trash1, Trash trash2, Trash trash3, Osprey osprey) {
		this.fish = fish;
		this.trash1 = trash1;
		this.trash2 = trash2;
		this.trash3 = trash3;
		this.osprey = osprey;
		gol.add(fish);
		gol.add(trash1);
		gol.add(trash2);
		gol.add(trash3);
		gol.add(osprey);
	}
	
	
	
	public void advanceWorld() {
		osprey.setX(osprey.getX() + osprey.getxSpeed());
		osprey.setY(osprey.getY() + osprey.getySpeed());
		fish.setX(fish.getX()-1);
		trash1.setX(trash1.getX() -1);
		trash2.setX(trash2.getX() -1);
		trash3.setX(trash3.getX() -1);
		if((fish.getX() + 134) <= 0) {
			fish.setX(800);
		}
		if((trash1.getX() + 134) <= 0) {
			trash1.setX(800);
		}
		if((trash2.getX() + 134) <= 0) {
			trash2.setX(800);
		}
		if((trash3.getX() + 134) <= 0) {
			trash3.setX(800);
		}
		if (osprey.getY() >= 550) {
			osprey.speed = -50;
		}
		if ((osprey.getY() == osprey.getcurrY()) && (osprey.getisDiving() == true)) {
			osprey.setySpeed(0);
			osprey.setisDiving(!osprey.getisDiving());
		}
	}
	
	
	
	/**
	 * 
	 * this method will contain the logic for moving the background image
	 * to create the illusion that the foreground images are moving
	 */
	
	/**
	 *  
	 * this method will contain the logic for advancing the icon on 
	 * the minimap to show progress during the birds migration
	 */
	public void miniMap() {
		
		
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller("osp");
		controller.start();	
	}



	public Fish getFish() {
		return fish;
	}



	public void setFish(Fish fish) {
		this.fish = fish;
	}



	public Trash getTrash1() {
		return trash1;
	}



	public void setTrash1(Trash trash1) {
		this.trash1 = trash1;
	}



	public Trash getTrash2() {
		return trash2;
	}



	public void setTrash2(Trash trash2) {
		this.trash2 = trash2;
	}



	public Trash getTrash3() {
		return trash3;
	}



	public void setTrash3(Trash trash3) {
		this.trash3 = trash3;
	}



	public Osprey getOsprey() {
		return osprey;
	}



	public void setOsprey(Osprey osprey) {
		this.osprey = osprey;
	}



	public ArrayList<GameObject> getGol() {
		return gol;
	}



	public void setGol(ArrayList<GameObject> gol) {
		this.gol = gol;
	}
	
}
