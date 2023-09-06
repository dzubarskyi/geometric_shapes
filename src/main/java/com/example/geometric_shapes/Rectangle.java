package com.example.geometric_shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape {
    private final double length;
    private final double width;

    @Autowired
    public Rectangle(@Value("${rectangle.length}") double length, @Value("${rectangle.width}") double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public boolean validateParameters() {
        return length > 0 && width > 0;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }
}
