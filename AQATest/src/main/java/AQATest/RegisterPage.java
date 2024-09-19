package AQATest;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for web elements
    private By usernameField = By.id("username");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By registerButton = By.id("register-submit");
    private By dashboardTitle = By.xpath("//*[@id=\"app\"]/div[2]/div/main/div/h2");
    private By errorMsg = By.xpath("//*[@id=\"app\"]/div[2]/div[2]/section[2]/div[1]/div[3]/div/div");
    private By errorMsgForPswd = By.xpath("//*[@id=\"registerform\"]/div[3]/p");
    
    Random rand = new Random();
    
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
	
    // Method to set username
    public void enterUsername(String username) {
    	wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to set email
    public void enterEmail(String email) throws InterruptedException {
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to set password
    public void enterPassword(String password) {
    	wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the Register button
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    // Method to wait for the register button to disappear (indicating submission)
    public void waitForRegistrationToComplete() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(registerButton));
    }
    
    public void waitForDashboardToAppear() {
        wait.until(ExpectedConditions.presenceOfElementLocated(dashboardTitle));
    }
    
    public void checkDashboardTitle(String title) {
        String titleDashboard = title;
        Assert.assertTrue(driver.findElement(dashboardTitle).getText().contains("Hi " + titleDashboard + "!"));
    }
    
    public void waitForErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
    }

    public void waitForPasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgForPswd));
    }
    
    public void checkPasswordErrorMessage() {
        String errorText = driver.findElement(errorMsgForPswd).getText();
        // Assert that the appropriate error message is displayed
        Assert.assertTrue(errorText.contains("Password must have at least 8 characters."));
    }
}
