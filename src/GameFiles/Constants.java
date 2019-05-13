package GameFiles;

import java.io.Serializable;

public class Constants implements Serializable {

	/// Booleans
	public static boolean BOOL_HARVEY = false;

	public final static int RIGHT = 39;
	public final static int LEFT = 37;
	public final static int UP = 38;
	public final static int DOWN = 40;
	public final static int SPACE = 32;
	
	/// ints
	public final static int g = 10;
	
	public final static int BIRD_MOVE_AMOUNT = 10;
	
	public final static int CLAPPER_RAIL_START_LOC_X = 400;
	public final static int CLAPPER_RAIL_START_LOC_Y = 200;
	public final static int CLAPPER_RAIL_START_SIZE_X = 100;
	public final static int CLAPPER_RAIL_START_SIZE_Y = 100;
	
	public final static int FISH_AC = 1;
	public final static int FISH_X_SPEED_TEST = -10;
	
	public final static int FOX_START_LOC_X = 400;
	public final static int FOX_START_LOC_Y = 400;
	public final static int FOX_START_SIZE_X = 100;
	public final static int FOX_START_SIZE_Y = 100;
	
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
	
	public static int COLLECTABLE_WIDTH = FRAME_X/10;
	public static int COLLECTABLE_HEIGHT = FRAME_Y/10;

	/// Strings
	public final static String IMG_AIRCURRENT = "img/aircurrent.png";
	public final static String IMG_BACKGROUND = "img/background.png";
	public final static String IMG_CLAPPER_RAIL_BACKGROUND = "img/cBackground.png";
	public final static String IMG_BROWN_SQUARE = "img/brown_square.png";
	public final static String IMG_BUSH = "img/bush.png";
	public final static String IMG_FISH = "img/fish_west1.png";
	public final static String IMG_FOX = "img/ee.png";
	public final static String IMG_MATE = "img/cr.png";
	public final static String IMG_NEST = "img/nest.png";
	public final static String IMG_OSPREY = "img/osprey_right.png";
	public final static String IMG_OSPREY_DIVE = "img/osprey_dive.png";
	public final static String IMG_POLY_HARVEY = "img/PolyHarvey.png";
	public final static String IMG_SELECT_CLAPPER_RAIL = "img/selectCR.png";
	public final static String IMG_SELECT_OSPREY = "img/selectOsprey.png";
	public final static String IMG_STICK = "img/Stick.png";
	public final static String IMG_THARVEY = "img/Tharvey.png";
	public final static String IMG_TRASH = "img/Trash.png";
	
	/// Doubles
	public final static double IMG_SCALE_RATIO_X = FRAME_X/800;
	public final static double IMG_SCALE_RATIO_Y = FRAME_Y/600;


	public static void setFrameX(int d) { FRAME_X = d; }
	public static void setFrameY(int y) { FRAME_Y = y; }
	public static int getFRAME_X() { return FRAME_X; }
	public static int getFRAME_Y() { return FRAME_Y; }
}
