package pages.DORA;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Dashboard.BasePage;
import utilities.HighchartsUtils;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoraPage extends BasePage {
    public DoraPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@data-original-title=\"DORA\"]")
    public WebElement doraIkon;

    public void intoDora() {

        doraIkon.click();
    }

    @FindBy(xpath = "(//*[@data-layer=\"score\"]//div)[5]")
    public WebElement doraMetricsScore;

    @FindBy(xpath = "(//*[@data-layer=\"score\"]//div)[6]")
    public WebElement doraMetricsSummary;

    public void checkDoraMetricsScore(){
        Assert.assertEquals(TestDataBase.doraMetricsScore,doraMetricsScore.getText());
        Assert.assertEquals(TestDataBase.doraMetricsSummary,doraMetricsSummary.getText());
    }

    @FindBy(xpath = "//*[@data-layer=\"score-progress\"]//*[@style=\"width: 68%;\"]//*[@class=\"si-container\"]")
    public WebElement doraYourStatus;

    public void checkDoraYourStatus(){
        Assert.assertTrue("Your Status didn't appear.",doraYourStatus.isDisplayed());

    }

    @FindBy(xpath = "//*[@data-layer=\"deployment_frequency\"]//*[@class=\"avg-container pd-y-16-f\"]")
    public WebElement doraDeploymentFrequencyStatus;

    @FindBy(xpath = "//*[@data-layer=\"deployment_frequency\"]//*[@class=\"badge-text tx-bold tx-14 lh-24px\"]")
    public WebElement getDoraDeploymentFrequencyBadge;

    public void checkDoraDeploymentFrequency(){
        Assert.assertEquals(TestDataBase.doraDeploymentFrequencyStatus,doraDeploymentFrequencyStatus.getText());
        Assert.assertEquals(TestDataBase.doraDeploymentFrequencyBadge,getDoraDeploymentFrequencyBadge.getText());
        ReusableMethods.wait(3);
        // Deployment Frequency
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "chart-deployment_frequency", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 1L,1L);
        System.out.println();
        System.out.println("Expected Deployment Frequency Values : " + expected);
        System.out.print("Actual Deployment Frequency Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + ",");
        }System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");
    }

    public void checkPullRequestVolume(){
        ReusableMethods.wait(3);
        // Pull Request Volume
        List<ArrayList> result = (List<ArrayList>) HighchartsUtils.getChartData(driver, "pull_request_volume", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList( 0L,43L);
        System.out.println();
        System.out.println("Expected Pull Request Volume Values : " + expected);
        System.out.print("Actual Pull Request Volume Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i).get(0));
            System.out.print(result.get(i) + ",");
        }
        System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");

    }

    @FindBy(xpath = "(//*[@id=\"development_cycle\"]//label)[1]")
    public WebElement doraDevelopmentCycleDetailsCoding;

    @FindBy(xpath = "(//*[@id=\"development_cycle\"]//label)[2]")
    public WebElement doraDevelopmentCycleDetailsPickup;

    @FindBy(xpath = "(//*[@id=\"development_cycle\"]//label)[3]")
    public WebElement doraDevelopmentCycleDetailsReview;

    @FindBy(xpath = "(//*[@id=\"development_cycle\"]//label)[4]")
    public WebElement doraDevelopmentCycleDetailsDeploy;

    public void checkDevelopmentCycleDetails(){
        Assert.assertEquals(TestDataBase.doraDevelopmentCycleDetailsCoding,doraDevelopmentCycleDetailsCoding.getText());
        Assert.assertEquals(TestDataBase.doraDevelopmentCycleDetailsPickup,doraDevelopmentCycleDetailsPickup.getText());
        Assert.assertEquals(TestDataBase.doraDevelopmentCycleDetailsReview,doraDevelopmentCycleDetailsReview.getText());
        Assert.assertEquals(TestDataBase.doraDevelopmentCycleDetailsDeploy,doraDevelopmentCycleDetailsDeploy.getText());
    }

    @FindBy(xpath = "//*[@data-layer=\"lead_time_changes\"]//*[@class=\"avg-container pd-y-16-f\"]")
    public WebElement doraLeadTimeChangesStatus;

    @FindBy(xpath = "//*[@data-layer=\"lead_time_changes\"]//*[@class=\"badge-text tx-bold tx-14 lh-24px\"]")
    public WebElement doraLeadTimeChangesBadge;

    @FindBy(id = "lead_time_changes")
    public WebElement doraLeadTimeChangesTable;

    public void checkLeadTimeForChanges(){
        JSUtilities.scrollToElement(driver,doraLeadTimeChangesTable);
        Assert.assertEquals(TestDataBase.doraLeadTimeChangesStatus,doraLeadTimeChangesStatus.getText());
        Assert.assertEquals(TestDataBase.doraLeadTimeChangesBadge,doraLeadTimeChangesBadge.getText());
        ReusableMethods.wait(3);
        // Lead Time for Changes
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "chart-lead_time_changes", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 266789L,757766L);
        System.out.println();
        System.out.println("Expected Lead Time for Changes Values : " + expected);
        System.out.print("Actual Lead Time for Changes Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + ",");
        }System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");
    }

    @FindBy(xpath = "(//*[@id=\"chart-title-most_critical_step\"]//div)[3]")
    public WebElement doraMostCriticalStepStatus;

    @FindBy(id = "most_critical_step")
    public WebElement doraMostCriticalStepTable;

    public void checkMostCriticalStep(){
        Assert.assertEquals(TestDataBase.doraMostCriticalStepStatus,doraMostCriticalStepStatus.getText());
        Assert.assertTrue("Most Critical Table didn't appear.",doraMostCriticalStepTable.isDisplayed());
    }

    public void checkPullRequestCount(){
        ReusableMethods.wait(3);
        // Pull Request Count
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "pull_request_count", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 0L,1L);
        System.out.println();
        System.out.println("Expected Pull Request Count Values : " + expected);
        System.out.print("Actual Pull Request Count Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + ",");
        }System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");
    }

    @FindBy(xpath = "//*[@data-layer=\"mean_time_to_recover\"]//*[@class=\"avg-container pd-y-16-f\"]")
    public WebElement doraMeanTimeToRecoverStatus;

    @FindBy(xpath = "//*[@data-layer=\"mean_time_to_recover\"]//*[@class=\"badge-text tx-bold tx-14 lh-24px\"]")
    public WebElement doraMeanTimeToRecoverBadge;

    @FindBy(id = "chart-mean_time_to_recover")
    public WebElement DoraMeanTimeToRecoverTable;

    public void checkMeanTimeToRecover(){
        JSUtilities.scrollToElement(driver,DoraMeanTimeToRecoverTable);
        Assert.assertEquals(TestDataBase.doraMeanTimeToRecoverStatus,doraMeanTimeToRecoverStatus.getText());
        Assert.assertEquals(TestDataBase.doraMeanTimeToRecoverBadge,doraMeanTimeToRecoverBadge.getText());
        ReusableMethods.wait(3);
        // Mean Time to Recover
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "chart-mean_time_to_recover", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 0L,0L);
        System.out.println();
        System.out.println("Expected Mean Time to Recover Values : " + expected);
        System.out.print("Actual Mean Time to Recover Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + ",");
        }System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");
    }

    @FindBy(xpath = "//*[@data-layer=\"largest_recovery_releases\"]//*[@class=\"tx-medium\"]")
    public WebElement doraLargestRecoveryReleasesThereIsNoDataText;

    public void checkLargestRecoveryReleases(){

        Assert.assertEquals(TestDataBase.thereIsNoData,doraLargestRecoveryReleasesThereIsNoDataText.getText());
    }

    public void checkRecoveryEffortRatio(){
        ReusableMethods.wait(3);
        // Recovery Effort Ratio
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "recovery_effort_ratio", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 100L,100L);
        System.out.println();
        System.out.println("Expected Recovery Effort Ratio Values : " + expected);
        System.out.print("Actual Recovery Effort Ratio Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + ",");
        }System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");
    }

    @FindBy(xpath = "//*[@data-layer=\"change_failure_rate\"]//*[@class=\"avg-container pd-y-16-f\"]")
    public WebElement doraChangeFailureRateStatus;

    @FindBy(xpath = "//*[@data-layer=\"change_failure_rate\"]//*[@class=\"badge-text tx-bold tx-14 lh-24px\"]")
    public WebElement doraChangeFailureRateBadge;

    @FindBy(id = "chart-change_failure_rate")
    public WebElement doraChangeFailureRateTable;

    public void checkChangeFailureRate(){
        JSUtilities.scrollToElement(driver,doraChangeFailureRateTable);
        Assert.assertEquals(TestDataBase.doraChangeFailureRateStatus,doraChangeFailureRateStatus.getText());
        Assert.assertEquals(TestDataBase.doraChangeFailureRateBadge,doraChangeFailureRateBadge.getText());
        ReusableMethods.wait(3);
        // Change Failure Rate
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "chart-change_failure_rate", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 0L,0L);
        System.out.println();
        System.out.println("Expected Change Failure Rate Values : " +expected);
        System.out.print("Actual Change Failure Rate Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + ",");
        }System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");





    }

    public void checkReviewFocus(){
        ReusableMethods.wait(3);
        // Review Focus
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "review_focus", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 0L,0L);
        System.out.println();
        System.out.println("Expected Review Focus Values : " +expected);
        System.out.print("Actual Review Focus Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + ",");
        }System.out.print("]");
        System.out.println();
        System.out.println("-----------------------------");
    }

    @FindBy(xpath = "(//*[@id=\"failure_summary\"]//label)[1]")
    public WebElement doraFailureSummaryTotalDeployment;

    @FindBy(xpath = "(//*[@id=\"failure_summary\"]//label)[2]")
    public WebElement doraFailureSummaryFailedDeployment;

    @FindBy(xpath = "(//*[@id=\"failure_summary\"]//label)[3]")
    public WebElement doraFailureSummaryMergedPullRequestWithoutReview;

    @FindBy(xpath = "(//*[@id=\"failure_summary\"]//label)[4]")
    public WebElement doraFailureSummaryCommitRisk;

    public void checkFailureSummary(){
        Assert.assertEquals(TestDataBase.doraFailureSummaryTotalDeployment,doraFailureSummaryTotalDeployment.getText());
        Assert.assertEquals(TestDataBase.doraFailureSummaryFailedDeployment,doraFailureSummaryFailedDeployment.getText());
        Assert.assertEquals(TestDataBase.doraFailureSummaryMergedPullRequestsWithoutReview,doraFailureSummaryMergedPullRequestWithoutReview.getText());
        Assert.assertEquals(TestDataBase.doraFailureSummaryCommitRisk,doraFailureSummaryCommitRisk.getText());
    }
}
