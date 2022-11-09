package org.triangle;

import org.point.Point;
import org.util.enums.TriangleSides;
import org.util.enums.TriangleTypes;
import org.util.interfaces.AreaCalculator;
import org.util.interfaces.TriangleMaker;
import org.util.interfaces.TypeQualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Triangle implements TriangleMaker, TypeQualifier, AreaCalculator {
    private Point a;
    private Point b;
    private Point c;

    private List<Double> sides = new ArrayList<Double>();

    private TriangleTypes triangleType;

    private Point createPoint() {
        Scanner readme = new Scanner(System.in);
        double x, y;

        x = readme.nextDouble();
        y = readme.nextDouble();

        return new Point(x, y);
    }

    @Override
    public void createTriangle() {
        this.a = createPoint();
        this.b = createPoint();
        this.c = createPoint();

        qualifyType();
    }

    private double calculateLength(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    @Override
    public void qualifyType() {
        sides.add(calculateLength(this.a, this.b));
        sides.add(calculateLength(this.b, this.c));
        sides.add(calculateLength(this.a, this.c));

        System.out.println(sides.get(TriangleSides.AB.ordinal()));
        System.out.println(sides.get(TriangleSides.BC.ordinal()));
        System.out.println(sides.get(TriangleSides.AC.ordinal()));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "Ax: " + a.getX() + " Ay: " + a.getY()+
                ", Bx: " + b.getX() + " By: " + b.getY() +
                ", Cx: " + c.getX() + " Cy: " + c.getY() + "}";
    }

    public Point getA() { return a; }
    public void setA(Point a) { this.a = a; }

    public Point getB() { return b; }
    public void setB(Point b) { this.b = b; }

    public Point getC() { return c; }
    public void setC(Point c) { this.c = c; }
}
