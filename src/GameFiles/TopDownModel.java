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
    	xChg = 12*xvel;
    	yChg = 12*yvel;
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
        
        
        if((g.get(1).getX() + 134) <= 0) {
			g.get(1).setX(800);
		}
		if((g.get(1).getY() + 134) <= 0) {
			g.get(1).setY(800);
		}
		if((g.get(1).getX() + 134) >= 800) {
			g.get(1).setX(0);
		}
		if((g.get(1).getY() + 134) >= 800) {
			g.get(1).setY(0);
		}
		
		if (count >= 100) {
        g.get(1).setX(g.get(1).getX()-foxxDirection());
        g.get(1).setY(g.get(1).getY()-foxyDirection());
        count++;
		}
		if (count >= 300) {
	        g.get(1).setX(g.get(1).getX()+foxxDirection());
	        g.get(1).setY(g.get(1).getY()+foxyDirection());
	        count = 0;
			}
		else if (count < 100) {g.get(1).setX(g.get(1).getX()+foxxDirection());
        	g.get(1).setY(g.get(1).getY()+foxyDirection());
        	count++;
		}
		
		
		
		
  
        //System.out.println("updateLocation is using these:");
        //System.out.println(xChg);
        //System.out.println(yChg);
        //System.out.println();
        return collision(g);
    }
    public boolean collision(ArrayList<GameObject> gme) {
    	@SuppressWarnings("unchecked")
		ArrayList<GameObject> safeToRemove = (ArrayList<GameObject>) gme.clone();
    	GameObject tested = safeToRemove.get(0);
    	safeToRemove.remove(tested);
    	for (GameObject g : safeToRemove) {
		if (((g.getX() >= (tested.getX()-20))&&((g.getX() <= (tested.getX()+20))))&&
			((g.getY() >= (tested.getY()-20))&&((g.getY() <= (tested.getY()+20))))) return true;
	    	tested = safeToRemove.get(0);
		safeToRemove.remove(tested);
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
