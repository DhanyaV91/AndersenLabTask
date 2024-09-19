package AQATest;

import java.util.Random;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    private ChromeDriver driver;
    private RegisterPage registerPage;
    private Random rand = new Random();

    @BeforeMethod
    public void setUp() {

        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize the RegistrationPage object
        registerPage = new RegisterPage(driver);

        // Navigate to the registration page
        driver.get("https://try.vikunja.io/register");
    }

    @Test(priority=0)
    public void testSuccessRegistration() throws InterruptedException {
        // Generate random integers for unique username and email
        int randInt = rand.nextInt(1000);

        // Fill the registration form using methods from RegistrationPage
        registerPage.enterUsername("Tester" + randInt);
        registerPage.enterEmail("tester" + randInt + "@gmail.com");
        registerPage.enterPassword("Tester@123");

        // Click the register button
        registerPage.clickRegister();

        // Wait for registration completion
        registerPage.waitForRegistrationToComplete();
        
        registerPage.waitForDashboardToAppear();
        registerPage.checkDashboardTitle("Tester" + randInt);
    }
    
    @Test(priority=1)
    public void testUnSuccessRegistrationWithInvalidUsername() throws InterruptedException {
        // Generate random integers for unique username and email
        int randInt = rand.nextInt(1000);

        // Fill the registration form using methods from RegistrationPage
        registerPage.enterUsername("AB");
        registerPage.enterEmail("ABCD" + randInt + "@gmail.com");
        registerPage.enterPassword("ABCD@123");

        // Click the register button
        registerPage.clickRegister();

        // Wait for registration completion
        registerPage.waitForErrorMessage();
    }
    
    @Test(priority=2)
    public void testUnSuccessRegistrationWithInvalidEmail() throws InterruptedException {
        // Generate random integers for unique username and email
        int randInt = rand.nextInt(1000);

        // Fill the registration form using methods from RegistrationPage
        registerPage.enterUsername("Tester" + randInt);
        registerPage.enterEmail("ABCD" + randInt + "$#@%.com");
        registerPage.enterPassword("ABCD@123");

        // Click the register button
        registerPage.clickRegister();

        // Wait for registration completion
        registerPage.waitForErrorMessage();
    }
    
    @Test(priority=3)
    public void testUnSuccessRegistrationWithInvalidPassword() throws InterruptedException {
        // Generate random integers for unique username and email
        int randInt = rand.nextInt(1000);

        // Fill the registration form using methods from RegistrationPage
        registerPage.enterUsername("Tester" + randInt);
        registerPage.enterEmail("ABCD" + randInt + "@gmail.com");
        registerPage.enterPassword("ABCD");
        // Click the register button
        registerPage.clickRegister();
        registerPage.waitForPasswordErrorMessage();
        registerPage.checkPasswordErrorMessage();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
