package io.jekov.japron;

import org.springframework.boot.SpringApplication;


public class TestJapronApplication {

    public static void main(String[] args) {
        SpringApplication.from(JapronApplication::main)
                .with(PostgresTestContainerConfig.class)
                .run(args);
    }

}
