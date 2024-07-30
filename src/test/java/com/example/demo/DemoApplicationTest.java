package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void main() {
        // Test if the main method starts the Spring Boot application without any exceptions
        DemoApplication.main(new String[]{});
    }

}