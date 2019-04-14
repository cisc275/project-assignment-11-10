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


public class OspreyMain extends JFrame {
	
    BufferedImage bird; 
    BufferedImage fox; 
    BufferedImage bush1; 
    BufferedImage fox_hold; //holds copy of fox to bring it back when outside of collision range
	int xloc = 100;
    int yloc = 100;
    int xIncr = 0;
    int yIncr = 0;
    final int picSize = 500; //don't think this will be necessary
    final int frameStartSize = 800;
    final int drawDelay = 30; //msec (don't know if this necessary)
    
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;
    
    public OspreyMain() {
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
    			if(e.getKeyCode() == 39) { //right arrow key
    				//System.out.println("right arrow key has been pressed");
    				xIncr = 5;
    			}
    			else if(e.getKeyCode() == 37) { //left arrow key
    				xIncr = -5;
    			}
    			else if(e.getKeyCode() == 38) { //up arrow key
    				yIncr = -5;
    			}
    			else if(e.getKeyCode() == 40) { //down arrow key
    				yIncr = 5;
    			}
    		}

    		public void keyReleased(KeyEvent e) {
    			//System.out.println("released");
    			//System.out.println(xloc + " by " + yloc);
    			xIncr = 0;
    			yIncr = 0;
    		}
    	});
    	add(drawPanel);
    	bird = createImage();
    	fox = createImage2();
    	fox_hold = createImage2();
    	bush1 = createImage3();

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
	    	//picNum = (picNum + 1);
			if(((xloc >= 380)&&(xloc <= 420))&&((yloc >= 380)&&(yloc <= 420))) {
				//System.out.println("collision");
				fox = null;
			}
			else if ((fox == null)&&(!(((xloc >= 380)&&(xloc <= 420))&&((yloc >= 380)&&(yloc <= 420))))) {
				fox = fox_hold;
			}
	    	g.drawImage(bird, xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	    	g.drawImage(fox, 400, 400, Color.gray, this);
	    	g.drawImage(bush1, 150, 450, Color.gray, this);
	    	g.drawImage(bush1, 200, 200, Color.gray, this);
	    	g.drawImage(bush1, 600, 600, Color.gray, this);

		}

		public Dimension getPreferredSize() {
			return new Dimension(frameStartSize, frameStartSize);
		}
	}
    
    public static void main(String[] args) {
    	
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				OspreyMain test = new OspreyMain();
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
