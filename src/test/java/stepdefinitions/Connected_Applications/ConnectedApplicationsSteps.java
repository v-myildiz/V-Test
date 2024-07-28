package stepdefinitions.Connected_Applications;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Connected_Applications.ConnectedApplicationsPage;
import stepdefinitions.Dashboard.BaseStep;

public class ConnectedApplicationsSteps extends BaseStep {
    ConnectedApplicationsPage connectedApplicationsPage=new ConnectedApplicationsPage(driver);

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_screenshot_" + scenario.getName());
        } else {
            Driver.closeDriver();
        }
    }

    @Then("If GitHub loses connection, the user should be able to disconnect.")
    public void if_git_hub_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkGitHubDisconnect();

    }

    @Then("If GitHub Enterprise loses connection, the user should be able to disconnect.")
    public void if_git_hub_enterprise_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkGitHubEnterpriseDisconnect();

    }

    @Then("If Bitbucket Cloud loses connection, the user should be able to disconnect.")
    public void if_bitbucket_cloud_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkBitBucketCloudDisconnect();

    }

    @Then("If Bitbucket Server loses connection, the user should be able to disconnect.")
    public void if_bitbucket_server_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkBitBucketServerDisconnect();

    }

    @Then("If GitLab loses connection, the user should be able to disconnect.")
    public void if_git_lab_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkGitLabDisconnect();

    }

    @Then("If GitLab Server loses connection, the user should be able to disconnect.")
    public void if_git_lab_server_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkGitLabServerDisconnect();

    }

    @Then("If Azure Repos loses connection, the user should be able to disconnect.")
    public void if_azure_repos_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkAzureReposDisconnect();

    }

    @Then("If Jira Cloud loses connection, the user should be able to disconnect.")
    public void if_jira_cloud_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkJiraCloudDisconnect();

    }

    @Then("If Jira Server loses connection, the user should be able to disconnect.")
    public void if_jira_server_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkJiraServerDisconnect();

    }

    @Then("If YouTrack Server loses connection, the user should be able to disconnect.")
    public void if_you_track_server_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkYouTrackServerDisconnect();

    }

    @Then("If Linear loses connection, the user should be able to disconnect.")
    public void if_linear_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkLinearDisconnect();

    }

    @Then("If ClickUp loses connection, the user should be able to disconnect.")
    public void if_click_up_loses_connection_the_user_should_be_able_to_disconnect() {

    }

    @Then("If Jenkins loses connection, the user should be able to disconnect.")
    public void if_jenkins_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkJenkinsDisconnect();

    }

    @Then("If Travis CI loses connection, the user should be able to disconnect.")
    public void if_travis_ci_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkTravisCIDisconnect();

    }

    @Then("If Circle CI loses connection, the user should be able to disconnect.")
    public void if_circle_ci_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkCircleCIDisconnect();

    }

    @Then("If Azure Pipelines loses connection, the user should be able to disconnect.")
    public void if_azure_pipelines_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkAzurePipelinesDisconnect();

    }

    @Then("If Slack loses connection, the user should be able to disconnect.")
    public void if_slack_loses_connection_the_user_should_be_able_to_disconnect() {
        connectedApplicationsPage.checkSlackDisconnect();

    }
}
