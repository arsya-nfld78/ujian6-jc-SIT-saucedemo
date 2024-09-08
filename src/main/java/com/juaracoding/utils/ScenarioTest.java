package com.juaracoding.utils;

public enum ScenarioTest {
    Test1("Successful login with valid credentials"),
    Test2("Login attempt with invalid password"),
    Test3("Login attempt with invalid username"),
    Test4("Login attempt with empty username and password"),
    Test5("Add two products to the cart successfully"),
    Test6("Successfully complete the checkout process"),
    Test7("Attempt checkout with missing information");

    private String scenarioTestName;

    ScenarioTest(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName() {
        return scenarioTestName;
    }
}
