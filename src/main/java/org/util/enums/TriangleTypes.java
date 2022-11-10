package org.util.enums;

public enum TriangleTypes {
    ISOSCELES("Isosceles"),
    EQUILATERAL("Equilateral"),
    SCALENE("Scalene");

    private final String name;
    TriangleTypes(String name){this.name = name;}

    @Override
    public String toString() {
        return name;
    }
}
