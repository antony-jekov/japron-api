package io.jekov.japron;

import org.springframework.boot.SpringApplication;
import org.springframework.modulith.Modulith;


@Modulith(systemName = "japron-api")
public class JapronApplication {

    public static void main(String[] args) {
        SpringApplication.run(JapronApplication.class, args);
    }

}
