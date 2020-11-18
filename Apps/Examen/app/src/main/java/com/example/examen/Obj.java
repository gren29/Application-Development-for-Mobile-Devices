package com.example.examen;


public class Obj {
    double rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    double angulo;
    String figura;
    int n_lados;
    Point3D[] w;
    Point2D[] vScr;

    Obj(String paramString, int paramInt) {
        this.n_lados = paramInt;
        this.figura = paramString;
        double d = paramInt;
        Double.isNaN(d);
        this.angulo = 360.0D / d;

        double a1 = 0.0D;
        double a2 = 0.0D;
        double a3 = 0.0D;
        double d1 = 1.0D;
        double d2 = 0.86D;
        double d3 = 1.0D;
        double b1 = 1.0D;
        double b2 = 1.51D;
        double b3 = 0.74D;
        double c1 = 0.38D;
        double c2 = 1.13D;
        double c3 = 1.178D;
        Point3D[] arrayOfPoint3D = new Point3D[8];
        this.w = arrayOfPoint3D;
        this.vScr = new Point2D[8];
        arrayOfPoint3D[0] = new Point3D(1.0D, -1.0D, -1.0D);
        this.w[1] = new Point3D(b1, b2, b3);
        this.w[2] = new Point3D(c1, c2, c3);
        this.w[3] = new Point3D(d1, -d2, d3);
        this.w[4] = new Point3D(1.0D, -1.0D, 1.0D);
        this.w[5] = new Point3D(1.0D, 1.0D, 1.0D);
        this.w[6] = new Point3D(-1.0D, 1.0D, 1.0D);
        this.w[7] = new Point3D(-1.0D, -1.0D, 1.0D);

        this.objSize = Math.sqrt(12.0D);

        this.rho = this.objSize * 5.0D;
    }

    void eyeAndScreen() {
        initPersp();
        int i = 8;
        int j;
        for (j = 0; j < i; j++) {
            Point3D point3D = this.w[j];
            double d1 = this.v11;
            double d2 = point3D.x;
            double d3 = this.v21;
            double d4 = point3D.y;
            double d5 = this.v12;
            double d6 = point3D.x;
            double d7 = this.v22;
            double d8 = point3D.y;
            double d9 = this.v32;
            double d10 = point3D.z;
            double d11 = this.v13 * point3D.x + this.v23 * point3D.y + this.v33 * point3D.z + this.v43;
            Point2D[] arrayOfPoint2D = this.vScr;
            double d12 = this.d;
            arrayOfPoint2D[j] = new Point2D(-d12 * (d1 * d2 + d3 * d4) / d11, -d12 * (d5 * d6 + d7 * d8 + d9 * d10) / d11);
        }
    }

    void initPersp() {
        double d1 = Math.cos(this.theta);
        double d2 = Math.sin(this.theta);
        double d3 = Math.cos(this.phi);
        double d4 = Math.sin(this.phi);
        this.v11 = -d2;
        this.v12 = -d3 * d1;
        this.v13 = d4 * d1;
        this.v21 = d1;
        this.v22 = -d3 * d2;
        this.v23 = d4 * d2;
        this.v32 = d4;
        this.v33 = d3;
        this.v43 = -this.rho;
    }
}
