package org.triangle;

import org.point.Point;
import org.shape.Shape;
import org.util.enums.AngleTypes;
import org.util.enums.TriangleSides;
import org.util.enums.TriangleTypes;
import org.util.interfaces.TriangleMaker;

import java.util.Objects;
import java.util.Scanner;

public class Triangle extends Shape implements TriangleMaker {
    private Point a, b, c;
    private final Double[] sides = new Double[3];
    private TriangleTypes triangleType;
    private AngleTypes angleType;

    private Point createPoint() {
        Scanner readme = new Scanner(System.in);
        double x, y;

        System.out.println("Enter the coordinates of the triangle: ");
        x = readme.nextDouble();
        y = readme.nextDouble();

        return new Point(x, y);
    }

    @Override
    public void createTriangle() {
        this.a = createPoint();
        this.b = createPoint();
        this.c = createPoint();

        sides[TriangleSides.AB.ordinal()] = calculateLength(this.a, this.b);
        sides[TriangleSides.BC.ordinal()] = calculateLength(this.b, this.c);
        sides[TriangleSides.AC.ordinal()] = calculateLength(this.a, this.c);

        while(!triangleExists()) {
            System.out.println("Enter a valid triangle");
            createTriangle();
        }

        qualifySidesType();
        qualifyAnglesType();
    }

    private Boolean triangleExists() {
        return sides[TriangleSides.AB.ordinal()]+sides[TriangleSides.BC.ordinal()] > sides[TriangleSides.AC.ordinal()] &&
          sides[TriangleSides.AB.ordinal()]+sides[TriangleSides.AC.ordinal()]>sides[TriangleSides.BC.ordinal()] &&
          sides[TriangleSides.BC.ordinal()]+sides[TriangleSides.AC.ordinal()]>sides[TriangleSides.AB.ordinal()];
    }

    private double calculateLength(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    private void qualifySidesType() {
        if(isEquilateral()) {
            triangleType = TriangleTypes.EQUILATERAL;
        } else if(isIsosceles()) {
            triangleType = TriangleTypes.ISOSCELES;
        } else {
            triangleType = TriangleTypes.SCALENE;
        }
    }

    private void qualifyAnglesType() {
        if(isRectangular()) {
            angleType = AngleTypes.RIGHT;
        } else if(isAcute() || triangleType == TriangleTypes.EQUILATERAL) {
            angleType = AngleTypes.ACUTE;
        } else {
            angleType = AngleTypes.OBTUSE;
        }
    }

    private Boolean isIsosceles() {
        return (Objects.equals(sides[TriangleSides.AB.ordinal()], sides[TriangleSides.BC.ordinal()]) ||
                Objects.equals(sides[TriangleSides.BC.ordinal()], sides[TriangleSides.AC.ordinal()]) ||
                Objects.equals(sides[TriangleSides.AB.ordinal()], sides[TriangleSides.AC.ordinal()]));
    }


    private Boolean isEquilateral() {
        return Objects.equals(sides[TriangleSides.AB.ordinal()], sides[TriangleSides.BC.ordinal()]) &&
                Objects.equals(sides[TriangleSides.BC.ordinal()], sides[TriangleSides.AC.ordinal()]);
    }

    private Boolean isRectangular() {
        return Math.pow(sides[TriangleSides.AB.ordinal()], 2) == Math.pow(sides[TriangleSides.BC.ordinal()], 2)
                + Math.pow(sides[TriangleSides.AC.ordinal()], 2) || Math.pow(sides[TriangleSides.BC.ordinal()], 2) ==
                Math.pow(sides[TriangleSides.AC.ordinal()], 2) + Math.pow(sides[TriangleSides.AB.ordinal()], 2) ||
                Math.pow(sides[TriangleSides.AC.ordinal()], 2) == Math.pow(sides[TriangleSides.BC.ordinal()], 2) +
                Math.pow(sides[TriangleSides.AB.ordinal()], 2);
    }

    private Boolean isAcute() {
        return (Math.pow(sides[TriangleSides.AB.ordinal()], 2) < Math.pow(sides[TriangleSides.BC.ordinal()], 2)
                + Math.pow(sides[TriangleSides.AC.ordinal()], 2)) &&
                (Math.pow(sides[TriangleSides.BC.ordinal()], 2) < Math.pow(sides[TriangleSides.AC.ordinal()], 2)
                        + Math.pow(sides[TriangleSides.AB.ordinal()], 2)) &&
                (Math.pow(sides[TriangleSides.AC.ordinal()], 2) < Math.pow(sides[TriangleSides.BC.ordinal()], 2)
                        + Math.pow(sides[TriangleSides.AB.ordinal()], 2));
    }

    public Point getA() { return a; }
    public void setA(Point a) { this.a = a; }

    public Point getB() { return b; }
    public void setB(Point b) { this.b = b; }

    public Point getC() { return c; }
    public void setC(Point c) { this.c = c; }

    public TriangleTypes getTriangleType() {
        return triangleType;
    }

    @Override
    public void calculateArea() {
        double semiPerimeter = perimeter / 2;
        area = Math.sqrt(semiPerimeter * (semiPerimeter - sides[TriangleSides.AB.ordinal()])*
                (semiPerimeter - sides[TriangleSides.AC.ordinal()])*(semiPerimeter - sides[TriangleSides.BC.ordinal()]));
    }

    @Override
    public void calculatePerimeter() {
        perimeter = sides[TriangleSides.AB.ordinal()] + sides[TriangleSides.AC.ordinal()] + sides[TriangleSides.BC.ordinal()];
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "Ax: " + a.getX() + " Ay: " + a.getY()+
                ", Bx: " + b.getX() + " By: " + b.getY() +
                ", Cx: " + c.getX() + " Cy: " + c.getY() +
                ", " + "AB: " + sides[TriangleSides.AB.ordinal()] + ", " + "BC: " +
                sides[TriangleSides.BC.ordinal()] + ", " + "AC: " +
                sides[TriangleSides.AC.ordinal()] + ", " +
                triangleType.toString() + ", " + angleType.toString() +
                ", Area: " + area + ", Perimeter: " + perimeter + "}";
    }
}
