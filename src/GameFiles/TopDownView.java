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
	public int getPicNum() {
		return picNum;
	}
	public void setPicNum(int picNum) {
		this.picNum = picNum;
	}
	public int getFrameWidth() {
		return frameWidth;
	}
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}
	public int getFrameHeight() {
		return frameHeight;
	}
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}
	public int getCrWidth() {
		return crWidth;
	}
	public void setCrWidth(int crWidth) {
		this.crWidth = crWidth;
	}
	public int getCrHeight() {
		return crHeight;
	}
	public void setCrHeight(int crHeight) {
		this.crHeight = crHeight;
	}
	public BufferedImage getFoxPic() {
		return foxPic;
	}
	public void setFoxPic(BufferedImage foxPic) {
		this.foxPic = foxPic;
	}
	public BufferedImage getCrPic() {
		return crPic;
	}
	public void setCrPic(BufferedImage crPic) {
		this.crPic = crPic;
	}
	public BufferedImage getBushPic() {
		return bushPic;
	}
	public void setBushPic(BufferedImage bushPic) {
		this.bushPic = bushPic;
	}
	public BufferedImage getFox_hold() {
		return fox_hold;
	}
	public void setFox_hold(BufferedImage fox_hold) {
		this.fox_hold = fox_hold;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public ClapperRail getCr() {
		return cr;
	}
	public void setCr(ClapperRail cr) {
		this.cr = cr;
	}
	public Bush getBush() {
		return bush;
	}
	public void setBush(Bush bush) {
		this.bush = bush;
	}
	public Fox getFox() {
		return fox;
	}
	public void setFox(Fox fox) {
		this.fox = fox;
	}
	public int getCrX() {
		return crX;
	}
	public void setCrX(int crX) {
		this.crX = crX;
	}
	public int getCrY() {
		return crY;
	}
	public void setCrY(int crY) {
		this.crY = crY;
	}
	public DrawPanel getDrawPanel() {
		return drawPanel;
	}
	public void setDrawPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	public int getFrameCount() {
		return frameCount;
	}
}
