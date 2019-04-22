package GameFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class OneTestToRuleThemAll {
	
	@Test
	void testGameObject() {
		GameObject go = new GameObject(null, null, null, 0, 0, null, 0, 0, 0, 0, 0, 0, false, 0, 0, 0);	

		assertEquals(null,go.getImgFileName());
		assertEquals(null, go.getHitBox());
		assertEquals(null, go.getImage());
		assertEquals(0, go.getY());
		assertEquals(0, go.getX());
		assertEquals(null, go.getImgPose());
		assertEquals(0, go.getWidth());
		assertEquals(0, go.getHeight());
		assertEquals(0, go.getxMin());
		assertEquals(0, go.getxMax());
		assertEquals(0, go.getyMin());
		assertEquals(0, go.getyMax());
		assertEquals(false, go.isDiving());
		assertEquals(0, go.getcurrY());
		assertEquals(0, go.getxSpeed());
		assertEquals(0, go.getySpeed());
	}

	@Test
	void testSelectionModel() {
		SelectionModel sm = new SelectionModel();
		sm.whatGame("scroll");
		assertTrue(sm.scroll);
		assertFalse(sm.td);
		sm.whatGame("td");
		assertTrue(sm.td);
		assertFalse(sm.scroll);
	}
	
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
		BufferedImage one = ImageIO.read(new File("red_square.png"));
		BufferedImage two = ImageIO.read(new File("blue_square.png"));
		BufferedImage three = ImageIO.read(new File("green_square.png"));
		BufferedImage four = ImageIO.read(new File("brown_square.png"));
		
		
		
		scm.advanceWorld(scm.getGame());
		scm.advanceBird(go, 2);	
		scm.miniMap(go);
		
		
		assertNotEquals(oldx2,scm.getGame().get(1).getX());
		assertEquals(oldy2,scm.getGame().get(1).getY());
		assertNotEquals(oldx3,scm.getGame().get(2).getX());
		assertEquals(oldy3,scm.getGame().get(2).getY());	
		assertNotEquals(oldx4,scm.getGame().get(3).getX());
		assertEquals(oldy4,scm.getGame().get(3).getY());	
		assertNotEquals(oldx5,scm.getGame().get(4).getX());
		assertEquals(oldy5,scm.getGame().get(4).getY());
		assertNotEquals(oldx6,scm.getGame().get(5).getX());
		assertEquals(oldy6,scm.getGame().get(5).getY());
		assertEquals(oldx1,scm.getGame().get(0).getX());
		assertNotEquals(oldy1,scm.getGame().get(0).getY());
		assertNotNull(scm.createImage());
		assertNotNull(scm.createImage2());
		assertNotNull(scm.createImage3());
		assertNotNull(scm.createImage4());
		
	
	}

	@Test
	void testTopDownModel() {
		TopDownModel tdm = new TopDownModel(0, 0, 0, 0);
		ArrayList<GameObject> go = new ArrayList<GameObject>();
		go.add(new ClapperRail(0, 0, 0, 0));
		go.add(new Bush(0, 0, 0, 0));
		go.add(new Bush(1000, 1000, 0, 0));
		tdm.setGame(go);
		tdm.setGame(go);
		tdm.collision(go);
		int oldx1 = tdm.getGame().get(0).getX();
		int oldy1 = tdm.getGame().get(0).getY();
		int oldx2 = tdm.getGame().get(1).getX();
		int oldy2 = tdm.getGame().get(1).getY();
		tdm.update();
		tdm.getFrameHeight();
		tdm.getFrameWidth();
		tdm.getGame();
		tdm.getImgHeight();
		tdm.setVel(2, 2);
		tdm.updateLocation(go);
		tdm.getImgWidth();
		
		
		
		assertNotEquals(oldx1,tdm.getGame().get(0).getX());
		assertNotEquals(oldy1,tdm.getGame().get(0).getY());
//		assertNotEquals(oldx2,tdm.getGame().get(1).getX());
//		assertNotEquals(oldy2,tdm.getGame().get(1).getY());
		assertNotNull(tdm.createImage());
		assertNotEquals(10, tdm.foxxDirection());
		assertNotEquals(-1, tdm.foxyDirection());
		assertNotNull(tdm.createImage());
		assertNotNull(tdm.createImage2());
		assertNotNull(tdm.createImage3());
		assertNotNull(tdm.createImage4());
		assertEquals(24, tdm.xChg);
		assertEquals(24, tdm.yChg);
		assertFalse(tdm.updateLocation(go));
		assertEquals(24, tdm.getxChg());
		assertEquals(0, tdm.getFrameHeight());
		assertEquals(0, tdm.getFrameWidth());
		assertEquals(24, tdm.getyChg());
		assertEquals(0, tdm.getImgWidth());
		assertEquals(0, tdm.getYloc());
		assertEquals(0, tdm.getXloc());
		
		
		tdm.setFrameHeight(0);
		assertEquals(0, tdm.getFrameHeight());
		tdm.setFrameWidth(20);
		assertEquals(20, tdm.getFrameWidth());
		tdm.setGame(go);
		assertNotNull(go);
		tdm.setImgHeight(10);
		assertEquals(10, tdm.getImgHeight());
		tdm.setImgWidth(10);
		assertEquals(10, tdm.getImgWidth());
		tdm.setVel(2, 2);
		assertEquals(24, tdm.getxChg());
		assertEquals(24, tdm.getyChg());
		tdm.setxChg(0);
		assertEquals(0, tdm.getxChg());
		tdm.setyChg(0);
		assertEquals(0, tdm.getyChg());
		tdm.setYloc(0);
		assertEquals(0, tdm.getYloc());
		tdm.setXloc(0);
		assertEquals(0, tdm.getXloc());
		
			
	}
	@Test
	void TestAirCurrent() {
		AirCurrent ac = new AirCurrent(0, 0, 0, 0);
		ac.setBenefit(0);
		ac.setDirection("east");
		ac.setOnScreen(true);
		
		assertEquals(ac.getDirection(), "east");
		assertEquals(ac.isOnScreen(), true);
		
	}
	
	@Test
	void TestBird() {
		Bird bird = new Bird(0, 0, 0, 0);
		Type Direction = null;
		bird.move();
		bird.setType(Direction);
		bird.setBirdSpeed(10);
		bird.move();
		
		assertEquals(10, bird.getBirdSpeed());
		assertNotEquals(bird.x, 0);
		assertEquals(bird.y, 0);
		assertEquals(bird.getType(), Direction);
	}
	
	@Test
	void TestBush() {
		Bush bush = new Bush(0, 0, 0, 0);
		assertNotNull(bush.gtImage());
	}
	
	@Test
	void TestClapperRail() {
		ClapperRail cr = new ClapperRail(0, 0, 0, 0);
		cr.move();
		cr.setCarryStick(true);
		cr.setHidden(true);
		cr.setcurrY(0);
		cr.setHeight(0);
		cr.setisDiving(false);
		cr.setSpeed(5);
		cr.setWidth(0);
		cr.setX(0);
		cr.setxMax(100);
		cr.setyMax(100);
		cr.setxMin(0);
		cr.setxSpeed(100);
		cr.setY(0);
		cr.setySpeed(100);
		cr.setyMin(0);
		cr.setImgPose(cr.getImgPose());
		cr.setImage(cr.getImage());
		cr.collidesWith(cr);
		cr.collisions();
		
//		System.out.println(cr);
		
		assertTrue(cr.isCarryStick());
		assertTrue(cr.isHidden());
		assertEquals(0, cr.getcurrY());
		assertEquals(0, cr.getHeight());
		assertFalse(cr.getisDiving());
		assertEquals(5, cr.getSpeed());
		assertEquals(0, cr.getWidth());
		assertEquals(0, cr.getX());
		assertEquals(100, cr.getxMax());
		assertEquals(100, cr.getyMax());
		assertEquals(0, cr.getxMin());
		assertEquals(100, cr.getxSpeed());
		assertEquals(0, cr.getY());
		assertEquals(100, cr.getySpeed());
		assertEquals(0, cr.getyMin());
		
	}
	
	@Test
	void TestCollectable() {
		Collectable coll = new Collectable(0, 0, 0, 0);
		coll.setId(0);
		coll.setBenefit(1);
		assertEquals(0, coll.getId());
		assertEquals(1, coll.getBenefit());
	}
	
	@Test
	void TestController() {
		Controller con = new Controller("topDown");
		Controller cont = new Controller("sideScroll");
		assertEquals(con.selected, "topDown");
		assertEquals(cont.selected, "sideScroll");
	}
	
	@Test 
	void TestStick() {
		Stick.setOnScreen(true);
		Stick.setHolding(true);
		Stick.setCount(100);
		
		assertEquals(100, Stick.getCount());
		assertTrue(Stick.isHolding());
		assertTrue(Stick.isOnScreen());
		
			
		
	}
	
	@Test
	void testType() {
		Type t = Type.FOX;
		
		assertEquals("Fox", t.toString());
		assertTrue(t == Type.FOX);
	}
	
	@Test
	void testTopDownView() {
		
	}
	
}
