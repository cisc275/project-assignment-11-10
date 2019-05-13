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

public class EndScreen extends JDialog implements ActionListener {
	
	//Controller m;
	
	Image image;
	JLabel congrats;
	JButton menu;
	JPanel p;
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public EndScreen() {
		p = new JPanel();
		p.setOpaque(true);
		p.setBackground(Color.WHITE);
		p.setLayout(new BoxLayout(p, 3));
		this.setResizable(false);
		this.setModal(true);
		image = createImage();
		congrats = new JLabel("Congradulations! You Win!");
		congrats.setOpaque(false);
        congrats.setFont(new Font("Serif", Font.BOLD, 30));
        congrats.setMinimumSize(new Dimension(550, 50));
        congrats.setPreferredSize(new Dimension(550, 50));
        congrats.setMaximumSize(new Dimension(550, 50));
        congrats.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        congrats.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
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
        
        p.add(congrats);
        p.add(menu);
        
        menu.addActionListener(this);
        this.add(p);
        this.setSize(1920, 1080);
        this.setVisible(true);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == menu) { 
            // create a dialog Box 
            System.out.println("send to menu");
            this.dispose();
            this.setModal(false);
            Controller c = new Controller("sel");
        }

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
