package tests;


import org.junit.jupiter.api.Test;
import pom.LandingPage;
import util.BaseHelper;

public class LandingPageTest extends BaseHelper {

    LandingPage landingPage = new LandingPage();


    @Test
    public void verifyUserLogin() {
        waitUntilPageLoaded();
        landingPage.clickOnLoginLink();
        landingPage.enterCredentialsForLogin("TestUser@testuser.com","testuser123");
        landingPage.clickOnLoginButton();
        assert landingPage.isUserLoginSuccessful();
    }

    @Test
    public void verifyNewSignUp() {
        waitUntilPageLoaded();
        landingPage.clickOnSignUpLink();
        landingPage.enterCredentialsForSignUp("demoUser125@demouserWebsite.com","userInfo@1234");
        landingPage.clickOnSignUpButton();
        assert landingPage.isNewUserSignedUp();
    }

}
