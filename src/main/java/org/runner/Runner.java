package org.runner;

import org.triangle.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static List<Triangle> triangles = new ArrayList<Triangle>();

    private static void fillTheTrianglesList(int trianglesNumber) {
        for(int i=0; i<trianglesNumber; i++) {
            Triangle triangle = new Triangle();
            triangle.createTriangle();
            triangle.calculatePerimeter();
            triangle.calculateArea();

            triangles.add(triangle);
        }
    }

    private static void printTriangles() {
        for(Triangle triangle : triangles) {
            System.out.println(triangle.toString());
        }
    }

//    private static double findMaxPerimeter() {
//
//    }


    public static void main(String[] args) {
        Scanner readme = new Scanner(System.in);

        System.out.println("Enter the number of triangles: ");
        int numberOfTriangles = readme.nextInt();

        fillTheTrianglesList(numberOfTriangles);
        printTriangles();
    }
}
