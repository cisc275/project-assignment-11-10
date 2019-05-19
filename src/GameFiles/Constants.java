package GameFiles;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * This contains all of our constants for the project, in on easy to edit spot.
 * @author wolginm
 *
 */
public class Constants implements Serializable {

	/// Booleans
	public static boolean BOOL_HARVEY = false;
	
	
	/// ints
	public final static int g = 10;
	
	public final static int BIRD_MOVE_AMOUNT = 10;
	
	public final static int RIGHT = 39;
	public final static int LEFT = 37;
	public final static int UP = 38;
	public final static int DOWN = 40;
	public final static int SPACE = 32;
	public final static int ESCAPE = 27;
	
	public final static int AIRCURRENT_ANIMATION_TICK_RATE = 3;
	
	public final static int CLAPPER_RAIL_START_LOC_X = 400;
	public final static int CLAPPER_RAIL_START_LOC_Y = 200;
	public final static int CLAPPER_RAIL_START_SIZE_X = 100;
	public final static int CLAPPER_RAIL_START_SIZE_Y = 100;
	public final static int CLAPPER_RAIL_ANIMATION_TICK_RATE = 1;
	
	public final static int CLAPPER_RAIL_INIT_LIVES = 3;
	
	public final static int FISH_AC = 5;
	public final static int FISH_X_SPEED_TEST = -50;
	public final static int FISH_ANIMATION_TICK_RATE = 2;
	
	public final static int FOX_INIT_XSPEED = 2;
	public final static int FOX_INIT_YSPEED = 2;
	public final static int FOX_START_LOC_X = 400;
	public final static int FOX_START_LOC_Y = 400;
	public final static int FOX_START_SIZE_X = 100;
	public final static int FOX_START_SIZE_Y = 100;
	
	public final static int LINUX_SCREEN_SIZE = 100;
	public final static int LINUX_SCREEN_SCALE_X = 16;
	public final static int LINUX_SCREEN_SCALE_Y = 9;
	
	public final static int INVISIBLE_WALL_POINTS = 5;
	
	public final static int MATE_ANIMATION_TICK_RATE = 4;
	
	public final static int OSPREY_STARTX = 100;
	public final static int OSPREY_DIVESPEED = 50;
	public final static int OSPREY_MAX_HEIGHT = 600;
	public final static int OSPREY_WATER_LEVEL = 400;
	public final static int OSPREY_MIN_SPEED = -5;
	public final static int OSPREY_MAX_SPEED = -50;
	public final static int OSPREY_MAX_DISTANCE = 3000;
	public final static int OSPREY_ANIMATION_TICK_RATE = 4;
	
	public final static int POWERUP_HEIGH = 100;
	public final static int POWERUP_SIZE = 50;
	
	public final static int STICK_HANDLECOLLISION_OFFSET = 30;
	public final static int STICK_SIZE = 40;
	
    public final static int TDM_BOUND_OFFSET = 134;
    public final static int TDM_CLOCK_TICK_CHECK = 100;
	public final static int TDM_LEFT_BOUND = 0;
    public final static int TDM_RIGHT_BOUND = 800;
	public final static int TDM_UPDATELOCATION_STICK_COUNT = 3;
	
	public final static int TO_ANIMATION_TICK_RATE = 2;
	
	
	public final static int TIMER_TICK_RATE = 50;
	
	public final static int TRASH_AC = 5;
	
	public static int FRAME_X;
	public static int FRAME_Y;
	
	
	/// Doubles
	public static double POWERUP_HEIGH_SCALE = 2.0;
	public static double POWERUP_SCALE = 1.0;
	
	public static double STICK_SCALE = 1.0;
	
	

