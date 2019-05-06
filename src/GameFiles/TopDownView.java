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


/**
 * Top down view for clapperrail
 *
 */
public class TopDownView extends View{
    DrawPanel drawPanel = new DrawPanel();
    JFrame frame;
	BufferedImage background = createImage();
    /**
     * 
     * @param Array list of GameObjects
     * constructs a view based on the array list it is given
     */
	public TopDownView(ArrayList<GameObject> g) {
		frame = new JFrame();
		game = g;
    	frame.add(drawPanel);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameSize, frameSize);
    	frame.setVisible(true);
	}
	
	
	
	/**
	 * 
	 * @param Array list of GameObjects
	 * calls paint component to create images based on the current ArrayList
	 */
	public void updateView(ArrayList<GameObject> g) {
		game = g; 
		drawPanel.repaint();
	}
	
	
	
	private class DrawPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			g.drawImage(background, 0, 0, this);
		
			for (GameObject hing : game) {	
				g.setClip(hing.hitbox);
				g.drawImage(hing.getScaledImg(),hing.hitbox.xpoints[0] ,hing.hitbox.ypoints[0], this);
			}		
	
		}
			public Dimension getPreferredSize() {
			return new Dimension(frameSize, frameSize);
		}
	}
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(Constants.IMG_CLAPPER_RAIL_BACKGROUND));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param controller
	 * adds the controller as a keyListener
	 */
	public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
	
}
