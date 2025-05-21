package io.jekov.japron;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;


public class JapronApplicationTests {

    @Test
    void verifyModules() {
        final var modules = ApplicationModules.of(JapronApplication.class)
                .verify();

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

}