	/// Strings
	public final static String IMG_AIRCURRENT = "img/aircurrent.png";
	public final static String IMG_AIRCURRENT_1 = "img/aircurrent/aircurrent_1.png";
	public final static String IMG_AIRCURRENT_2 = "img/aircurrent/aircurrent_2.png";
	public final static String IMG_AIRCURRENT_3 = "img/aircurrent/aircurrent_3.png";
	public final static String IMG_AIRCURRENT_4 = "img/aircurrent/aircurrent_4.png";
	public final static String IMG_AIRCURRENT_5 = "img/aircurrent/aircurrent_5.png";
	public final static String IMG_AIRCURRENT_6 = "img/aircurrent/aircurrent_6.png";
	public final static String IMG_BACKGROUND = "img/background.png";
	public final static String IMG_CLAPPER_RAIL_BACKGROUND = "img/cBackground.png";
	public final static String IMG_BUSH = "img/bush.png";
	public final static String IMG_DOWN_KEY = "img/down.png";
	public final static String IMG_FISH_1 = "img/fish/fish_west1.png";
	public final static String IMG_FISH_2 = "img/fish/fish_west2.png";
	public final static String IMG_FISH_3 = "img/fish/fish_west3.png";
	public final static String IMG_FOX = "img/ee.png";
	public final static String IMG_LEFT_KEY = "img/left.png";
	public final static String IMG_MATE = "img/cr.png";
	public final static String IMG_MODEL_DUMP_STATUS_MSG = "img/modelDumpStatusMsg.png";
	public final static String IMG_NEST = "img/nest.png";
	public final static String IMG_OSPREY_1 = "img/osprey/osprey1.png";
	public final static String IMG_OSPREY_2 = "img/osprey/osprey2.png";
	public final static String IMG_OSPREY_3 = "img/osprey/osprey3.png";
	public final static String IMG_OSPREY_DIVE = "img/osprey_dive.png";
	public final static String IMG_POLY_HARVEY = "img/PolyHarvey.png";
	public final static String IMG_RIGHT_KEY = "img/right.png";
	public final static String IMG_SELECT_CLAPPER_RAIL = "img/selectCR.png";
	public final static String IMG_SELECT_OSPREY = "img/selectOsprey.png";
	public final static String IMG_SPACEBAR = "img/spacebar/spacebar.png";
	public final static String IMG_SPACEBAR_1 = "img/spacebar/spacebar_1.png";
	public final static String IMG_SPACEBAR_2 = "img/spacebar/spacebar_2.png";
	public final static String IMG_SPACEBAR_3 = "img/spacebar/spacebar_3.png";
	public final static String IMG_SPACEBAR_4 = "img/spacebar/spacebar_4.png";
	public final static String IMG_SPACEBAR_5 = "img/spacebar/spacebar_5.png";
	public final static String IMG_SPACEBAR_6 = "img/spacebar/spacebar_6.png";
	public final static String IMG_STICK = "img/Stick.png";
	public final static String IMG_THARVEY_1 = "img/cr/Tharvey1.png";
	public final static String IMG_THARVEY_2 = "img/cr/Tharvey2.png";
	public final static String IMG_TRASH = "img/Trash.png";
	public final static String IMG_UP_KEY = "img/up/up.png";
	public final static String IMG_UP_KEY_1 = "img/up/up_1.png";
	public final static String IMG_UP_KEY_2 = "img/up/up_2.png";
	public final static String IMG_UP_KEY_3 = "img/up/up_3.png";
	public final static String IMG_UP_KEY_4 = "img/up/up_4.png";
	public final static String IMG_UP_KEY_5 = "img/up/up_5.png";
	public final static String IMG_UP_KEY_6 = "img/up/up_6.png";
	
	// Arrays of String file paths
	
