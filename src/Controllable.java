/**
 * represents all objects that can be controlled by the user
 *
 */
public class Controllable extends GameObject {
	/**
	 * speed of object being controlled 
	 */
	int speed; 
	/**
	 * 
	 * this method will be defined in subclasses, and will contain the 
	 * logic needed for the objects movement on screen.
	 * the speed will be used to increment the x and y coordinates as needed
	 */
	public void move() {
		
	}
}
