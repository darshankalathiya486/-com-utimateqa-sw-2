package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1. Verify 'Welcome Back!' text by method name userShouldNavigateToLoginPageSuccessfully
 *                  * click on the ‘Sign In’ link
 *                  * Verify the text ‘Welcome Back!’
 * 2. Verify the error message by method name verifyTheErrorMessage
 *                  * click on the ‘Sign In’ link
 *                  * Enter invalid username
 *                  * Enter invalid password
 *                  * Click on Login button
 *                  * Verify the error message ‘Invalid email or password.’
 *
 */

public class LoginTest extends BaseTest  {

    // Declare baseUrl
    String baseUrl = "https://courses.ultimateqa.com/";


    // Open Browser
    @Before
    public void setUP(){
        openBrowser(baseUrl);
    }

    @Test
    // Method name userShouldNavigateToLoginPageSuccessfully
    public void userShouldNavigateToLoginPageSuccessfully(){

        // Find Sign in link and click sign in link
        WebElement signLink = driver.findElement(By.xpath("//a[contains(text(), 'Sign In')] "));
        signLink.click();

        // Find text and verify text
        // expected text
        String expectedText = "Welcome Back!";

        // actual text
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class= 'page__heading']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    // Method name verifyTheErrorMessage
    public void verifyTheErrorMessage() throws InterruptedException {

        // Find Sign in link and click sign in link
        WebElement signLink = driver.findElement(By.xpath("//li[@class = 'header__nav-item header__nav-sign-in'] "));
        signLink.click();

        // Find username field and enter username in the field
        WebElement userName = driver.findElement(By.id("user[email]"));
        userName.sendKeys("abcd@gmail.com");

        // Find password field and enter password in the field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("12344444");


        // Find Login button and click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class= 'button button-primary g-recaptcha']"));
        loginButton.click();

        Thread.sleep(5000);
        //Verify error message
        // expected text
        String expected = "Invalid email or password.";

        // actual text
        WebElement actualTextElement = driver.findElement(By.id("notice"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expected, actualText);

    }

    //Close browser
    @After
    public void tearDown(){
        closeBrowser();
    }

}
