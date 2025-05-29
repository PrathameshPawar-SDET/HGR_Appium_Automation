package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class LoginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;


    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement mobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
    private WebElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    private WebElement hgrLogo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Your next job is just a click away']")
    private WebElement headerText;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterMobileNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
        mobileNumberField.click();
        mobileNumberField.clear();
        mobileNumberField.sendKeys(phoneNumber);
    }

    // Method to click Continue button
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    // Check if Continue button is enabled
    public boolean isContinueButtonEnabled() {
        try {
            return continueButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    // Complete the login flow
    public void completeLoginWithMobileNumber(String phoneNumber) {
        enterMobileNumber(phoneNumber);
        wait.until(driver -> isContinueButtonEnabled());
        clickContinueButton();
    }

    public boolean isLogoDisplayed(){
        try {
            return hgrLogo.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public String headerText(){
        return headerText.getAttribute("content-desc");
    }
}
