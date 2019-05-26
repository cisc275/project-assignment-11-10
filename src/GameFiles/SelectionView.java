package GameFiles;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import GameFiles.Quiz.keyAction;
/**
 * View for the selection screen
 */
public class SelectionView extends View implements KeyListener{
	
	/**
	 * button that will allow user to select the osprey game
	 */
	static JButton osprey; 
	/**
	 * button that will allow user to select the clapperrail game
	 */
	static JButton clapperRail;
	
	/**
	 * the size of our screen
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * the image drawn on the back of the jpanel
	 */
	BufferedImage image;
	
	/**
	 * creates the screen used as our main menu
	 */
	
	public SelectionView(ArrayList<GameObject> g) {
		DrawPanel dp = new DrawPanel();
		Dimension fullScreen = new Dimension(screenSize);
		dp.setMinimumSize(fullScreen);
		dp.setPreferredSize(fullScreen);
		dp.setMaximumSize(fullScreen);
		game = g;
		osprey = new JButton(new ImageIcon(Constants.IMG_SELECT_OSPREY));
		clapperRail = new JButton(new ImageIcon(Constants.IMG_SELECT_CLAPPER_RAIL));
		osprey = new JButton();
		clapperRail = new JButton();
		osprey.setOpaque(false);
		osprey.setContentAreaFilled(false);
		osprey.setBorderPainted(false);
		clapperRail.setOpaque(false);
		clapperRail.setContentAreaFilled(false);
		clapperRail.setBorderPainted(false);
		osprey.addKeyListener(this);
		clapperRail.addKeyListener(this);
		this.setLayout(new FlowLayout());
		this.add(dp);
		dp.add(osprey);
		dp.add(clapperRail);
		this.setSize(screenSize.getSize());
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);	

	}
	
	/**
	 * the class that draws our JPanel, and its background image
	 * @author tim mazzarelli
	 *
	 */
	private class DrawPanel extends JPanel{
		
		/**
		 * creates the scaled Image to place on the JPanel
		 * @return BufferedImage
		 * @author Andrew Thompson
		 */
		private BufferedImage createImage(){
			BufferedImage ig;
			BufferedImage scaledImg;
	    	try {
	    		ig = ImageIO.read(new File(Constants.IMG_SELECTION_VIEW_BG));
	    		scaledImg = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TRANSLUCENT);
			    Graphics2D g2 = scaledImg.createGraphics();
			    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			    g2.drawImage(ig, 0, 0, this.getWidth(), this.getHeight(), null);
			    g2.dispose();
			    return scaledImg;
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}	
	    	return null;
		}
			
		/**
		 * paints our JPanel
		 * @param g 
		 * @author Andrew Thompson
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			image = createImage();
			g.drawImage(image, Constants.FRAME_X - Constants.FRAME_X, Constants.FRAME_Y - Constants.FRAME_Y, this);
		}
	}
	

	/**
	 * class that handles the KeyStroke action
	 * @author tim mazzarelli
	 *
	 */
	private class keyAction extends AbstractAction{

		/**
		 * if the key stroke is related to osprey the osprey game starts
		 * and same for clapper rail, then disposes of the screen
		 * @param e
		 * @author tim mazarelli
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(osprey)) {
				new Controller("sideScroll");
			}
			if (e.getSource().equals(clapperRail)) {
				new Controller("topDown");
			}
			endSelection();
		}
		
	}
	
	/**
	 * disposes of the selection screen
	 * @author tim mazzarelli
	 */
	public void endSelection() {
		this.dispose();
	}

	/**
	 * when a key is pressed the buttons are setup
	 * and ready to act
	 * @author Tim Mazzarelli
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		ospreySetup();
		crSetup();
	}
	
	/**
	 * maps the osprey button to the left arrow key
	 * @author tim mazzarelli
	 */
	public void ospreySetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = osprey.getInputMap(map);
		
		keyAction rA = new keyAction();
		rA.setEnabled(true);
		
		imap.put(KeyStroke.getKeyStroke("LEFT"), "osprey");
		ActionMap amap = osprey.getActionMap();
		amap.put("osprey", new keyAction());
	}
	
	/**
	 * maps the clapper rail button to the right arrow key
	 * @author Tim Mazzarelli
	 */
	public void crSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = clapperRail.getInputMap(map);
		
		keyAction rA = new keyAction();
		rA.setEnabled(true);
		
		imap.put(KeyStroke.getKeyStroke("RIGHT"), "third");
		ActionMap amap = clapperRail.getActionMap();
		amap.put("third", new keyAction());
	}

	/**
	 * does nothing for us, here for interface
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * does nothing for us, here for interface
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
