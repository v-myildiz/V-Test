package stepdefinitions.Insights;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.AtlasPage;
import pages.Dashboard.DashboardPage;
import pages.Insights.InsightsPage;
import stepdefinitions.Dashboard.BaseStep;
import utilities.ReusableMethods;

public class InsightsPageSteps extends BaseStep {
    InsightsPage insightsPage = new InsightsPage(driver);
    AtlasPage atlasPage = new AtlasPage(driver);
    DashboardPage dashboardPage=new DashboardPage(driver);
    //ISSUE LINK INSIGHT TEST

    @Then("The user checks that Issue Insights Warning is Displayed in Dev. Behaviors.")
    public void the_user_checks_that_issue_insights_warning_is_displayed_in_dev_behaviors() {
        insightsPage.controlIssueLinkWithGitAndIssueRepo();
    }

    @Then("The user selects a project with Git and Issue repos Issue Link Insight Test with Git\\/Issue Repo.")
    public void the_user_selects_a_project_with_git_and_issue_repos_issue_link_insight_test_with_git_issue_repo() {
        insightsPage.chooseProjectWithGitAndIssueRepo();

    }

    @Then("The user selects a project with Git and without Issue repos Issue Link Insight Test with Git without Issue Repo.")
    public void the_user_selects_a_project_with_git_and_without_issue_repos_issue_link_insight_test_with_git_without_issue_repo() {
        insightsPage.chooseProjectWithGitAndWithoutIssueRepo();

    }

    @Then("The user checks that Issue Insights Warning is not Displayed in Dev. Behaviors.")
    public void the_user_checks_that_issue_insights_warning_is_not_displayed_in_dev_behaviors() {
        insightsPage.controlIssueLinkWithGitWithoutIssueRepo();
    }

    @Then("The user selects a contributor who involved in a project with an Issue Repo attached.")
    public void the_user_selects_a_contributor_who_involved_in_a_project_with_an_issue_repo_attached() {
        insightsPage.chooseContributorWithGitAndIssueRepo();

    }

    @Then("The user checks that Issue Insights Warning is Displayed in Contributor Insights.")
    public void the_user_checks_that_issue_insights_warning_is_displayed_in_contributor_insights() {
        insightsPage.controlContributorWithGitAndIssueRepo();

    }

    @Then("The user selects a contributor who involved in a project with an Issue Repo not attached.")
    public void the_user_selects_a_contributor_who_involved_in_a_project_with_an_issue_repo_not_attached() {
        insightsPage.chooseContributorWithGitAndWithoutIssueRepo();

    }

    @Then("The user checks that Issue Insights Warning is not Displayed in Contributor Insights.")
    public void the_user_checks_that_issue_insights_warning_is_not_displayed_in_contributor_insights() {
        insightsPage.controlContributorWithGitAndWithoutIssueRepo();

    }



}
