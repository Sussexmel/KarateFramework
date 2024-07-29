package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends UIInteractionSteps {

    private List<Map<String, String>> users;

    public void loadData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        users = mapper.readValue(new File("src/test/resources/users.json"), new TypeReference<List<Map<String, String>>>() {});
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        openUrl("https://www.demoblaze.com/index.html");
    }

    @When("the user logs in with {string}")
    public void theUserLogsInWith(String userType) {
        try {
            loadData();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load data", e);
        }
        Map<String, String> user = users.stream()
                .filter(u -> u.get("type").equals(userType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User type not found: " + userType));

        $(By.id("login2")).click();
        $(By.id("loginusername")).sendKeys(user.get("username"));
        $(By.id("loginpassword")).sendKeys(user.get("password"));
        $(By.cssSelector("button[onclick='logIn()']")).click();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        assertThat($(By.id("nameofuser")).isVisible()).isTrue();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        assertThat($(By.id("nameofuser")).isVisible()).isFalse();
    }
}
