
# Geometric Shapes Calculation API

This API allows you to calculate the area and perimeter of various geometric shapes, including squares, rectangles, triangles, and circles.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 8 or higher installed on your system.
- Maven (or Gradle) for building the project.
- Git for cloning the repository.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine:

   ```sh
   git clone https://github.com/dzubarskyi/geometric_shapes.git
   cd geometric-shapes-api


2. Build and run the application:

    ```
    mvn clean package
    java -jar target/Geometric_Shapes-0.0.1-SNAPSHOT.jar
    ```

### Using the API
Calculate Area and Perimeter
To calculate the area and perimeter of a geometric shape, make a POST request to the /shapes/calculate endpoint with the following JSON payload:

    
    {
      "type": "Square",   // Replace with the desired shape (Square, Rectangle, Triangle, Circle)
      "parameters": {
        "side": 5.0       // Replace with the specific parameters for the chosen shape
      }
    }
    

### Expected Responses
For valid requests, you will receive a response with HTTP status 200 OK and the calculated area and perimeter.

    
    {
      "area": 25.0,
      "perimeter": 20.0
    }
    

For invalid requests (e.g., invalid shape type or non-positive parameters), you will receive a response with HTTP status 400 Bad Request and an error message.

"Invalid shape type"

### Request Example
    
    curl -X POST -H "Content-Type: application/json" -d '{
       "type": "square",
       "sideLength": 5.0
    }' http://localhost:8080/shapes/calculate
    

### Additional Information

This API is built with Spring Boot 2 and Java 8+.
Validation is performed to ensure that input parameters are valid for each shape.

If you have any questions or encounter issues, please contact Dmytro.

Enjoy using the Geometric Shapes Calculation API!
