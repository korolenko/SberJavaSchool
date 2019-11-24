package FinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class FinalProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }
}