	public final static String[] ANIMATION_AIRCURRENT = {IMG_AIRCURRENT_1, IMG_AIRCURRENT_2, IMG_AIRCURRENT_3, IMG_AIRCURRENT_4, IMG_AIRCURRENT_5, IMG_AIRCURRENT_6};
	public final static String[] ANIMATION_BACKGROUND = {IMG_BACKGROUND};
	public final static String[] ANIMATION_CRBACKGROUND = {IMG_CLAPPER_RAIL_BACKGROUND};
	public final static String[] ANIMATION_BUSH = {IMG_BUSH};
	public final static String[] ANIMATION_DOWN_KEY= {IMG_DOWN_KEY};
	public final static String[] ANIMATION_FOX = {IMG_FOX};
	public final static String[] ANIMATION_FISH = {IMG_FISH_1, IMG_FISH_2, IMG_FISH_1, IMG_FISH_3};
	public final static String[] ANIMATION_LEFT_KEY = {IMG_LEFT_KEY};
	public final static String[] ANIMATION_MATE = {IMG_OSPREY_1,IMG_OSPREY_3,IMG_OSPREY_1,IMG_OSPREY_2};
	public final static String[] ANIMATION_MODEL_DUMP_STATUS_MSG = {IMG_MODEL_DUMP_STATUS_MSG};
	public final static String[] ANIMATION_NEST = {IMG_NEST};
	public final static String[] ANIMATION_OSPREY = {IMG_OSPREY_1,IMG_OSPREY_3,IMG_OSPREY_1,IMG_OSPREY_2};
	public final static String[] ANIMATION_OSPREYDIVE = {IMG_OSPREY_DIVE};
	public final static String[] ANIMATION_POLY_HARVEY = {IMG_POLY_HARVEY};
	public final static String[] ANIMATION_SPACEBAR = {IMG_SPACEBAR_1, IMG_SPACEBAR_2, IMG_SPACEBAR_3, IMG_SPACEBAR_4, IMG_SPACEBAR_5, IMG_SPACEBAR_6,
																		IMG_SPACEBAR_5, IMG_SPACEBAR_4, IMG_SPACEBAR_3, IMG_SPACEBAR_2};
	public final static String[] ANIMATION_STICK = {IMG_STICK};
	public final static String[] ANIMATION_RIGHT_KEY = {IMG_RIGHT_KEY};
	public final static String[] ANIMATION_THARVEY= {IMG_THARVEY_1, IMG_THARVEY_2};
	public final static String[] ANIMATION_TRASH = {IMG_TRASH};
	public final static String[] ANIMATION_UP_KEY = {IMG_UP_KEY_1, IMG_UP_KEY_2, IMG_UP_KEY_3, IMG_UP_KEY_4, IMG_UP_KEY_5, IMG_UP_KEY_6, 
																	IMG_UP_KEY_5, IMG_UP_KEY_4, IMG_UP_KEY_3, IMG_UP_KEY_2};
	
	// Osprey information
	
	public final static JButton OSPREY_I_1 = new JButton("<html>Ospreys like to get food by diving into shallow water<br>and grabbing whatever they can. </html>");
	public final static JButton OSPREY_I_2 = new JButton("<html>Ospreys are lonely birds and <br>they usually like to fly by themselves. </html>");
	public final static JButton OSPREY_I_3 = new JButton("<html>North American ospreys tend to migrate to Central and South America while European ospreys will migrate to Africa for the winter. </html>");
	public final static JButton OSPREY_I_4 = new JButton("<html>Osprey predators include eagles, owls, raccoons, and snakes</html>");
	public final static JButton OSPREY_I_5 = new JButton("<html>Ospreys are usually a combination of brown and white depending on where they are born. </html>");
	public final static JButton OSPREY_I_6 = new JButton("<html>Ospreys will almost always eat fish but if they have to they can other small animals such as insects and snakes. </html>");
	public final static JButton OSPREY_I_7 = new JButton("<html>Ospreys are very loyal and will usually only take one mate in their life. </html>");
	public final static JButton OSPREY_I_8 = new JButton("<html>While 50% of ospreys don't make it to adulthood <BR> the ospreys that can live for up to 15 years, with one osprey female making it to over 20 years old.</html>");
	public final static JButton OSPREY_I_9 = new JButton("<html>The osprey can weigh anywhere from 2 pounds to 5 pounds and their wingspan can be up to 5 feet. </html>");
	public final static JButton OSPREY_I_10 = new JButton("<html>Ospreys mainly get their food and nutrients from fish <BR> and because of this they like to live near water. </html>");
	public final static JButton OSPREY_I_LAST = new JButton("<html>Ospreys like to be near water as that is their food source <BR> but more importantly they like to make their nests up high to avoid predators. </html>");
	
	
	// Osprey Questions
	
	public final static JLabel OSPREY_1 = new JLabel("How do ospreys like to get their food?");
	public final static JLabel OSPREY_2 = new JLabel("How big are osprey flocks?");
	public final static JLabel OSPREY_3 = new JLabel("Where do ospreys migrate to?");
	public final static JLabel OSPREY_4 = new JLabel("What is NOT a predator of the osprey?");
	public final static JLabel OSPREY_5 = new JLabel("What colors are the feathers of the osprey?");
	public final static JLabel OSPREY_6 = new JLabel("What do ospreys usually eat?");
	public final static JLabel OSPREY_7 = new JLabel("How many different mates will an osprey have in its life?");
	public final static JLabel OSPREY_8 = new JLabel("How long does an osprey usually live?");
	public final static JLabel OSPREY_9 = new JLabel("How much does an osprey weigh?");
	public final static JLabel OSPREY_10 = new JLabel("Where do ospreys like to live?");
	public final static JLabel OSPREY_LAST = new JLabel("Where would you like to make your nest?");
	
