package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import GameFiles.Quiz.keyAction;

public class LoseScreen extends JDialog implements KeyListener {

	Image image;
	JLabel tryAgain;
	JButton menu;
	JButton restart;
	JPanel p;
	String game;
	int offset = 0;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * creates a new window with 1 labels and 2 JButtons The new window is a
	 * keyListener
	 */
	public LoseScreen(String game) {
			
		
		this.game = game;
		if(game.equals(Constants.TOP_DOWN_STRING)) {
			p = new DrawPanel();
			p.setOpaque(true);
			p.setBackground(Color.GREEN);
			p.setLayout(new BoxLayout(p, 3));
			this.setResizable(false);
			this.setModal(true);
			tryAgain = new JLabel("Oh no! You ran out of Lives!", SwingConstants.CENTER);
			tryAgain.setOpaque(false);
			tryAgain.setFont(new Font("Serif", Font.BOLD, 30));
			tryAgain.setMinimumSize(new Dimension(550, 100));
			tryAgain.setPreferredSize(new Dimension(550, 100));
			tryAgain.setMaximumSize(new Dimension(550, 100));
			tryAgain.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			tryAgain.setAlignmentY(JLabel.TOP_ALIGNMENT);

			menu = new JButton("Press LEFT ARROW KEY to return to Selection Screen");
			menu.setMinimumSize(new Dimension(1000, 100));
			menu.setPreferredSize(new Dimension(1000, 100));
			menu.setMaximumSize(new Dimension(1000, 100));
			menu.setFocusPainted(false);
			menu.setBackground(Color.WHITE);
			menu.setAlignmentX(JButton.CENTER_ALIGNMENT);
			menu.setAlignmentY(TOP_ALIGNMENT);
			menu.setOpaque(false);
			menu.setFont(new Font("Serif", Font.BOLD, 30));
			menu.setBorderPainted(false);

			restart = new JButton("Press RIGHT ARROW KEY to Try Again");
			restart.setMinimumSize(new Dimension(1000, 100));
			restart.setPreferredSize(new Dimension(1000, 100));
			restart.setMaximumSize(new Dimension(1000, 100));
			restart.setFocusPainted(false);
			restart.setBackground(Color.GRAY);
			restart.setAlignmentX(JButton.CENTER_ALIGNMENT);
			restart.setAlignmentY(TOP_ALIGNMENT);
			restart.setOpaque(false);
			restart.setFont(new Font("Serif", Font.BOLD, 30));
			restart.setBorderPainted(false);

			p.add(tryAgain);
			p.add(menu);
			p.add(restart);

			menu.addKeyListener(this);
			restart.addKeyListener(this);
			this.setUndecorated(true);
			this.add(p);
			this.setSize(screenSize);
			this.setVisible(true);
		}
		else if(game.equals(Constants.SIDE_SCROLL_STRING)) {
			p = new DrawPanel();
			p.setOpaque(true);
			p.setLayout(new GridLayout(0,1));
			this.setResizable(false);
			this.setModal(true);
			tryAgain = new JLabel("Wrong! Ospreys build their nests on high poles!", SwingConstants.CENTER);
			tryAgain.setOpaque(false);
			tryAgain.setFont(new Font("Serif", Font.BOLD, 30));
			tryAgain.setMinimumSize(new Dimension(550, 50));
			tryAgain.setPreferredSize(new Dimension(550, 50));
			tryAgain.setMaximumSize(new Dimension(1550, 50));
			tryAgain.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			tryAgain.setAlignmentY(JLabel.TOP_ALIGNMENT);

			menu = new JButton("Press LEFT ARROW KEY to return to Main Menu");
			menu.setMinimumSize(new Dimension(500, 50));
			menu.setPreferredSize(new Dimension(500, 50));
			menu.setMaximumSize(new Dimension(500, 50));
			menu.setFocusPainted(false);
			menu.setBackground(Color.WHITE);
			menu.setAlignmentX(JButton.CENTER_ALIGNMENT);
			menu.setAlignmentY(TOP_ALIGNMENT);
			menu.setOpaque(false);
			menu.setFont(new Font("Serif", Font.BOLD, 30));
			menu.setBorderPainted(false);

			restart = new JButton("Press RIGHT ARROW KEY to Try Again");
			restart.setMinimumSize(new Dimension(1000, 100));
			restart.setPreferredSize(new Dimension(1000, 100));
			restart.setMaximumSize(new Dimension(1000, 100));
			restart.setFocusPainted(false);
			restart.setBackground(Color.GRAY);
			restart.setAlignmentX(JButton.CENTER_ALIGNMENT);
			restart.setAlignmentY(TOP_ALIGNMENT);
			restart.setOpaque(false);
			restart.setFont(new Font("Serif", Font.BOLD, 30));
			restart.setBorderPainted(false);
			
			p.add(new JLabel());
			p.add(tryAgain);
			p.add(menu);
			p.add(restart);
			p.add(new JLabel());
			p.add(new JLabel());
			p.add(new JLabel());
			p.add(new JLabel());
			

			menu.addKeyListener(this);
			restart.addKeyListener(this);
			this.setUndecorated(true);
			this.add(p);
			this.setSize(screenSize);
			this.setVisible(true);
		}
		
		
	}
	
