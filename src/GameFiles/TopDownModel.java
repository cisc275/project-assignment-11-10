package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
/**
 * Model clapperrail game
 *
 */
public class TopDownModel extends Model {
	int xloc = 0;
    int yloc = 0;
    int xChg = 0;
    int yChg = 0;
    int imgWidth = 0;
    int imgHeight = 0;
    int frameWidth = 0;
    int frameHeight = 0;

    int count = 0;
    
    final int LEFT_BOUND = 0;
    final int BOUND_OFFSET = 134;
    final int RIGHT_BOUND = 800;
    final int VELOCITY_MULTIPLYER = 12;
    final int CLOCK_TICK_CHECK = 100;
    
	//ArrayList<GameObject> game;
    
    public int foxxDirection() {
    	Random rand = new Random();
    	return rand.nextInt(5);
    }
    
    public int foxyDirection() {
    	Random rand = new Random();
    	return rand.nextInt(5);
    }


    
    public TopDownModel(int x, int y, int imgW, int imgH) {
    	imgWidth = x;
		imgHeight = y;
		frameWidth = imgW;
		frameHeight = imgH;
		game = new ArrayList<GameObject>();
    }
    public void setVel(int xvel, int yvel) {
    	xChg = VELOCITY_MULTIPLYER*xvel;
    	yChg = VELOCITY_MULTIPLYER*yvel;
    	System.out.println();
    }
    public boolean updateLocation(ArrayList<GameObject> g) {
    	/*
    	if(xloc+xChg > (imgWidth - frameWidth) || xloc+xChg < 0) {
    		System.out.println("WHY");
        	xChg = 0;
        	
        }
        if(yloc+yChg > (imgHeight - frameHeight) || yloc+yChg < 0) {
        	yChg = 0;
        }
        */
        //xloc+=xChg;
        //yloc+=yChg;
        g.get(0).setX(g.get(0).getX()+xChg);
        g.get(0).setY(g.get(0).getY()+yChg);
        g.get(0).getHitBox().translate(xChg, yChg);;
        
        if((g.get(1).getX() + BOUND_OFFSET) <= LEFT_BOUND) {
			g.get(1).setX(RIGHT_BOUND);
		}
		if((g.get(1).getY() + BOUND_OFFSET) <= LEFT_BOUND) {
			g.get(1).setY(RIGHT_BOUND);
		}
		if((g.get(1).getX() + BOUND_OFFSET) >= RIGHT_BOUND) {
			g.get(1).setX(LEFT_BOUND);
		}
		if((g.get(1).getY() + BOUND_OFFSET) >= RIGHT_BOUND) {
			g.get(1).setY(LEFT_BOUND);
		}
		
		if (count >= CLOCK_TICK_CHECK) {
        g.get(1).setX(g.get(1).getX()-foxxDirection());
        g.get(1).setY(g.get(1).getY()-foxyDirection());
        g.get(1).getHitBox().translate(-foxxDirection(), -foxyDirection());
        count++;
		}
		if (count >= 3*CLOCK_TICK_CHECK) {
	        g.get(1).setX(g.get(1).getX()+foxxDirection());
	        g.get(1).setY(g.get(1).getY()+foxyDirection());
	        count = 0;
	        g.get(1).getHitBox().translate(foxxDirection(), foxyDirection());
			}
		else if (count < CLOCK_TICK_CHECK) {g.get(1).setX(g.get(1).getX()+foxxDirection());
        	g.get(1).setY(g.get(1).getY()+foxyDirection());
        	count++;
        	g.get(1).getHitBox().translate(foxxDirection(), foxyDirection());
		}
		
		
		
		
  
        //System.out.println("updateLocation is using these:");
        //System.out.println(xChg);
        //System.out.println(yChg);
        //System.out.println();
        this.collision(g);
		return false;
    }
    public boolean collision(ArrayList<GameObject> gme) {
    	for (int k = 0; k < gme.size(); k ++) {
    		if (count % 1 == 0 && (gme.get(k).getType() == Type.FOX)) System.out.println(gme.get(k) + " vs Polygon " + gme.get(k).getHitBox().getBounds2D());
    		for (int j = 0; j < gme.size(); j ++) {
    			if (k != j) { //Entering the dodgy bit.
    				if (k > j && gme.get(k).getHitBox().intersects(gme.get(j).getHitBox().getBounds2D())) {
    					System.out.println("Collision found between " + k + " and " + j);
    				}
    			} //Exiting the dogey bit
    		}
    		
    	}
	    return false;
    }	
    
  
	/**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
		Controller theControl = new Controller("topDown");
		theControl.topDownStart();
	}
	public BufferedImage createImage(){
		//System.out.println("Start of createImage");
    	BufferedImage bufferedImage;
    	//System.out.println("Im about to try");
    	try {
    		//System.out.println("im trying");
    		bufferedImage = ImageIO.read(new File("red_square.png"));
    		
    		//System.out.println("I succeded");
    		return bufferedImage;
    	} catch (IOException e) {
    		//System.out.println("im being caught");
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public BufferedImage createImage2(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("blue_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	public BufferedImage createImage3(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("green_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	public BufferedImage createImage4(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("brown_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	public int getXloc() {
		return xloc;
	}
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}
	public int getYloc() {
		return yloc;
	}
	public void setYloc(int yloc) {
		this.yloc = yloc;
	}
	public int getxChg() {
		return xChg;
	}
	public void setxChg(int xChg) {
		this.xChg = xChg;
	}
	public int getyChg() {
		return yChg;
	}
	public void setyChg(int yChg) {
		this.yChg = yChg;
	}
	public int getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}
	public int getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
	public int getFrameWidth() {
		return frameWidth;
	}
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}
	public int getFrameHeight() {
		return frameHeight;
	}
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}
}
