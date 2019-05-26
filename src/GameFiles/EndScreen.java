    
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

public class EndScreen extends JDialog implements KeyListener {
	
	
	Image image;
	JButton congrats;
	JButton menu;
	JLabel timer;
	JPanel p;
	String game;
	ArrayList<JButton> buttons;
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public EndScreen(String game) {
		this.game = game;		
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
	
	public void panelHandling() {
		p = new DrawPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new GridLayout(Constants.GRID_LAYOUT_X, Constants.GRID_LAYOUT_Y));
	}
	
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
	
	
	public void buttonHandling() {
		for (JButton b : buttons) {
			b.setOpaque(false);
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			b.setBackground(Color.BLUE);
	        b.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
	        b.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
	        b.setAlignmentY(JLabel.TOP_ALIGNMENT);
	        b.addKeyListener(this);
	        p.add(b);
		}
		
	}
	
	public void labelHandling() {
		if (game.equals(Constants.SIDE_SCROLL_STRING)){
			timer = new JLabel("You completed migration in " + (10*(Osprey.time/Constants.TIMER_TICK_RATE + 10)/10 + 1)/10.0 + " weeks", SwingConstants.CENTER);
			timer.setOpaque(false);
			timer.setForeground(Color.BLACK);
			timer.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 30));
			p.add(timer);
		}
	    p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
	}
	
	
	private class DrawPanel extends JPanel{
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
			
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			image = createImage();
			g.drawImage(image, this.getWidth() - this.getWidth(), this.getHeight()- this.getHeight(), 
					this.getWidth(), this.getHeight(), this);
	
		}
	}
	

	
	public static void main(String[] args) {
		new EndScreen(Constants.TOP_DOWN_STRING);
	}

	private class keyAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(menu)) {
				endScreen();
				new Controller(Constants.SELECTION_STRING);	
			}
			
		}
		
	}
	
	public void endScreen() {
		Stick.count = 0;
		this.setModal(false);
		this.dispose();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = menu.getInputMap(map);  
		imap.put(KeyStroke.getKeyStroke("UP"), "menu");
		
		ActionMap amap = menu.getActionMap();
		amap.put("menu", new keyAction());
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	}
	