	// Osprey right answers
	
	public final static JButton OSPREY_CORRECT1 = new JButton("By diving into water");
	public final static JButton OSPREY_CORRECT2 = new JButton("Ospreys usually don't travel in flocks");
	public final static JButton OSPREY_CORRECT3 = new JButton("Central and South America");
	public final static JButton OSPREY_CORRECT4 = new JButton("Fox");
	public final static JButton OSPREY_CORRECT5 = new JButton("Brown and white");
	public final static JButton OSPREY_CORRECT6 = new JButton("Fish");
	public final static JButton OSPREY_CORRECT7 = new JButton("Only one!");
	public final static JButton OSPREY_CORRECT8 = new JButton("10-15 years");
	public final static JButton OSPREY_CORRECT9 = new JButton("3-5 pounds");
	public final static JButton OSPREY_CORRECT10 = new JButton("Near water (like the Delaware Estuary!)");
	public final static JButton OSPREY_LAST_RIGHT = new JButton("Up high off the ground");
	
	// Osprey Wrong answers
	
	public final static JButton OSPREY_INCORRECT1 = new JButton("By hiding and catching prey by surprise");
	public final static JButton OSPREY_INCORRECT2 = new JButton("20 birds");
	public final static JButton OSPREY_INCORRECT3 = new JButton("Europe");
	public final static JButton OSPREY_INCORRECT4 = new JButton("Owl");
	public final static JButton OSPREY_INCORRECT5 = new JButton("Black and red");
	public final static JButton OSPREY_INCORRECT6 = new JButton("Bobcats");
	public final static JButton OSPREY_INCORRECT7 = new JButton("Five");
	public final static JButton OSPREY_INCORRECT8 = new JButton("One year");
	public final static JButton OSPREY_INCORRECT9 = new JButton("10 pounds");
	public final static JButton OSPREY_INCORRECT10 = new JButton("The desert");
	public final static JButton OSPREY_LAST_INCORRECT = new JButton("Low down by the ground");
	
	// Osprey moreWrong answers
	

	public final static JButton OSPREY_WRONG1 = new JButton("Ospreys do not eat food");
	public final static JButton OSPREY_WRONG2 = new JButton("1 million birds");
	public final static JButton OSPREY_WRONG3 = new JButton("Antartica");
	public final static JButton OSPREY_WRONG4 = new JButton("Eagle");
	public final static JButton OSPREY_WRONG5 = new JButton("Blue and gold");
	public final static JButton OSPREY_WRONG6 = new JButton("Cheetahs");
	public final static JButton OSPREY_WRONG7 = new JButton("Thirty");
	public final static JButton OSPREY_WRONG8 = new JButton("50 years");
	public final static JButton OSPREY_WRONG9 = new JButton("1 pound");
	public final static JButton OSPREY_WRONG10 = new JButton("in the mountains");
	public final static JButton OSPREY_LAST_WRONG = new JButton("Osprey don't make nests");
	
	
	// Clapper Rail Information
	
	public final static JButton CR_I_1 = new JButton("<html> Clapper rails will eat almost anything, but they like crabs, crustaceans, and small fish. </html>");
	public final static JButton CR_I_2 = new JButton("<html> The clapper rail life is short but full, as they usually live for five years. </html> ");
	public final static JButton CR_I_3 = new JButton("<html> Clapper rails do not migrate, and will stay in the same area where they were born for their entire life. </html>");
	public final static JButton CR_I_4 = new JButton("<html> Clapper rails like to make their nests at high elevations to avoid flooding or in tall grass to hide from predators. </html>");
	public final static JButton CR_I_5 = new JButton("<html> The clapper rail has many predators, but it's most fearsome is the red fox. </html>");
	public final static JButton CR_I_6 = new JButton("<html> Clapper rails face trouble from predators every day, but their biggest threats are humans and habitat loss. </html>");
	public final static JButton CR_I_7 = new JButton("<html> Clapper rails like to live in muddy areas with tall grass like marshes in order to hide from predators. </html>");
	public final static JButton CR_I_8 = new JButton("<html> Like the osprey, clapper rails take only one mate during breeding season. </html>");
	public final static JButton CR_I_9 = new JButton("<html> Depending on where the clapper rail lives, the clapper rail can be a of brown and gray. </html>");
	public final static JButton CR_I_10 = new JButton("<html> The clapper rail nesting season can go from March to June, with eggs being laid around February or March. </html>");
	
