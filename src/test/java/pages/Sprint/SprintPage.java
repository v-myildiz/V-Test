package pages.Sprint;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Dashboard.BasePage;
import utilities.HighchartsUtils;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;

import java.util.List;

public class SprintPage extends BasePage {
    public SprintPage(WebDriver driver) {

        super(driver);
    }


    @FindBy(xpath = "//*[@data-original-title=\"Sprint\"]")
    public WebElement sprintsIkon;

    public void intoSprints() {
        ReusableMethods.wait(1);
        sprintsIkon.click();
    }

    @FindBy(id = "4652")
    public WebElement sprintGSoC2019;

    @FindBy(id = "4657")
    public WebElement sprintEvergreenMilestone2;

    @FindBy(id = "4653")
    public WebElement sprintGSoc;

    @FindBy(id = "4654")
    public WebElement sprintPostLaunch;

    @FindBy(id = "4658")
    public WebElement sprintBundlesManagementUISprint;

    @FindBy(id = "4655")
    public WebElement sprintDeclarativeBacklog;

    @FindBy(id = "4656")
    public WebElement sprintBlueOceanCandidates;

    @FindBy(id = "start-date")
    public WebElement sprintStartDate;

    @FindBy(id = "end-date")
    public WebElement sprintEndDate;

    @FindBy(id = "completed-date")
    public WebElement sprintCompletedDate;

    @FindBy(id = "completion-rate")
    public WebElement sprintCompletionRate;

    @FindBy(id = "contributors")
    public WebElement sprintContributors;

    //Project : GSoC 2019. Coding Phase 3

    @FindBy(xpath = "//*[@class=\"row m-0 item gray\"]")
    public WebElement sprintCommittedRow;

    @FindBy(xpath = "//*[@class=\"row m-0 item green\"]")
    public WebElement sprintCompletedRow;

    public void checkOverview(){
        Assert.assertEquals(TestDataBase.sprintGSoC2019CodingPhase3Committed,sprintCommittedRow.getText());
        Assert.assertEquals(TestDataBase.sprintGSoC2019CodingPhase3Completed,sprintCompletedRow.getText());
    }

    @FindBy(xpath = "//*[@id=\"insights\"]//*[@class=\"alert alert-solid-danger\"]")
    public WebElement insightsSolidDangerAlert;

    @FindBy(xpath = "//*[@id=\"insights\"]//*[@class=\"alert alert-solid-warning\"]")
    public WebElement insightsSolidWarningAlert;

    @FindBy(xpath = "//*[@id=\"insights\"]//*[@class=\"alert alert-solid-info\"]")
    public WebElement insightsSolidInfoAlert;

    public void checkSprintInsights(){
        Assert.assertTrue(insightsSolidDangerAlert.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert.isDisplayed());
        Assert.assertTrue(insightsSolidInfoAlert.isDisplayed());
    }

