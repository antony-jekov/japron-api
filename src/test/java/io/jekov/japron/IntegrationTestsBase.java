package io.jekov.japron;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@SpringBootTest
@Import(PostgresTestContainerConfig.class)
abstract class IntegrationTestsBase {

}
