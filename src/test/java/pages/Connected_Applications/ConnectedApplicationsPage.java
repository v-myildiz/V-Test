package pages.Connected_Applications;

import log.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Dashboard.BasePage;
import utilities.ReusableMethods;

import java.util.List;

public class ConnectedApplicationsPage extends BasePage {
    public ConnectedApplicationsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@class=\"btn btn-main-primary\"]")
    public WebElement disconnectOKButton;

    @FindBy(xpath = "//*[@data-guide=\"JENKINS\"]//button")
    public WebElement jenkinsConnectButton;

    public void checkThisConnection(String app) {
        List<WebElement> appConnectedList = driver.findElements(By.xpath("//*[@data-guide=\"" + app + "\"]//*[@class=\"selected-right success tx-bold tx-12\"]"));
        List<WebElement> appDisconnectedList = driver.findElements(By.xpath("//*[@data-guide=\"" + app + "\"]//*[@class=\"selected-right problem tx-bold tx-12\"]"));
        List<WebElement> appRateLimitList = driver.findElements(By.xpath("//*[@data-guide=\"" + app + "\"]//*[@class=\"selected-right warn tx-bold tx-12\"]"));
        List<WebElement> appDisconnectButtonList = driver.findElements(By.xpath("//*[@data-guide=\"" + app + "\"]//*[@class=\"unlink\"]"));
        List<WebElement> appConnectButtonList = driver.findElements(By.xpath("(//*[@data-guide=\"" + app + "\"]//a)[2]"));
        List<WebElement> appConnectButton2List = driver.findElements(By.xpath("//*[@data-guide=\"" + app + "\"]//button"));

        WebElement appConnected = appConnectedList.isEmpty() ? null : appConnectedList.get(0);
        WebElement appDisconnected = appDisconnectedList.isEmpty() ? null : appDisconnectedList.get(0);
        WebElement appRateLimit = appRateLimitList.isEmpty() ? null : appRateLimitList.get(0);
        WebElement appDisconnectButton = appDisconnectButtonList.isEmpty() ? null : appDisconnectButtonList.get(0);
        WebElement appConnectButton = appConnectButtonList.isEmpty() ? null : appConnectButtonList.get(0);
        WebElement appConnectButton2 = appConnectButton2List.isEmpty() ? null : appConnectButton2List.get(0);

        if (isElementDisplayed(appConnected)) {
            Logger.info(app + " Connected !");
        }
        else if (isElementDisplayed(appDisconnected)) {
            if (appDisconnectButton != null) {
                ReusableMethods.waitForVisibilityNew(driver, appDisconnectButton);
                appDisconnectButton.click();
                Logger.info(app + " disconnect button clicked.");
                ReusableMethods.waitForVisibilityNew(driver, disconnectOKButton);
                disconnectOKButton.click();
                ReusableMethods.wait(1);
                if (appConnectButton != null) {
                    ReusableMethods.waitForVisibilityNew(driver, appConnectButton);
                    Assert.assertTrue(appConnectButton.isDisplayed());
                    ReusableMethods.wait(1);
                    Logger.info(app + " connection successfully disconnected");
                }
                if (appConnectButton2 != null) {
                    ReusableMethods.waitForVisibilityNew(driver, appConnectButton2);
                    Assert.assertTrue(appConnectButton2.isDisplayed());
                    ReusableMethods.wait(1);
                    Logger.info(app + " connection successfully disconnected");
                }
                else {
                    Logger.error(app + " connect button not found.");
                }
            }
            else {
                Logger.error(app + " disconnect button couldn't find");
            }
        }
        else if (isElementDisplayed(appRateLimit)) {
            Logger.info(app + " currently has a Rate Limit Warning.");
        }
        else {
            Logger.info(app + " isn't Connected.");
        }
    }

    public void checkGitHubDisconnect() {
        checkThisConnection("GITHUB");

    }

    public void checkGitHubEnterpriseDisconnect(){
       checkThisConnection("GITHUB_ENTERPRISE");

    }

    public void checkBitBucketCloudDisconnect(){
        checkThisConnection("BITBUCKET");

    }

    public void checkBitBucketServerDisconnect(){

        checkThisConnection("BITBUCKET_SERVER");

    }

    public void checkGitLabDisconnect(){

        checkThisConnection("GITLAB");
    }

    public void checkGitLabServerDisconnect(){

        checkThisConnection("GITLAB_SERVER");
    }

    public void checkAzureReposDisconnect(){

        checkThisConnection("AZURE");
    }

    public void checkJiraCloudDisconnect(){
        checkThisConnection("JIRA");

    }

    public void checkJiraServerDisconnect(){
        checkThisConnection("JIRA_SERVER");

    }

    public void checkYouTrackServerDisconnect(){
        checkThisConnection("YOUTRACK_SERVER");

    }

    public void checkLinearDisconnect(){
        checkThisConnection("LINEAR");

    }

    public void checkClickUpDisconnect(){
        checkThisConnection("CLICKUP");

    }

    public void checkJenkinsDisconnect(){
        checkThisConnection("JENKINS");

    }

    public void checkTravisCIDisconnect(){
        checkThisConnection("TRAVIS");

    }

    public void checkCircleCIDisconnect(){
        checkThisConnection("CIRCLE");

    }

    public void checkAzurePipelinesDisconnect(){
        checkThisConnection("AZURE_PIPELINE");

    }

    public void checkSlackDisconnect(){
        checkThisConnection("SLACK");

    }
}
