package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.condition.OS;

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
	private int pwrCount = 0;

	/**
	 * saves the speed of the osprey prior to gaining the powerup;
	 */
	private int prevSpeed;

	/**
	 * used for giving set time for collision glows
	 */
	private int collCount = 0;

	private boolean yepItsOkayToMoveTheCloudAgain = false;

	private boolean onlyDoOnce = true;

	public SideScrollModel() {
		o = new Osprey(Constants.OSPREY_STARTX, 150, 50, 50);
		game = new ArrayList<GameObject>();
		game.add(o);
		Model.inTutoral = true;
	}

	/**
	 * takes an ArrayList of GameObjects and moves them while checking for collision
	 * 
	 * @param g
	 * @author Tim Mazzarelli
	 */
	public void updateLocation(ArrayList<GameObject> g) {
		if (Osprey.negHitOs && Osprey.posHitOs) {
			Osprey.negHitOs = false;
			Osprey.posHitOs = false;
			collCount = 0;
			o.imgFileName = Constants.ANIMATION_OSPREY;
		}
		else if (Osprey.negHitOs && !Osprey.posHitOs) {
			if (collCount == 0) {
				collCount += 1;
				o.imgFileName = Constants.ANIMATION_OSPREY_BAD;
			}
			else if (collCount <= 50) {
				collCount += 1;
				o.imgFileName = Constants.ANIMATION_OSPREY_BAD;
			} 
			else{
				collCount = 0;
				Osprey.negHitOs = false;
				o.imgFileName = Constants.ANIMATION_OSPREY;
				/*
				 * if(o.isDiving && o.getySpeed() < 0) { o.imgFileName =
				 * Constants.ANIMATION_OSPREY; }
				 * 
				 * else if(o.isDiving) { //o.imgFileName = Constants.ANIMATION_OSPREY; }
				 * 
				 * else { o.imgFileName = Constants.ANIMATION_OSPREY; }
				 */
			}
		} else if (Osprey.posHitOs && !Osprey.negHitOs) {
			if(Osprey.negHitOs) {
				Osprey.negHitOs = false;
			}
			if (collCount == 0) {
				collCount += 1;
				o.imgFileName = Constants.ANIMATION_OSPREY_GOOD;
			} else if (collCount <= 50) {
				collCount += 1;
				o.imgFileName = Constants.ANIMATION_OSPREY_GOOD;
			} else {
				collCount = 0;
				Osprey.posHitOs = false;
				o.imgFileName = Constants.ANIMATION_OSPREY;
				/*
				 * if (o.isDiving && o.getySpeed() < 0) { o.imgFileName =
				 * Constants.ANIMATION_OSPREY; } else if (o.isDiving) { // o.imgFileName =
				 * Constants.ANIMATION_OSPREY; } else { o.imgFileName =
				 * Constants.ANIMATION_OSPREY; }
				 */
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
				tfish = new TFish(Constants.FRAME_X, (int) (Constants.FRAME_Y * .9), (int) (Constants.FRAME_X * 0.05),
						(int) (Constants.FRAME_Y * 0.05));
				game.add(tfish);
			}

			// Does the aircurrent exist yet?????
			if (tair == null) {
				tair = new AirCurrent(Constants.FRAME_X + 500, 150, 200, 200);
				game.add(tair);
			}

			if (twall1 == null) {
				twall1 = new InvisibleWall(0, 50, 300, 100);
				game.add(twall1);
			}

			if (twall2 == null) {
				twall2 = new InvisibleWall(0, 200, 300, 100);
				game.add(twall2);
			}

			if (tpow == null) {
				tpow = new Powerup(Constants.FRAME_X, (int) (Constants.FRAME_Y * .9), (int) (Constants.FRAME_X * .05),
						(int) (Constants.FRAME_Y * .05));
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
					// System.out.println(tfish + " " + o);
				} else if (tspace == null) {
					tspace = new TutorialObject(300, 300, 483, 110, Constants.ANIMATION_SPACEBAR);
					Osprey.xSpeed = 0;
					game.add(tspace);
				} else if (tfish.hitbox.intersects(o.hitbox.getBounds2D())) {
					System.out.println("hi");
					tfish.visible = false;
					// tfish.hitbox.reset();
					tspace.visible = false;
					tspace = null;

				}

			}

			else if (tpow.visible) {

				if (tpow.hitbox.getBounds2D().getMinX() <= Constants.OSPREY_STARTX) {
					o.setXSpeed(0);
				}

				else if (tspace == null) {
					// o.setXSpeed(0);
					tspace = new TutorialObject(300, 300, 483, 110, Constants.ANIMATION_SPACEBAR);
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
				if (tair.hitbox.getBounds2D().getMinX() > 500) {
					tair.move();
					if (tup == null || tdown == null) {
						tup = new TutorialObject(350, 100, 122, 122, Constants.ANIMATION_UP_KEY);
						tdown = new TutorialObject(350, 200, 122, 122, Constants.ANIMATION_DOWN_KEY);
						game.add(tup);
						game.add(tdown);
						game.remove(twall1);
						game.remove(twall2);
						// System.out.println(tair);
					}
				}
//				else if (tup == null || tdown == null) {
//					tup = new TutorialObject(350, 100, 122, 122, Constants.ANIMATION_UP_KEY);
//					tdown = new TutorialObject(350, 200, 122, 122, Constants.ANIMATION_DOWN_KEY);
//					game.add(tup);
//					game.add(tdown);
//					game.remove(twall1);
//					game.remove(twall2);
//				}
				else if (!(o.hitbox.getBounds2D().getMinY() > tair.hitbox.getBounds2D().getMaxY()
						|| o.hitbox.getBounds2D().getMaxY() < tair.hitbox.getBounds2D().getMinY())) {

				} else if (tair.hitbox.getBounds2D().getMaxX() > 40) {
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
				if (tair.visible == false && tfish.visible == false && tpow.visible == false) {
					o.setXSpeed(-10);
					Model.inTutoral = false;
					this.postTutorial();
				}
			}
		} else {
			ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
			for (GameObject a : g) {
				a.move();
				a.collision(g);
				if (a.removeObject())
					toRemove.add(a);
				// if (a instanceof Fish) System.out.println(a.hitbox.getBounds2D());
			}
			g.removeAll(toRemove);
			if (Quiz.correct) {
				if (pwrCount == 0) {
					prevSpeed = o.getXSpeed();
					pwrCount += 1;
					o.setXSpeed(Constants.POWERUP_SPEED);
				} else if (pwrCount <= Constants.POWERUP_DURATION) {
					pwrCount += 1;
					o.setXSpeed(Constants.POWERUP_SPEED);
				} else {
					Quiz.correct = false;
					o.setXSpeed(prevSpeed);
					pwrCount = 0;
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
		game.add(new Background(0, 0, Constants.FRAME_X, Constants.FRAME_Y));
		game.add(o);
		game.add(new InvisibleWall(0, (int) (Constants.FRAME_Y * .60), Constants.FRAME_X, 50));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see GameFiles.Model#postTutorial()
	 */
	@Override
	protected void postTutorial() {
		game.add(new Fish(Constants.FRAME_X + 100, (int) (Constants.FRAME_Y * 0.9), (int) (Constants.FRAME_X * 0.05),
				(int) (Constants.FRAME_Y * 0.05)));
		game.add(new Fish(Constants.FRAME_X + 600, (int) (Constants.FRAME_Y * .88), (int) (Constants.FRAME_X * 0.05),
				(int) (Constants.FRAME_Y * 0.05)));
		game.add(new Fish(Constants.FRAME_X + 1100, (int) (Constants.FRAME_Y * .92), (int) (Constants.FRAME_X * 0.05),
				(int) (Constants.FRAME_Y * 0.05)));
		game.add(new Fish(Constants.FRAME_X + 1500, (int) (Constants.FRAME_Y * 0.91), (int) (Constants.FRAME_X * 0.05),
				(int) (Constants.FRAME_Y * 0.05)));
		game.add(new Fish(Constants.FRAME_X + 1800, (int) (Constants.FRAME_Y * .83), (int) (Constants.FRAME_X * 0.05),
				(int) (Constants.FRAME_Y * 0.05)));
		game.add(new Fish(Constants.FRAME_X + 2100, (int) (Constants.FRAME_Y * .94), (int) (Constants.FRAME_X * 0.05),
				(int) (Constants.FRAME_Y * 0.05)));

		game.add(new Trash(Constants.FRAME_X, (int) (Constants.FRAME_Y * .91), (int) (Constants.FRAME_X * .05),
				(int) (Constants.FRAME_Y * .05)));
		game.add(new Trash(Constants.FRAME_X + 150, (int) (Constants.FRAME_Y * .86), (int) (Constants.FRAME_X * .05),
				(int) (Constants.FRAME_Y * .05)));
		game.add(new Trash(Constants.FRAME_X + 400, (int) (Constants.FRAME_Y * .91), (int) (Constants.FRAME_X * .05),
				(int) (Constants.FRAME_Y * .05)));
		game.add(new Trash(Constants.FRAME_X + 600, (int) (Constants.FRAME_Y * .86), (int) (Constants.FRAME_X * .05),
				(int) (Constants.FRAME_Y * .05)));
		game.add(new Trash(Constants.FRAME_X + 1000, (int) (Constants.FRAME_Y * .91), (int) (Constants.FRAME_X * .05),
				(int) (Constants.FRAME_Y * .05)));
		game.add(new Trash(Constants.FRAME_X + 1300, (int) (Constants.FRAME_Y * .86), (int) (Constants.FRAME_X * .05),
				(int) (Constants.FRAME_Y * .05)));

		game.add(new AirCurrent(Constants.FRAME_X + 50, (int) (Constants.FRAME_Y * .05), 250, 250));
		game.add(new AirCurrent(Constants.FRAME_X + 175, (int) (Constants.FRAME_Y * .25), 200, 200));
		game.add(new AirCurrent(Constants.FRAME_X + 400, (int) (Constants.FRAME_Y * .5), 200, 200));
		game.add(new AirCurrent(Constants.FRAME_X + 620, (int) (Constants.FRAME_Y * .4), 250, 250));
		game.add(new AirCurrent(Constants.FRAME_X + 895, (int) (Constants.FRAME_Y * .23), 200, 200));
		game.add(new AirCurrent(Constants.FRAME_X + 1200, (int) (Constants.FRAME_Y * .55), 200, 200));
		game.add(new AirCurrent(Constants.FRAME_X + 1800, (int) (Constants.FRAME_Y * .4), 250, 250));
		game.add(new AirCurrent(Constants.FRAME_X + 1337, (int) (Constants.FRAME_Y * .15), 200, 200));
		game.add(new AirCurrent(Constants.FRAME_X + 1529, (int) (Constants.FRAME_Y * .58), 200, 200));

		game.add(new Powerup(Constants.FRAME_X * 7, (int) (Constants.FRAME_Y * .93), 50, 50));
		game.add(new Mate(Constants.FRAME_X, 200, 75, 75));// suposed to be 50 50, this is for the memes
	}

	/**
	 * takes a hashset of integers and moves osprey accordingly
	 * 
	 * @param HashSet<Integer> keyPresses
	 * @author andrew thompson
	 */
	@Override
	public void handleMove(HashSet<Integer> keyPresses) {
		if (Quiz.answered == true) {

			keyPresses.clear();
			Quiz.answered = false;
		}
		if (!o.isDiving) {
			o.setYSpeed(0);
			for (Integer key : keyPresses) {
				switch (key) {
				case Constants.UP_KEY_CODE:
					if (!o.isDiving) {
						o.setYSpeed(-o.getMaxYSpeed());
					}
					break;
				case Constants.DOWN_KEY_CODE:
					if (!o.isDiving) {
						o.setYSpeed(o.getMaxYSpeed());
					}

					break;
				case Constants.SPACE_KEY_CODE:
					o.dive();
				}
			}
		}
	}

	/**
	 * 
	 * this method will contain the logic for advancing the icon on the minimap to
	 * show progress during the birds migration
	 */
	public void miniMap(ArrayList<GameObject> g) {
		g.get(0).setY(g.get(0).getY() + 5);
	}

	public static void main(String[] args) {
		new Controller("sideScroll");

	}
}
