package com.example.geometric_shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
    private final double radius;

    @Autowired
    public Circle(@Value("${circle.radius}") double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean validateParameters() {
        return radius > 0;
    }

    @Override
    public String getType() {
        return "Circle";
    }
}
