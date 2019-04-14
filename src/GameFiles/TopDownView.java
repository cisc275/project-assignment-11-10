package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Top down view for clapperrail
 *
 */
public class TopDownView extends JPanel{
	final int frameCount = 10;
	int picNum = 0;
	int frameWidth = 800;
	int frameHeight = 500;
	int crWidth = 200;
	int crHeight = 100;
	BufferedImage foxPic;
	BufferedImage crPic;
	BufferedImage bushPic;
	BufferedImage fox_hold;
	JFrame frame;
	ClapperRail cr;
	Bush bush;
	Fox fox;
	int crX=100;
	int crY=100;
	DrawPanel drawPanel;
	public TopDownView() {
		frame = new JFrame();
		frame.getContentPane().add(this);
        drawPanel = new DrawPanel();
		this.add(drawPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        frame.pack();
        cr = new ClapperRail(0,0,null,crWidth,crHeight,-100,-100,2000,2000,12,null,false,false);
        bush = new Bush(100,100,null,200,100,-100,-100,2000,2000);
        fox = new Fox(400,400,null,200,100,0,0,500,800,12);        
        foxPic = fox.getImage();
        fox_hold = fox.getImage();
        crPic = cr.getImage();
        bushPic = bush.getImage();
	}
	public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
	public void paint(Graphics g) {
		drawPanel.paint(g);
	}
	public void update(int x, int y) {
		crX = x;
		crY = y;
		drawPanel.repaint();
	}
	@SuppressWarnings("serial") class DrawPanel extends JPanel{
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
	    	//picNum = (picNum + 1);
			if(((crX >= 380)&&(crX <= 420))&&((crX >= 380)&&(crY <= 420))) {
				//System.out.println("collision");
				foxPic = null;
			}
			else if ((foxPic == null)&&(!(((crX >= 380)&&(crX <= 420))&&((crY >= 380)&&(crY <= 420))))) {
				foxPic = fox_hold;
			}
	    	g.drawImage(crPic, crX, crY, Color.gray, this);
	    	g.drawImage(foxPic, 400, 400, Color.gray, this);
	    	g.drawImage(bushPic, 150, 450, Color.gray, this);
	    	g.drawImage(bushPic, 200, 200, Color.gray, this);
	    	g.drawImage(bushPic, 600, 600, Color.gray, this);
	
		}
		public Dimension getPreferredSize() {
			return new Dimension(1000,1000);
		}
	}
}
