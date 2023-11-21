package test_suite;

import browser_factory.Base_Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * <p>
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Login’ link
 * * Verify the text ‘Welcome, Please Sign
 * In!’
 * <p>
 * <p>
 * 2. userShouldLoginSuccessfullyWithValidCredentials
 * <p>
 * * click on the ‘Login’ link
 * * Enter valid username
 * * Enter valid password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Log out’ text is display
 * <p>
 * <p>
 * 3. verifyTheErrorMessage
 * <p>
 * * click on the ‘Login’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Login was unsuccessful.
 * Please correct the errors and try again. No customer account found’
 */
public class Login_In_Test extends Base_Test {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on the ‘Login’ link
        driver.findElement(By.className("ico-login")).click();

        //Verify the text ‘Welcome, Please Sign In!
        String expectedText = "Welcome, Please Sign In!";
        String actualText = driver.findElement(By.xpath("//h1")).getText();

        Assert.assertEquals(expectedText, actualText);
        System.out.println("Method 1");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //click on the ‘Login’ link
        driver.findElement(By.className("ico-login")).click();

        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("abc123@gmail.com");

        //Enter valid password
        driver.findElement(By.id("Password")).sendKeys("abc123");

        //Click on ‘LOGIN’ button
        driver.findElement(By.className("login-button")).click();

        //Verify the ‘Log out’ text is display
        String expectedText = "Log out";
        String actualText = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();

        Assert.assertEquals(expectedText, actualText);
        System.out.println("Method 2");
    }

    @Test
    public void verifyTheErrorMessage() {

        //click on the ‘Login’ link
        driver.findElement(By.className("ico-login")).click();

        //Enter invalid username
        driver.findElement(By.id("Email")).sendKeys("ab123@gmail.com");

        //Enter invalid password
        driver.findElement(By.id("Password")).sendKeys("abc23");

        //Click on Login button
        driver.findElement(By.className("login-button")).click();

        //Verify the error message ‘Login was unsuccessful.Please correct the errors and try again. No customer account found’
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again. \n" +
                "No customer account found";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        System.out.println("Method 3");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
