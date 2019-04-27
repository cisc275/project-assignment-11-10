package testing;

public class ZTrash1 extends ZGameObject1{

	public ZTrash1(int x) {
		this.x = x;
		this.addPoint(this.x + XSQUARE, this.x - XSQUARE);
		this.addPoint(this.x + XSQUARE, this.x);
		this.addPoint(this.x + YSQUARE, this.x);
		this.addPoint(this.x + YSQUARE, this.x - XSQUARE);
	}
	
	public void move() {
		this.translate((int) ZOsprey1.getXSpeed(), 0);
		if((this.xpoints[3] <= 0)) {
			this.reset();
			this.addPoint(this.x + XSQUARE, this.x - XSQUARE);
			this.addPoint(this.x + XSQUARE, this.x);
			this.addPoint(this.x + YSQUARE, this.x);
			this.addPoint(this.x + YSQUARE, this.x - XSQUARE);
				
		}
	}

}

