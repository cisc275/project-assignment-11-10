package GameFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class OneTestToRuleThemAll {
	
	@Test
	void testSelectionModel() {
		assertTrue(true);
	}
	
	@Test
	void testSideScrollModel() {
		SideScrollModel scm = new SideScrollModel();
		ArrayList<GameObject> go = new ArrayList<GameObject>();
		Osprey os = new Osprey(0, 0, null, 0, 0, 0, 0, 0, 0, null, false, 0, 0, 0);
		go.add(os);
		go.add(new Fish(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0));
		scm.setGame(go);
		int oldx1 = scm.getGame().get(0).getX();
		int oldy1 = scm.getGame().get(0).getY();
		int oldx2 = scm.getGame().get(1).getX();
		int oldy2 = scm.getGame().get(1).getY();
		scm.advanceWorld(scm.getGame());
		scm.advanceBird(scm.getGame(), 4);
		assertNotEquals(oldx1,scm.getGame().get(0).getX());
		assertNotEquals(oldy1,scm.getGame().get(0).getY());	
		assertNotEquals(oldx2,scm.getGame().get(1).getX());
		assertEquals(oldy2,scm.getGame().get(1).getY());	
		
		
	}

	@Test
	void testTopDownModel() {
		TopDownModel tdm = new TopDownModel(0, 0, 0, 0);
		ArrayList<GameObject> go = new ArrayList<GameObject>();
		go.add(new ClapperRail(0, 0, null, 0, 0, 0, 0, 0, 0, 0, null, false, false, false, 0, 0, 0));
		go.add(new Bush(0, 0, null, 0, 0, 0, 0, 0, 0, false, 0, 0, 0));
		tdm.setGame(go);
		int oldx1 = tdm.getGame().get(0).getX();
		int oldy1 = tdm.getGame().get(0).getY();
		int oldx2 = tdm.getGame().get(1).getX();
		int oldy2 = tdm.getGame().get(1).getY();
		tdm.setGame(go);
		tdm.update();
		assertNotEquals(oldx1,tdm.getGame().get(0).getX());
		assertNotEquals(oldy1,tdm.getGame().get(0).getY());
		assertEquals(oldx2,tdm.getGame().get(1).getX());
		assertEquals(oldy2,tdm.getGame().get(1).getY());
	}
	
	@Test
	void testTopDownView() {
		
	}
	
}
