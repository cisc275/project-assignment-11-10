package GameFiles;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller {
	
	private TopDownModel topDownModel;
	private TopDownView topDownView;
	private Timer time;
	private Action drawAction;
	ArrayList<GameObject> game;

	
	public Controller() {
		game = new ArrayList<GameObject>();
		topDownModel = new TopDownModel(10,10,10,10);
		game.add(new GameObject(topDownModel.createImage(),100,100));
		game.add(new GameObject(topDownModel.createImage2(),400,400));
		game.add(new GameObject(topDownModel.createImage3(),200,200));
		topDownView = new TopDownView(game);
		//topDownView.addActionListener(this);
		//topDownView.addKeyListener(this);
		//game = new ArrayList<GameObject>();
		//game.add(new GameObject(pic,100,100));
		//System.out.println("DID IT DO ANYTHING DIFFERENT????????????????????");
		//game.add(new GameObject(topDownModel.createImage2(),400,400));
		//System.out.println("HOW ABOUT NOW?????????????????");
		//game.add(new GameObject(topDownModel.createImage3(),200,200));
	}
	
	public void topDownStart() {
		System.out.println("topDownStart is starting");
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			System.out.println("im performing actions");
    			topDownModel.updateLocation();
    			topDownView.updateView(topDownModel.game);
    		}
    	};
    	time = new Timer(50, drawAction);
	}
	
	
}
