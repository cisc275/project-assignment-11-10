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
import java.util.ArrayList;

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

	/**
	 * image on the back of the lose screen panel
	 */
	Image image;
	
	/**
	 * Label with the lost message
	 */
	JLabel tryAgain;
	
	/**
	 * button you can press to return to home screen
	 */
	JButton menu;
	
	/**
	 * button you press to restart game
	 */
	JButton restart;
	
	/**
	 * Panel we are drawing on
	 */
	JPanel p;
	
	/**
	 * String that tells us what game we are in
	 */
	String game;
	
	/**
	 * array list of jbuttons for making the drawing of them easier
	 */
	ArrayList<JButton> buttons;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * creates a new window with 1 labels and 2 JButtons The new window is a
	 * keyListener
	 */
	public LoseScreen(String game) {
		this.game = game;
		Constants.FRAME_X = (int) screenSize.getWidth();
		Constants.FRAME_Y = (int) screenSize.getHeight();
		panelHandling();
		initLabels();
		initButtons();
		this.setUndecorated(true);
		p.add(new JLabel());
		p.add(new JLabel());
		p.add(new JLabel());
		p.add(new JLabel());
		this.add(p);
		this.setSize(screenSize);
		this.setVisible(true);
	}
	
	/**
	 * creates our panel
	 * @author Tim Mazzarelli
	 */
	public void panelHandling() {
		p = new DrawPanel();
		p.setOpaque(true);
		p.setLayout(new GridLayout(Constants.GRID_LAYOUT_X, Constants.GRID_LAYOUT_Y));
	}
	
	/**
	 * creates the label with our loss message
	 * and draws the labels all pretty
	 * @author Tim Mazzarelli
	 */
	public void initLabels() {
		if (game.equals(Constants.TOP_DOWN_STRING)) {
			tryAgain = new JLabel("Sorry! You ran out of lives!", SwingConstants.CENTER);
		}
		if (game.equals(Constants.SIDE_SCROLL_STRING)) {
			tryAgain = new JLabel("Sorry! Ospreys make their nests high off the ground!", SwingConstants.CENTER);
		}
		
		tryAgain.setOpaque(false);
		tryAgain.setFont(new Font("Serif", Font.BOLD, (int)(Constants.FRAME_X * Constants.ENDSCREEN_TEXT_SIZE)));
		tryAgain.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		tryAgain.setAlignmentY(JLabel.TOP_ALIGNMENT);
		p.add(new JLabel());
		p.add(tryAgain);
	}
	
	
	/**
	 * creates the JButtons and adds them to the arraylist for handling
	 * @author Tim Mazzarelli
	 */
	public void initButtons() {
		buttons = new ArrayList<JButton>();
		menu = new JButton("Press LEFT ARROW KEY to return to Main Menu");
		restart = new JButton("Press RIGHT ARROW KEY to Try Again");
		buttons.add(menu);
		buttons.add(restart);
		buttonHandling();
	}

	/**
	 * draws the buttons in the arraylist in a pretty way
	 * @author Tim Mazzarelli
	 */
	public void buttonHandling() {
		for (JButton b : buttons) {
			b.setFocusPainted(false);
			b.setBackground(Color.GRAY);
			b.setAlignmentX(JButton.CENTER_ALIGNMENT);
			b.setAlignmentY(TOP_ALIGNMENT);
			b.setOpaque(false);
			b.setFont(new Font("Serif", Font.BOLD, (int)(Constants.FRAME_X * Constants.ENDSCREEN_TEXT_SIZE)));
			b.setBorderPainted(false);
			b.addKeyListener(this);
			p.add(b);
		}
	}
	
	
	/**
	 * class that we use when creating our JPanel for our losescreen
	 * @author Tim Mazzarelli
	 */
	private class DrawPanel extends JPanel{
		
		/**
		 * creates the endgame image depending on whatever game you're in
		 * @return BufferedImage
		 * @author Tim Mazzarelli
		 */
		private BufferedImage createImage(){
			BufferedImage bufferedImage;
	    	try {
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
			
		/**
		 * draws the image on the JPane;
		 * @author Tim Mazzarelli
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			image = createImage();
			g.drawImage(image, Constants.VIEW_ORIGIN, Constants.VIEW_ORIGIN, this.getWidth(), this.getHeight(), this);
	
	}
	}

	/**
	 * class that handles the actions connected to key stroke
	 * @author Tim Mazzarelli
	 */
	private class keyAction extends AbstractAction{
		
		/**
		 * if menu is pressed we return to home screen
		 * else the game is restarted
		 * @author Tim Mazzarelli
		 */
		  @Override 
		  public void actionPerformed(ActionEvent e) { 
				  endtheScreen();
				  if(game.equals(Constants.TOP_DOWN_STRING)) {
					  if (e.getSource() == menu) { 
						  Stick.count = Constants.STICK_RESET; 
						  ClapperRail.lives = Constants.CLAPPER_RAIL_INIT_LIVES; 
						  new Controller(Constants.SELECTION_STRING); 
					  }
					  else if (e.getSource() == restart) {
						  Stick.count = Constants.STICK_RESET; 
						  ClapperRail.lives = Constants.CLAPPER_RAIL_INIT_LIVES; 
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
	
	/**
	 * disposes of the current screen
	 * @author Tim Mazzarelli
	 */
	public void endtheScreen() {
		this.dispose();
	}

	/**
	 * setups the buttons when keys are pressed
	 * 
	 * @author Tim Mazzarelli
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		menuSetup();
		restartSetup();
	}
	
	/**
	 * connects the menu button to the left arrow key
	 * @author Tim Mazzarelli
	 */
	public void menuSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = menu.getInputMap(map);
		imap.put(KeyStroke.getKeyStroke("LEFT"), "menu");
		
		ActionMap amap = menu.getActionMap();
		amap.put("menu", new keyAction());
	}
	
	/**
	 * connects the restart button to the right arrow key
	 * @author Tim Mazzarelli
	 */
	public void restartSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = restart.getInputMap(map);
		imap.put(KeyStroke.getKeyStroke("RIGHT"), "tryAgain");
		
		ActionMap amap = restart.getActionMap();
		amap.put("tryAgain", new keyAction());
	}
	
	/**
	 * does nothing but here for KeyListener interface
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * does nothing but here for KeyListener interface
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
		 

	
	 
