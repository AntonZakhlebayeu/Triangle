package org.util.enums;

public enum AngleTypes {
    RIGHT("RightTriangle"),
    OBTUSE("ObtuseAngle"),
    ACUTE("AcuteAngle");

    AngleTypes(String name) { this.name = name; }
    private final String  name;

    @Override
    public String toString() {
        return name;
    }
}
