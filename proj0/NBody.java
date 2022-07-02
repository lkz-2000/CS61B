public class NBody {
    public static double readRadius(String file_name){
        In in=new In(file_name);
        int N=in.readInt();
        double R=in.readDouble();
        return R;
    }
    public static Planet[] readPlanets(String file_name) {
        In in = new In(file_name);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet planet = new Planet(xP, yP, xV, yV, m, img);
            planets[i] = planet;
        }
        return planets;
    }
    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] planets=readPlanets(filename);
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);
        StdDraw.show();
        StdDraw.pause(10);
        for(int i=0;i< planets.length;i++){
            planets[i].draw();
        }
        StdDraw.enableDoubleBuffering();
        double t=0.0;
        while(t<T){
            double xForces[]=new double[planets.length];
            double yForces[]=new double[planets.length];
            for(int i=0;i<planets.length;i++){
                xForces[i]=planets[i].calcNetForceExertedByX(planets);
                yForces[i]=planets[i].calcNetForceExertedByY(planets);
            }
            for(int j=0;j< planets.length;j++){
                planets[j].update(dt,xForces[j],yForces[j]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for(int i=0;i< planets.length;i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t=t+dt;
            }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
        }

}


