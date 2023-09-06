package com.example.geometric_shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {
    private final double base;
    private final double height;
    private final double side1;
    private final double side2;
    private final double side3;

    @Autowired
    public Triangle(
            @Value("${triangle.base}") double base,
            @Value("${triangle.height}") double height,
            @Value("${triangle.side1}") double side1,
            @Value("${triangle.side2}") double side2,
            @Value("${triangle.side3}") double side3) {

        if (base <= 0 || height <= 0 || side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Base, height, and sides must be positive");
        }

        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public boolean validateParameters() {
        return base > 0 && height > 0 && side1 > 0 && side2 > 0 && side3 > 0;
    }

    @Override
    public String getType() {
        return "Triangle";
    }
}
