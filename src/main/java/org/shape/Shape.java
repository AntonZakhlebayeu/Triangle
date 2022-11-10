package org.shape;

import org.util.interfaces.AreaCalculator;
import org.util.interfaces.PerimeterCalculator;

public abstract class Shape implements AreaCalculator, PerimeterCalculator {
    protected double area;
    protected double perimeter;

    public double getArea() { return area; }
    public double getPerimeter() { return perimeter; }
}
