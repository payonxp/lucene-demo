package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class DemoApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApp.class, args);
    }
}
