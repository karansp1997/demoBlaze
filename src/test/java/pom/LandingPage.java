package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BaseHelper;

import java.time.Duration;

public class LandingPage extends BaseHelper {

    By signUpLink = By.xpath("//a[@id='signin2']");
    By loginLink = By.xpath("//a[@id='login2']");
    By logInUserNameInput = By.xpath("//input[@id='loginusername']");
    By logInPasswordInput =By.xpath("//input[@id='loginpassword']");
    By signUpUserNameInput = By.xpath("//input[@id='sign-username']");
    By loginButton = By.xpath("//button[text()='Log in']");
    By signUpUserNamePasswordInput = By.xpath("//input[@id='sign-password']");
    By signUpButton = By.xpath("//button[text()='Sign up']");
    By loggedInUserLink = By.xpath("//a[@id='nameofuser']");

    public void enterCredentialsForSignUp(String userName, String password) {
        waitUntilElementDisplayed(signUpUserNameInput);
        findElement(signUpUserNameInput).sendKeys(userName);
        waitUntilElementDisplayed(signUpUserNamePasswordInput);
        findElement(signUpUserNamePasswordInput).sendKeys(password);
    }

    public void clickOnSignUpButton() {
        findElement(signUpButton).click();
    }

    public void clickOnLoginLink() {
        findElement(loginLink).click();
    }

    public void clickOnSignUpLink() {
        findElement(signUpLink).click();
    }

    public boolean isUserLoginSuccessful() {
        waitUntilElementDisplayed(loggedInUserLink);
        return findElement(loggedInUserLink).isDisplayed();
    }

    public void enterCredentialsForLogin(String userName, String password) {
        waitUntilElementDisplayed(logInUserNameInput);
        findElement(logInUserNameInput).sendKeys(userName);
        waitUntilElementDisplayed(logInPasswordInput);
        findElement(logInPasswordInput).sendKeys(password);
    }

    public void clickOnLoginButton() {
        waitUntilElementDisplayed(loginButton);
        findElement(loginButton).click();
    }

    public boolean isUserLoggedIn() {
        return findElement(loggedInUserLink).isDisplayed();
    }

    public boolean isNewUserSignedUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String signUpAlertMessage = driver.switchTo().alert().getText();
        return signUpAlertMessage.equals("Sign up successful.");
    }



}
