package stepdefinitions;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.SettingsPage;

public class SettingsPageSteps extends BaseStep{
    SettingsPage settingsPage=new SettingsPage(driver);
@After
public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "failed_screenshot_" + scenario.getName());
    } else {
        Driver.closeDriver();
    }
}
    //PROFILE SETTINGS

    @Then("The user changes the Full Name {string} and check.")
    public void the_user_changes_the_full_name_and_check(String name) {
       settingsPage.checkFullNameProfileSettings(name);
    }

    @Then("The user changes the Show Cookie Preferences and check.")
    public void the_user_changes_the_show_cookie_preferences_and_check() {
        //   settingsPage.checkShowCookiePreferencesProfileSettings();

    }

    //COMPANY SETTINGS
    @Then("The user changes the Company Name {string} and check.")
    public void the_user_changes_the_company_name_and_check(String companyName) {
        settingsPage.checkCompanyName(companyName);
    }

    @Then("The user changes the Industry {string} and check.")
    public void the_user_changes_the_industry_and_check(String industry) {
        settingsPage.checkIndustry(industry);

    }

    @Then("The user changes the Timezone {string} and check.")
    public void the_user_changes_the_timezone_and_check(String timezone) {
        settingsPage.checkTimeZone(timezone);


    }

    @Then("The user changes the Working Days {string},{string},{string},{string},{string} and check.")
    public void the_user_changes_the_working_days_and_check(String day1, String day2, String day3, String day4, String day5) {
        settingsPage.checkWorkingDays(day1,day2,day3,day4,day5);

    }

    @Then("The user changes the Working Hours {string} and {string} and check.")
    public void the_user_changes_the_working_hours_and_and_check(String startHour, String endHour) {
        settingsPage.checkWorkingHours(startHour,endHour);

    }

    @Then("The user changes the Average Man Day Cost {string} and check.")
    public void the_user_changes_the_average_man_day_cost_and_check(String cost) {
        settingsPage.checkAverageManDayCost(cost);

    }

    @Then("the user changes the Two-Factor Authentication and check.")
    public void the_user_changes_the_two_factor_authentication_and_check() {
           settingsPage.checkTwoFactorAuthenticationButton();



    }

    //TEAM SETTINGS
    @Then("The user imports the Team From Repositories {string} and check.")
    public void the_user_imports_the_team_from_repositories_and_check(String teamNameFromRepo) {
        settingsPage.checkImportTeamFromRepositories(teamNameFromRepo);

    }

    @Then("The user creates the New Team {string} and check.")
    public void the_user_creates_the_new_team_and_check(String teamName) {
        settingsPage.checkCreateTeam(teamName);

    }

    //CONFIGURATIONS SETTINGS
    @Then("The user edits Bug Mapping and check.")
    public void the_user_edits_bug_mapping_and_check() {
        settingsPage.checkBugMappingConfigurationsSettings();

    }

    @Then("The user edits Feature Mapping and check.")
    public void the_user_edits_feature_mapping_and_check() {
        settingsPage.checkFeatureMappingConfigurationsSettings();

    }

    @Then("The user edits Improvement Mapping and check.")
    public void the_user_edits_improvement_mapping_and_check() {
        settingsPage.checkImprovementMappingConfigurationsSettings();

    }

    @Then("The user edits Task Mapping and check.")
    public void the_user_edits_task_mapping_and_check() {
        settingsPage.checkTaskMappingConfigurationsSettings();

    }

    @Then("The user edits Epic Mapping and check.")
    public void the_user_edits_epic_mapping_and_check() {
        settingsPage.checkEpicMappingConfigurationsSettings();

    }

    @Then("The user edits Open Mapping and check.")
    public void the_user_edits_open_mapping_and_check() {
        settingsPage.checkOpenMappingConfigurationsSettings();

    }

    @Then("The user edits In Progress Mapping and check.")
    public void the_user_edits_in_progress_mapping_and_check() {
        settingsPage.checkInProgressMappingConfigurationsSettings();

    }

    @Then("The user edits Closed Mapping and check.")
    public void the_user_edits_closed_mapping_and_check() {
        settingsPage.checkClosedMappingConfigurationsSettings();

    }

    @Then("The user edits Analysis Mapping and check.")
    public void the_user_edits_analysis_mapping_and_check() {
        settingsPage.checkAnalysisMappingConfigurationsSettings();


    }

    @Then("The user edits UX\\/UI Mapping and check.")
    public void the_user_edits_ux_ui_mapping_and_check() {
        settingsPage.checkUXUIMappingConfigurationsSettings();

    }

    @Then("The user edits Development Mapping and check.")
    public void the_user_edits_development_mapping_and_check() {
        settingsPage.checkDevelopmentMappingConfigurationsSettings();

    }

    @Then("The user edits Review Mapping and check.")
    public void the_user_edits_review_mapping_and_check() {
        settingsPage.checkReviewMappingConfigurationsSettings();


    }

    @Then("The user edits QA Mapping and check.")
    public void the_user_edits_qa_mapping_and_check() {
        settingsPage.checkQAMappingConfigurationsSettings();


    }

    @Then("The user edits CI\\/CD Mapping and check.")
    public void the_user_edits_ci_cd_mapping_and_check() {
        settingsPage.checkCICDMappingConfigurationsSettings();

    }

    //OUTLIERS SETTINGS
    @Then("The user changes the PR Outliers Title {string} and check.")
    public void the_user_changes_the_pr_outliers_title_and_check(String title) {
        settingsPage.checkPROutliersTitleOutliersSettings(title);

    }

    @Then("The user changes the PR Outliers Label {string} and check.")
    public void the_user_changes_the_pr_outliers_label_and_check(String label) {
        settingsPage.checkPROutliersLabelOutliersSettings(label);


    }

    @Then("The user changes the Commit Outliers {string} and check.")
    public void the_user_changes_the_commit_outliers_and_check(String message) {
        settingsPage.checkCommitOutliersMessageOutliersSettings(message);


    }

    @Then("The user changes the File Count {string} and check.")
    public void the_user_changes_the_file_count_and_check(String fileCount) {
        settingsPage.checkCommitOutliersFileCountOutliersSettings(fileCount);

    }

    //DORA SETTINGS
    @Then("The user changes the Release Detection Merge Pull Request {string} and check.")
    public void the_user_changes_the_release_detection_merge_pull_request_and_check(String version) {
        settingsPage.checkReleaseDetectionMergePullRequestDoraSettings(version);

    }

    @Then("The user changes the Failure Detection Issue Title {string} and check.")
    public void the_user_changes_the_failure_detection_issue_title_and_check(String version) {
        settingsPage.checkFailureDetectionIssueDoraSettings(version);
    }

    @Then("The user changes the Recover Detection Destination Branch {string} and check.")
    public void the_user_changes_the_recover_detection_destination_branch_and_check(String version) {
        settingsPage.checkRecoverDetectionDestinationBranchDoraSettings(version);

    }
}
