package GameFiles;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import GameFiles.Quiz.keyAction;
/**
 * View for the selection screen
 */
public class SelectionView extends View implements KeyListener{
	
	/**
	 * button that will allow user to select the osprey game
	 */
	static JButton osprey; 
	/**
	 * button that will allow user to select the clapperrail game
	 */
	static JButton clapperRail;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * creates the screen used as our main menu
	 */
	
	public SelectionView(ArrayList<GameObject> g) {
		
		game = g;
		osprey = new JButton(new ImageIcon(Constants.IMG_SELECT_OSPREY));
		clapperRail = new JButton(new ImageIcon(Constants.IMG_SELECT_CLAPPER_RAIL));
		osprey.addKeyListener(this);
		clapperRail.addKeyListener(this);
		this.setLayout(new FlowLayout());
		this.add(osprey);
		this.add(clapperRail);
	
		this.setSize(screenSize.getSize());
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);	

	}
	

	
	private class keyAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(osprey)) {
				new Controller("sideScroll");
			}
			if (e.getSource().equals(clapperRail)) {
				new Controller("topDown");
			}
			endSelection();
		}
		
	}
	
	public void endSelection() {
		this.dispose();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("hello there");
		ospreySetup();
		crSetup();
	}
	
	public void ospreySetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = osprey.getInputMap(map);
		
		keyAction rA = new keyAction();
		rA.setEnabled(true);
		
		imap.put(KeyStroke.getKeyStroke("LEFT"), "osprey");
		ActionMap amap = osprey.getActionMap();
		amap.put("osprey", new keyAction());
	}
	
	public void crSetup() {
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = clapperRail.getInputMap(map);
		
		keyAction rA = new keyAction();
		rA.setEnabled(true);
		
		imap.put(KeyStroke.getKeyStroke("RIGHT"), "third");
		ActionMap amap = clapperRail.getActionMap();
		amap.put("third", new keyAction());
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
