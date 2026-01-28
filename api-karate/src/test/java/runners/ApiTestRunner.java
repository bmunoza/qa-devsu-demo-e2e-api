package runners;

import com.intuit.karate.junit5.Karate;

public class ApiTestRunner {

    @Karate.Test
    Karate runApiTests() {
        return Karate.run("classpath:features");
    }
}
