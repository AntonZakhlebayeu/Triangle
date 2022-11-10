package org.runner;

import org.point.Point;
import org.triangle.Triangle;
import org.util.enums.TriangleTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static List<Triangle> triangles = new ArrayList<Triangle>();
    private static List<Triangle> isoscelesTriangles = new ArrayList<Triangle>();
    private static List<Triangle> equilateralTriangles = new ArrayList<Triangle>();
    private static List<Triangle> scaleneTriangles = new ArrayList<Triangle>();

    private static void fillTheTrianglesList(int trianglesNumber) {
        for(int i=0; i<trianglesNumber; i++) {
            Triangle triangle = new Triangle();
            triangle.createTriangle();
            triangles.add(triangle);
        }
    }

    private static void divideTheTrianglesByType() {
        for(Triangle triangle : triangles) {
            if(triangle.getTriangleType() == TriangleTypes.ISOSCELES) {
                isoscelesTriangles.add(triangle);
            } else if(triangle.getTriangleType() == TriangleTypes.EQUILATERAL) {
                equilateralTriangles.add(triangle);
            } else {
                scaleneTriangles.add(triangle);
            }
        }
    }

    private static void printTriangles(List<Triangle> triangles) {
        for(Triangle triangle : triangles) {
            System.out.println(triangle.toString());
        }
    }

    private static double findMaxPerimeter(List<Triangle> triangles) {
        double maxPerimeter = 0;

        for(Triangle triangle : triangles) {
            if (triangle.getPerimeter() > maxPerimeter) {
                maxPerimeter = triangle.getPerimeter();
            }
        }

        return maxPerimeter;
    }

    private static double findMinPerimeter(List<Triangle> triangles) {
        double minPerimeter = triangles.get(0).getPerimeter();

        for(Triangle triangle : triangles) {
            if (triangle.getPerimeter() < minPerimeter) {
                minPerimeter = triangle.getPerimeter();
            }
        }

        return minPerimeter;
    }

    private static double findMaxArea(List<Triangle> triangles) {
        double maxArea = 0;

        for(Triangle triangle : triangles) {
            if (triangle.getArea() > maxArea) {
                maxArea = triangle.getArea();
            }
        }

        return maxArea;
    }

    private static double findMinArea(List<Triangle> triangles) {
        double minArea = triangles.get(0).getArea();

        for(Triangle triangle : triangles) {
            if (triangle.getArea() < minArea) {
                minArea = triangle.getArea();
            }
        }

        return minArea;
    }

    public static void main(String[] args) {
        Scanner readme = new Scanner(System.in);

        System.out.println("Enter the number of triangles: ");
        int numberOfTriangles = readme.nextInt();

        fillTheTrianglesList(numberOfTriangles);
        printTriangles(triangles);

        divideTheTrianglesByType();

        if(equilateralTriangles.size() > 0) {
            System.out.println("=======================");
            System.out.println("Count of equilateral triangles: " + equilateralTriangles.size());
            System.out.println("Max area: " + findMaxArea(equilateralTriangles));
            System.out.println("Min area: " + findMinArea(equilateralTriangles));
            System.out.println("Max perimeter: " + findMaxPerimeter(equilateralTriangles));
            System.out.println("Min perimeter: " + findMinPerimeter(equilateralTriangles));
        }

        if(isoscelesTriangles.size() > 0) {
            System.out.println("=======================");
            System.out.println("Count of isosceles triangles: " + isoscelesTriangles.size());
            System.out.println("Max area: " + findMaxArea(isoscelesTriangles));
            System.out.println("Min area: " + findMinArea(isoscelesTriangles));
            System.out.println("Max perimeter: " + findMaxPerimeter(isoscelesTriangles));
            System.out.println("Min perimeter: " + findMinPerimeter(isoscelesTriangles));
        }

        if(scaleneTriangles.size() > 0) {
            System.out.println("=======================");
            System.out.println("Count of scalene triangles: " + scaleneTriangles.size());
            System.out.println("Max area: " + findMaxArea(scaleneTriangles));
            System.out.println("Min area: " + findMinArea(scaleneTriangles));
            System.out.println("Max perimeter: " + findMaxPerimeter(scaleneTriangles));
            System.out.println("Min perimeter: " + findMinPerimeter(scaleneTriangles));
        }

        System.out.println(triangles.get(0).toString());
        triangles.get(0).setA(new Point(0, 0));
        System.out.println(triangles.get(0).toString());
    }
}
