    
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

public class EndScreen extends JDialog implements KeyListener {
	
	
	Image image;
	JButton congrats;
	JButton menu;
	JPanel p;
	String game;
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public EndScreen(String game) {
		this.game = game;
		
		p = new DrawPanel();
		p.setBackground(Color.WHITE);
		GridLayout g = new GridLayout(0, 1);
		g.setVgap(10);
		p.setLayout(g);
		
		this.setResizable(false);
		this.setModal(true);
		congrats = new JButton("Congratulations! You Win!");
		congrats.setOpaque(false);
		congrats.setFocusPainted(false);
		congrats.setBorderPainted(false);
		congrats.setBackground(Color.BLUE);
        congrats.setFont(new Font("Serif", Font.BOLD, 40));
        congrats.setMinimumSize(new Dimension(300, 0));
        congrats.setPreferredSize(new Dimension(300, 0));
        congrats.setMaximumSize(new Dimension(300, 0));
        congrats.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        congrats.setAlignmentY(JLabel.TOP_ALIGNMENT);
        congrats.addKeyListener(this);
        
        menu = new JButton(" Press UP ARROW KEY to return to Main Menu");
//        menu.setMinimumSize(new Dimension(200, 0));
//        menu.setPreferredSize(new Dimension(200, 0));
//        menu.setMaximumSize(new Dimension(200, 0));
    	menu.setFocusPainted(false);
    	menu.setBackground(Color.WHITE);
    	menu.setAlignmentX(JButton.CENTER_ALIGNMENT);
    	menu.setAlignmentY(TOP_ALIGNMENT);
    	menu.setOpaque(false);
    	menu.setFont(new Font("Serif", Font.BOLD, 25));
    	menu.setBorderPainted(false);
        
    	this.setUndecorated(true);
    	
    	JLabel timer = new JLabel("You completed the game in " + (Osprey.time/50 + 10) + " seconds", SwingConstants.CENTER);
    	timer.setOpaque(false);
		timer.setForeground(Color.BLACK);
		timer.setMinimumSize(new Dimension(200, 5));
	    timer.setPreferredSize(new Dimension(200, 5));
	    timer.setMaximumSize(new Dimension(200, 5));
	    timer.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 30));
    	
    	p.add(timer);
        p.add(congrats);
        
        p.add(menu);
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
        p.add(new JLabel());
     
        menu.addKeyListener(this);
        this.add(p);
        this.setSize(screenSize);
        this.setVisible(true);
        
	}
	
	private class DrawPanel extends JPanel{
		private BufferedImage createImage(){
			BufferedImage bufferedImage;
	    	try {
	    		if (game.equals("sides")){
	    		bufferedImage = ImageIO.read(new File("img/TIM PICK ME PLEASE.png"));
	    		return bufferedImage;
	    		}
	    		if (game.equals("topDown")) {
	    		bufferedImage = ImageIO.read(new File(Constants.IMG_CLAPPER_RAIL_BACKGROUND));
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
	

	
	public static void main(String[] args) {
		new EndScreen("sides");
	}

	private class keyAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(menu)) {
				endScreen();
				new Controller("sel");	
			}
			
		}
		
	}
	
	public void endScreen() {
		this.setModal(false);
		this.dispose();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		menuButtonSetup();
	}
	
	public void menuButtonSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = menu.getInputMap(map);  
		imap.put(KeyStroke.getKeyStroke("UP"), "second");
		
		ActionMap amap = menu.getActionMap();
		amap.put("second", new keyAction());
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
	
