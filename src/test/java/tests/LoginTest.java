package tests;

import base.AndroidBaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AndroidBaseTest {

    @Test(priority = 1)
    public void verifyheaderText(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.headerText(),"Your next job is just a click away","Header text is not matching");
        System.out.println("Header text is verified");
    }

    @Test(priority = 2)
    public void testLoginWithValidMobileNumber() {
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("Testing login flow with valid phone number");

        Assert.assertFalse(loginPage.isContinueButtonEnabled(),
                "Continue button should be disabled initially");

        loginPage.completeLoginWithMobileNumber("1234567890");

    }


}