    
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


public class EndScreen extends JDialog implements KeyListener {
	
	/**
	 * image on each panel
	 */
	Image image;
	
	/**
	 * Button telling you congratulations
	 */
	JButton congrats;
	
	/**
	 * button that returns you to main menu
	 */
	JButton menu;
	
	/**
	 * for sidescroll game tells you how long the game took you
	 */
	JLabel timer;
	
	/**
	 * Panel to draw on
	 */
	JPanel p;
	
	/**
	 * The string that tells you what game you're in
	 */
	String game;
	
	/**
	 * arraylist of jbuttons for buttonhandling
	 */
	ArrayList<JButton> buttons;
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * 
	 * @param game
	 * 
	 * constructor that creates the endscreen
	 */
	
	public EndScreen(String game) {
		this.game = game;
		Constants.FRAME_X = (int) screenSize.getWidth();
		Constants.FRAME_Y = (int) screenSize.getHeight();
		panelHandling();  
		initButtons(); 
		labelHandling();
    	this.setUndecorated(true);
        this.add(p);
        this.setSize(screenSize);
        this.setVisible(true);
        this.setResizable(false);
		this.setModal(true);
	}
	
	/**
	 * creates our JPanel to draw and add things
	 * @author Tim Mazzarelli
	 */
	
	public void panelHandling() {
		p = new DrawPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new GridLayout(Constants.GRID_LAYOUT_X, Constants.GRID_LAYOUT_Y));
	}
	
	/**
	 * initializes the buttons depending on whichever game you are in, 
	 * also adds it to array list for handling purposes
	 * @author Tim Mazzarelli
	 * 
	 */
	public void initButtons() {
		buttons = new ArrayList<JButton>();
		if (game.equals(Constants.SIDE_SCROLL_STRING)){
			congrats = Constants.END_SCREEN_OSPREY_CONGRATS;
		}
		if (game.equals(Constants.TOP_DOWN_STRING)) {			
			congrats = Constants.END_SCREEN_CR_CONGRATS;
		}
		menu = Constants.END_SCREEN_MENU;
		buttons.add(congrats);
		buttons.add(menu);
		buttonHandling();
	}
	
	/**
	 * draws the buttons in a satisfactory way
	 * @author Tim Mazzarelli
	 */
	public void buttonHandling() {
		for (JButton b : buttons) {
			b.setOpaque(false);
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			b.setBackground(Color.BLUE);
	        b.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, (int)(Constants.FRAME_X * Constants.ENDSCREEN_TEXT_SIZE)));
	        b.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
	        b.setAlignmentY(JLabel.TOP_ALIGNMENT);
	        b.addKeyListener(this);
	        p.add(b);
		}
		
	}
	/**
	 * formats the JLabels in a satisfactory way
	 * also adds the timer label if you are in sidescroll
	 * @author Tim Mazzarelli
	 */
	
	public void labelHandling() {
		if (game.equals(Constants.SIDE_SCROLL_STRING)){
			timer = new JLabel("You completed migration in " + (Constants.MIGRATION_OFFSET*
					(Osprey.time/Constants.TIMER_TICK_RATE 
							+ Constants.MIGRATION_OFFSET)/Constants.MIGRATION_OFFSET + 1)/Constants.MIGRATION_OFFSET 
					+ " weeks", SwingConstants.CENTER);
			timer.setOpaque(false);
			timer.setForeground(Color.BLACK);
			timer.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, (int)(Constants.FRAME_X * Constants.ENDSCREEN_TEXT_SIZE)));
			p.add(timer);
		}
	    p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
	}
	
	
	/**
	 * class in which we draw and create our JPanel
	 * @author Tim Mazzarelli
	 *
	 */
	private class DrawPanel extends JPanel{
		
		/**
		 * creates the image on the back of our panel 
		 * according to the game you are in
		 * @return BufferedImage
		 */
		private BufferedImage createImage(){
			BufferedImage bufferedImage;
	    	try {
	    		if (game.equals(Constants.SIDE_SCROLL_STRING)){
	    		bufferedImage = ImageIO.read(new File("img/TIM PICK ME PLEASE.png"));
	    		return bufferedImage;
	    		}
	    		if (game.equals(Constants.TOP_DOWN_STRING)) {
	    		bufferedImage = ImageIO.read(new File("img/cend.png"));
	    		return bufferedImage;
	    		}
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}	
	    	return null;
		}
			
		/**
		 * how the panel is painted
		 * @param g
		 * @author Tim Mazzarelli
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			image = createImage();
			g.drawImage(image, this.getWidth() - this.getWidth(), this.getHeight()- this.getHeight(), 
					this.getWidth(), this.getHeight(), this);
	
		}
	}
	

	/**
	 * main method used for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		new EndScreen(Constants.SIDE_SCROLL_STRING);
	}
	
	/**
	 * class that handles the KeyEvent
	 * @author Tim Mazzarelli
	 *
	 */
	private class keyAction extends AbstractAction{

		/**
		 * tells us what to do if the menu button is clicked
		 * return to the selection screen
		 * @param e
		 * @author Tim Mazzarelli
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(menu)) {
				endScreen();
				new Controller(Constants.SELECTION_STRING);	
			}
			
		}
		
	}
	
	/**
	 * disposes of our endscreen once the key event is done
	 * @author Tim Mazzarelli
	 */
	public void endScreen() {
		Stick.count = 0;
		this.setModal(false);
		this.dispose();
	}
	
	/**
	 * connects the KeyStroke of the uparrow key to the pressing of a button
	 * @param KeyEvent e
	 * @author tim mazzarelli
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = menu.getInputMap(map);  
		imap.put(KeyStroke.getKeyStroke("UP"), "menu");
		
		ActionMap amap = menu.getActionMap();
		amap.put("menu", new keyAction());
	}
	
	/**
	 * does nothing, here for interface implementation
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * does nothing, here for interface implementation
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	}
	
