package com.thomson.effective.enumsandannotations.item30;

/**
 * Enum type with data and behavior
 *
 * To associate data with enum constant, declare instance fields and write a constructor that takes the data and stores
 * it in the fields.
 * Enums are by their nature immutable, so all fields should be final.
 * <p/>
 * User: ThomsonTang
 * Date: 8/23/13
 * Time: 8:28 AM
 */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6);
    // others ...

    private final double mass; // In kilograms
    private final double radius; // In meters
    private final double surfaceGravity; // In m / s^2

    // Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }
}
