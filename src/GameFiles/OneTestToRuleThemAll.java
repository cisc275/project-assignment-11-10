package GameFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class OneTestToRuleThemAll {
	
	@Test
	void testGameObject() {
		GameObject go = new GameObject(0,0,0,0);	

		assertEquals(null,go.getImgFileName());
		assertEquals(null, go.getHitBox());
		assertEquals(null, go.getImage());
		assertEquals(0, go.getY());
		assertEquals(0, go.getX());
		assertEquals(null, go.getImgPose());
		assertEquals(0, go.getWidth());
		assertEquals(0, go.getHeight());
//		assertEquals(false, go.isDiving());
//		assertEquals(0, go.getcurrY());
//		assertEquals(0, go.getxSpeed());
//		assertEquals(0, go.getySpeed());
	}

//	@Test
//	void testSelectionModel() {
//		SelectionModel sm = new SelectionModel();
//		sm.whatGame("scroll");
//		assertTrue(sm.scroll);
//		assertFalse(sm.td);
//		sm.whatGame("td");
//		assertTrue(sm.td);
//		assertFalse(sm.scroll);
//	}
	
	@Test
	void testSideScrollModel() throws IOException {
		SideScrollModel scm = new SideScrollModel();
		ArrayList<GameObject> go = new ArrayList<GameObject>();
		Osprey os = new Osprey(0, 0, 0, 0);
		go.add(os);
		go.add(new Fish(-134, 0, 0, 0));
		//scm.setGame(go);
		go.add(new Fish(-134, 0, 0, 0));
		//scm.setGame(go);
		go.add(new Fish(-134, 0, 0, 0));
		//scm.setGame(go);
		go.add(new Trash(-134, 0, 0, 0));
		//scm.setGame(go);
		go.add(new AirCurrent(200, 0, 0, 0));
		scm.setGame(go);
		int oldx1 = scm.getGame().get(0).getX();
		int oldy1 = scm.getGame().get(0).getY();
		int oldx2 = scm.getGame().get(1).getX();
		int oldy2 = scm.getGame().get(1).getY();
		int oldx3 = scm.getGame().get(2).getX();
		int oldy3 = scm.getGame().get(2).getY();
		int oldx4 = scm.getGame().get(3).getX();
		int oldy4 = scm.getGame().get(3).getY();
		int oldx5 = scm.getGame().get(4).getX();
		int oldy5 = scm.getGame().get(4).getY();
		int oldx6 = scm.getGame().get(5).getX();
		int oldy6 = scm.getGame().get(5).getY();
		

		Quiz.correct = true;
		scm.updateLocation(go);
		Quiz.correct = false;
		scm.updateLocation(go);
		Osprey.negHitOs = true;
		Osprey.posHitOs = true;
		scm.updateLocation(go);
		Osprey.negHitOs = false;
		Osprey.posHitOs = false;
		scm.updateLocation(go);
		Osprey.negHitOs = true;
		scm.updateLocation(go);
		Osprey.posHitOs = false;
		scm.collCount = 5;
		scm.updateLocation(go);
		scm.collCount = 60;
		scm.updateLocation(go);
		
		Osprey.negHitOs = false;
		scm.updateLocation(go);
		Osprey.posHitOs = true;
		scm.collCount = 5;
		scm.updateLocation(go);
		scm.collCount = 60;
		scm.updateLocation(go);
		
		
		scm.updateLocation(go);
		Osprey.negHitOs = false;
		Osprey.posHitOs = true;
		scm.updateLocation(go);
		
		
		
		assertEquals(oldx2,scm.getGame().get(1).getX());
		assertEquals(oldy2,scm.getGame().get(1).getY());
		assertEquals(oldx3,scm.getGame().get(2).getX());
		assertEquals(oldy3,scm.getGame().get(2).getY());	
		assertEquals(oldx4,scm.getGame().get(3).getX());
		assertEquals(oldy4,scm.getGame().get(3).getY());	
		assertEquals(oldx5,scm.getGame().get(4).getX());
		assertEquals(oldy5,scm.getGame().get(4).getY());
		assertEquals(oldx6,scm.getGame().get(5).getX());
		assertEquals(oldy6,scm.getGame().get(5).getY());
		assertEquals(oldx1,scm.getGame().get(0).getX());
		assertEquals(oldy1,scm.getGame().get(0).getY());
		scm.inTutoral = false;
		scm.postTutorial();
		HashSet<Integer> keys = new HashSet<>();
		keys.add(Constants.UP_KEY_CODE);
		keys.add(Constants.DOWN_KEY_CODE);
		
		Quiz.answered = true;
		scm.handleMove(keys);
		Quiz.answered = false;
		scm.handleMove(keys);
		scm.updateLocation(scm.getGame());
		
	
	}

	@Test
	void testTopDownModel() {
		TopDownModel tdm = new TopDownModel();
		ArrayList<GameObject> go = new ArrayList<GameObject>();
		go.add(new ClapperRail(0, 0, 0, 0));
		go.add(new Bush(0, 0, 0, 0));
		go.add(new Bush(1000, 1000, 0, 0));
		tdm.setGame(go);
		tdm.setGame(go);
		//tdm.collision(go);
		int oldx1 = tdm.getGame().get(0).getX();
		int oldy1 = tdm.getGame().get(0).getY();
		int oldx2 = tdm.getGame().get(1).getX();
		int oldy2 = tdm.getGame().get(1).getY();
		tdm.updateLocation(go);
//		tdm.getFrameHeight();
//		tdm.getFrameWidth();
		tdm.getGame();
//		tdm.getImgHeight();
//		tdm.setVel(2, 2);
		tdm.updateLocation(go);
//		tdm.getImgWidth();
		
		
		
		assertNotEquals(oldx1,tdm.getGame().get(0).getX());
		assertNotEquals(oldy1,tdm.getGame().get(0).getY());
//		assertNotEquals(oldx2,tdm.getGame().get(1).getX());
//		assertNotEquals(oldy2,tdm.getGame().get(1).getY());
//		assertNotNull(tdm.createImage());
//		assertNotEquals(10, tdm.foxxDirection());
//		assertNotEquals(-1, tdm.foxyDirection());
//		assertNotNull(tdm.createImage());
//		assertNotNull(tdm.createImage2());
//		assertNotNull(tdm.createImage3());
//		assertNotNull(tdm.createImage4());
//		assertEquals(24, tdm.xChg);
//		assertEquals(24, tdm.yChg);
//		assertFalse(tdm.updateLocation(go));
//		assertEquals(24, tdm.getxChg());
//		assertEquals(0, tdm.getFrameHeight());
//		assertEquals(0, tdm.getFrameWidth());
//		assertEquals(24, tdm.getyChg());
//		assertEquals(0, tdm.getImgWidth());
//		assertEquals(0, tdm.getYloc());
//		assertEquals(0, tdm.getXloc());
		
		
//		tdm.setFrameHeight(0);
//		assertEquals(0, tdm.getFrameHeight());
//		tdm.setFrameWidth(20);
//		assertEquals(20, tdm.getFrameWidth());
//		tdm.setGame(go);
//		assertNotNull(go);
//		tdm.setImgHeight(10);
//		assertEquals(10, tdm.getImgHeight());
//		tdm.setImgWidth(10);
//		assertEquals(10, tdm.getImgWidth());
//		tdm.setVel(2, 2);
//		assertEquals(24, tdm.getxChg());
//		assertEquals(24, tdm.getyChg());
//		tdm.setxChg(0);
//		assertEquals(0, tdm.getxChg());
//		tdm.setyChg(0);
//		assertEquals(0, tdm.getyChg());
//		tdm.setYloc(0);
//		assertEquals(0, tdm.getYloc());
//		tdm.setXloc(0);
//		assertEquals(0, tdm.getXloc());
		
			
	}
	@Test
	void TestAirCurrent() {
		AirCurrent ac = new AirCurrent(0, 0, 0, 0);
//		ac.setBenefit(0);
//		ac.setDirection("east");
//		ac.setOnScreen(true);
		
//		assertEquals(ac.getDirection(), "east");
//		assertEquals(ac.isOnScreen(), true);
		
	}
	
	@Test
	void TestBird() {
		Bird bird = new Bird(0, 0, 0, 0);
		bird.move();
	}
	
	@Test
	void TestBush() {
		Bush bush = new Bush(0, 0, 0, 0);
		assertNotNull(bush.imgFileName);
	}
	
	@Test
	void TestClapperRail() {
		ClapperRail cr = new ClapperRail(0, 0, 0, 0);
		cr.move();
		cr.setCarryStick(true);
		cr.setHidden(true);
		cr.setY(0);
		cr.setHeight(0);
		cr.setWidth(0);
		cr.setX(0);
		cr.setxSpeed(100);
		cr.setY(0);
		cr.setySpeed(100);
		cr.setImgPose(cr.getImgPose());
		cr.collidesWith(cr);
		
//		System.out.println(cr);
		
		assertTrue(cr.isCarryStick());
		assertEquals(0, cr.getY());
		assertEquals(0, cr.getHeight());
		assertEquals(0, cr.getWidth());
		assertEquals(0, cr.getX());
		assertEquals(100, cr.getxSpeed());
		assertEquals(0, cr.getY());
		assertEquals(100, cr.getySpeed());
		
	}
	
	@Test
	void TestCollectable() {
		Collectable coll = new Collectable(0, 0, 0, 0);
	}
	
	@Test
	void TestController() {
		Controller con = new Controller("topDown");
		Controller cont = new Controller("sideScroll");
		Controller conS = new Controller("selection");
		
		ActionEvent e = new ActionEvent(con, 0, null);
		e.setSource(((SelectionView)conS.getView()).clapperRail);
		
		assertEquals(con.selected, "topDown");
		assertEquals(cont.selected, "sideScroll");
		assertEquals(conS.selected, "selection");
		
		conS.actionPerformed(e);
		assertEquals(conS.selected, null);
		
		
		
	}
	
	@Test 
	void TestStick() {
		Stick.setCount(100);
		
		assertEquals(100, Stick.getCount());	
	}
	@Test
	void TestFox() {
		Fox fox = new Fox(0, 0, 0, 0, null);
		fox.move();
	}
	
	@Test
	void testTopDownView() {
		
	}
	
}
