package GameFiles;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

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
	
	public final static int CLAPPER_RAIL_START_LOC_X = 400;
	public final static int CLAPPER_RAIL_START_LOC_Y = 200;
	public final static int CLAPPER_RAIL_START_SIZE_X = 100;
	public final static int CLAPPER_RAIL_START_SIZE_Y = 100;
	
	public final static int CLAPPER_RAIL_INIT_LIVES = 3;
	
	public final static int FISH_AC = 1;
	public final static int FISH_X_SPEED_TEST = -50;
	
	public final static int FOX_START_LOC_X = 400;
	public final static int FOX_START_LOC_Y = 400;
	public final static int FOX_START_SIZE_X = 100;
	public final static int FOX_START_SIZE_Y = 100;
	
	public final static int LINUX_SCREEN_SIZE = 100;
	public final static int LINUX_SCREEN_SCALE_X = 16;
	public final static int LINUX_SCREEN_SCALE_Y = 9;
	
	public final static int OSPREY_STARTX = 100;
	public final static int OSPREY_DIVESPEED = 50;
	public final static int OSPREY_MAX_HEIGHT = 600;
	public final static int OSPREY_WATER_LEVEL = 350;
	
	public final static int STICK_HANDLECOLLISION_OFFSET = 30;
	
    public final static int TDM_BOUND_OFFSET = 134;
    public final static int TDM_CLOCK_TICK_CHECK = 100;
	public final static int TDM_LEFT_BOUND = 0;
    public final static int TDM_RIGHT_BOUND = 800;
	public final static int TDM_UPDATELOCATION_STICK_COUNT = 3;
	
	public final static int TIMER_TICK_RATE = 50;
	
	public final static int TRASH_AC = 1;
	
	public static int FRAME_X;
	public static int FRAME_Y;
	

	/// Strings
	public final static String IMG_AIRCURRENT = "img/aircurrent.png";
	public final static String IMG_BACKGROUND = "img/background.png";
	public final static String IMG_CLAPPER_RAIL_BACKGROUND = "img/cBackground.png";
	public final static String IMG_BUSH = "img/bush.png";
	public final static String IMG_DOWN_KEY = "img/down.png";
	public final static String IMG_FISH = "img/fish_west1.png";
	public final static String IMG_FOX = "img/ee.png";
	public final static String IMG_LEFT_KEY = "img/left.png";
	public final static String IMG_MATE = "img/cr.png";
	public final static String IMG_MODEL_DUMP_STATUS_MSG = "img/modelDumpStatusMsg.png";
	public final static String IMG_NEST = "img/nest.png";
	public final static String IMG_OSPREY = "img/osprey_right.png";
	public final static String IMG_OSPREY_DIVE = "img/osprey_dive.png";
	public final static String IMG_POLY_HARVEY = "img/PolyHarvey.png";
	public final static String IMG_RIGHT_KEY = "img/right.png";
	public final static String IMG_SELECT_CLAPPER_RAIL = "img/selectCR.png";
	public final static String IMG_SELECT_OSPREY = "img/selectOsprey.png";
	public final static String IMG_SPACEBAR = "img/spacebar.png";
	public final static String IMG_STICK = "img/Stick.png";
	public final static String IMG_THARVEY = "img/Tharvey.png";
	public final static String IMG_TRASH = "img/Trash.png";
	public final static String IMG_UP_KEY = "img/up.png";
	
	// Arrays of String file paths
	
	public final static String[] ANIMATION_AIRCURRENT = {IMG_AIRCURRENT};
	public final static String[] ANIMATION_BACKGROUND = {IMG_BACKGROUND};
	public final static String[] ANIMATION_CRBACKGROUND = {IMG_CLAPPER_RAIL_BACKGROUND};
	public final static String[] ANIMATION_BUSH = {IMG_BUSH};
	public final static String[] ANIMATION_DOWNKEY= {IMG_DOWN_KEY};
	public final static String[] ANIMATION_FOX = {IMG_FOX};
	public final static String[] ANIMATION_FISH = {IMG_FISH};
	public final static String[] ANIMATION_LEFT_KEY = {IMG_LEFT_KEY};
	public final static String[] ANIMATION_MATE = {IMG_MATE};
	public final static String[] ANIMATION_MODEL_DUMP_STATUS_MSG = {IMG_MODEL_DUMP_STATUS_MSG};
	public final static String[] ANIMATION_NEST = {IMG_NEST};
	public final static String[] ANIMATION_OSPREY = {IMG_OSPREY};
	public final static String[] ANIMATION_OSPREYDIVE = {IMG_OSPREY_DIVE};
	public final static String[] ANIMATION_POLY_HARVEY = {IMG_POLY_HARVEY};
	public final static String[] ANIMATION_SPACEBAR = {IMG_SPACEBAR};
	public final static String[] ANIMATION_STICK = {IMG_STICK};
	public final static String[] ANIMATION_RIGHT_KEY = {IMG_RIGHT_KEY};
	public final static String[] ANIMATION_THARVEY= {IMG_THARVEY};
	public final static String[] ANIMATION_TRASH = {IMG_TRASH};
	public final static String[] ANIMATION_UP_KEY = {IMG_UP_KEY};
	
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
	public final static JButton OSPREY_CORRECT8 = new JButton("15-20 years");
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
	
	// Clapper Rail Questions
	
	public final static JLabel CR_1 = new JLabel();
	public final static JLabel CR_2 = new JLabel();
	public final static JLabel CR_3 = new JLabel();
	public final static JLabel CR_4 = new JLabel();
	public final static JLabel CR_5 = new JLabel();
	public final static JLabel CR_6 = new JLabel();
	public final static JLabel CR_7 = new JLabel();
	public final static JLabel CR_8 = new JLabel();
	public final static JLabel CR_9 = new JLabel();
	public final static JLabel CR_10 = new JLabel();
	  
	// Clapper Rail Correct
	
	public final static JButton CR_CORRECT1 = new JButton();
	public final static JButton CR_CORRECT2 = new JButton();
	public final static JButton CR_CORRECT3 = new JButton();
	public final static JButton CR_CORRECT4 = new JButton();
	public final static JButton CR_CORRECT5 = new JButton();
	public final static JButton CR_CORRECT6 = new JButton();
	public final static JButton CR_CORRECT7 = new JButton();
	public final static JButton CR_CORRECT8 = new JButton();
	public final static JButton CR_CORRECT9 = new JButton();
	public final static JButton CR_CORRECT10 = new JButton();
	
	
	// Clapper Rail incorrect
	
	public final static JButton CR_INCORRECT1 = new JButton();
	public final static JButton CR_INCORRECT2 = new JButton();
	public final static JButton CR_INCORRECT3 = new JButton();
	public final static JButton CR_INCORRECT4 = new JButton();
	public final static JButton CR_INCORRECT5 = new JButton();
	public final static JButton CR_INCORRECT6 = new JButton();
	public final static JButton CR_INCORRECT7 = new JButton();
	public final static JButton CR_INCORRECT8 = new JButton();
	public final static JButton CR_INCORRECT9 = new JButton();
	public final static JButton CR_INCORRECT10 = new JButton();
	
	// Clapper Rail moreWrong
	
	public final static JButton CR_WRONG1 = new JButton();
	public final static JButton CR_WRONG2 = new JButton();
	public final static JButton CR_WRONG3 = new JButton();
	public final static JButton CR_WRONG4 = new JButton();
	public final static JButton CR_WRONG5 = new JButton();
	public final static JButton CR_WRONG6 = new JButton();
	public final static JButton CR_WRONG7 = new JButton();
	public final static JButton CR_WRONG8 = new JButton();
	public final static JButton CR_WRONG9 = new JButton();
	public final static JButton CR_WRONG10 = new JButton();
	
	/// Doubles
	public final static double IMG_SCALE_RATIO_X = FRAME_X/800;
	public final static double IMG_SCALE_RATIO_Y = FRAME_Y/600;


	public static void setFrameX(int d) { FRAME_X = d; }
	public static void setFrameY(int y) { FRAME_Y = y; }
	public static int getFRAME_X() { return FRAME_X; }
	public static int getFRAME_Y() { return FRAME_Y; }
	
	//other
	public static Rectangle SCREEN = new Rectangle(0,0,FRAME_X,FRAME_Y);
}