	private class DrawPanel extends JPanel{

		private BufferedImage createImage(){
			BufferedImage bufferedImage;
	    	try {
	    		if (Mate.caughtUp) {
	    			bufferedImage = ImageIO.read(new File("img/TIM PICK ME PLEASE.png"));
		    		return bufferedImage;
	    		}
	    		if (game.equals(Constants.SIDE_SCROLL_STRING)){
	    		bufferedImage = ImageIO.read(new File(Constants.IMG_BACKGROUND_OSPREY_QUIZ));
	    		return bufferedImage;
	    		}
	    		if (game.equals(Constants.TOP_DOWN_STRING)) {
	    		bufferedImage = ImageIO.read(new File(Constants.IMG_CR_BACKGROUND_QUIZ));
	    		return bufferedImage;
	    		}
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}	
	    	return null;
		}
			
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			image = createImage();
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	
	}
	}

	/**
	 * if menu clicked, returns to the selection screen, if restart is clicked, new
	 * CR game is started
	 */
	private class keyAction extends AbstractAction{
		  @Override 
		  public void actionPerformed(ActionEvent e) { 
				  endtheScreen();
				  if(game.equals(Constants.TOP_DOWN_STRING)) {
					  if (e.getSource() == menu) { 
						  Stick.count = 0; 
						  ClapperRail.lives = 3; 
						  new Controller(Constants.SELECTION_STRING); 
					  }
					  else if (e.getSource() == restart) {
						  Stick.count = 0; 
						  ClapperRail.lives = 3; 
						  new Controller(Constants.TOP_DOWN_NT_STRING);
					  }
				  }
				  if(game.equals(Constants.SIDE_SCROLL_STRING)) {
					  if (e.getSource() == menu) {  
						  Mate.caughtUp = false;
						  new Controller(Constants.SELECTION_STRING); 
						  
					  } 
					  else if (e.getSource() == restart) {
						  Mate.caughtUp = false;
						  new Controller(Constants.SIDE_SCROLL_NT_STRING);
						   }
				  }
			  }
	}
	
	
	public void endtheScreen() {
		this.dispose();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		menuSetup();
		restartSetup();
	}
	
	public void menuSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = menu.getInputMap(map);
		imap.put(KeyStroke.getKeyStroke("LEFT"), "menu");
		
		ActionMap amap = menu.getActionMap();
		amap.put("menu", new keyAction());
	}
	
	public void restartSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = restart.getInputMap(map);
		imap.put(KeyStroke.getKeyStroke("RIGHT"), "tryAgain");
		
		ActionMap amap = restart.getActionMap();
		amap.put("tryAgain", new keyAction());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new LoseScreen(Constants.SIDE_SCROLL_STRING);
	}
}
		 

	
	 
