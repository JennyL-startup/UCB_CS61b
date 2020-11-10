public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	public Body(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Body(Body B) {
		xxPos = B.xxPos;
		yyPos = B.yyPos;
		xxVel = B.xxVel;
		yyVel = B.yyVel;
		mass = B.mass;
		imgFileName = B.imgFileName;
	}
	
	public double calcDistance(Body B) {
		double dx2, dy2, r;
		dx2 = Math.pow((this.xxPos - B.xxPos), 2.0);
		dy2 = Math.pow((this.yyPos - B.yyPos), 2.0);
		r = Math.sqrt(dx2 + dy2);
		return r;
	}
	
	public double calcForceExertedBy(Body B) {
		final double G = 6.67e-11;
		double F;
		F = (G*this.mass*B.mass)/Math.pow(this.calcDistance(B), 2.0);
		return F;
	}
	
	public double calcForceExertedByX(Body B) {
		double Fx;
		Fx = this.calcForceExertedBy(B)*Math.abs(this.xxPos - B.xxPos)/this.calcDistance(B);
		return Fx;
	}
	
	public double calcForceExertedByY(Body B) {
		double Fy;
		Fy = this.calcForceExertedBy(B)*Math.abs(this.yyPos - B.yyPos)/this.calcDistance(B);
		return Fy;
	}
	
	public double calcNetForceExertedByX(Body[] B) {
		double Fnx = 0;
		for(int i = 0; i < B.length; i++) {
			if(this == B[i]) {
				double Fix = 0;
				Fnx += Fix;
			}else {
				double Fix = this.calcForceExertedBy(B[i])*(B[i].xxPos - this.xxPos)/this.calcDistance(B[i]);
				Fnx += Fix;
			}

		}
		return Fnx;
	}
	
	public double calcNetForceExertedByY(Body[] B) {
		double Fny = 0;
		for(int i = 0; i < B.length; i++) {
			if(this == B[i]) {
				double Fiy = 0;
				Fny += Fiy;
			}else {
				double Fiy = this.calcForceExertedBy(B[i])*(B[i].yyPos - this.yyPos)/this.calcDistance(B[i]);
				Fny += Fiy;
			}
		}
		return Fny;	
	}
	
	public void update(double dt, double fX, double fY) {
		double anx, any;
		anx = fX/this.mass;
		any = fY/this.mass;
		this.xxVel += dt*anx;
		this.yyVel += dt*any;
		this.xxPos += dt*this.xxVel;
		this.yyPos += dt*this.yyVel;
	}
	
	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}
}
