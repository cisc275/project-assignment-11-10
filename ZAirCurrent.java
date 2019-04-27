package testing;

public class ZAirCurrent extends ZGameObject1{
	public ZAirCurrent(int x) {
		this.x = x;
		this.addPoint(this.x + ACIX, this.x - XSQUARE);
		this.addPoint(this.x + ACIX, this.x);
		this.addPoint(this.x + ACIY, this.x);
		this.addPoint(this.x + ACIY, this.x - XSQUARE);
	}
	
	public void move() {
		this.translate((int) ZOsprey1.getXSpeed(), 0);
		if((this.xpoints[3] <= 0)) {
			this.reset();
			this.addPoint(this.x + ACFX, this.x - XSQUARE);
			this.addPoint(this.x + ACFX, this.x);
			this.addPoint(this.x + ACFY, this.x);
			this.addPoint(this.x + ACFY, this.x - XSQUARE);
				
		}
	}

}

