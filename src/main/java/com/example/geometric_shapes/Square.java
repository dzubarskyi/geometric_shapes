package com.example.geometric_shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {
    private final double side;

    @Autowired
    public Square(@Value("${square.side}") double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        this.side = side;
    }


    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public boolean validateParameters() {
        return side > 0;
    }

    @Override
    public String getType() {
        return "square";
    }
}
