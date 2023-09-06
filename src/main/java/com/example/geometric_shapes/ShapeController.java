package com.example.geometric_shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/shapes")
public class ShapeController {

    private final Map<String, Shape> shapeMap;

    @Autowired
    public ShapeController(List<Shape> shapes) {
        shapeMap = shapes.stream().collect(Collectors.toMap(s -> s.getType().toLowerCase(), Function.identity()));
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateShape(@RequestBody ShapeRequest request) {
        String requestedType = request.getType().toLowerCase(); // Convert to lowercase for case insensitivity
        Shape shape = shapeMap.get(requestedType);

        if (shape == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid shape type: " + request.getType());
        }

        if (!shape.validateParameters()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid parameters for the selected shape: " + request.getType());
        }

        double area = shape.calculateArea();
        double perimeter = shape.calculatePerimeter();

        ShapeResponse response = new ShapeResponse(area, perimeter);

        return ResponseEntity.ok(response);
    }
}
