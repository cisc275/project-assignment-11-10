package testing;

import java.awt.Polygon;

public class ZGameObject1 extends Polygon {
	int XSQUARE = 100;
	int YSQUARE = 200;
	int ZSQUARE = 300;
	int ACFX = 500;
	int ACFY = 600;
	int ACIX = 700;
	int ACIY = 800;
	int x;
	
public boolean collidesWith(ZGameObject1 g) {
	return this.getBounds2D().intersects(g.getBounds2D());
}
	
}
