package org.example;

import com.intuit.karate.junit5.Karate;

class ApiTest {
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features/api-tests.feature").relativeTo(getClass());
    }
}

