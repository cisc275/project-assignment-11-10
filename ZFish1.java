package testing;

public class ZFish1 extends ZGameObject1 {
	
		public ZFish1(int x) {
			this.x = x;
			this.addPoint(this.x, this.x);
			this.addPoint(this.x, this.x + XSQUARE);
			this.addPoint(this.x + XSQUARE, this.x + this.XSQUARE);
			this.addPoint(this.x + XSQUARE, this.x);
		}
		
		public void move() {
			this.translate((int) ZOsprey1.getXSpeed(), 0);
			if((this.xpoints[3] <= 0)) {
				this.reset();
				this.addPoint(this.x + YSQUARE, this.x);
				this.addPoint(this.x + YSQUARE, this.x + XSQUARE);
				this.addPoint(this.x + ZSQUARE, this.x + XSQUARE);
				this.addPoint(this.x + ZSQUARE, this.x);
					
			}
		}

	}
