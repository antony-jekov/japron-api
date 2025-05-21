package io.jekov.japron;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;


@TestConfiguration(proxyBeanMethods = false)
class PostgresTestContainerConfig {

    static final PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>(DockerImageName.parse("postgres:17-alpine"))
                    .withDatabaseName("japron_test_db")
                    .withUsername("japron_test_user")
                    .withPassword("japron_test_password");

    static {
        postgresContainer.start();
    }

    @Bean
    public DataSource dataSource() {
        final var config = new HikariConfig();
        config.setJdbcUrl(postgresContainer.getJdbcUrl());
        config.setUsername(postgresContainer.getUsername());
        config.setPassword(postgresContainer.getPassword());

        return new HikariDataSource(config);
    }

}
