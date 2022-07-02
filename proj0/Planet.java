public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet P){
        this.xxPos=P.xxPos;
        this.yyPos=P.yyPos;
        this.xxVel=P.xxVel;
        this.yyVel=P.yyVel;
        this.mass=P.mass;
        this.imgFileName=P.imgFileName;
    }
    public double calcDistance(Planet a){
        double squar;
        squar=(this.yyPos-a.yyPos)*(this.yyPos-a.yyPos)+(this.xxPos-a.xxPos)*(this.xxPos-a.xxPos);
        return Math.sqrt(squar);
    }
    private static final double G=6.67e-11;
    public double calcForceExertedBy(Planet a){
        return this.mass*a.mass*G/(this.calcDistance(a)*this.calcDistance(a));
    }
    public double calcForceExertedByX(Planet a){
        return this.calcForceExertedBy(a)*(a.xxPos-this.xxPos)/this.calcDistance(a);
    }
    public double calcForceExertedByY(Planet a){
        return this.calcForceExertedBy(a)*(a.yyPos-this.yyPos)/this.calcDistance(a);
    }
    public double calcNetForceExertedByX(Planet[] a){
        double ByX=0;
        for(int i=0;i<a.length;i++){
            if(this.equals(a[i])!=true){
                ByX=ByX+this.calcForceExertedByX(a[i]);
            }
        }
        return ByX;
    }
    public double calcNetForceExertedByY(Planet[] a){
        double ByY=0;
        for(Planet i:a){
            if(this.equals(i)!=true){
                ByY=ByY+this.calcForceExertedByY(i);
            }
        }
        return ByY;
    }
    public void update(double dt,double fX,double fY){
        double ax=fX/this.mass;
        double ay=fY/this.mass;
        this.xxVel+=ax*dt;
        this.yyVel+=ay*dt;
        this.xxPos+=this.xxVel*dt;
        this.yyPos+=this.yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
        StdDraw.show();
        StdDraw.pause(10);
    }
}
