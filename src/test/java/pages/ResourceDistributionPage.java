package pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.HighchartsUtils;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourceDistributionPage extends BasePage{
    public ResourceDistributionPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@data-original-title=\"Resource Distribution\"]")
    public WebElement resourceDistributionIkon;

    public void intoResourceDistribution() {
        resourceDistributionIkon.click();

    }

    @FindBy(xpath = "//*[@id=\"total_number_of_issues\"]//label")
    public WebElement totalNumberOfIssues;

    @FindBy(xpath = "//*[@id=\"total_number_of_hours\"]//label")
    public WebElement totalNumberOfHours;

    @FindBy(xpath = "//*[@id=\"total_number_of_contributors\"]//label")
    public WebElement totalNumberOfContributors;

    @FindBy(xpath = "//*[@id=\"total_cost\"]//label")
    public WebElement totalCost;

    public void checkTotalNumberOfIssues(){
        Assert.assertEquals(TestDataBase.resourceDistributionTotalNumberOfIssues,totalNumberOfIssues.getText());
        // Total Number Of Issues
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "issue-worktype-chart", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of( 114L,27L,29L,30L);
        System.out.println();
        System.out.println("Expected Total Number Of Issues Values : " + expected);
        System.out.print("Actual Total Number Of Issues Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
    }

    public void checkTotalNumberOfHours(){
        Assert.assertEquals(TestDataBase.resourceDistributionTotalNumberOfHours,totalNumberOfHours.getText());
        // Total Number Of Hours
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "hour-worktype-chart", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(586L,152L,171L,179L);
        System.out.println();
        System.out.println("Expected Total Number Of Hours Values : " + expected);
        System.out.print("Actual Total Number Of Hours Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
    }

    public void checkTotalNumberOfContributors(){
        Assert.assertEquals(TestDataBase.resourceDistributionTotalNumberOfContributors,totalNumberOfContributors.getText());
        // Total Number Of Contributors
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "contributor-worktype-chart", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(21L,12L,12L,14L);
        System.out.println();
        System.out.println("Expected Total Number Of Contributors Values : " + expected);
        System.out.print("Actual Total Number Of Contributors Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
    }

    public void checkTotalCost(){
        Assert.assertEquals(TestDataBase.resourceDistributionTotalCost,totalCost.getText());
        // Recovery
        String result = (String) HighchartsUtils.getChartDataProperty(driver, "cost-worktype-chart", 0, 0, "name");
        String expected = "$22,757.50";
        System.out.println();
        System.out.println("Expected Recovery Cost : " + expected);
        System.out.print("Actual Recovery Cost :   "+result);
        System.out.println();
        System.out.println("- - - - -");
        // Support
        String result1 = (String) HighchartsUtils.getChartDataProperty(driver, "cost-worktype-chart", 0, 1, "name");
        String expected1 = "$26,847.50";
        System.out.println();
        System.out.println("Expected Support Cost : " + expected1);
        System.out.print("Actual Support Cost :   "+result1);
        System.out.println();
        System.out.println("- - - - -");
        // Continuation
        String result2 = (String) HighchartsUtils.getChartDataProperty(driver, "cost-worktype-chart", 0, 2, "name");
        String expected2 = "$25,655.00";
        System.out.println();
        System.out.println("Expected Continuation Cost : " + expected2);
        System.out.print("Actual Continuation Cost :   "+result2);
        System.out.println();
        System.out.println("- - - - -");
        // Improvement
        String result3 = (String) HighchartsUtils.getChartDataProperty(driver, "cost-worktype-chart", 0, 3, "name");
        String expected3 = "$87,832.50";
        System.out.println();
        System.out.println("Expected Improvement Cost : " + expected3);
        System.out.print("Actual Improvement Cost :   "+result3);
        System.out.println();
        System.out.println("------------------------------");

    }

    public void checkResourceOverview(){
        checkTotalNumberOfIssues();
        checkTotalNumberOfHours();
        checkTotalNumberOfContributors();
        checkTotalCost();
    }

    @FindBy(id = "historic_resource_distribution")
    public WebElement historicResourceDistributionTable;

    public void checkHistoricResourceDistribution(){
        JSUtilities.scrollToElement(driver,historicResourceDistributionTable);
        Assert.assertTrue(historicResourceDistributionTable.isDisplayed());
    }

    @FindBy(id = "team_resource_distribution")
    public WebElement teamEffortAnalysisTable;

    public void checkTeamEffortAnalysis(){
        JSUtilities.scrollToElement(driver,teamEffortAnalysisTable);
        ReusableMethods.wait(3);
        // Team Effort Analysis Improvement
        List<ArrayList> result = (List<ArrayList>) HighchartsUtils.getChartData(driver, "team_resource_distribution", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = Arrays.asList(55.4,52.3,59.9,50.8);
        System.out.println();
        System.out.println("Expected Team Effort Analysis Improvement Percent : " + expected);
        System.out.print("Actual Team Effort Analysis Improvement Percent :   ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i).get(0));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Team Effort Analysis Recovery
        List<ArrayList> result1 = (List<ArrayList>) HighchartsUtils.getChartData(driver, "team_resource_distribution", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = Arrays.asList(10.6,18.7,8.3,20.7);
        System.out.println();
        System.out.println("Expected Team Effort Analysis Recovery Percent : " + expected1);
        System.out.print("Actual Team Effort Analysis Recovery Percent :   ");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i).get(0));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Team Effort Analysis Continuation
        List<ArrayList> result2 = (List<ArrayList>) HighchartsUtils.getChartData(driver, "team_resource_distribution", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = Arrays.asList(19.3,21.3,12.7,16L);
        System.out.println();
        System.out.println("Expected Team Effort Analysis Continuation Percent : " + expected2);
        System.out.print("Actual Team Effort Analysis Continuation Percent :   ");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i).get(0));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Team Effort Analysis Support
        List<ArrayList> result3 = (List<ArrayList>) HighchartsUtils.getChartData(driver, "team_resource_distribution", 3, HighchartsUtils.DataType.Y);
        List<Number> expected3 = Arrays.asList(14.7,7.8,19.1,12.5);
        System.out.println();
        System.out.println("Expected Team Effort Analysis Support Percent : " + expected3);
        System.out.print("Actual Team Effort Analysis Support Percent :   ");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected3.get(i), result3.get(i).get(0));
            System.out.print(result3.get(i) + " ,");
        }
        System.out.println();
        System.out.println("------------------------------------------");
    }

    @FindBy(id = "project-table_wrapper")
    public WebElement projectEffortAnalysisTable;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[1]")
    public WebElement project1ProjectName;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[2]")
    public WebElement project1InvestmentProfile;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[3]")
    public WebElement project1NumberOfIssues;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[4]")
    public WebElement project1Contributors;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[5]")
    public WebElement project1TotalCost;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[6]")
    public WebElement project2ProjectName;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[7]")
    public WebElement project2InvestmentProfile;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[8]")
    public WebElement project2NumberOfIssues;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[9]")
    public WebElement project2Contributors;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[10]")
    public WebElement project2TotalCost;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[11]")
    public WebElement project3ProjectName;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[12]")
    public WebElement project3InvestmentProfile;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[13]")
    public WebElement project3NumberOfIssues;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[14]")
    public WebElement project3Contributors;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td)[15]")
    public WebElement project3TotalCost;

    public void checkProjectEffortAnalysis(){
        JSUtilities.scrollToElement(driver,projectEffortAnalysisTable);
        Assert.assertTrue(project1ProjectName.isDisplayed());
        Assert.assertTrue(project1InvestmentProfile.isDisplayed());
        Assert.assertTrue(project1NumberOfIssues.isDisplayed());
        Assert.assertTrue(project1Contributors.isDisplayed());
        Assert.assertTrue(project1TotalCost.isDisplayed());
        Assert.assertTrue(project2ProjectName.isDisplayed());
        Assert.assertTrue(project2InvestmentProfile.isDisplayed());
        Assert.assertTrue(project2NumberOfIssues.isDisplayed());
        Assert.assertTrue(project2Contributors.isDisplayed());
        Assert.assertTrue(project2TotalCost.isDisplayed());
        Assert.assertTrue(project3ProjectName.isDisplayed());
        Assert.assertTrue(project3InvestmentProfile.isDisplayed());
        Assert.assertTrue(project3NumberOfIssues.isDisplayed());
        Assert.assertTrue(project3Contributors.isDisplayed());
        Assert.assertTrue(project3TotalCost.isDisplayed());










    }

}
