package GameFiles;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * represents the quiz at the end of each game 
 *
 */
public class Quiz extends JDialog implements KeyListener{
	/**
	 * button that will allow user to select the osprey game
	 */
	 static JFrame f; 
	/**
	 * button that will allow user to select the clapperrail game
	 */

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Quiz() {
		JPanel p = new JPanel();
		BoxLayout g = new BoxLayout(p, 3);
		p.setLayout(g);
		this.setResizable(false);
		this.setModal(true);
		JLabel question = new JLabel("Where would you like to make your nest?");
		JLabel wrong = new JLabel("A. In the tall nest"); 
        JLabel right = new JLabel("B. Osprey's done make nests");
        JLabel mW = new JLabel("C. Low on the ground by water");
        p.add(question);
        p.add(wrong);
        p.add(right);
        p.add(mW);
        this.addKeyListener(this);
        this.add(p);
        this.setSize(300, 200);
        this.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		JPanel p = new JPanel();
		BoxLayout g = new BoxLayout(p, 3);
		p.setLayout(g);
		Quiz q = new Quiz();
		q.setResizable(false);
		q.setModal(true);
		JLabel question = new JLabel("Where would you like to make your nest?");
		JLabel wrong = new JLabel("A. In the tall nest"); 
        JLabel right = new JLabel("B. Osprey's done make nests");
        JLabel mW = new JLabel("C. Low on the ground by water");
        p.add(question);
        p.add(wrong);
        p.add(right);
        p.add(mW);
        q.addKeyListener(q);
        q.add(p);
        q.setSize(300, 200);
        q.setVisible(true);
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
			String s = KeyEvent.getKeyText(e.getKeyCode());
	        if (s.equals("A")) { 
	            // create a dialog Box 
	            System.out.println("Hooray");
	            this.dispose();
	            this.setModal(false);
	        }
	        if(s.equals("B")){
	        	this.dispose();
	        	
	        }
	        if (s.equals("C")) {
	        	System.out.println("cat");
	        }

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
