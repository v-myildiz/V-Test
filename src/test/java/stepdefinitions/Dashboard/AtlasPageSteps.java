package stepdefinitions.Dashboard;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Dashboard.AtlasPage;
import utilities.ReusableMethods;

import java.util.NoSuchElementException;

public class AtlasPageSteps extends BaseStep {
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

    @Given("Login to the website as an User\\(n3).")
    public void login_to_the_website_as_an_user_n3() {
        atlasPage.loginUserDataAccessTestN3();

    }

    @Given("Login to the website as an Use\\(n2).")
    public void login_to_the_website_as_an_user_n2() {
        atlasPage.loginN2();
    }

    @Given("Login to the website as an User {string}.")
    public void login_to_the_website_as_an_user(String environment) {
        if (environment.equals("n2")){
            atlasPage.loginN2();}

        else if (environment.equals("n3")) {
            atlasPage.loginUserDataAccessTestN3();
        }

    }

    @Then("The user should be able to display the Help & Feedback button on all pages in the sidebar.")
    public void the_user_should_be_able_to_display_the_help_feedback_button_on_all_pages_in_the_sidebar() {
        atlasPage.checkHelpFeedbackButtonAllPages();
    }

    @Then("The user should click the Help & Feedback button and display the content on all pages without permission switch.")
    public void the_user_should_click_the_help_feedback_button_and_display_the_content_on_all_pages_without_permission_switch() {
        atlasPage.checkHelpFeedbackContentWithoutPermissionSwitch();
    }

    @Then("The user should click the Help & Feedback button and display the content on all pages with permission switch.")
    public void the_user_should_click_the_help_feedback_button_and_display_the_content_on_all_pages_with_permission_switch() {
        atlasPage.checkHelpFeedbackContentWithPermissionSwitch();

    }

    @When("The user selects company {string} and goes to page {string}.")
    public void the_user_selects_company_and_goes_to_page(String company, String page) {
        atlasPage.loginWithCompanyAndGoToPage(company,page);
    }
}