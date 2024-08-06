package stepdefinitions.Dashboard;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Dashboard.AtlasPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestData.MailReader;

public class MailTrapLoginSteps extends BaseStep{
    AtlasPage atlasPage = new AtlasPage(driver);
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_screenshot_" + scenario.getName());
        } else {
            Driver.closeDriver();
        }
    }

    private MailReader mailReader = new MailReader();

    @Given("Login to the website as an User with Mailtrap.")
    public void login_to_the_website_as_an_user_with_mailtrap() throws Exception {
        try {
            atlasPage.loadHomePageN2();
            atlasPage.mailBox.sendKeys("myildiz@valven.com");
            atlasPage.passwordBox.sendKeys("Asdasdasd.123");
            atlasPage.signInText.click();

            // Take the OTP Code from the Mailtrap
            String otp = mailReader.getOtpCode(); // OTP kodunu Mailtrap'ten alın

            if (otp == null) {
                throw new Exception("OTP not received from Mailtrap.");
            }
            // Enter the OTP Code into the OTP Field
            atlasPage.otpField.sendKeys(otp);
            atlasPage.signInText.click();

        } finally {
        }
    }

}
