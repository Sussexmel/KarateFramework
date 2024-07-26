package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends UIInteractionSteps {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        openUrl("https://www.demoblaze.com/index.html");
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        $(By.id("login2")).click();
        $(By.id("loginusername")).sendKeys("newuser"); // username creado en la prueba de API
        $(By.id("loginpassword")).sendKeys("password123");
        $(By.cssSelector("button[onclick='logIn()']")).click();
    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        $(By.id("login2")).click();
        $(By.id("loginusername")).sendKeys("wronguser");
        $(By.id("loginpassword")).sendKeys("wrongpassword");
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
