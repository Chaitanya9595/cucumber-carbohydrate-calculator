package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CarbohydrateCalculatorPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarbohydrateCalculatorSteps {
    WebDriver driver;
    CarbohydrateCalculatorPage carbPage;

    @Given("I open the Carbohydrate Calculator page")
    public void i_open_the_carbohydrate_calculator_page() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
        carbPage = new CarbohydrateCalculatorPage(driver);
    }

    @When("I enter age {int}")
    public void i_enter_age(Integer age) {
        carbPage.enterAge(age.toString());
    }

    @When("I select sex {string}")
    public void i_select_sex(String sex) {
        carbPage.selectSex(sex);
    }

    @When("I enter height {int}")
    public void i_enter_height(Integer height) {
        carbPage.enterHeight(height.toString());
    }

    @When("I enter weight {int}")
    public void i_enter_weight(Integer weight) {
        carbPage.enterWeight(weight.toString());
    }

    @When("I select activity level {int}")
    public void i_select_activity_level(Integer level) {
        carbPage.selectActivityLevel(level);
    }

    @When("I click on the Calculate button")
    public void i_click_on_the_calculate_button() {
        carbPage.clickCalculateButton();
    }

    @Then("I should see the carbohydrate intake result")
    public void i_should_see_the_carbohydrate_intake_result() {
        assertTrue(carbPage.isResultDisplayed());
        driver.quit();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        String actualMessage = carbPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }
}
