package com.example.geometric_shapes;

import java.util.Map;

public class ShapeRequest {
    private String type;
    private Map<String, Double> parameters;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Double> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Double> parameters) {
        this.parameters = parameters;
    }
}
