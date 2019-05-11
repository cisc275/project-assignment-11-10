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
		
	}

	
	
	public static void main(String[] args) {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 1));
		Quiz q = new Quiz();
		q.setModal(true);
		JLabel wrong = new JLabel("this is a dialog box \n yes"); 
        JLabel right = new JLabel("this is the right answer");
        JLabel mW = new JLabel("more wrong");
        p.add(wrong);
        p.add(right);
        q.addKeyListener(q);
        p.add(mW);
        q.add(p);
        q.setSize(200, 200);
        q.setVisible(true);
		
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String s = KeyEvent.getKeyText(e.getKeyCode());
		 System.out.println(s);
	        if (s.equals("A")) { 
	            // create a dialog Box 
	            System.out.println("Hooray");
	            this.setVisible(false);
	        }
	        if(s.equals("B")){
	        	System.out.println("bitch");
	        	this.setEnabled(false);
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