	// Clapper Rail Questions
	
	public final static JLabel CR_1 = new JLabel("What is the clapper rail's favorite food?");
	public final static JLabel CR_2 = new JLabel("How long does the clapper rail usually live?");
	public final static JLabel CR_3 = new JLabel("Where do clapper rails migrate to?");
	public final static JLabel CR_4 = new JLabel("Where does the clapper rail NOT like to make their nest?");
	public final static JLabel CR_5 = new JLabel("What is one of the main predators of the clapper rail?");
	public final static JLabel CR_6 = new JLabel("What is the biggest threat to the clapper rail species?");
	public final static JLabel CR_7 = new JLabel("Where do clapper rails like to live?");
	public final static JLabel CR_8 = new JLabel("How many mates does the clapper rail have during breeding season?");
	public final static JLabel CR_9 = new JLabel("What color are the feathers of the clapper rail?");
	public final static JLabel CR_10 = new JLabel("When is the clapper rail's nesting season?");
	  
	// Clapper Rail Correct
	
	public final static JButton CR_CORRECT1 = new JButton("Crab");
	public final static JButton CR_CORRECT2 = new JButton("2-4 years");
	public final static JButton CR_CORRECT3 = new JButton("They don't migrate!");
	public final static JButton CR_CORRECT4 = new JButton("Out in the open grass");
	public final static JButton CR_CORRECT5 = new JButton("The red fox");
	public final static JButton CR_CORRECT6 = new JButton("Habitat loss");
	public final static JButton CR_CORRECT7 = new JButton("Swamps (like at the Delaware Estuary!)");
	public final static JButton CR_CORRECT8 = new JButton("Only one!");
	public final static JButton CR_CORRECT9 = new JButton("Brown, gray");
	public final static JButton CR_CORRECT10 = new JButton("From March to June");
	
	
	// Clapper Rail incorrect
	
	public final static JButton CR_INCORRECT1 = new JButton("Snake");
	public final static JButton CR_INCORRECT2 = new JButton("10 years");
	public final static JButton CR_INCORRECT3 = new JButton("South America");
	public final static JButton CR_INCORRECT4 = new JButton("On high grounds like hills");
	public final static JButton CR_INCORRECT5 = new JButton("Fish");
	public final static JButton CR_INCORRECT6 = new JButton("Clapper rails don't have any threats.");
	public final static JButton CR_INCORRECT7 = new JButton("Deserts");
	public final static JButton CR_INCORRECT8 = new JButton("Five");
	public final static JButton CR_INCORRECT9 = new JButton("Blue, green");
	public final static JButton CR_INCORRECT10 = new JButton("November to January");
	
	// Clapper Rail moreWrong
	
	public final static JButton CR_WRONG1 = new JButton("Duck");
	public final static JButton CR_WRONG2 = new JButton("20 years");
	public final static JButton CR_WRONG3 = new JButton("Australia");
	public final static JButton CR_WRONG4 = new JButton("Hidden in bushes and grass");
	public final static JButton CR_WRONG5 = new JButton("Lions");
	public final static JButton CR_WRONG6 = new JButton("Ducks");
	public final static JButton CR_WRONG7 = new JButton("In the ocean");
	public final static JButton CR_WRONG8 = new JButton("Ten");
	public final static JButton CR_WRONG9 = new JButton("Orange, yellow");
	public final static JButton CR_WRONG10 = new JButton("July to October");
	
	/// Doubles
	public final static double IMG_SCALE_RATIO_X = FRAME_X/800;
	public final static double IMG_SCALE_RATIO_Y = FRAME_Y/600;


	public static void setFrameX(int d) { 
		FRAME_X = d; 
	}
	public static void setFrameY(int y) { FRAME_Y = y; }
	public static int getFRAME_X() { return FRAME_X; }
	public static int getFRAME_Y() { return FRAME_Y; }
	
	//other
	public static Rectangle SCREEN = new Rectangle(0,0,FRAME_X,FRAME_Y);
}
