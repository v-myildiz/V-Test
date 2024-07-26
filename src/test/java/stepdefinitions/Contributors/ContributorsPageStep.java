package stepdefinitions;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import pages.AtlasPage;
import pages.ContributorsPage;

public class ContributorsPageStep extends BaseStep{
    ContributorsPage contributorsPage=new ContributorsPage(driver);
    AtlasPage atlasPage=new AtlasPage(driver);

    @Then("The user clicks Manage Contributors Button.")
    public void the_user_clicks_manage_contributors_button() {
        contributorsPage.clickManageContributorsButton();

        }

    @Then("The user hovers over the Show Suggestions Button and displays the Merge Icon.")
    public void the_user_hovers_over_the_show_suggestions_button_and_displays_the_merge_icon() {
        contributorsPage.hoverShowSuggestions();
    }

    @Then("The user clicks the Show Suggestions Button and displays the Loading Icon or Suggestion Table during installation.")
    public void the_user_clicks_the_show_suggestions_button_and_displays_the_loading_icon_or_suggestion_table_during_installation() {
        contributorsPage.displayLoadingIcon();
    }

}
