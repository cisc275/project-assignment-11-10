package GameFiles;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
public class Quiz extends JDialog implements ActionListener{
	/**
	 * button that will allow user to select the osprey game
	 */
	
	 Image image;
	 JLabel question;
	 JButton right;
	 JButton wrong;
	 ArrayList<JButton> buttons;
	 JPanel p;
	
	/**
	 * button that will allow user to select the clapperrail game
	 */

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Quiz() {
		
		
		p = new JPanel();
		p.setOpaque(true);
		p.setBackground(Color.WHITE);
		p.setLayout(new BoxLayout(p, 3));
		this.setResizable(false);
		this.setModal(true);
		image = createImage();
        buttons = new ArrayList<>();
        question = new JLabel("Where would you like to make your nest?");
        question.setOpaque(false);
        question.setFont(new Font("Serif", Font.BOLD, 30));
        question.setMinimumSize(new Dimension(550, 50));
        question.setPreferredSize(new Dimension(550, 50));
        question.setMaximumSize(new Dimension(550, 50));
        question.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        question.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        right = new JButton("A. in the tall nest");
        wrong = new JButton("B. Osprey don't make nests");
        p.add(question);
        buttons.add(right);
        buttons.add(wrong);
        buttons.add(new JButton("C. Low on the ground by water"));
       
        for (JButton b : buttons) {
        	b.setMinimumSize(new Dimension(500, 50));
            b.setPreferredSize(new Dimension(500, 50));
            b.setMaximumSize(new Dimension(500, 50));
        	b.setFocusPainted(false);
        	b.setBackground(Color.WHITE);
        	b.setAlignmentX(JButton.CENTER_ALIGNMENT);
        	b.setAlignmentY(TOP_ALIGNMENT);
        	b.setOpaque(true);
        	b.setFont(new Font("Serif", Font.BOLD, 30));
        	b.setBorderPainted(false);
        	p.add(b);
        }
        JLabel img = new JLabel(new ImageIcon(image));
        img.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        img.setAlignmentY(JLabel.TOP_ALIGNMENT);
        p.add(img);
        addActionListener(this);
        this.add(p);
        this.setSize(1920, 1080);
        this.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new Quiz();
	}
	
	private void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(image, 0, 0, this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
	        if (e.getSource() == right) { 
	            // create a dialog Box 
	            System.out.println("Hooray");
	            this.dispose();
	            this.setModal(false);
	        }
	
	   /*     if(s.equals("B")){
	        	this.dispose();
	        	
	        }
	        if (s.equals("C")) {
	        	System.out.println("cat");
	        }
*/
	}
	
	public void addActionListener(Quiz q) {
		right.addActionListener(q);
		wrong.addActionListener(q);
	}

	private Image createImage() {
		try {
			image = ImageIO.read(new File("img/Winner.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		return image;
	}

	


	

}