    public void checkBurndownChart(){
        ReusableMethods.wait(2);
        // Guideline
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("GSoC 2019. Coding Phase 3 Guideline Burndown Values > 1 ");
        // Remaining Effort
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 1, HighchartsUtils.DataType.Y);
        System.out.println();
        Assert.assertTrue(result1.size()>1);
        System.out.println("GSoC 2019. Coding Phase 3 Remaining Effort Burndown Values > 1 ");    }

    public void checkCumulativeFlowDiagram(){
        ReusableMethods.wait(2);
        // Open
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("GSoC 2019. Coding Phase 3 Open Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        // In-Progress
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result1.size()>1);
        System.out.println("GSoC 2019. Coding Phase 3 In-Progress Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        System.out.println("- - - - -");
        // Done
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 2, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result2.size()>1);
        System.out.println("GSoC 2019. Coding Phase 3 Done Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        System.out.println("----------------------------------------");
    }

    @FindBy(xpath = "//*[@data-guide=\"backlog\"]")
    public WebElement sprintBacklogTable;

    @FindBy(id = "42469")
    public WebElement sprintGSoC2019CodingPhase3Backlog1;

    @FindBy(id = "43212")
    public WebElement sprintGSoC2019CodingPhase3Backlog2;

    @FindBy(id = "43210")
    public WebElement sprintGSoC2019CodingPhase3Backlog3;

    @FindBy(id = "43211")
    public WebElement sprintGSoC2019CodingPhase3Backlog4;

    @FindBy(id = "43851")
    public WebElement sprintGSoC2019CodingPhase3Backlog5;

    public void checkBacklog(){
        JSUtilities.scrollToElement(driver,sprintBacklogTable);
        Assert.assertTrue(sprintGSoC2019CodingPhase3Backlog1.isDisplayed());
        Assert.assertTrue(sprintGSoC2019CodingPhase3Backlog2.isDisplayed());
        Assert.assertTrue(sprintGSoC2019CodingPhase3Backlog3.isDisplayed());
        Assert.assertTrue(sprintGSoC2019CodingPhase3Backlog4.isDisplayed());
        Assert.assertTrue(sprintGSoC2019CodingPhase3Backlog5.isDisplayed());
        sprintsIkon.click();
    }

    // Evergreen - Milestone 2
    public void checkSprintSummaryEvergreenMilestone2(){
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.sprintEvergreenMilestone2StartDate,sprintStartDate.getText());
        Assert.assertEquals(TestDataBase.sprintEvergreenMilestone2DueDate,sprintEndDate.getText());
        Assert.assertEquals(TestDataBase.sprintEvergreenMilestone2CompletedDate,sprintCompletedDate.getText());
        Assert.assertEquals(TestDataBase.sprintEvergreenMilestone2CompletionRate,sprintCompletionRate.getText());
        Assert.assertEquals(TestDataBase.sprintEvergreenMilestone2Contributors,sprintContributors.getText());
    }

    public void checkOverviewEvergreenMilestone2(){
        Assert.assertEquals(TestDataBase.sprintEvergreenMilestone2Committed,sprintCommittedRow.getText());
        Assert.assertEquals(TestDataBase.sprintEvergreenMilestone2Completed,sprintCompletedRow.getText());
    }

    public void checkSprintInsightsEvergreenMilestone2(){
        Assert.assertTrue(insightsSolidDangerAlert.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert.isDisplayed());
        Assert.assertTrue(insightsSolidInfoAlert.isDisplayed());
    }

    public void checkBurndownChartEvergreenMilestone2(){
        ReusableMethods.wait(2);
        // Guideline
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("Evergreen - Milestone 2 Guideline Values > 1 ");
        System.out.println();
        // Remaining Effort
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("Evergreen - Milestone 2 Remaining Effort Values > 1 ");
        System.out.println();
        System.out.println("---------------------------");
    }

    public void checkCumulativeFlowDiagramEvergreenMilestone2(){
        ReusableMethods.wait(2);
        // Open
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("Evergreen - Milestone 2 Open Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        // In-Progress
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result1.size()>1);
        System.out.println("Evergreen - Milestone 2 In-Progress Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        // Done
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 2, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result2.size()>1);
        System.out.println("Evergreen - Milestone 2 Done Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        System.out.println("----------------------------------------");
    }

    @FindBy(id = "43329")
    public WebElement sprintEvergreenMilestone2Backlog1;

    @FindBy(id = "43520")
    public WebElement sprintEvergreenMilestone2Backlog2;

    @FindBy(id = "43450")
    public WebElement sprintEvergreenMilestone2Backlog3;

    @FindBy(id = "43448")
    public WebElement sprintEvergreenMilestone2Backlog4;

    @FindBy(id = "43668")
    public WebElement sprintEvergreenMilestone2Backlog5;

    @FindBy(id = "43449")
    public WebElement sprintEvergreenMilestone2Backlog6;

    @FindBy(id = "43451")
    public WebElement sprintEvergreenMilestone2Backlog7;

    @FindBy(id = "43050")
    public WebElement sprintEvergreenMilestone2Backlog8;

    public void checkBacklogEvergreenMilestone2(){
        JSUtilities.scrollToElement(driver,sprintBacklogTable);
        Assert.assertTrue(sprintEvergreenMilestone2Backlog1.isDisplayed());
        Assert.assertTrue(sprintEvergreenMilestone2Backlog2.isDisplayed());
        Assert.assertTrue(sprintEvergreenMilestone2Backlog3.isDisplayed());
        Assert.assertTrue(sprintEvergreenMilestone2Backlog4.isDisplayed());
        Assert.assertTrue(sprintEvergreenMilestone2Backlog5.isDisplayed());
        Assert.assertTrue(sprintEvergreenMilestone2Backlog6.isDisplayed());
        Assert.assertTrue(sprintEvergreenMilestone2Backlog7.isDisplayed());
        Assert.assertTrue(sprintEvergreenMilestone2Backlog8.isDisplayed());
        sprintsIkon.click();
    }

    // GSoC - Coding Phase 3
    public void checkSprintSummaryGSoCCodingPhase3(){
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.sprintGSoCCodingPhase3StartDate,sprintStartDate.getText());
        Assert.assertEquals(TestDataBase.sprintGSoCCodingPhase3DueDate,sprintEndDate.getText());
        Assert.assertEquals(TestDataBase.sprintGSoCCodingPhase3CompletedDate,sprintCompletedDate.getText());
        Assert.assertEquals(TestDataBase.sprintGSoCCodingPhase3CompletionRate,sprintCompletionRate.getText());
        Assert.assertEquals(TestDataBase.sprintGSoCCodingPhase3Contributors,sprintContributors.getText());
    }

    public void checkOverviewGSoCCodingPhase3(){
        Assert.assertEquals(TestDataBase.sprintGSoCCodingPhase3Committed,sprintCommittedRow.getText());
        Assert.assertEquals(TestDataBase.sprintGSoCCodingPhase3Completed,sprintCompletedRow.getText());
    }

    public void checkSprintInsightsGSoCCodingPhase3(){
        Assert.assertTrue(insightsSolidDangerAlert.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert.isDisplayed());
        Assert.assertTrue(insightsSolidInfoAlert.isDisplayed());
    }

    public void checkBurndownChartGSoCCodingPhase3(){
        ReusableMethods.wait(2);
        // Guideline
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("GSoC - Coding Phase 3 Guideline Values > 1 ");
        System.out.println();
        // Remaining Effort
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result1.size()>1);
        System.out.println("GSoC - Coding Phase 3 Remaining Effort Values > 1 ");
        System.out.println();
        System.out.println("---------------------------");
    }

    public void checkCumulativeFlowDiagramGSoCCodingPhase3(){
        ReusableMethods.wait(2);
        // Open
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("GSoC - Coding Phase 3 Open Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        // In-Progress
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result1.size()>1);
        System.out.println("GSoC - Coding Phase 3 Open Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        // Done
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 2, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result2.size()>1);
        System.out.println("GSoC - Coding Phase 3 Open Cummulative Flow Diagram Values > 1 ");
        System.out.println();
        System.out.println("----------------------------------------");
    }

    @FindBy(id = "43213")
    public WebElement sprintGSoCCodingPhase3Backlog1;

    @FindBy(id = "43749")
    public WebElement sprintGSoCCodingPhase3Backlog2;

    @FindBy(id = "42494")
    public WebElement sprintGSoCCodingPhase3Backlog3;

    public void checkBacklogGSoCCodingPhase3(){
        JSUtilities.scrollToElement(driver,sprintBacklogTable);
        Assert.assertTrue(sprintGSoCCodingPhase3Backlog1.isDisplayed());
        Assert.assertTrue(sprintGSoCCodingPhase3Backlog2.isDisplayed());
        Assert.assertTrue(sprintGSoCCodingPhase3Backlog3.isDisplayed());
        sprintsIkon.click();
    }

    // Post-launch
    public void checkSprintSummaryPostLaunch(){
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.sprintPostLaunchStartDate,sprintStartDate.getText());
        Assert.assertEquals(TestDataBase.sprintPostLaunchDueDate,sprintEndDate.getText());
        Assert.assertEquals(TestDataBase.sprintPostLaunchCompletedDate,sprintCompletedDate.getText());
        Assert.assertEquals(TestDataBase.sprintPostLaunchCompletionRate,sprintCompletionRate.getText());
        Assert.assertEquals(TestDataBase.sprintPostLaunchContributors,sprintContributors.getText());
    }

    public void checkOverviewPostLaunch(){
        Assert.assertEquals(TestDataBase.sprintPostLaunchCommitted,sprintCommittedRow.getText());
        Assert.assertEquals(TestDataBase.sprintPostLaunchCompleted,sprintCompletedRow.getText());
    }

    public void checkSprintInsightsPostLaunch(){
        Assert.assertTrue(insightsSolidDangerAlert.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert.isDisplayed());
        Assert.assertTrue(insightsSolidInfoAlert.isDisplayed());
    }

    public void checkBurndownChartPostLaunch(){
        ReusableMethods.wait(2);
        // Guideline
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("Post-launch Guideline Values > 1 ");
        System.out.println();
        // Remaining Effort
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result1.size()>1);
        System.out.println("Post-launch Guideline Values > 1 ");
        System.out.println();
        System.out.println("---------------------------");
    }

    public void checkCumulativeFlowDiagramPostLaunch(){
        ReusableMethods.wait(2);
        // Open
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println("// Post-launch Open Cumulative Flow Diagram Values > 1 ");
        System.out.println();
        // In-Progress
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result1.size()>1);
        System.out.println("// Post-launch In-Progress Cumulative Flow Diagram Values > 1 ");
        System.out.println();
        // Done
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 2, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result2.size()>1);
        System.out.println("// Post-launch Done Cumulative Flow Diagram Values > 1 ");
        System.out.println();
        System.out.println("----------------------------------------");
    }

    @FindBy(id = "42634")
    public WebElement sprintPostLaunchBacklog1;

    public void checkBacklogPostLaunch(){
        JSUtilities.scrollToElement(driver,sprintBacklogTable);
        Assert.assertTrue(sprintPostLaunchBacklog1.isDisplayed());
        sprintsIkon.click();
    }

    // Bundles Management UI Sprint
    public void checkSprintSummaryBundlesManagementUISprint(){
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.sprintBundlesManagementUISprintStartDate,sprintStartDate.getText());
        Assert.assertEquals(TestDataBase.sprintBundlesManagementUISprintDueDate,sprintEndDate.getText());
        Assert.assertEquals(TestDataBase.sprintBundlesManagementUISprintCompletedDate,sprintCompletedDate.getText());
        Assert.assertEquals(TestDataBase.sprintBundlesManagementUISprintCompletionRate,sprintCompletionRate.getText());
        Assert.assertEquals(TestDataBase.sprintBundlesManagementUISprintContributors,sprintContributors.getText());
    }

    public void checkOverviewBundlesManagementUISprint(){
        Assert.assertEquals(TestDataBase.sprintBundlesManagementUISprintCommitted,sprintCommittedRow.getText());
        Assert.assertEquals(TestDataBase.sprintBundlesManagementUISprintCompleted,sprintCompletedRow.getText());
    }

    public void checkSprintInsightsBundlesManagementUISprint(){
        Assert.assertTrue(insightsSolidDangerAlert.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert.isDisplayed());
        Assert.assertTrue(insightsSolidInfoAlert.isDisplayed());
    }

    public void checkBurndownChartBundlesManagementUISprint(){
        ReusableMethods.wait(2);
        // Guideline
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 0, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println(" Bundles Management UI Sprint Guideline Values > 1 ");
        System.out.println();
        // Remaining Effort
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "burndown", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result.size()>1);
        System.out.println(" Bundles Management UI Sprint Remaining Effort Values > 1 ");
        System.out.println();
        System.out.println("---------------------------");
    }

    public void checkCumulativeFlowDiagramBundlesManagementUISprint(){
        ReusableMethods.wait(2);
        // Open
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L,0L);
        Assert.assertTrue(result.size()>1);
        System.out.println("// Bundles Management UI Sprint Open Cumulative Flow Diagram Values > 1 ");
        System.out.println();
        // In-Progress
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 1, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result1.size()>1);
        System.out.println("// Bundles Management UI Sprint In-Progress Cumulative Flow Diagram Values > 1 ");
        System.out.println();
        // Done
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "cumulative", 2, HighchartsUtils.DataType.Y);
        Assert.assertTrue(result2.size()>1);
        System.out.println("// Bundles Management UI Sprint Done Cumulative Flow Diagram Values > 1 ");
        System.out.println();
        System.out.println("----------------------------------------");
    }

    @FindBy(id = "43521")
    public WebElement sprintBundlesManagementUISprintBacklog1;

    public void checkBacklogBundlesManagementUISprint(){
        JSUtilities.scrollToElement(driver,sprintBacklogTable);
        Assert.assertTrue(sprintBundlesManagementUISprintBacklog1.isDisplayed());
    }


}
