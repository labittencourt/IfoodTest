package hook;

import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

import static core.DriverFactory.*;
import static core.DriverFactory.testScenario;

public class Hook {
    @Before
    public void init(Scenario scenario) {
        testScenario.set(scenario);
        getDriver();

        String testName = testScenario.get().getName().replace(".", "");

        System.out.print("---------------------------------------------------------------------------------\n");
        System.out.print("=> Executando: ");
        System.out.print(testName +"\n");
        System.out.print("=> Steps: \n");
    }

    @After
    public void cleanUp() throws IOException {
        killDriver();

        Result.Type testStatus = testScenario.get().getStatus();

        System.out.print("=> Concluído\n");
        System.out.print("=> Resultado: "+ testStatus +"\n");
        System.out.print("---------------------------------------------------------------------------------\n");
    }
}
