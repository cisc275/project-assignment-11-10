package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndScreen extends JDialog implements ActionListener {
	
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
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
