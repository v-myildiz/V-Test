package stepdefinitions;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.UserManagementPage;
import utilities.ReusableMethods;

public class UserManagementPageSteps extends BaseStep{
    UserManagementPage userManagementPage=new UserManagementPage(driver);
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_screenshot_" + scenario.getName());
        } else {
            Driver.closeDriver();
        }
    }

    @Then("The user shouldn't add a new user {string} with a constant patter email {string}.")
    public void the_user_shouldn_t_add_a_new_user_with_a_constant_patter_email(String name, String mail) {
        userManagementPage.addAtlasUserIncorrect(name,mail);
        driver.navigate().back();
        ReusableMethods.waitForVisibilityNew(driver,userManagementPage.addAtlasUserButton);
    }

    @Then("The user shouldn't add a new user {string} with a free email {string}.")
    public void the_user_shouldn_t_add_a_new_user_with_a_free_email(String name, String mail) {
        userManagementPage.addAtlasUserIncorrect(name,mail);
        driver.navigate().back();
        ReusableMethods.waitForVisibilityNew(driver,userManagementPage.addAtlasUserButton);
    }

    @Then("The user should add a new user {string} with an email that may be a company email {string}.")
    public void the_user_should_add_a_new_user_with_an_email_that_may_be_a_company_email(String name, String mail) {
        userManagementPage.addAtlasUserCorrect(name,mail);

    }

}
