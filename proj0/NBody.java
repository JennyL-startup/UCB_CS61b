
public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		int n = in.readInt();
		double r = in.readDouble();
		return r;
	}
	public static Body[] readBodies(String filename) {
		In in = new In(filename);
		int n = in.readInt();
		double r = in.readDouble();
		Body[] bodies = new Body[n];
		for(int i = 0; i < n; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			bodies[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, img);
		}
		return bodies;
	}
	public static void main(String[] args) {
		double T, dt, time;
		T = 157788000.0;
		dt = 25000.0;
		time = 0;
		String filename = "data/planets.txt";
		double r = NBody.readRadius(filename);
		Body[] bodies = NBody.readBodies(filename);
		String background = "images/starfield.jpg";
		
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-r, r);
		
		while (time <= T) {
			double[] xForces = null;
			double[] yForces = null;
			xForces = new double[bodies.length];
			yForces = new double[bodies.length];
			/*
			 * Calculate and update all xForces and yForces.
			 */
			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}
			/*
			 * Update bodies.
			 */
			for(int i = 0; i < bodies.length; i++) {
				bodies[i].update(dt, xForces[i], yForces[i]);
			}
			/*
			 * Draw background.
			 */
			StdDraw.picture(0, 0, background);
			/*
			 * Draw all bodies.
			 */
			for(Body B : bodies) {
				B.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		/*
		 * Print results.
		 */
		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < bodies.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
		                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
	}

}
