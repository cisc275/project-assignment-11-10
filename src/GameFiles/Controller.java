package GameFiles;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;

import javax.swing.Action;
import javax.swing.Timer;


public class Controller implements ActionListener, KeyListener{
	TopDownModel model1;
	TopDownView view1;
	private Action drawAction;
	private Timer time;
	private final Set<Integer> pressed = new HashSet<>();
	final int drawDelay = 30;
	public Controller() {
		model1 = new TopDownModel(800,500,200,100);
		view1 = new TopDownView();
		view1.addKeyListener(this);
		drawAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				view1.drawPanel.repaint();
			}
		};
		
	}
	
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int xvel=0;
		int yvel=0;
		pressed.add(e.getKeyCode());
		for(Integer code: pressed) {
			if(code.equals(KeyEvent.VK_UP))
				yvel-=1;
			if(code.equals(KeyEvent.VK_DOWN))
				yvel+=1;
			if(code.equals(KeyEvent.VK_LEFT))
				xvel-=1;
			if(code.equals(KeyEvent.VK_RIGHT))
				xvel+=1;
		}
		model1.setVel(xvel, yvel);
		System.out.println(xvel+":"+yvel);
		
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		pressed.remove(e.getKeyCode());
		int xvel=0;
		int yvel=0;
		for(Integer code: pressed) {
			if(code.equals(KeyEvent.VK_UP))
				yvel-=1;
			if(code.equals(KeyEvent.VK_DOWN))
				yvel+=1;
			if(code.equals(KeyEvent.VK_LEFT))
				xvel-=1;
			if(code.equals(KeyEvent.VK_RIGHT))
				xvel+=1;
		}
		model1.setVel(xvel, yvel);
		System.out.println(xvel+":"+yvel);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void start(){
		drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			 //increment the x and y coordinates, alter direction if necessary
    			model1.updateLocation();
    			
    			//update the view
    			view1.update(model1.getX(), model1.getY());
    		}
    	};
		time = new Timer(50, drawAction);
	}
	public void update() {
		model1.updateLocation();
		view1.update(model1.getX(), model1.getY());
	}
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Controller cont = new Controller();
				Timer t = new Timer(cont.drawDelay, cont.drawAction);
				t.start();
			}
		});
	}

}
