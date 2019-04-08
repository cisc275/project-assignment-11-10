package GameFiles;
/**
 * represents the Fox object in the clapperrail game 
 *
 */
public class Fox extends Controllable {
	
	/**
	 * @param None
	 * @return true if the bird is visible false otherwise
	 * 
	 * this method will scan within a predetermined range to see if the bird's location is within 
	 * the foxes view if so true will be returned. false otherwise 
	 */
	public boolean birdVisible() {
		
		return false;
	}
}
