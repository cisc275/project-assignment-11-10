package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

//import org.junit.jupiter.api.condition.OS;

/**
 * all logic for the side scroll game
 *
 */
public class SideScrollModel extends Model {

	/**
	 * osprey used by the Model for key inputs
	 */
	Osprey o;

	/**
	 * to see if the final quiz question was answered correctly
	 */
	static boolean right;

	/**
	 * The tutorial fish
	 */
	private TFish tfish = null;

	/**
	 * The tutorial aircurrent
	 */
	private AirCurrent tair = null;

	/**
	 * Tutorial powerup
	 */
	private Powerup tpow = null;

	/**
	 * The tutorial spacebar
	 */
	private TutorialObject tspace = null;

	/**
	 * The tutorial up
	 */
	private TutorialObject tup = null;

	/**
	 * The tutorial down
	 */
	private TutorialObject tdown = null;

	/**
	 * The upper invisible wall to keep you from moving.
	 */
	private InvisibleWall twall1 = null;

	/**
	 * The lower invisible wall to keep you from moving
	 */
	private InvisibleWall twall2 = null;

	/**
	 * Used to track time for powerup to be active
	 */
	private int pwrCount;

	/**
	 * saves the speed of the osprey prior to gaining the powerup;
	 */
	private int prevSpeed;

	/**
	 * used for giving set time for collision glows
	 */
	public int collCount;
	
	/**
	 * can the cloud move if you aren't in the way
	 */
	private boolean yepItsOkayToMoveTheCloudAgain = false;

	/**
	 * makes sure to not do the cloud again
	 */
	private boolean onlyDoOnce = true;

	/**
	 * creates the SideScrollModel, creates an Osprey, puts into our arraylist of gameobjects
	 * and starts the tutorial
	 */
	public SideScrollModel() {
		o = new Osprey(Constants.OSPREY_STARTX, Constants.OSPREY_STARTY, Constants.OSPREY_WIDTH,
				Constants.OSPREY_HEIGHT);
		game = new ArrayList<GameObject>();
		game.add(o);
		Model.inTutoral = true;
	}

