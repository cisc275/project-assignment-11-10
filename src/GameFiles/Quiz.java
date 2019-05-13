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
	 JButton moreWrong;
	 ArrayList<JButton> buttons;
	 JPanel p;
	
	/**
	 * button that will allow user to select the clapperrail game
	 */

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Quiz(String game) {
		p = new JPanel();
		GridLayout g = new GridLayout(0,1);
		g.setVgap(0);
		p.setLayout(g);
		p.setAlignmentX(CENTER_ALIGNMENT);
		p.setAlignmentY(TOP_ALIGNMENT);
//		this.imageHandling(game);
		this.setResizable(false);
		this.setModal(true);
		this.questionHandling(game);
        this.buttonHandling(game);
        this.add(p);
        this.setSize(350, 200);
        this.setVisible(true);
        addActionListener(this);
	}

	
	public void questionHandling(String game) {
		
		if (game.equals("sides")) {
			 question = new JLabel("Where would you like to make your nest?");
		}
		if (game.equals("td")) {
			question = new JLabel("What is the natural predator of the Clapper Rail?");
			 
		}
	    
		question.setHorizontalAlignment(JLabel.CENTER);
		question.setVerticalAlignment(JLabel.TOP);
		question.setOpaque(true);
        question.setFont(new Font("Serif", Font.BOLD, 15));
        question.setBackground(Color.WHITE);
        question.setMinimumSize(new Dimension(200, 5));
        question.setPreferredSize(new Dimension(200, 5));
        question.setMaximumSize(new Dimension(200, 5));
		p.add(question);
	}
	
	public void buttonHandling(String game) {
		buttons = new ArrayList<JButton>();
		if (game.equals("sides")){
		right = new JButton("A. in the tall nest");
        wrong = new JButton("B. Osprey don't make nests");
        moreWrong = new JButton("C. On the water, low ground");
		}
		if (game.equals("td")) {
			right = new JButton("A. red fox");
			wrong = new JButton("B. snails");
			moreWrong = new JButton("C. people");
		}
        buttons.add(right);
        buttons.add(wrong);
        buttons.add(moreWrong);
		for (JButton b :buttons) {
			b.setOpaque(true);
			b.setBackground(Color.WHITE);
			b.setMinimumSize(new Dimension(300, 20));
            b.setPreferredSize(new Dimension(300, 20));
            b.setMaximumSize(new Dimension(300, 20));
        	b.setFocusPainted(false);
        	b.setVerticalAlignment(JButton.TOP);
        	b.setHorizontalAlignment(JButton.CENTER);
        	b.setFont(new Font("Serif", Font.BOLD, 15));
        	b.setBorderPainted(false);
        	b.addActionListener(this);
        	p.add(b);
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(image, 0, 0, this);
	}
	
	public void imageHandling(String game) {
	
			image = createImage();
			JLabel img = new JLabel(new ImageIcon(image));
	        img.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	        img.setAlignmentY(JLabel.TOP_ALIGNMENT);
	        p.add(img);
		
	}
	
	public static void main(String[] args) {
		new Quiz("td");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	        if (e.getSource().equals(right)) { 
	            System.out.println("Hooray");
	        }
	
	        if(e.getSource().equals(wrong)){
	        	System.out.println("Boo");
	        	
	        	
	        }
	        if (e.getSource().equals(moreWrong)){
	        	System.out.println("cat");
	        	
	        }
	        this.dispose();
	}

	
	
	public void addActionListener(Quiz q) {
	}

	private Image createImage() {
		try {
			image = ImageIO.read(new File(Constants.IMG_CLAPPER_RAIL_BACKGROUND));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
		return image;
	}

	


	

}
