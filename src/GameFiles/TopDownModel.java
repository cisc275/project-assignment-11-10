package GameFiles;
import java.util.ArrayList;
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
    
    public TopDownModel(int x, int y, int imgW, int imgH) {
    	imgWidth = x;
		imgHeight = y;
		frameWidth = imgW;
		frameHeight = imgH;
    }
    public void setVel(int xvel, int yvel) {
    	xChg = 12*xvel;
    	yChg = 12*yvel;
    	System.out.println();
    }
    public void updateLocation() {
    	if(xloc+xChg > (imgWidth - frameWidth) || xloc+xChg < 0) {
        	xChg = 0;
        	
        }
        if(yloc+yChg > (imgHeight - frameHeight) || yloc+yChg < 0) {
        	yChg = 0;
        }
        xloc+=xChg;
        yloc+=yChg;
    }
	/**
	 * 
	 * @param args
	 * runs the top down
	 */
	public static void main(String[] args) {
	}
	public int getX() {
		return xloc;
	}
	public int getY() {
		return yloc;
	}
}
