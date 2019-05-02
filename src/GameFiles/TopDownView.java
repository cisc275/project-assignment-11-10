package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import GameFiles.OspreyMain.DrawPanel;

/**
 * Top down view for clapperrail
 *
 */
public class TopDownView extends View{
    DrawPanel drawPanel = new DrawPanel();
    ArrayList<GameObject> game;
    BufferedImage backUp;
    BufferedImage backUp2;
    JFrame frame;
	
	public TopDownView(ArrayList<GameObject> g) {
		//System.out.println("starting topDownView");
		frame = new JFrame();
		//frame.getContentPane().add(this);
		game = g;
		backUp = g.get(1).getScaledImg();
		backUp2 = g.get(3).getImage();
    	frame.add(drawPanel);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameSize, frameSize);
    	frame.setVisible(true);
    	//pack();
    	//System.out.println("leaving topDownView()");
	}
	
	public void updateView(ArrayList<GameObject> g) {
		//System.out.println("updateView is existing");
		game = g; //may need to be a for each loop
		
			if (((g.get(0).getX() >= (g.get(1).getX()-20))&&((g.get(0).getX() <= (g.get(1).getX()+20))))&&
	    			((g.get(0).getY() >= (g.get(1).getY()-20))&&
	    					((g.get(0).getY() <= (g.get(1).getY()+20))))){
								g.get(1).setImage(null);
			}
			
			if (((g.get(0).getX() >= (g.get(3).getX()-20))&&((g.get(0).getX() <= (g.get(3).getX()+20))))&&
	    			((g.get(0).getY() >= (g.get(3).getY()-20))&&((g.get(0).getY() <= (g.get(3).getY()+20))))){
	    		g.get(3).setImage(null);
	    	}
		
		
		else if (g.get(1).getImage() == null) {
			g.get(1).setImage(backUp);
		}
		
		else if (g.get(0).getY() < 20 & g.get(0).getX() < 150) {
			g.get(3).setImage(backUp2);
		}
		
		drawPanel.repaint();
	}
	
	private class DrawPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			//System.out.println("ahhh good old paintComponent");
			super.paintComponent(g);
			g.setColor(Color.gray);
			
			//System.out.println(game.get(0));
			
			for(GameObject thing : game) {
				//System.out.println("x that paintComponent sees:");
				//System.out.println(thing.getX());
				if(thing instanceof Fox) {
					g.drawImage(thing.getScaledImg(),thing.hitbox.xpoints[0] ,thing.hitbox.ypoints[0] , Color.gray, this);
				}
				else {
					g.drawImage(thing.getImage(),thing.hitbox.xpoints[0] ,thing.hitbox.ypoints[0] , Color.gray, this);
				}
			}
			
			//System.out.println("so like do i leave paintComponent?");
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameSize, frameSize);
		}
	}

	/*
	public void addActionListener(Controller controller) {
		btn.addActionListener(controller);
	}
*/
	//adds controller as key listener
	public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
	
}
