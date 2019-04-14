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
	Model model;
	View view;
	boolean isOsp;
	private Action drawAction;
	private Timer time;
	private final Set<Integer> pressed = new HashSet<>();
	final int drawDelay = 30;

	public Controller(String a) {
		if(a == "cr") {
			model = new TopDownModel(800,500,1000,1000);
			view = new TopDownView();
			view.addKeyListener(this);
			drawAction = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					view.drawPanel.repaint();
				}
			};
			isOsp = false;
		}
		else if(a == "osp") {
			model = new SideScrollModel();
			view = new SideScrollView();
			view.addKeyListener(this);
			drawAction = new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					view.drawPanel.repaint();
				}
			};
			isOsp = true;
		}

	}



	@Override
	public synchronized void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//		int xvel=0;
		//		int yvel=0;
		//		pressed.add(e.getKeyCode());
		//		for(Integer code: pressed) {
		//			if(code.equals(KeyEvent.VK_UP))
		//				yvel-=1;
		//			if(code.equals(KeyEvent.VK_DOWN))
		//				yvel+=1;
		//			if(code.equals(KeyEvent.VK_LEFT))
		//				xvel-=1;
		//			if(code.equals(KeyEvent.VK_RIGHT))
		//				xvel+=1;
		//		}
		//		model1.setVel(xvel, yvel);
		//		System.out.println(xvel+":"+yvel);
		if((e.getKeyCode() == 38) && (model.isDiving == false)) { //up arrow key
			yIncr = -5;
		}
		else if((e.getKeyCode() == 40) && (isDiving == false)) { //down arrow key
			yIncr = 5;
		}
		else if ((e.getKeyCode() == 32) && (isDiving == false)) {
			System.out.println("space");
			isDiving = true;
			yIncr = 50;
			currY = yloc;
			yloc += yIncr;
		}

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
				model.updateLocation();

				//update the view
				view.update(model.getX(), model.getY());
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

	public TopDownModel getModel1() {
		return model;
	}

	public void setModel1(TopDownModel model1) {
		this.model = model1;
	}

	public TopDownView getView1() {
		return view;
	}

	public void setView1(TopDownView view1) {
		this.view1 = view1;
	}

	public Action getDrawAction() {
		return drawAction;
	}

	public void setDrawAction(Action drawAction) {
		this.drawAction = drawAction;
	}

	public Timer getTime() {
		return time;
	}

	public void setTime(Timer time) {
		this.time = time;
	}

	public Set<Integer> getPressed() {
		return pressed;
	}

	public int getDrawDelay() {
		return drawDelay;
	}

}
