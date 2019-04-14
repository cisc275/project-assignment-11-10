package GameFiles;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ClapperRailMain extends JFrame {
	BufferedImage bird; 
    BufferedImage fish; //blue
    BufferedImage trash;//green 

    //BufferedImage fox_hold; //holds copy of fox to bring it back when outside of collision range
    int currY;
	int xloc = 200;
    int yloc = 200;
    int xIncr = 0;
    int yIncr = 0;
    boolean isDiving = false;
    
    int fish_xloc = 700;
    int trash1_xloc = 300;
    int trash2_xloc = 500;
    int trash3_xloc = 100;
    
    int fish_yloc = 550;
    int trash1_yloc = 550;
    int trash2_yloc = 550;
    int trash3_yloc = 550;
    
    final int picSize = 500; //don't think this will be necessary
    final int frameStartSize = 800;
    final int drawDelay = 30; //msec (don't know if this necessary)
    
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;
    
    public ClapperRailMain() {
    	drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			drawPanel.repaint();
    		}
    	};
    	this.addKeyListener(new KeyListener() {
    		Timer time;

    		
    		public void keyTyped(KeyEvent e) {
    			// TODO Auto-generated method stub
    			//System.out.println("typed");
    			 
    		}

    		public void keyPressed(KeyEvent e) {
    			//System.out.println("pressed");
    			//SHOULDNT BE NEEDED
    			/*
    			if(e.getKeyCode() == 39) { //right arrow key
    				//System.out.println("right arrow key has been pressed");
    				xIncr = 5;
    			}
    			*/
    			/*
    			else if(e.getKeyCode() == 37) { //left arrow key
    				xIncr = -5;
    			}
    			*/
    			if((e.getKeyCode() == 38) && (isDiving == false)) { //up arrow key
    				yIncr = -5;
    			}
    			else if((e.getKeyCode() == 40) && (isDiving == false)) { //down arrow key
    				yIncr = 5;
    			}
    			else if ((e.getKeyCode() == 32) && (isDiving == false)) {
    				System.out.println("space");
    				isDiving = true;
    				yIncr = 50;
    				currY = yloc;
    				yloc += yIncr;
    			}
    		}

    		public void keyReleased(KeyEvent e) {
    			//System.out.println("released");
    			//System.out.println(xloc + " by " + yloc);
    			xIncr = 0;
    			if (!isDiving) {
        			yIncr = 0;
    			}
    		}
    	});
    	add(drawPanel);
    	bird = createImage();
    	fish = createImage2();
    	//fox_hold = createImage2();
    	trash = createImage3();

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(frameStartSize, frameStartSize);
    	setVisible(true);
    	pack();
    }
    
    @SuppressWarnings("serial")
	private class DrawPanel extends JPanel {
    	//int picNum = 0;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			fish_xloc-=1;
			trash1_xloc-=1;
			trash2_xloc-=1;
			trash3_xloc-=1;
			if((fish_xloc + 134) <= 0) {
				fish_xloc = 800;
			}
			if((trash1_xloc + 134) <= 0) {
				trash1_xloc = 800;
			}
			if((trash2_xloc + 134) <= 0) {
				trash2_xloc = 800;
			}
			if((trash3_xloc + 134) <= 0) {
				trash3_xloc = 800;
			}
			if (yloc >= 550) {
				yIncr = -50;
			}
			if ((yloc == currY) && (isDiving == true)) {
				yIncr = 0;
				isDiving = !isDiving;
			}
	    	//picNum = (picNum + 1);
			//WILL BE USED FOR DIVE 
			/*
			if(((xloc >= 380)&&(xloc <= 420))&&((yloc >= 380)&&(yloc <= 420))) {
				//System.out.println("collision");
				fox = null;
			}
			else if ((fox == null)&&(!(((xloc >= 380)&&(xloc <= 420))&&((yloc >= 380)&&(yloc <= 420))))) {
				fox = fox_hold;
			}
			*/
	    	g.drawImage(bird, xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	    	g.drawImage(fish,fish_xloc, fish_yloc, Color.gray, this);
	    	g.drawImage(trash, trash1_xloc, trash1_yloc, Color.gray, this);
	    	g.drawImage(trash, trash2_xloc, trash2_yloc, Color.gray, this);
	    	g.drawImage(trash, trash3_xloc, trash3_yloc, Color.gray, this);

		}

		public Dimension getPreferredSize() {
			return new Dimension(frameStartSize, frameStartSize);
		}
	}
    
    public static void main(String[] args) {
    	
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				ClapperRailMain test = new ClapperRailMain();
				Timer t = new Timer(test.drawDelay, test.drawAction);
				t.start();
			}
		});
		
	}
    
	private BufferedImage createImage(){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("red_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
	
	private BufferedImage createImage2(){
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
	private BufferedImage createImage3(){
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
}


