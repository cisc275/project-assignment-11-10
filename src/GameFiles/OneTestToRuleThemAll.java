package GameFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class OneTestToRuleThemAll {
	
	@Test
	void testSelectionModel() {
		assertTrue(true);
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
		
		assertEquals(oldx1,tdm.getGame().get(0).getX());
		assertEquals(oldy1,tdm.getGame().get(0).getY());
		assertEquals(oldx2,tdm.getGame().get(1).getX());
		assertEquals(oldy2,tdm.getGame().get(1).getY());
	}
	
	@Test
	void testTopDownView() {
		
	}
	
}
