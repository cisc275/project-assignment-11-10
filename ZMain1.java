package testing;

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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import GameFiles.AirCurrent;
import GameFiles.Fish;


public class ZMain1 extends JFrame {
	
		BufferedImage bird; 
	    BufferedImage fish; //blue
	    BufferedImage trash;//green 
	    BufferedImage ac;
	    //BufferedImage fox_hold; //holds copy of fox to bring it back when outside of collision range
	    
	    
	    ZOsprey1 o;
	    ZFish1 f;
	    ZTrash1 t;
	    ZAirCurrent a;
	   
	    
	    final int picSize = 500; //don't think this will be necessary
	    final int frameStartSize = 800;
	    final int drawDelay = 30; //msec (don't know if this necessary)
	    
	    DrawPanel drawPanel = new DrawPanel();
	    Action drawAction;
	    
	    public ZMain1(ZOsprey1 o, ZFish1 f, ZTrash1 t, ZAirCurrent a) {
	    	this.o = o;
	    	this.f = f;
	    	this.t = t;
	    	this.a = a;
	    	drawAction = new AbstractAction(){
	    		public void actionPerformed(ActionEvent e){
	    			drawPanel.repaint();
	    		}
	    	};
	    	this.addKeyListener(new KeyListener() {
	    		Timer time;

	    		
	    		public void keyTyped(KeyEvent e) {
	    		
	    		}

	    		public void keyPressed(KeyEvent e) {
	    			
	    			if((e.getKeyCode() == 38) && (o.isDiving == false)) { //up arrow key
	    				o.ySpeed = -5;
	    			}
	    			else if((e.getKeyCode() == 40) && (o.isDiving == false)) { //down arrow key
	    				o.ySpeed = 5;
	    				
	    			}
	    			else if ((e.getKeyCode() == 32) && (o.isDiving == false)) {
	    				o.dive();
	    				
	    				
	    			}
	    		}

	    		public void keyReleased(KeyEvent e) {
	    			//System.out.println("released");
	    			//System.out.println(xloc + " by " + yloc);
	    			
	    			if (!o.isDiving) {
	        			o.ySpeed = 0;
	    			}
	    		}
	    	});
	    	add(drawPanel);
	    	bird = createImage();
	    	fish = createImage2();
	    	trash = createImage3();
	    	ac = createImage4();

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
				o.move();
				f.move();
				t.move();
				a.move();
				o.collision(f, t, a);
				
				
				g.setClip(f);
				g.drawImage(fish, f.xpoints[0], f.ypoints[0], this);
		    	g.setClip(t);
		    	g.drawImage(trash, t.xpoints[0], t.ypoints[0], this);
		    	g.setClip(o);
		    	g.drawImage(bird, o.xpoints[0],o.ypoints[0], this);
		    	
		    	g.setClip(a);
		    	g.drawImage(ac, a.xpoints[0], a.ypoints[0], this);
		    	
		    	

		    	
			}

			public Dimension getPreferredSize() {
				return new Dimension(frameStartSize, frameStartSize);
			}
		}
	    
	    public static void main(String[] args) {
	    	EventQueue.invokeLater(new Runnable(){
				public void run(){
					ZMain1 test = new ZMain1(new ZOsprey1(100, -5, false), new ZFish1(600), 
							new ZTrash1(700), new ZAirCurrent(300));
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
		private BufferedImage createImage4(){
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
	}