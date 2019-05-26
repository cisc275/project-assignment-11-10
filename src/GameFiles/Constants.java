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
	
	public final static int RIGHT_KEY_CODE = 39;
	public final static int LEFT_KEY_CODE = 37;
	public final static int UP_KEY_CODE = 38;
	public final static int DOWN_KEY_CODE = 40;
	public final static int SPACE_KEY_CODE = 32;
	public final static int ESCAPE_KEY_CODE = 27;
	public final static int TILDA_KEY_CODE = 192;
	public final static int ONE_KEY_CODE = 49;
	
	public final static int AIRCURRENT_ANIMATION_TICK_RATE = 3;
	public final static int AIRCURRENT_OFFSET = 2;
	
	public final static int BACKGROUND_YSPEED = 0;
	
	public final static int BUSH_ANIMATION_TICK_RATE = 2;
	public final static int BUSH_SIZE = 150;
	public final static int BUSH_PAUSE = 5;
	
	public final static int CLAPPER_RAIL_START_LOC_X = 0;
	public final static int CLAPPER_RAIL_START_LOC_Y = 0;
	public final static int CLAPPER_RAIL_START_SIZE_X = 100;
	public final static int CLAPPER_RAIL_START_SIZE_Y = 100;
	public final static int CLAPPER_RAIL_ANIMATION_TICK_RATE = 1;
	public final static int CLAPPER_RAIL_LIVES_END_STATE = 0;
	public final static int CLAPPER_RAIL_LIVE_LOSS = -1;
	public final static int CLAPPER_RAIL_INIT_LIVES = 3;
	
	public final static int COLLECTABLE_RANDOM_SPEED = 10;
	public final static int COLLECTABLE_RANDOM_OFFSET = 15;
	public final static int COLLECTABLE_YSPEED = 0;
	
	public final static int CRAB_ANIMATION_TICK_RATE = 5;
	
	public final static int FISH_AC = 5;
	public final static int FISH_X_SPEED_TEST = -50;
	public final static int FISH_ANIMATION_TICK_RATE = 2;
	
	public final static int FOX_HEIGHT_DIVISION_FACTOR = 2;
	public final static int FOX_INIT_XSPEED = 1;
	public final static int FOX_INIT_YSPEED = -2;
	public final static int FOX_START_LOC_X = 400;
	public final static int FOX_START_LOC_Y = 300;
	public final static int FOX_START_SIZE_X = 250;
	public final static int FOX_START_SIZE_Y = 125;
	public final static int FOX_ANIMATION_TICK_RATE = 2;
	public final static int FOX_SPEED_MULTIPLIER = 3;
	public final static int FOX_SQUARED = 2;
	public final static int FOX_T_SPEED = -10;
	
	
	public final static int GAME_OBJECT_START_IMAGE = 0;
	
	public final static int GRID_LAYOUT_X = 0;
	public final static int GRID_LAYOUT_Y = 1;
	
	
	public final static int LINUX_SCREEN_SIZE = 10;
	public final static int LINUX_SCREEN_SCALE_X = 192;
	public final static int LINUX_SCREEN_SCALE_Y = 108;
	
	public final static int INVISIBLE_WALL_POINTS = 5;
	
	public final static int MATE_ANIMATION_TICK_RATE = 4;
	public final static int MATE_INIT_SPEED = 0;
	public final static int MATE_CAUGHT_SPEED = -10;
	
	public final static int NEST_START_SIZE = 50;
	public final static int NEST_X = 25;
	public final static int NEST_Y = 25;
	
	public final static int OSPREY_STARTX = 100;
	public final static int OSPREY_DIVESPEED = 40;
	public final static int OSPREY_MAX_HEIGHT = 600;
	public final static int OSPREY_WATER_LEVEL = 400;
	public final static int OSPREY_MIN_SPEED = -5;
	public final static int OSPREY_MAX_SPEED = -30;
	public final static int OSPREY_MAX_DISTANCE = 26000;
	public final static int OSPREY_ANIMATION_TICK_RATE = 4;
	public final static int OSPREY_INIT_YSPEED = 0;
	
	public final static int POWERUP_HEIGH = 100;
	public final static int POWERUP_LIFE_INCREASE_RATE = 1;
	public final static int POWERUP_SIZE = 50;
	public final static int POWERUP_SPEED = -50;
	public final static int POWERUP_DURATION = 100;
	
	public final static int STICK_ANIMATION_TICK_RATE = 2;
	public final static int STICK_HANDLECOLLISION_OFFSET = 30;
	public final static int STICK_SIZE = 40;
	public final static int STICK_END_COUNT = 3;
	
    public final static int TDM_BOUND_OFFSET = 134;
    public final static int TDM_CLOCK_TICK_CHECK = 100;
	public final static int TDM_LEFT_BOUND = 0;
    public final static int TDM_RIGHT_BOUND = 800;
	public final static int TDM_UPDATELOCATION_STICK_COUNT = 3;
	
	public final static int TA_OFFSET = 50;
	public final static int TA_IMG_SAFTEY_MARGIN = 10;
	
	public final static int TO_ANIMATION_TICK_RATE = 2;
	public final static int TO_DEFAULT_SIZE = 122;
	public final static int TO_KEY_OFFSET = 100;
	public final static int TO_SPACE_DEFAULT_WIDTH = 483;
	public final static int TO_SPACE_DEFUALT_HEIGH = 110;
	public final static int TO_STICK_DEFAULT_LOCATION = 400;
	public final static int TO_UP_KEY_DEFAULT_X = 1000;
	public final static int TO_UP_KEY_DEFAULT_Y = 300;
	
	
	public final static int TIMER_TICK_RATE = 50;
	
	public final static int TRASH_AC = 5;
	
	public static int FRAME_X;
	public static int FRAME_Y;
	
	
	/// Ints Array
	public final static int[] BUSH_X_ARR = {800, 600, 20, 1200, 0, 150, 150};
	public final static int[] BUSH_Y_ARR = {600, 20, 450, 300, 150, 0, 150};
	
	public final static int[] STICK_OFFSET_X = {0, 400, 200, 700};
	public final static int[] STICK_OFFSET_Y = {0, 700, 325, 235};
	
	
	/// Doubles
	public static double POWERUP_HEIGH_SCALE = 2.0;
	public static double POWERUP_SCALE = 1.0;
	
	public static double STICK_SCALE = 1.0;
	
	

	/// Strings
	public final static String TOP_DOWN_STRING = "topDown";
	public final static String TOP_DOWN_NT_STRING = "topDownNT";
	public final static String SIDE_SCROLL_STRING = "sideScroll";
	public final static String SIDE_SCROLL_NT_STRING = "sideScrollNT";
	public final static String SELECTION_STRING = "sel";
	
	public final static String IMG_AIRCURRENT = "img/aircurrent.png";
	public final static String IMG_AIRCURRENT_1 = "img/aircurrent/aircurrent_1.png";
	public final static String IMG_AIRCURRENT_2 = "img/aircurrent/aircurrent_2.png";
	public final static String IMG_AIRCURRENT_3 = "img/aircurrent/aircurrent_3.png";
	public final static String IMG_AIRCURRENT_4 = "img/aircurrent/aircurrent_4.png";
	public final static String IMG_AIRCURRENT_5 = "img/aircurrent/aircurrent_5.png";
	public final static String IMG_AIRCURRENT_6 = "img/aircurrent/aircurrent_6.png";
	public final static String IMG_ARROW = "img/arrow.png";
	public final static String IMG_ARROW_1 = "img/arrow/arrow1.png";
	public final static String IMG_ARROW_2 = "img/arrow/arrow2.png";
	public final static String IMG_ARROW_3 = "img/arrow/arrow3.png";
	public final static String IMG_ARROW_4 = "img/arrow/arrow4.png";
	public final static String IMG_ARROW_5 = "img/arrow/arrow5.png";
	public final static String IMG_BACKGROUND = "img/backgroundTim.png";
	public final static String IMG_BACKGROUND_OSPREY_QUIZ = "img/backgroundTimQuiz.png";
	public final static String IMG_BUSH = "img/bush.png";
	public final static String IMG_BUSH_1 = "img/bush/bush1.png";
	public final static String IMG_BUSH_2 = "img/bush/bush2.png";
	public final static String IMG_BUSH_3 = "img/bush/bush3.png";
	public final static String IMG_BUSH_4 = "img/bush/bush4.png";
	public final static String IMG_BUSH_5 = "img/bush/bush5.png";
	public final static String IMG_BUSH_6 = "img/bush/bush6.png";
	public final static String IMG_CR_BACKGROUND_QUIZ = "img/cBackgroundQuiz.png";
	public final static String IMG_CLAPPER_RAIL_BACKGROUND = "img/cBackground.png";
	public final static String IMG_CLAPPER_RAIL_LEFT_1 = "img/cr/cr1.png";
	public final static String IMG_CLAPPER_RAIL_LEFT_2 = "img/cr/cr2.png";
	public final static String IMG_CLAPPER_RAIL_LEFT_3 = "img/cr/cr3.png";
	public final static String IMG_CLAPPER_RAIL_RIGHT_1 = "img/cr/cr4.png";
	public final static String IMG_CLAPPER_RAIL_RIGHT_2 = "img/cr/cr5.png";
	public final static String IMG_CLAPPER_RAIL_RIGHT_3 = "img/cr/cr6.png";
	public final static String IMG_CRAB_1 = "img/crab/crab1.png";
	public final static String IMG_CRAB_2 = "img/crab/crab2.png";
	public final static String IMG_CRAB_ANIMATED_1 = "img/crab/crab1_1.png";
	public final static String IMG_CRAB_ANIMATED_2 = "img/crab/crab2_2.png";
	public final static String IMG_CRAB_ANIMATED_3 = "img/crab/crab1_3.png";
	public final static String IMG_CRAB_ANIMATED_4 = "img/crab/crab2_4.png";
	public final static String IMG_CRAB_ANIMATED_5 = "img/crab/crab1_5.png";
	public final static String IMG_CRAB_ANIMATED_6 = "img/crab/crab2_5.png";
	public final static String IMG_CRAB_ANIMATED_7 = "img/crab/crab1_4.png";
	public final static String IMG_CRAB_ANIMATED_8 = "img/crab/crab2_3.png";
	public final static String IMG_CRAB_ANIMATED_9 = "img/crab/crab1_2.png";
	public final static String IMG_DOWN_KEY = "img/down/down.png";
	public final static String IMG_DOWN_KEY_1 = "img/down/down_1.png";
	public final static String IMG_DOWN_KEY_2 = "img/down/down_2.png";
	public final static String IMG_DOWN_KEY_3 = "img/down/down_3.png";
	public final static String IMG_DOWN_KEY_4 = "img/down/down_4.png";
	public final static String IMG_DOWN_KEY_5 = "img/down/down_5.png";
	public final static String IMG_DOWN_KEY_6 = "img/down/down_6.png";
	public final static String IMG_FISH_1 = "img/fish/fish_west1.png";
	public final static String IMG_FISH_2 = "img/fish/fish_west2.png";
	public final static String IMG_FISH_3 = "img/fish/fish_west3.png";
	public final static String IMG_FOX = "img/fox/fox.png";
	public final static String IMG_FOX_LEFT_1 = "img/fox/fox_left_1.png";
	public final static String IMG_FOX_LEFT_2 = "img/fox/fox_left_2.png";
	public final static String IMG_FOX_LEFT_3 = "img/fox/fox_left_3.png";
	public final static String IMG_FOX_LEFT_4 = "img/fox/fox_left_4.png";
	public final static String IMG_FOX_LEFT_5 = "img/fox/fox_left_5.png";
	public final static String IMG_FOX_LEFT_6 = "img/fox/fox_left_6.png";
	public final static String IMG_FOX_BAD_LEFT_1 = "img/fox/fox_left_1_bad.png";
	public final static String IMG_FOX_BAD_LEFT_2 = "img/fox/fox_left_2_bad.png";
	public final static String IMG_FOX_BAD_LEFT_3 = "img/fox/fox_left_3_bad.png";
	public final static String IMG_FOX_BAD_LEFT_4 = "img/fox/fox_left_4_bad.png";
	public final static String IMG_FOX_BAD_LEFT_5 = "img/fox/fox_left_5_bad.png";
	public final static String IMG_FOX_BAD_LEFT_6 = "img/fox/fox_left_6_bad.png";
	public final static String IMG_FOX_RIGHT_1 = "img/fox/fox_right_1.png";
	public final static String IMG_FOX_RIGHT_2 = "img/fox/fox_right_2.png";
	public final static String IMG_FOX_RIGHT_3 = "img/fox/fox_right_3.png";
	public final static String IMG_FOX_RIGHT_4 = "img/fox/fox_right_4.png";
	public final static String IMG_FOX_RIGHT_5 = "img/fox/fox_right_5.png";
	public final static String IMG_FOX_RIGHT_6 = "img/fox/fox_right_6.png";
	public final static String IMG_FOX_BAD_RIGHT_1 = "img/fox/fox_right_1_bad.png";
	public final static String IMG_FOX_BAD_RIGHT_2 = "img/fox/fox_right_2_bad.png";
	public final static String IMG_FOX_BAD_RIGHT_3 = "img/fox/fox_right_3_bad.png";
	public final static String IMG_FOX_BAD_RIGHT_4 = "img/fox/fox_right_4_bad.png";
	public final static String IMG_FOX_BAD_RIGHT_5 = "img/fox/fox_right_5_bad.png";
	public final static String IMG_FOX_BAD_RIGHT_6 = "img/fox/fox_right_6_bad.png";
	public final static String IMG_LEFT_KEY = "img/left/left.png";
	public final static String IMG_LEFT_KEY_1 = "img/left/left_1.png";
	public final static String IMG_LEFT_KEY_2 = "img/left/left_2.png";
	public final static String IMG_LEFT_KEY_3 = "img/left/left_3.png";
	public final static String IMG_LEFT_KEY_4 = "img/left/left_4.png";
	public final static String IMG_LEFT_KEY_5 = "img/left/left_5.png";
	public final static String IMG_LEFT_KEY_6 = "img/left/left_6.png";
	public final static String IMG_MATE = "img/cr.png";
	public final static String IMG_MODEL_DUMP_STATUS_MSG = "img/modelDumpStatusMsg.png";
	public final static String IMG_NEST = "img/nest.png";
	public final static String IMG_OSPREY_1 = "img/osprey/osprey1.png";
	public final static String IMG_OSPREY_2 = "img/osprey/osprey2.png";
	public final static String IMG_OSPREY_3 = "img/osprey/osprey3.png";
	public final static String IMG_OSPREY_DIVE = "img/osprey_dive.png";
	public final static String IMG_OSPREY_BAD_1 = "img/osprey/osprey1_bad.png";
	public final static String IMG_OSPREY_BAD_2 = "img/osprey/osprey2_bad.png";
	public final static String IMG_OSPREY_BAD_3 = "img/osprey/osprey3_bad.png";
	public final static String IMG_OSPREY_GOOD_1 = "img/osprey/osprey1_good.png";
	public final static String IMG_OSPREY_GOOD_2 = "img/osprey/osprey2_good.png";
	public final static String IMG_OSPREY_GOOD_3 = "img/osprey/osprey3_good.png";
	public final static String IMG_POLY_HARVEY = "img/PolyHarvey.png";
	public final static String IMG_RIGHT_KEY = "img/right/right.png";
	public final static String IMG_RIGHT_KEY_1 = "img/right/right_1.png";
	public final static String IMG_RIGHT_KEY_2 = "img/right/right_2.png";
	public final static String IMG_RIGHT_KEY_3 = "img/right/right_3.png";
	public final static String IMG_RIGHT_KEY_4 = "img/right/right_4.png";
	public final static String IMG_RIGHT_KEY_5 = "img/right/right_5.png";
	public final static String IMG_RIGHT_KEY_6 = "img/right/right_6.png";
	public final static String IMG_ESC_KEY = "img/esc.png";
	public final static String IMG_SELECT_CLAPPER_RAIL = "img/selectCR.png";
	public final static String IMG_SELECT_OSPREY = "img/selectOsprey.png";
	public final static String IMG_SELECTION_VIEW_BG = "img/estuary_meadow_with_river.png";
	public final static String IMG_SELECT_BG = "img/selectionBG.png";
	public final static String IMG_SPACEBAR = "img/spacebar/spacebar.png";
	public final static String IMG_SPACEBAR_1 = "img/spacebar/spacebar_1.png";
	public final static String IMG_SPACEBAR_2 = "img/spacebar/spacebar_2.png";
	public final static String IMG_SPACEBAR_3 = "img/spacebar/spacebar_3.png";
	public final static String IMG_SPACEBAR_4 = "img/spacebar/spacebar_4.png";
	public final static String IMG_SPACEBAR_5 = "img/spacebar/spacebar_5.png";
	public final static String IMG_SPACEBAR_6 = "img/spacebar/spacebar_6.png";
	public final static String IMG_STICK = "img/stick/Stick.png";
	public final static String IMG_TO_STICK_1 = "img/stick/stick1.png";
	public final static String IMG_TO_STICK_2 = "img/stick/stick2.png";
	public final static String IMG_TO_STICK_3 = "img/stick/stick3.png";
	public final static String IMG_TO_STICK_4 = "img/stick/stick4.png";
	public final static String IMG_TO_STICK_5 = "img/stick/stick5.png";
	public final static String IMG_TO_STICK_6 = "img/stick/stick6.png";
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
	public final static String[] ANIMATION_ARROW = {IMG_ARROW_1, IMG_ARROW_2, IMG_ARROW_3, IMG_ARROW_4, IMG_ARROW_5, IMG_ARROW_4, IMG_ARROW_3, IMG_ARROW_2};
	public final static String[] ANIMATION_ARROW_STATIC = {IMG_ARROW};
	public final static String[] ANIMATION_BACKGROUND = {IMG_BACKGROUND};
	public final static String[] ANIMATION_CRBACKGROUND = {IMG_CLAPPER_RAIL_BACKGROUND};
	public final static String[] ANIMATION_BACKGROUND_OSPREY_QUIZ = {IMG_BACKGROUND_OSPREY_QUIZ};
	public final static String[] ANIMATION_BUSH_GLOW = {IMG_BUSH_1, IMG_BUSH_2, IMG_BUSH_3, IMG_BUSH_4, IMG_BUSH_5, IMG_BUSH_6, IMG_BUSH_5, IMG_BUSH_4, IMG_BUSH_3, IMG_BUSH_2};
	public final static String[] ANIMATION_CR_LEFT= {IMG_CLAPPER_RAIL_LEFT_1,IMG_CLAPPER_RAIL_LEFT_2,IMG_CLAPPER_RAIL_LEFT_3,IMG_CLAPPER_RAIL_LEFT_2};
	public final static String[] ANIMATION_CR_RIGHT= {IMG_CLAPPER_RAIL_RIGHT_1,IMG_CLAPPER_RAIL_RIGHT_2,IMG_CLAPPER_RAIL_RIGHT_3,IMG_CLAPPER_RAIL_RIGHT_2};
	
	public final static String[] ANIMATION_CRAB_STATIC = {IMG_CRAB_1, IMG_CRAB_2};
	public final static String[] ANIMATION_CRAB = {IMG_CRAB_ANIMATED_1, IMG_CRAB_ANIMATED_2, IMG_CRAB_ANIMATED_3, IMG_CRAB_ANIMATED_4, 
																		IMG_CRAB_ANIMATED_5, IMG_CRAB_ANIMATED_6, IMG_CRAB_ANIMATED_7, 
																		IMG_CRAB_ANIMATED_8, IMG_CRAB_ANIMATED_9};
	
	public final static String[] ANIMATION_BUSH = {IMG_BUSH};
	public final static String[] ANIMATION_DOWN_KEY= {IMG_DOWN_KEY_1, IMG_DOWN_KEY_2, IMG_DOWN_KEY_3, IMG_DOWN_KEY_4, IMG_DOWN_KEY_5, IMG_DOWN_KEY_6, 
																		IMG_DOWN_KEY_5, IMG_DOWN_KEY_4, IMG_DOWN_KEY_3, IMG_DOWN_KEY_2};
	public final static String[] ANIMATION_FOX_LEFT = {IMG_FOX_LEFT_1, IMG_FOX_LEFT_2, IMG_FOX_LEFT_3, IMG_FOX_LEFT_4, IMG_FOX_LEFT_5, IMG_FOX_LEFT_6, 
																		IMG_FOX_LEFT_5, IMG_FOX_LEFT_4, IMG_FOX_LEFT_3, IMG_FOX_LEFT_2};
	public final static String[] ANIMATION_FOX_RIGHT = {IMG_FOX_RIGHT_1, IMG_FOX_RIGHT_2, IMG_FOX_RIGHT_3, IMG_FOX_RIGHT_4, IMG_FOX_RIGHT_5, IMG_FOX_RIGHT_6, 
																		IMG_FOX_RIGHT_5, IMG_FOX_RIGHT_4, IMG_FOX_RIGHT_3, IMG_FOX_RIGHT_2};
	public final static String[] ANIMATION_FOX_LEFT_BAD = {IMG_FOX_BAD_LEFT_1, IMG_FOX_BAD_LEFT_2, IMG_FOX_BAD_LEFT_3, IMG_FOX_BAD_LEFT_4, IMG_FOX_BAD_LEFT_5, IMG_FOX_BAD_LEFT_6,
																		IMG_FOX_BAD_LEFT_5, IMG_FOX_BAD_LEFT_4, IMG_FOX_BAD_LEFT_3, IMG_FOX_BAD_LEFT_2};
	public final static String[] ANIMATION_FOX_RIGHT_BAD = {IMG_FOX_BAD_RIGHT_1, IMG_FOX_BAD_RIGHT_2, IMG_FOX_BAD_RIGHT_3, IMG_FOX_BAD_RIGHT_4, IMG_FOX_BAD_RIGHT_5, IMG_FOX_BAD_RIGHT_6, 
																		IMG_FOX_BAD_RIGHT_5, IMG_FOX_BAD_RIGHT_4, IMG_FOX_BAD_RIGHT_3, IMG_FOX_BAD_RIGHT_2};
	public final static String[] ANIMATION_FOX_STATIC = {IMG_FOX};
	public final static String[] ANIMATION_FISH = {IMG_FISH_1, IMG_FISH_2, IMG_FISH_1, IMG_FISH_3};
	public final static String[] ANIMATION_LEFT_KEY = {IMG_LEFT_KEY_1, IMG_LEFT_KEY_2, IMG_LEFT_KEY_3, IMG_LEFT_KEY_4, IMG_LEFT_KEY_5, IMG_LEFT_KEY_6, 
																		IMG_LEFT_KEY_5, IMG_LEFT_KEY_4, IMG_LEFT_KEY_3, IMG_LEFT_KEY_2};
	public final static String[] ANIMATION_MATE = {IMG_OSPREY_1,IMG_OSPREY_3,IMG_OSPREY_1,IMG_OSPREY_2};
	public final static String[] ANIMATION_MODEL_DUMP_STATUS_MSG = {IMG_MODEL_DUMP_STATUS_MSG};
	public final static String[] ANIMATION_NEST = {IMG_NEST};
	public final static String[] ANIMATION_OSPREY = {IMG_OSPREY_1,IMG_OSPREY_3,IMG_OSPREY_1,IMG_OSPREY_2};
	public final static String[] ANIMATION_OSPREY_BAD = {IMG_OSPREY_BAD_1,IMG_OSPREY_BAD_3,IMG_OSPREY_BAD_1,IMG_OSPREY_BAD_2};
	public final static String[] ANIMATION_OSPREY_GOOD = {IMG_OSPREY_GOOD_1,IMG_OSPREY_GOOD_3,IMG_OSPREY_GOOD_1,IMG_OSPREY_GOOD_2};
	public final static String[] ANIMATION_OSPREYDIVE = {IMG_OSPREY_DIVE};
	public final static String[] ANIMATION_POLY_HARVEY = {IMG_POLY_HARVEY};
	public final static String[] ANIMATION_SPACEBAR = {IMG_SPACEBAR_1, IMG_SPACEBAR_2, IMG_SPACEBAR_3, IMG_SPACEBAR_4, IMG_SPACEBAR_5, IMG_SPACEBAR_6,
																		IMG_SPACEBAR_5, IMG_SPACEBAR_4, IMG_SPACEBAR_3, IMG_SPACEBAR_2};
	public final static String[] ANIMATION_STICK = {IMG_STICK};
	public final static String[] ANIMATION_RIGHT_KEY = {IMG_RIGHT_KEY_1, IMG_RIGHT_KEY_2, IMG_RIGHT_KEY_3, IMG_RIGHT_KEY_4, IMG_RIGHT_KEY_5, IMG_RIGHT_KEY_6, 
																		IMG_RIGHT_KEY_5, IMG_RIGHT_KEY_4, IMG_RIGHT_KEY_3, IMG_RIGHT_KEY_2, };
	public final static String[] ANIMATION_THARVEY = {IMG_THARVEY_1, IMG_THARVEY_2};
	public final static String[] ANIMATION_TO_STICK = {IMG_TO_STICK_1, IMG_TO_STICK_2, IMG_TO_STICK_3, IMG_TO_STICK_4, IMG_TO_STICK_5, IMG_TO_STICK_6, IMG_TO_STICK_5, IMG_TO_STICK_4, IMG_TO_STICK_3, IMG_TO_STICK_2};
	public final static String[] ANIMATION_TRASH = {IMG_TRASH};
	public final static String[] ANIMATION_UP_KEY = {IMG_UP_KEY_1, IMG_UP_KEY_2, IMG_UP_KEY_3, IMG_UP_KEY_4, IMG_UP_KEY_5, IMG_UP_KEY_6, 
																	IMG_UP_KEY_5, IMG_UP_KEY_4, IMG_UP_KEY_3, IMG_UP_KEY_2};
	
	// Osprey Questions
	
	public final static JLabel OSPREY_1 = new JLabel("How do ospreys like to get their food?");
	public final static JLabel OSPREY_2 = new JLabel("How big are osprey flocks?");
	public final static JLabel OSPREY_3 = new JLabel("Where do ospreys migrate from?");
	public final static JLabel OSPREY_4 = new JLabel("What is the osprey's favorite food?");
	public final static JLabel OSPREY_5 = new JLabel("Where do ospreys like to live?");
	public final static JLabel OSPREY_6 = new JLabel("What do ospreys usually eat?");
	public final static JLabel OSPREY_7 = new JLabel("How many different mates will an osprey have in its life?");
	public final static JLabel OSPREY_8 = new JLabel("How long does an osprey usually live?");
	public final static JLabel OSPREY_9 = new JLabel("How much does an osprey weigh?");
	public final static JLabel OSPREY_10 = new JLabel("Where do ospreys like to live?");
	public final static JLabel OSPREY_LAST = new JLabel("Where would you like to make your nest?");
	public final static JLabel OSPREY_TUTORIAL = new JLabel("If you hit a crab, a quiz like this will pop up!");
	
	// Osprey right answers
	
	public final static JButton OSPREY_CORRECT1 = new JButton("By diving into water");
	public final static JButton OSPREY_CORRECT2 = new JButton("Ospreys usually don't travel in flocks");
	public final static JButton OSPREY_CORRECT3 = new JButton("Central and South America");
	public final static JButton OSPREY_CORRECT4 = new JButton("Fish");
	public final static JButton OSPREY_CORRECT5 = new JButton("Near water (like the Delaware Estuary!)");
	public final static JButton OSPREY_CORRECT6 = new JButton("Fish");
	public final static JButton OSPREY_CORRECT7 = new JButton("Only one!");
	public final static JButton OSPREY_CORRECT8 = new JButton("10-15 years");
	public final static JButton OSPREY_CORRECT9 = new JButton("3-5 pounds");
	public final static JButton OSPREY_CORRECT10 = new JButton("Near water (like the Delaware Estuary!)");
	public final static JButton OSPREY_LAST_RIGHT = new JButton("Up high off the ground");
	public final static JButton OSPREY_TUTORIAL_RIGHT = new JButton("you understand!");
	
	// Osprey Wrong answers
	
	public final static JButton OSPREY_INCORRECT1 = new JButton("By hiding and catching prey by surprise");
	public final static JButton OSPREY_INCORRECT2 = new JButton("20 birds");
	public final static JButton OSPREY_INCORRECT3 = new JButton("Europe");
	public final static JButton OSPREY_INCORRECT4 = new JButton("Owl");
	public final static JButton OSPREY_INCORRECT5 = new JButton("In the desert (they don't like water!)");
	public final static JButton OSPREY_INCORRECT6 = new JButton("Bobcats");
	public final static JButton OSPREY_INCORRECT7 = new JButton("Five");
	public final static JButton OSPREY_INCORRECT8 = new JButton("One year");
	public final static JButton OSPREY_INCORRECT9 = new JButton("10 pounds");
	public final static JButton OSPREY_INCORRECT10 = new JButton("The desert");
	public final static JButton OSPREY_LAST_INCORRECT = new JButton("Low down by the ground");
	public final static JButton OSPREY_TUTORIAL_INCORRECT = new JButton("you understand!");
	
	// Osprey moreWrong answers
	

	public final static JButton OSPREY_WRONG1 = new JButton("Ospreys do not eat food");
	public final static JButton OSPREY_WRONG2 = new JButton("1 million birds");
	public final static JButton OSPREY_WRONG3 = new JButton("Antartica");
	public final static JButton OSPREY_WRONG4 = new JButton("Bobcat");
	public final static JButton OSPREY_WRONG5 = new JButton("in the city (they love people!)");
	public final static JButton OSPREY_WRONG6 = new JButton("Cheetahs");
	public final static JButton OSPREY_WRONG7 = new JButton("Thirty");
	public final static JButton OSPREY_WRONG8 = new JButton("50 years");
	public final static JButton OSPREY_WRONG9 = new JButton("1 pound");
	public final static JButton OSPREY_WRONG10 = new JButton("in the mountains");
	public final static JButton OSPREY_LAST_WRONG = new JButton("Osprey don't make nests");
	public final static JButton OSPREY_TUTORIAL_WRONG = new JButton("you understand!");	
	
	
	// Clapper Rail Questions
	
	public final static JLabel CR_1 = new JLabel("What is the clapper rail's favorite food?");
	public final static JLabel CR_2 = new JLabel("Where do clapper rails like to make their nest?");
	public final static JLabel CR_3 = new JLabel("Where do clapper rails migrate to?");
	public final static JLabel CR_4 = new JLabel("Where do clapper rails like to live?");
	public final static JLabel CR_5 = new JLabel("What is one of the main predators of the clapper rail?");
	public final static JLabel CR_6 = new JLabel("What is the biggest threat to the clapper rail species?");
	public final static JLabel CR_7 = new JLabel("Where do clapper rails like to live?");
	public final static JLabel CR_8 = new JLabel("How many mates does the clapper rail have during breeding season?");
	public final static JLabel CR_9 = new JLabel("What color are the feathers of the clapper rail?");
	public final static JLabel CR_10 = new JLabel("When is the clapper rail's nesting season?");
	  
	// Clapper Rail Correct
	
	public final static JButton CR_CORRECT1 = new JButton("Crab");
	public final static JButton CR_CORRECT2 = new JButton("Hidden in bushes or tall grass");
	public final static JButton CR_CORRECT3 = new JButton("They don't migrate!");
	public final static JButton CR_CORRECT4 = new JButton("In swampy areas (like at the Delaware Estuary!)");
	public final static JButton CR_CORRECT5 = new JButton("The red fox");
	public final static JButton CR_CORRECT6 = new JButton("Habitat loss");
	public final static JButton CR_CORRECT7 = new JButton("Swamps (like at the Delaware Estuary!)");
	public final static JButton CR_CORRECT8 = new JButton("Only one!");
	public final static JButton CR_CORRECT9 = new JButton("Brown, gray");
	public final static JButton CR_CORRECT10 = new JButton("From March to June");
	
	
	// Clapper Rail incorrect
	
	public final static JButton CR_INCORRECT1 = new JButton("Snake");
	public final static JButton CR_INCORRECT2 = new JButton("in water");
	public final static JButton CR_INCORRECT3 = new JButton("South America");
	public final static JButton CR_INCORRECT4 = new JButton("In the mountains");
	public final static JButton CR_INCORRECT5 = new JButton("Fish");
	public final static JButton CR_INCORRECT6 = new JButton("Clapper rails don't have any threats.");
	public final static JButton CR_INCORRECT7 = new JButton("Deserts");
	public final static JButton CR_INCORRECT8 = new JButton("Five");
	public final static JButton CR_INCORRECT9 = new JButton("Blue, green");
	public final static JButton CR_INCORRECT10 = new JButton("November to January");
	
	// Clapper Rail moreWrong
	
	public final static JButton CR_WRONG1 = new JButton("Duck");
	public final static JButton CR_WRONG2 = new JButton("Clapper Rails don't make nests");
	public final static JButton CR_WRONG3 = new JButton("Australia");
	public final static JButton CR_WRONG4 = new JButton("In the desert (They love cacti!)");
	public final static JButton CR_WRONG5 = new JButton("Lions");
	public final static JButton CR_WRONG6 = new JButton("Ducks");
	public final static JButton CR_WRONG7 = new JButton("In the ocean");
	public final static JButton CR_WRONG8 = new JButton("Ten");
	public final static JButton CR_WRONG9 = new JButton("Orange, yellow");
	public final static JButton CR_WRONG10 = new JButton("July to October");
	
	// End Screen JButtons
	
	public final static JButton END_SCREEN_OSPREY_CONGRATS = new JButton("Congratulations! You caught your mate!");
	public final static JButton END_SCREEN_CR_CONGRATS = new JButton("You attracted a mate! Congratulations!");
	public final static JButton END_SCREEN_MENU = new JButton(" Press UP ARROW KEY to return to Main Menu");
	
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
