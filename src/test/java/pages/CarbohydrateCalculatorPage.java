package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarbohydrateCalculatorPage {
    WebDriver driver;
    WebDriverWait wait;

    By ageField = By.name("cage");
    By maleRadioButton = By.xpath("//input[@name='csex'][@value='m']");
    By femaleRadioButton = By.xpath("//input[@name='csex'][@value='f']");
    By heightField = By.name("cheightmeter");
    By weightField = By.name("ckg");
    By activityLevelDropdown = By.name("cactivity");
    By calculateButton = By.xpath("//input[@value='Calculate']");
    By resultText = By.xpath("//div[@id='content']//b[contains(text(),'grams')]");
    By errorMessage = By.xpath("//div[@id='content']//font[contains(text(),'Please provide')]");

    public CarbohydrateCalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterAge(String age) {
        WebElement element = driver.findElement(ageField);
        element.clear();
        element.sendKeys(age);
    }

    public void selectSex(String sex) {
        WebElement button;
        if (sex.equalsIgnoreCase("male")) {
            button = driver.findElement(maleRadioButton);
        } else {
            button = driver.findElement(femaleRadioButton);
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

    }

    public void enterHeight(String height) {
        WebElement element = driver.findElement(heightField);
        element.clear();
        element.sendKeys(height);
    }

    public void enterWeight(String weight) {
        WebElement element = driver.findElement(weightField);
        element.clear();
        element.sendKeys(weight);
    }

    public void selectActivityLevel(int level) {
        Select dropdown = new Select(driver.findElement(activityLevelDropdown));
        dropdown.selectByIndex(level);
    }

    public void clickCalculateButton() {
        driver.findElement(calculateButton).click();
    }

    public boolean isResultDisplayed() {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultText));
        return result.isDisplayed();
    }

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }
}
