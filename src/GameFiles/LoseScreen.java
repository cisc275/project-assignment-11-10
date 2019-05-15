package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoseScreen extends JDialog implements ActionListener {
	
	
	Image image;
	JLabel tryAgain;
	JButton menu;
	JButton restart;
	JPanel p;
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * creates a new window with a message and two JButtons. The new window is an actionListener
	 */
	public LoseScreen() {
		p = new JPanel();
		p.setOpaque(true);
		p.setBackground(Color.WHITE);
		p.setLayout(new BoxLayout(p, 3));
		this.setResizable(false);
		this.setModal(true);
		tryAgain = new JLabel("Oh no! You ran out of Lives! Do you want to try again? (Do we want this to be a quiz?)");
		tryAgain.setOpaque(false);
        tryAgain.setFont(new Font("Serif", Font.BOLD, 30));
        tryAgain.setMinimumSize(new Dimension(550, 50));
        tryAgain.setPreferredSize(new Dimension(550, 50));
        tryAgain.setMaximumSize(new Dimension(550, 50));
        tryAgain.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        tryAgain.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        menu = new JButton("Return to Selection Screen");
        menu.setMinimumSize(new Dimension(500, 50));
        menu.setPreferredSize(new Dimension(500, 50));
        menu.setMaximumSize(new Dimension(500, 50));
    	menu.setFocusPainted(false);
    	menu.setBackground(Color.WHITE);
    	menu.setAlignmentX(JButton.CENTER_ALIGNMENT);
    	menu.setAlignmentY(TOP_ALIGNMENT);
    	menu.setOpaque(true);
    	menu.setFont(new Font("Serif", Font.BOLD, 30));
    	menu.setBorderPainted(false);
    	
    	restart = new JButton("Try Again");
        restart.setMinimumSize(new Dimension(500, 50));
        restart.setPreferredSize(new Dimension(500, 50));
        restart.setMaximumSize(new Dimension(500, 50));
     	restart.setFocusPainted(false);
     	restart.setBackground(Color.WHITE);
     	restart.setAlignmentX(JButton.CENTER_ALIGNMENT);
     	restart.setAlignmentY(TOP_ALIGNMENT);
     	restart.setOpaque(true);
     	restart.setFont(new Font("Serif", Font.BOLD, 30));
     	restart.setBorderPainted(false);
        
        p.add(tryAgain);
        p.add(menu);
        p.add(restart);
        
        menu.addActionListener(this);
        this.add(p);
        this.setSize(1920, 1080);
        this.setVisible(true);
        
	}

	
	/**
	 * if menu clicked, returns to the selection screen, if restart is clicked, new CR game is started
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu) { 
            System.out.println("send to menu");
            this.dispose();
            this.setModal(false);
            Stick.count = 0;
            ClapperRail.lives = 3;
            Controller c = new Controller("sel");
        }
		else if (e.getSource() == restart) { 
            System.out.println("restart");
            this.dispose();
            this.setModal(false);
            Stick.count = 0;
            ClapperRail.lives = 3;
            Controller c = new Controller("topDown");
        }

	}
	
	
	
	

}