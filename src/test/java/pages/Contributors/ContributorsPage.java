package pages.Contributors;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.Dashboard.BasePage;
import utilities.HighchartsUtils;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;
import java.util.Arrays;
import java.util.List;
public class ContributorsPage extends BasePage {
    public ContributorsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@data-original-title=\"Contributors\"]")
    public WebElement contributorsIkon;

    public void intoContributors() {
        ReusableMethods.wait(1);
        contributorsIkon.click();
    }

    @FindBy(id = "90581")
    public WebElement contributorARegnander;

    public void checkContributorARegnander(){
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(driver,contributorARegnander);
        contributorARegnander.click();
    }

    @FindBy(xpath = "//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-success\"]")
    public WebElement insightsSolidSuccessAlert;

    @FindBy(xpath = "(//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-danger\"])[1]")
    public WebElement insightsSolidDangerAlert1;

    @FindBy(xpath = "(//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-danger\"])[2]")
    public WebElement insightsSolidDangerAlert2;

    @FindBy(xpath = "(//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-danger\"])[3]")
    public WebElement insightsSolidDangerAlert3;

    @FindBy(xpath = "(//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-warning\"])[1]")
    public WebElement insightsSolidWarningAlert1;

    @FindBy(xpath = "(//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-warning\"])[2]")
    public WebElement insightsSolidWarningAlert2;

    @FindBy(xpath = "(//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-warning\"])[3]")
    public WebElement insightsSolidWarningAlert3;

    public void checksContributorInsightsARegnander(){
        ReusableMethods.waitForVisibility(insightsSolidSuccessAlert);
        Assert.assertTrue(insightsSolidSuccessAlert.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert2.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert3.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert2.isDisplayed());
    }

    @FindBy(xpath = "(//*[@id=\"focus\"]//*[@class=\"progress-bar-chart\"]//*[@class=\"value\"])[1]")
    public WebElement contributorFocusNewWork;

    @FindBy(xpath = "(//*[@id=\"focus\"]//*[@class=\"progress-bar-chart\"]//*[@class=\"value\"])[2]")
    public WebElement contributorFocusLegacyRefactor;

    @FindBy(xpath = "(//*[@id=\"focus\"]//*[@class=\"progress-bar-chart\"]//*[@class=\"value\"])[3]")
    public WebElement contributorFocusHelpOthers;

    @FindBy(xpath = "(//*[@id=\"focus\"]//*[@class=\"progress-bar-chart\"]//*[@class=\"value\"])[4]")
    public WebElement contributorFocusChurn;

    public void checksContributorFocusARegnander(){
        ReusableMethods.waitForVisibility(contributorFocusNewWork);
        Assert.assertEquals(TestDataBase.contributorsFocusNewWorkARegnander,contributorFocusNewWork.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusLegacyRefactorARegnander,contributorFocusLegacyRefactor.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusHelpOthersARegnander,contributorFocusHelpOthers.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusChurnARegnander,contributorFocusChurn.getText());
    }

    public void checksContributorCommitRiskBreakdownARegnander(){
        ReusableMethods.wait(2);
        // High risk
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(43L,0L,0L);
        System.out.println(); //218
        System.out.println("Expected Commit Risk Breakdown High risk Values : " + expected);
        System.out.print("Actual Commit Risk Breakdown High risk Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Medium risk
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L,7L,0L);
        System.out.println(); //218
        System.out.println("Expected Commit Risk Breakdown Medium risk Values : " + expected1);
        System.out.print("Actual Commit Risk Breakdown Medium risk Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Low risk
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(0L,0L,50L);
        System.out.println(); //218
        System.out.println("Expected Commit Risk Breakdown Low risk Values : " + expected2);
        System.out.print("Actual Commit Risk Breakdown Low risk Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-------------------------------------");
    }

    @FindBy(id = "code-impact")
    public WebElement contributorsCodeImpactTable;

    @FindBy(xpath = "//*[@id=\"code_impact_insights\"]//*[@class=\"alert alert-solid-success\"]")
    public WebElement contributorsCodeImpactAlertSuccess;

    @FindBy(xpath = "//*[@id=\"code_impact_insights\"]//*[@class=\"alert alert-solid-danger\"]")
    public WebElement contributorsCodeImpactAlertDanger;

    @FindBy(xpath = "(//*[@id=\"code_impact_insights\"]//*[@class=\"alert alert-solid-danger\"])[2]")
    public WebElement contributorsCodeImpactAlertDanger2;

    @FindBy(xpath = "(//*[@id=\"code_impact_insights\"]//*[@class=\"alert alert-solid-info\"])[1]")
    public WebElement contributorsCodeImpactAlertInfo1;

    @FindBy(xpath = "(//*[@id=\"code_impact_insights\"]//*[@class=\"alert alert-solid-info\"])[2]")
    public WebElement contributorsCodeImpactAlertInfo2;

    public void checksContributorCodeImpactARegnander(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactTable);
        ReusableMethods.wait(2);
        // Code Impact
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "code-impact", 1, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(19.589930978481522,2.9492455418381343,43.209876543209866,0L,0L,0L,100L,0L,91.48709763234902,0L, 78.15820543093271,23.809523809523807,29.761904761904763);
        System.out.println();
        System.out.println("Expected Code Impact Values : " + expected);
        System.out.print("Actual Code Impact Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        Assert.assertTrue(contributorsCodeImpactAlertSuccess.isDisplayed());
    }

    @FindBy(id = "efficiency-by-days")
    public WebElement contributorsCodeImpactChurnRateTable;

    @FindBy(xpath = "//*[@data-guide=\"average-throughput\"]//label")
    public WebElement contributorsChurnRateThroughput;

    @FindBy(xpath = "//*[@class=\"average_churn_rate\"]//*[@class=\"main-content-title tx-20 lh-6 text-bold mb-0\"]")
    public WebElement contributorsChurnRateAverageChurnRate;

    @FindBy(xpath = "//*[@data-guide=\"least-productive-week\"]//label")
    public WebElement contributorsChurnRateLeastProductiveWeek;

    public void checksContributorChurnRateARegnander(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactChurnRateTable);
        ReusableMethods.waitForVisibility(contributorsCodeImpactChurnRateTable);
        // Contributor Churn Rate
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(5.3, 14.3, 1.8, 50L, 84.6, 11.8);
        System.out.println();
        System.out.println("Expected Contributor Churn Rate Values : " + expected);
        System.out.print("Actual Contributor Churn Rate Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Company Average
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor Company Average Values : " + expected1);
        System.out.print("Actual Contributor Company Average Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        Assert.assertEquals(TestDataBase.contributorsChurnRateThroughputARegnander,contributorsChurnRateThroughput.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateAverageChurnRateARegnander,contributorsChurnRateAverageChurnRate.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateLeastProductiveWeekARegnander,contributorsChurnRateLeastProductiveWeek.getText());
    }

    @FindBy(id = "activity-log")
    public WebElement contributorsActivityLogTable;

    public void checksContributorActivityLogARegnander(){
        JSUtilities.scrollToElement(driver,contributorsActivityLogTable);
        ReusableMethods.waitForVisibility(contributorsActivityLogTable);
        Assert.assertTrue(contributorsActivityLogTable.isDisplayed());
    }

    @FindBy(id = "proficiency-by-days")
    public WebElement contributorsChurnRateByLanguagesTable;

    public void checksContributorChurnRateLanguagesARegnander(){
        JSUtilities.scrollToElement(driver,contributorsChurnRateByLanguagesTable);
        ReusableMethods.waitForVisibility(contributorsChurnRateByLanguagesTable);
        // Contributor Churn Rate by Languages HTML
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(7.441860465116278, 25L, 69.42148760330579, 84.61538461538461, 0L);
        System.out.println();
        System.out.println("Expected Contributor Churn Rate HTML Values : " + expected);
        System.out.print("Actual Contributor Churn Rate HTML Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages OTHER
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(1.4802631578947398, 10L, 1.7695473251028773, 0L, 15.228826933193048);
        System.out.println();
        System.out.println("Expected Contributor Churn Rate OTHER  Values : " + expected1);
        System.out.print("Actual Contributor Churn Rate OTHER Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Contributor Average
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = Arrays.asList(5.288175999999993, 14.285714999999996, 1.7695474000000075, 50L, 84.615386, 11.75395850000001);
        System.out.println();
        System.out.println("Expected Contributor Churn Rate Contributor Average Values : " + expected2);
        System.out.print("Actual Contributor Churn Rate Contributor Average Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Company Average
        List<Long> result3 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 3, HighchartsUtils.DataType.Y);
        List<Number> expected3 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor Churn Rate Company Average Values : " + expected3);
        System.out.print("Actual Contributor Churn Rate Company Average Values :   [");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected3.get(i), result3.get(i));
            System.out.print(result3.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        contributorsIkon.click();
    }

    //Contributor : Bod Du
    @FindBy(id = "90567")
    public WebElement contributorBodDu;

    public void checkContributorBodDu(){
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(driver,contributorBodDu);
        ReusableMethods.wait(2);
        contributorBodDu.click();
    }

    public void checksContributorInsightsBodDu(){
        ReusableMethods.waitForVisibility(insightsSolidDangerAlert1);
        Assert.assertTrue(insightsSolidDangerAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert2.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert2.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert3.isDisplayed());
    }

    public void checksContributorFocusBobDu(){
        ReusableMethods.waitForVisibility(contributorFocusNewWork);
        Assert.assertEquals(TestDataBase.contributorsFocusNewWorkBobDu,contributorFocusNewWork.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusLegacyRefactorBobDu,contributorFocusLegacyRefactor.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusHelpOthersBobDu,contributorFocusHelpOthers.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusChurnBobDu,contributorFocusChurn.getText());
    }

    public void checksContributorCommitRiskBreakdownBobDu(){
        ReusableMethods.wait(2);
        // High risk
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(6L,0L,0L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Commit Risk Breakdown High risk Values : " + expected);
        System.out.print("Actual Contributor Bob Du Commit Risk Breakdown High risk Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Medium risk
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L,0L,0L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Commit Risk Breakdown Medium risk Values : " + expected1);
        System.out.print("Actual Contributor Bob Du Commit Risk Breakdown Medium risk Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Low risk
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(0L,0L,94L);
        System.out.println(); //218
        System.out.println("Expected Contributor Bob Du Commit Risk Breakdown Low risk Values : " + expected2);
        System.out.print("Actual Contributor Bob Du Commit Risk Breakdown Low risk Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-------------------------------------");
    }

    public void checksContributorCodeImpactBobDu(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactTable);
        ReusableMethods.wait(2);
        // Code Impact
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "code-impact", 1, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(0L, 64.28571428571429, 0L, 78.57142857142857, 64.28571428571429, 64.28571428571429, 52.38095238095238, 64.28571428571429, 50L, 52.38095238095238, 23.809523809523807, 69.38775510204081, 52.38095238095238, 100L, 64.28571428571429, 64.28571428571429);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Code Impact Values : " + expected);
        System.out.print("Actual Contributor Bob Du Code Impact Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        Assert.assertTrue(contributorsCodeImpactAlertDanger.isDisplayed());
    }

    public void checksContributorChurnRateBobDu(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactChurnRateTable);
        ReusableMethods.waitForVisibility(contributorsCodeImpactChurnRateTable);
        // Contributor Churn Rate
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(38L, 100L, 33.3, 30L, 70L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Churn Rate Values : " + expected);
        System.out.print("Actual Contributor Bob Du Churn Rate Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Company Average
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Company Average Values : " + expected1);
        System.out.print("Actual Contributor Bob Du Company Average Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        Assert.assertEquals(TestDataBase.contributorsChurnRateThroughputBobDu,contributorsChurnRateThroughput.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateAverageChurnRateBobDu,contributorsChurnRateAverageChurnRate.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateLeastProductiveWeekBobDu,contributorsChurnRateLeastProductiveWeek.getText());
    }

    public void checksContributorActivityLogBobDu(){
        JSUtilities.scrollToElement(driver,contributorsActivityLogTable);
        ReusableMethods.waitForVisibility(contributorsActivityLogTable);
        Assert.assertTrue(contributorsActivityLogTable.isDisplayed());
    }

    public void checksContributorChurnRateLanguagesBobDu(){
        JSUtilities.scrollToElement(driver,contributorsChurnRateByLanguagesTable);
        ReusableMethods.waitForVisibility(contributorsChurnRateByLanguagesTable);
        // Contributor Churn Rate by Languages HTML
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(38L, 100L, 33.33333333333334, 30L, 70L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Churn Rate HTML Values : " + expected);
        System.out.print("Actual Contributor Bob Du Churn Rate HTML Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        // Contributor Churn Rate by Languages Contributor Average
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected2 = Arrays.asList(38L, 100L, 33.33333400000001, 30L, 70L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Churn Rate Contributor Average Values : " + expected2);
        System.out.print("Actual Contributor Bob Du Churn Rate Contributor Average Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Company Average
        List<Long> result3 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 2, HighchartsUtils.DataType.Y);
        List<Number> expected3 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Churn Rate Company Average Values : " + expected3);
        System.out.print("Actual Contributor Bob Du Churn Rate Company Average Values :   [");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected3.get(i), result3.get(i));
            System.out.print(result3.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        contributorsIkon.click();
    }

    //Contributor : Allan Burdajewicz
    @FindBy(id = "90560")
    public WebElement contributorAllanBurdajewicz;

    public void checkContributorAllanBurdajewicz(){
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(driver,contributorAllanBurdajewicz);
        ReusableMethods.wait(2);
        contributorAllanBurdajewicz.click();
    }

    public void checksContributorInsightsAllanBurdajewicz(){
        ReusableMethods.waitForVisibility(insightsSolidDangerAlert1);
        Assert.assertTrue(insightsSolidDangerAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert2.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert3.isDisplayed());
    }

    public void checksContributorFocusAllanBurdajewicz(){
        ReusableMethods.waitForVisibility(contributorFocusNewWork);
        Assert.assertEquals(TestDataBase.contributorsFocusNewWorkAllanBurdajewicz,contributorFocusNewWork.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusLegacyRefactorAllanBurdajewicz,contributorFocusLegacyRefactor.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusHelpOthersAllanBurdajewicz,contributorFocusHelpOthers.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusChurnAllanBurdajewicz,contributorFocusChurn.getText());
    }

    public void checksContributorCommitRiskBreakdownAllanBurdajewicz(){
        ReusableMethods.wait(2);
        // High risk
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(0L,0L,0L);
        System.out.println();
        System.out.println("Expected Contributor Bob Du Commit Risk Breakdown High risk Values : " + expected);
        System.out.print("Actual Contributor Bob Du Commit Risk Breakdown High risk Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Medium risk
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L,20L,0L);
        System.out.println();
        System.out.println("Expected Contributor Allan Burdajewicz Commit Risk Breakdown Medium risk Values : " + expected1);
        System.out.print("Actual Contributor Allan Burdajewicz Commit Risk Breakdown Medium risk Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Low risk
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(0L,0L,80L);
        System.out.println(); //218
        System.out.println("Expected Contributor Allan Burdajewicz Commit Risk Breakdown Low risk Values : " + expected2);
        System.out.print("Actual Contributor Allan Burdajewicz Commit Risk Breakdown Low risk Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-------------------------------------");
    }

    public void checksContributorCodeImpactAllanBurdajewicz(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactTable);
        ReusableMethods.wait(2);
        // Code Impact
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "code-impact", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(0L, 50.310559006211186);
        System.out.println();
        System.out.println("Expected Contributor Allan Burdajewicz Code Impact Values : " + expected);
        System.out.print("Actual Contributor Allan Burdajewicz Code Impact Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        Assert.assertTrue(contributorsCodeImpactAlertDanger.isDisplayed());
        Assert.assertTrue(contributorsCodeImpactAlertInfo1.isDisplayed());
        Assert.assertTrue(contributorsCodeImpactAlertDanger2.isDisplayed());
    }

    public void checksContributorChurnRateAllanBurdajewicz(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactChurnRateTable);
        ReusableMethods.waitForVisibility(contributorsCodeImpactChurnRateTable);
        // Contributor Churn Rate
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(6.8, 55.4, 0L);
        System.out.println();
        System.out.println("Expected Contributor Allan Burdajewicz Churn Rate Values : " + expected);
        System.out.print("Actual Contributor Allan Burdajewicz Churn Rate Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Company Average
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor Allan Burdajewicz Company Average Values : " + expected1);
        System.out.print("Actual Contributor Allan Burdajewicz Company Average Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        Assert.assertEquals(TestDataBase.contributorsChurnRateThroughputAllanBurdajewicz,contributorsChurnRateThroughput.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateAverageChurnRateAllanBurdajewicz,contributorsChurnRateAverageChurnRate.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateLeastProductiveWeekAllanBurdajewicz,contributorsChurnRateLeastProductiveWeek.getText());
    }

    public void checksContributorActivityLogAllanBurdajewicz(){
        JSUtilities.scrollToElement(driver,contributorsActivityLogTable);
        ReusableMethods.waitForVisibility(contributorsActivityLogTable);
        Assert.assertTrue(contributorsActivityLogTable.isDisplayed());
    }

    public void checksContributorChurnRateLanguagesAllanBurdajewicz(){
        JSUtilities.scrollToElement(driver,contributorsChurnRateByLanguagesTable);
        ReusableMethods.waitForVisibility(contributorsChurnRateByLanguagesTable);
        // Contributor Churn Rate by Languages Java
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(6.779661016949163, 55.357142857142854, 0L);
        System.out.println();
        System.out.println("Expected Contributor Allan Burdajewicz Churn Rate Java Values : " + expected);
        System.out.print("Actual Contributor Allan Burdajewicz Churn Rate Java Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        // Contributor Churn Rate by Languages Contributor Average
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected2 = Arrays.asList(6.779661000000004, 55.35714, 0L);
        System.out.println();
        System.out.println("Expected Contributor Allan Burdajewicz Churn Rate Contributor Average Values : " + expected2);
        System.out.print("Actual Contributor Allan Burdajewicz Churn Rate Contributor Average Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Company Average
        List<Long> result3 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 2, HighchartsUtils.DataType.Y);
        List<Number> expected3 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor Allan Burdajewicz Churn Rate Company Average Values : " + expected3);
        System.out.print("Actual Contributor Allan Burdajewicz Churn Rate Company Average Values :   [");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected3.get(i), result3.get(i));
            System.out.print(result3.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        contributorsIkon.click();
    }

    //Contributor : JanFaracik
    @FindBy(id = "90562")
    public WebElement contributorJanFaracik;

    public void checkContributorJanFaracik(){
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(driver,contributorJanFaracik);
        ReusableMethods.wait(2);
        contributorJanFaracik.click();
    }

    public void checksContributorInsightsJanFaracik(){
        ReusableMethods.waitForVisibility(insightsSolidDangerAlert1);
        Assert.assertTrue(insightsSolidWarningAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert2.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert3.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidDangerAlert2.isDisplayed());
    }

    public void checksContributorFocusJanFaracik(){
        ReusableMethods.waitForVisibility(contributorFocusNewWork);
        Assert.assertEquals(TestDataBase.contributorsFocusNewWorkJanFaracik,contributorFocusNewWork.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusLegacyRefactorJanFaracik,contributorFocusLegacyRefactor.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusHelpOthersJanFaracik,contributorFocusHelpOthers.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusChurnJanFaracik,contributorFocusChurn.getText());
    }

    public void checksContributorCommitRiskBreakdownJanFaracik(){
        ReusableMethods.wait(2);
        // High risk
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(4L,0L,0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Commit Risk Breakdown High risk Values : " + expected);
        System.out.print("Actual Contributor JanFaracik Commit Risk Breakdown High risk Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Medium risk
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L,7L,0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Commit Risk Breakdown Medium risk Values : " + expected1);
        System.out.print("Actual Contributor JanFaracik Commit Risk Breakdown Medium risk Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Low risk
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(0L,0L,89L);
        System.out.println(); //218
        System.out.println("Expected Contributor JanFaracik Commit Risk Breakdown Low risk Values : " + expected2);
        System.out.print("Actual Contributor JanFaracik Commit Risk Breakdown Low risk Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-------------------------------------");
    }

    public void checksContributorCodeImpactJanFaracik(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactTable);
        ReusableMethods.wait(2);
        // Code Impact Issue
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "code-impact", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Code Impact Issue Values : " + expected);
        System.out.print("Actual Contributor JanFaracik Code Impact Issue Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Code Impact Commit
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "code-impact", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(0L, 57.142857142857146, 0L, 100L, 100L, 0L, 100L, 0L, 0L, 100L, 0L, 0L, 100L, 0L, 100L, 100L, 100L, 95.23809523809524, 16.949152542372882, 93.19727891156462, 0L, 100L, 100L, 100L, 0L, 100L, 0L, 55.357142857142854, 45.22613065326633, 72.7891156462585, 100L, 0L, 100L, 2.4154589371980677, 100L, 0L, 0L, 0L, 0L, 100L, 0L, 74.78991596638656, 0L, 0L, 0L, 100L, 0L, 0L, 100L, 51.298701298701296, 0L, 0L, 79.87927565392354, 0L, 0L, 94.04761904761904, 100L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Code Impact Commit Values : " + expected);
        System.out.print("Actual Contributor JanFaracik Code Impact Commit Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        Assert.assertTrue(contributorsCodeImpactAlertInfo1.isDisplayed());
        Assert.assertTrue(contributorsCodeImpactAlertInfo2.isDisplayed());
    }

    public void checksContributorChurnRateJanFaracik(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactChurnRateTable);
        ReusableMethods.waitForVisibility(contributorsCodeImpactChurnRateTable);
        // Contributor Churn Rate
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(100L, 1.4, 0L, 0L, 0L, 6.7, 0L, 10.2, 6.7, 24.3, 100L, 22.2, 2.9, 50L, 24.1, 0L, 80.9, 82.6, 0L, 17.2, 0L, 100L, 11.1, 0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Churn Rate Values : " + expected);
        System.out.print("Actual Contributor JanFaracik Churn Rate Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Company Average
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Company Average Values : " + expected1);
        System.out.print("Actual Contributor JanFaracik Company Average Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        Assert.assertEquals(TestDataBase.contributorsChurnRateThroughputJanFaracik,contributorsChurnRateThroughput.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateAverageChurnRateJanFaracik,contributorsChurnRateAverageChurnRate.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateLeastProductiveWeekJanFaracik,contributorsChurnRateLeastProductiveWeek.getText());
    }

    public void checksContributorActivityLogJanFaracik(){
        JSUtilities.scrollToElement(driver,contributorsActivityLogTable);
        ReusableMethods.waitForVisibility(contributorsActivityLogTable);
        Assert.assertTrue(contributorsActivityLogTable.isDisplayed());
    }

    public void checksContributorChurnRateLanguagesJanFaracik(){
        JSUtilities.scrollToElement(driver,contributorsChurnRateByLanguagesTable);
        ReusableMethods.waitForVisibility(contributorsChurnRateByLanguagesTable);
        // Contributor Churn Rate by Languages JavaScript
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(100L, 1.4492753623188293, 0L, 0L, 0L, 3.911564625850332, 92L, 76.36363636363636, 53.125, 0L, 0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Churn Rate JavaScript Values : " + expected);
        System.out.print("Actual Contributor JanFaracik Churn Rate JavaScript Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        // Contributor Churn Rate by Languages CSS
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(0L, 0L, 0L, 7.086614173228341, 10.169491525423723, 6.666666666666671, 32.14285714285714, 22.222222222222214, 1.4117647058823621, 15.625, 5.9375, 87.70491803278688, 90.47619047619048, 18.51851851851852, 100L, 0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Churn Rate CSS Values : " + expected1);
        System.out.print("Actual Contributor JanFaracik Churn Rate CSS Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Other
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = Arrays.asList(0L, null, 0L, 0L, 0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Churn Rate Other Values : " + expected2);
        System.out.print("Actual Contributor JanFaracik Churn Rate Other Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Java
        List<Long> result3 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 3, HighchartsUtils.DataType.Y);
        List<Number> expected3 = Arrays.asList(0L, 0L, 100L, 100L, 50L, 0L, 0L, 0L, 11.111111111111114);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Churn Rate Java Values : " + expected3);
        System.out.print("Actual Contributor JanFaracik Churn Rate Java Values :   [");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected3.get(i), result3.get(i));
            System.out.print(result3.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Contributor Average
        List<Long> result4 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 4, HighchartsUtils.DataType.Y);
        List<Number> expected4 = Arrays.asList(100L, 1.4492754000000048, 0L, 0L, 0L, 6.666667000000004, 0L, 10.169490999999994, 6.666667000000004, 24.324325, 100L, 22.222222000000002, 2.8599604999999997, 50L, 24.074075000000008, 0L, 80.921054, 82.608694, 0L, 17.241379999999992, 0L, 100L, 11.111110999999994, 0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Churn Rate Contributor Average Values : " + expected4);
        System.out.print("Actual Contributor JanFaracik Churn Rate Contributor Average Values :   [");
        for (int i = 0; i < result4.size(); i++) {
            Assert.assertEquals(expected4.get(i), result4.get(i));
            System.out.print(result4.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Company Average
        List<Long> result5 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 5, HighchartsUtils.DataType.Y);
        List<Number> expected5 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor JanFaracik Churn Rate Company Average Values : " + expected5);
        System.out.print("Actual Contributor JanFaracik Churn Rate Company Average Values :   [");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected5.get(i), result5.get(i));
            System.out.print(result5.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        contributorsIkon.click();
    }

    //Contributor : MikelOrtega
    @FindBy(id = "90584")
    public WebElement contributorMikelOrtega;

    public void checkContributorMikelOrtega(){
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(driver,contributorMikelOrtega);
        ReusableMethods.wait(2);
        contributorMikelOrtega.click();
    }

    public void checksContributorInsightsMikelOrtega(){
        ReusableMethods.waitForVisibility(insightsSolidDangerAlert1);
        Assert.assertTrue(insightsSolidDangerAlert1.isDisplayed());
        Assert.assertTrue(insightsSolidWarningAlert1.isDisplayed());
    }

    public void checksContributorFocusMikelOrtega(){
        ReusableMethods.waitForVisibility(contributorFocusNewWork);
        Assert.assertEquals(TestDataBase.contributorsFocusNewWorkMikelOrtega,contributorFocusNewWork.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusLegacyRefactorMikelOrtega,contributorFocusLegacyRefactor.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusHelpOthersMikelOrtega,contributorFocusHelpOthers.getText());
        Assert.assertEquals(TestDataBase.contributorsFocusChurnMikelOrtega,contributorFocusChurn.getText());
    }

    public void checksContributorCommitRiskBreakdownMikelOrtega(){
        ReusableMethods.wait(2);
        // High risk
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(0L,0L,0L);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Commit Risk Breakdown High risk Values : " + expected);
        System.out.print("Actual Contributor MikelOrtega Commit Risk Breakdown High risk Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Medium risk
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L,0L,0L);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Commit Risk Breakdown Medium risk Values : " + expected1);
        System.out.print("Actual Contributor MikelOrtega Commit Risk Breakdown Medium risk Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Low risk
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-breakdown", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(0L,0L,100L);
        System.out.println(); //218
        System.out.println("Expected Contributor MikelOrtega Commit Risk Breakdown Low risk Values : " + expected2);
        System.out.print("Actual Contributor MikelOrtega Commit Risk Breakdown Low risk Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-------------------------------------");
    }

    public void checksContributorCodeImpactMikelOrtega(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactTable);
        ReusableMethods.wait(2);
        // Code Impact Issue
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "code-impact", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(100L);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Code Impact Issue Values : " + expected);
        System.out.print("Actual Contributor MikelOrtega Code Impact Issue Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        Assert.assertTrue(contributorsCodeImpactAlertDanger.isDisplayed());
    }

    public void checksContributorChurnRateMikelOrtega(){
        JSUtilities.scrollToElement(driver,contributorsCodeImpactChurnRateTable);
        ReusableMethods.waitForVisibility(contributorsCodeImpactChurnRateTable);
        // Contributor Churn Rate
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(100L);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Churn Rate Values : " + expected);
        System.out.print("Actual Contributor MikelOrtega Churn Rate Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Company Average
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "efficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Company Average Values : " + expected1);
        System.out.print("Actual Contributor MikelOrtega Company Average Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        Assert.assertEquals(TestDataBase.contributorsChurnRateThroughputMikelOrtega,contributorsChurnRateThroughput.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateAverageChurnRateMikelOrtega,contributorsChurnRateAverageChurnRate.getText());
        Assert.assertEquals(TestDataBase.contributorsChurnRateLeastProductiveWeekMikelOrtega,contributorsChurnRateLeastProductiveWeek.getText());
    }

    public void checksContributorActivityLogMikelOrtega(){
        JSUtilities.scrollToElement(driver,contributorsActivityLogTable);
        ReusableMethods.waitForVisibility(contributorsActivityLogTable);
        Assert.assertTrue(contributorsActivityLogTable.isDisplayed());
    }

    public void checksContributorChurnRateLanguagesMikelOrtega(){
        JSUtilities.scrollToElement(driver,contributorsChurnRateByLanguagesTable);
        ReusableMethods.waitForVisibility(contributorsChurnRateByLanguagesTable);
        // Contributor Churn Rate by Languages Other
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(100L);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Churn Rate Other Values : " + expected);
        System.out.print("Actual Contributor MikelOrtega Churn Rate Other Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        // Contributor Churn Rate by Languages Contributor Average
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(100L);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Churn Rate Contributor Average Values : " + expected1);
        System.out.print("Actual Contributor MikelOrtega Churn Rate Contributor Average  Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Contributor Churn Rate by Languages Company Average
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = Arrays.asList(100L, 0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 100L, 100L, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 100L, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 100L, 0L, 53.8, 80L, 100L, 100L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L
);
        System.out.println();
        System.out.println("Expected Contributor MikelOrtega Churn Rate Company Average  Values : " + expected2);
        System.out.print("Actual Contributor MikelOrtega Churn Rate Company Average  Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
    }

    @FindBy(xpath = "//*[@id=\"data-table_wrapper\"]//*[@class=\"btn btn-primary text-button manage-developer\"]")
    public WebElement manageContributorsButton;

    public void clickManageContributorsButton(){
        ReusableMethods.waitForVisibilityNew(driver,manageContributorsButton);
        manageContributorsButton.click();

    }

    @FindBy(id = "suggestion-btn")
    public WebElement showSuggestionsButton;

    @FindBy(xpath = "//*[@class=\"s-icon merge-blue\"]")
    public WebElement showSuggestionMergeIcon;

    public void hoverShowSuggestions(){
       Actions actions=new Actions(driver);
       String beforeBackgroundColorMergeIcon=showSuggestionMergeIcon.getCssValue("color");
     //  System.out.println("Before Merge Icon Color : "+beforeBackgroundColorMergeIcon);
       actions.moveToElement(showSuggestionsButton).perform();
       ReusableMethods.wait(5);
       String afterBackgroundColorMergeIcon=showSuggestionMergeIcon.getCssValue("color");
     //  System.out.println("After Merge Icon Color : "+afterBackgroundColorMergeIcon);
       Assert.assertNotEquals(beforeBackgroundColorMergeIcon,afterBackgroundColorMergeIcon);
       showSuggestionsButton.click();
    }

    @FindBy(xpath = "//*[@class=\"m-icon loading\"]")
    public WebElement loadingIconMergeContributors;

    @FindBy(id = "suggestion-table_wrapper")
    public WebElement suggestionTable;

    public void displayLoadingIcon(){
        if (ReusableMethods.waitForVisibility(loadingIconMergeContributors).isDisplayed()){
            System.out.println("Loading Icon is Displayed");
        } else if (ReusableMethods.waitForVisibility(suggestionTable).isDisplayed()) {
            System.out.println("Suggestion Table is Displayed");
        }else {Assert.fail();
            System.out.println("Merge Contributors Table can not display");}
    }

}
