package org.runner;

import org.triangle.Triangle;

public class Runner {
    public static void main(String[] args) {
        Triangle testTriangle = new Triangle();
        testTriangle.createTriangle();
        testTriangle.calculatePerimeter();
        testTriangle.calculateArea();
        System.out.println(testTriangle.toString());
    }
}
