package stepdefinitions.Contributors;

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
import pages.Contributors.ContributorsPage;
import stepdefinitions.Dashboard.BaseStep;

public class ContributorsPageStep extends BaseStep {
ContributorsPage contributorsPage=new ContributorsPage(driver);

    // Merge Developer Icon Control Test
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

    // Checking [bot] Cont. Active-Passive Test
    @Then("The user selects a project {string}.")
    public void the_user_selects_a_project(String project) {
        contributorsPage.chooseAProject(project);

    }

    @Then("The user writes {string} into the search box.")
    public void the_user_writes_into_the_search_box(String string) {

    }

    @Then("The user checks [bot] contributors who were passive.")
    public void the_user_checks_bot_contributors_who_were_passive() {

    }

    @Then("The user changes [bot] contributors as an active.")
    public void the_user_changes_bot_contributors_as_an_active() {

    }

    @Then("The user checks [bot] contributors are active.")
    public void the_user_checks_bot_contributors_are_active() {

    }

}
