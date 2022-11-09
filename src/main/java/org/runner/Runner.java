package org.runner;

import org.triangle.Triangle;

public class Runner {
    public static void main(String[] args) {
        Triangle testTriangle = new Triangle();
        testTriangle.createTriangle();
        System.out.println(testTriangle.toString());
    }
}