	/**
	 * takes an ArrayList of GameObjects and moves them while checking for collision
	 * handles tutorial now
	 * @param g ArrayList of GameObjects
	 * @author Tim Mazzarelli
	 */
	public void updateLocation(ArrayList<GameObject> g) {
		if(Quiz.correct) {
			o.imgFileName = Constants.ANIMATION_OSPREY_GOOD;
		}
		else if (Osprey.negHitOs && Osprey.posHitOs) {
			Osprey.negHitOs = false;
			Osprey.posHitOs = false;
			collCount = Constants.COLLISION_COUNT_INIT;
			o.imgFileName = Constants.ANIMATION_OSPREY;
		}
		else if (Osprey.negHitOs && !Osprey.posHitOs) {
			if (collCount <= Constants.COLLISION_COUNT_MAX) {
				collCount ++;
				o.imgFileName = Constants.ANIMATION_OSPREY_BAD;
			} 
			else{
				collCount = Constants.COLLISION_COUNT_INIT;
				Osprey.negHitOs = false;
				o.imgFileName = Constants.ANIMATION_OSPREY;
			}
		} else if (Osprey.posHitOs && !Osprey.negHitOs) {
			if(Osprey.negHitOs) {
				Osprey.negHitOs = false;
			}
			if (collCount <= Constants.COLLISION_COUNT_MAX) {
				collCount++;
				o.imgFileName = Constants.ANIMATION_OSPREY_GOOD;
			} else {
				collCount = Constants.COLLISION_COUNT_INIT;
				Osprey.posHitOs = false;
				o.imgFileName = Constants.ANIMATION_OSPREY;
			}
		}
		if (Model.inTutoral) {
			// Movement of the background and bird, this MUST be here.
			for (GameObject a : g) {
				if (!a.equals(tfish) && !a.equals(tair) && !a.equals(tpow)) {
					a.move();
					a.collision(g);
				}
			}

			// Does the fish exist yet????
			if (tfish == null) {
				tfish = new TFish(Constants.FRAME_X, (int) (Constants.FRAME_Y * Constants.TFISH_OFFSET), 
						(int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
						(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT));
				game.add(tfish);
			}

			// Does the aircurrent exist yet?????
			if (tair == null) {
				tair = new AirCurrent(Constants.FRAME_X + Constants.TAIR_OFFSET, 
						(int) (Constants.FRAME_Y * Constants.AR_Y), 
						(int) (Constants.FRAME_X * Constants.AR_WIDTH), 
						(int) (Constants.FRAME_Y * Constants.AR_HEIGHT));
				game.add(tair);
			}

			// does one wall exist
			if (twall1 == null) {
				twall1 = new InvisibleWall(Constants.VIEW_ORIGIN, 
						(int) (Constants.OSPREY_STARTY - (Constants.FRAME_Y * Constants.INVISIBLE_WALL_HEIGHT)), 
						(int) (Constants.FRAME_X * Constants.INVISIBLE_WALL_WIDTH), 
						(int) (Constants.FRAME_Y * Constants.INVISIBLE_WALL_HEIGHT));
				game.add(twall1);
			}

			// does the other wall exist
			if (twall2 == null) {
				twall2 = new InvisibleWall(Constants.VIEW_ORIGIN, 
						Constants.OSPREY_OFFSET + 
						(int) (Constants.OSPREY_STARTY - (Constants.FRAME_Y * Constants.INVISIBLE_WALL_HEIGHT)) 
						+ Constants.OSPREY_HEIGHT +
						(int) (Constants.FRAME_Y * Constants.INVISIBLE_WALL_HEIGHT), 
						(int) (Constants.FRAME_X * Constants.INVISIBLE_WALL_WIDTH),
						(int) (Constants.FRAME_Y * Constants.INVISIBLE_WALL_HEIGHT));
						game.add(twall2);
			}

			if (tpow == null) {
				tpow = new Powerup((int) (Constants.FRAME_X * Constants.POWERUP_TUT_X), 
						(int) (Constants.FRAME_Y * Constants.POWERUP_TUT_Y), 
						(int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
						(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT));
				game.add(tpow);

			}

			// ---------------------------------------
			// If we are still working with the
			// fish, this will run. Once we
			// are done with it, its visibility
			// goes false, and we skip this.
			// ---------------------------------------
			if (tfish.visible) {
				if (tfish.hitbox.getBounds2D().getMinX() > Constants.OSPREY_STARTX) {
					tfish.move();
				} else if (tspace == null) {
					tspace = new TutorialObject((int)(Constants.FRAME_X * Constants.SPACE_X), 
							(int)(Constants.FRAME_Y * Constants.SPACE_Y), 
							(int) (Constants.FRAME_X * Constants.SPACE_WIDTH), 
							(int) (Constants.FRAME_Y * Constants.SPACE_HEIGHT), 
							Constants.ANIMATION_SPACEBAR);
					Osprey.xSpeed = Constants.OSPREY_INIT_XSPEED;
					game.add(tspace);
				} else if (tfish.hitbox.intersects(o.hitbox.getBounds2D())) {
					tfish.visible = false;
					tspace.visible = false;
					tspace = null;

				}

			}

			// ---------------------------------------
			// If we are still working with the
			// powerup, this will run. Once we
			// are done with it, its visibility
			// goes false, and we skip this.
			// ---------------------------------------
			else if (tpow.visible) {
				if (tpow.hitbox.getBounds2D().getMinX() <= Constants.OSPREY_STARTX) {
					o.setXSpeed(Constants.OSPREY_INIT_XSPEED);
				}

				else if (tspace == null) {
					tspace = new TutorialObject((int)(Constants.FRAME_X * Constants.SPACE_X), 
							(int)(Constants.FRAME_Y * Constants.SPACE_Y), 
							(int) (Constants.FRAME_X * Constants.SPACE_WIDTH), 
							(int) (Constants.FRAME_Y * Constants.SPACE_HEIGHT), 
							Constants.ANIMATION_SPACEBAR);
							game.add(tspace);
				} else if (Powerup.power) {
					Powerup.power = false;
					o.setXSpeed(Constants.OSPREY_MAX_SPEED);
					tpow.visible = false;
					tspace.visible = false;
				} else if (tpow.hitbox.getBounds2D().getMinX() > Constants.OSPREY_STARTX) {
					tpow.move();
				}

			}
			// ---------------------------------------
			// If we are still working with the air,
			// this will run. Once done, its
			// visibility will be set to false
			// and we skip it.
			// ---------------------------------------

			else if (tair.visible) {
				if (tair.hitbox.getBounds2D().getMinX() > Constants.OSPREY_STARTX * Constants.AIRCURRENT_STOP) {
					tair.move();
					if (tup == null || tdown == null) {
						tup = new TutorialObject((int) (Constants.FRAME_X * Constants.UPDOWN_X), 
								(int) (Constants.FRAME_Y * Constants.UP_Y), 
								(int) (Constants.FRAME_X * Constants.UPDOWN_WIDTH), 
								(int) (Constants.FRAME_Y * Constants.UPDOWN_HEIGHT), 
								Constants.ANIMATION_UP_KEY);
						tdown = new TutorialObject((int) (Constants.FRAME_X * Constants.UPDOWN_X), 
								(int) (Constants.FRAME_Y * Constants.DOWN_Y), 
								(int) (Constants.FRAME_X * Constants.UPDOWN_WIDTH), 
								(int) (Constants.FRAME_Y * Constants.UPDOWN_HEIGHT), 
								Constants.ANIMATION_DOWN_KEY);
						game.add(tup);
						game.add(tdown);
						game.remove(twall1);
						game.remove(twall2);
					}
				}

				else if (!(o.hitbox.getBounds2D().getMinY() > tair.hitbox.getBounds2D().getMaxY()
						|| o.hitbox.getBounds2D().getMaxY() < tair.hitbox.getBounds2D().getMinY())) {

				} else if (tair.hitbox.getBounds2D().getMaxX() > Constants.VIEW_ORIGIN + Constants.OSPREY_WIDTH) {
					tair.move();
					if (onlyDoOnce) {
						tup.visible = false;
						tdown.visible = false;
						yepItsOkayToMoveTheCloudAgain = true;
						onlyDoOnce = false;
					}
				} else {
					tair.visible = false;
					game.remove(tair);
				}
				// game starts
				if (tair.visible == false && tfish.visible == false && tpow.visible == false) {
					o.setXSpeed(Constants.OSPREY_MIN_SPEED);
					Model.inTutoral = false;
					this.postTutorial();
				}
			}
		}
		else { // actual game handling
			ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
			for (GameObject a : g) {
				a.move();
				a.collision(g);
				if (a.removeObject())
					toRemove.add(a);
			}
			g.removeAll(toRemove);
			if (Quiz.correct) {
				if (pwrCount == Constants.PWR_COUNT_INIT) {
					prevSpeed = Osprey.xSpeed;
					pwrCount ++;
					o.setXSpeed(Constants.POWERUP_SPEED);
				} else if (pwrCount <= Constants.POWERUP_DURATION) {
					pwrCount++;
					o.setXSpeed(Constants.POWERUP_SPEED);
				} else {
					Quiz.correct = false;
					o.setXSpeed(prevSpeed);
					pwrCount = Constants.PWR_COUNT_INIT;
				}
			}
			if (Mate.caughtUp) {
				Model.gameOver = true;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see GameFiles.Model#defaultSetup()
	 */
	@Override
	protected void defaultSetup() {
		game.add(new Background(Constants.VIEW_ORIGIN, Constants.VIEW_ORIGIN, Constants.FRAME_X, Constants.FRAME_Y));
		game.add(o);
		game.add(new InvisibleWall(Constants.VIEW_ORIGIN, 
				(int) (Constants.FRAME_Y * Constants.INVISIBLE_WALL_Y), 
				Constants.FRAME_X, 
				(int) (Constants.FRAME_Y * Constants.INVISIBLE_WALL_HEIGHT)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see GameFiles.Model#postTutorial()
	 */
	@Override
	protected void postTutorial() {
		// adding in all the fish at positions according to screen
		game.add(new Fish(Constants.FRAME_X + Constants.FISH_OFFSET_1, (int) (Constants.FRAME_Y * Constants.FISH_OFFSET_Y_1), (int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT)));
		game.add(new Fish(Constants.FRAME_X + Constants.FISH_OFFSET_2, (int) (Constants.FRAME_Y * Constants.FISH_OFFSET_Y_2), (int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT)));
		game.add(new Fish(Constants.FRAME_X + Constants.FISH_OFFSET_3, (int) (Constants.FRAME_Y * Constants.FISH_OFFSET_Y_3), (int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT)));
		game.add(new Fish(Constants.FRAME_X + Constants.FISH_OFFSET_4, (int) (Constants.FRAME_Y * Constants.FISH_OFFSET_Y_4), (int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT)));
		game.add(new Fish(Constants.FRAME_X + Constants.FISH_OFFSET_5, (int) (Constants.FRAME_Y * Constants.FISH_OFFSET_Y_5), (int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT)));
		game.add(new Fish(Constants.FRAME_X + Constants.FISH_OFFSET_6, (int) (Constants.FRAME_Y * Constants.FISH_OFFSET_Y_6), (int) (Constants.FRAME_X * Constants.FISH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.FISH_WIDTH_HEIGHT)));

		// adding in all the trash at positions according to screen
		game.add(new Trash(Constants.FRAME_X, (int) (Constants.FRAME_Y * Constants.TRASH_OFFSET_Y_1), (int) (Constants.FRAME_X * Constants.TRASH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.TRASH_WIDTH_HEIGHT)));
		game.add(new Trash(Constants.FRAME_X + Constants.TRASH_OFFSET_1, (int) (Constants.FRAME_Y * Constants.TRASH_OFFSET_Y_2), (int) (Constants.FRAME_X * Constants.TRASH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.TRASH_WIDTH_HEIGHT)));
		game.add(new Trash(Constants.FRAME_X + Constants.TRASH_OFFSET_2, (int) (Constants.FRAME_Y * Constants.TRASH_OFFSET_Y_3), (int) (Constants.FRAME_X * Constants.TRASH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.TRASH_WIDTH_HEIGHT)));
		game.add(new Trash(Constants.FRAME_X + Constants.TRASH_OFFSET_3, (int) (Constants.FRAME_Y * Constants.TRASH_OFFSET_Y_4), (int) (Constants.FRAME_X * Constants.TRASH_WIDTH_HEIGHT),
				(int) (Constants.FRAME_Y * Constants.TRASH_WIDTH_HEIGHT)));

		
		// adding in all the Aircurrents at positions according to screen
		game.add(new AirCurrent(Constants.FRAME_X + Constants.AR_OFFSET_X_1, (int) (Constants.FRAME_Y * Constants.AR_OFFSET_Y_1), (int) (Constants.FRAME_X * Constants.AR_WIDTH), (int) (Constants.FRAME_Y * Constants.AR_HEIGHT)));
		game.add(new AirCurrent(Constants.FRAME_X + Constants.AR_OFFSET_X_2, (int) (Constants.FRAME_Y * Constants.AR_OFFSET_Y_2), (int) (Constants.FRAME_X * Constants.AR_WIDTH), (int) (Constants.FRAME_Y * Constants.AR_HEIGHT)));
		game.add(new AirCurrent(Constants.FRAME_X + Constants.AR_OFFSET_X_3, (int) (Constants.FRAME_Y * Constants.AR_OFFSET_Y_3), (int) (Constants.FRAME_X * Constants.AR_WIDTH), (int) (Constants.FRAME_Y * Constants.AR_HEIGHT)));
		game.add(new AirCurrent(Constants.FRAME_X + Constants.AR_OFFSET_X_4, (int) (Constants.FRAME_Y * Constants.AR_OFFSET_Y_4), (int) (Constants.FRAME_X * Constants.AR_WIDTH), (int) (Constants.FRAME_Y * Constants.AR_HEIGHT)));
		game.add(new AirCurrent(Constants.FRAME_X + Constants.AR_OFFSET_X_5, (int) (Constants.FRAME_Y * Constants.AR_OFFSET_Y_5), (int) (Constants.FRAME_X * Constants.AR_WIDTH), (int) (Constants.FRAME_Y * Constants.AR_HEIGHT)));
		game.add(new AirCurrent(Constants.FRAME_X + Constants.AR_OFFSET_X_6, (int) (Constants.FRAME_Y * Constants.AR_OFFSET_Y_6), (int) (Constants.FRAME_X * Constants.AR_WIDTH), (int) (Constants.FRAME_Y * Constants.AR_HEIGHT)));
		game.add(new AirCurrent(Constants.FRAME_X + Constants.AR_OFFSET_X_7, (int) (Constants.FRAME_Y * Constants.AR_OFFSET_Y_7), (int) (Constants.FRAME_X * Constants.AR_WIDTH), (int) (Constants.FRAME_Y * Constants.AR_HEIGHT)));

		// // adding in powerup at position according to screen
		game.add(new Powerup(Constants.FRAME_X * Constants.POWERUP_OFFSET, 
				(int) (Constants.FRAME_Y * Constants.POWERUP_Y), 
				(int) (Constants.FRAME_X * Constants.POWERUP_WIDTH), 
				(int) (Constants.FRAME_Y * Constants.POWERUP_HEIGHT)));
		
		// adding in the Mate at positions according to screen
		game.add(new Mate(Constants.FRAME_X, 
				(int) (Constants.FRAME_Y * Constants.MATE_Y), 
				(int)(Constants.FRAME_X * Constants.MATE_WIDTH), 
				(int) (Constants.FRAME_Y * Constants.MATE_HEIGHT)));
	}

	/**
	 * takes a hashset of integers and moves osprey accordingly
	 * @param keyPresses HashSet of keyPresses
	 * @author andrew thompson
	 */
	@Override
	public void handleMove(HashSet<Integer> keyPresses) {
		if (Quiz.answered == true) {

			keyPresses.clear();
			Quiz.answered = false;
		}
		if (!o.getisDiving()) {
			o.setySpeed(0);
			for (Integer key : keyPresses) {
				switch (key) {
				case Constants.UP_KEY_CODE:
					if (!o.getisDiving()) {
						o.setySpeed(-Constants.OSPREY_MAX_YSPEED);
					}
					break;
				case Constants.DOWN_KEY_CODE:
					if (!o.getisDiving()) {
						o.setySpeed(Constants.OSPREY_MAX_YSPEED);
					}

					break;
				case Constants.SPACE_KEY_CODE:
					o.dive();
				}
			}
		}
	}

	public static void main(String[] args) {
		new Controller(Constants.SIDE_SCROLL_STRING);

	}
}
