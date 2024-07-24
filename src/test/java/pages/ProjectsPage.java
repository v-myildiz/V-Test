package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

public class ProjectsPage extends BasePage{
    public ProjectsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@data-original-title=\"Projects\"]")
    public WebElement projectsIkon;

    public void intoProjects() {
        ReusableMethods.wait(1);
        projectsIkon.click();
    }

    @FindBy(id = "9683")
    public WebElement jenkinsTestProject;

    @FindBy(id = "work-breakdown")
    public WebElement workBreakdownTable;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"open-issues\"]//label")
    public WebElement workBreakdownOpenIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"open-issues\"]//*[@class=\"critical\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownOpenIssuesCriticalIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"open-issues\"]//*[@class=\"important\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownOpenIssuesImportantIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"open-issues\"]//*[@class=\"normal\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownOpenIssuesNormalIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"open-issues\"]//*[@class=\"low\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownOpenIssuesLowIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"open-issues\"]//*[@class=\"unknown\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownOpenIssuesUnknownIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"inprogress-issues\"]//label")
    public WebElement workBreakdownInProgressIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"inprogress-issues\"]//*[@class=\"critical\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownInProgressIssuesCriticalIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"inprogress-issues\"]//*[@class=\"important\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownInProgressIssuesImportantIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"inprogress-issues\"]//*[@class=\"normal\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownInProgressIssuesNormalIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"inprogress-issues\"]//*[@class=\"low\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownInProgressIssuesLowIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"inprogress-issues\"]//*[@class=\"unknown\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownInProgressIssuesUnknownIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"closed-issues\"]//label")
    public WebElement workBreakdownClosedIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"closed-issues\"]//*[@class=\"critical\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownClosedIssuesCriticalIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"closed-issues\"]//*[@class=\"important\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownClosedIssuesImportantIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"closed-issues\"]//*[@class=\"normal\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownClosedIssuesNormalIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"closed-issues\"]//*[@class=\"low\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownClosedIssuesLowIssues;

    @FindBy(xpath = "//*[@id=\"work-breakdown\"]//*[@class=\"closed-issues\"]//*[@class=\"unknown\"]//*[@class=\"percentage-value\"]")
    public WebElement workBreakdownClosedIssuesUnknownIssues;

    public void checkWorkBreakdownOpenIssues(){
        Integer openIssues=Integer.parseInt(workBreakdownOpenIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Open Issues : "+openIssues);
        Assert.assertTrue(openIssues>1);
        Integer criticalIssues=Integer.parseInt(workBreakdownOpenIssuesCriticalIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Critical Issues : "+criticalIssues);
        Assert.assertTrue(criticalIssues>1);
        Integer importantIssues=Integer.parseInt(workBreakdownOpenIssuesImportantIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Important Issues : "+importantIssues);
        Assert.assertTrue(importantIssues>1);
        Integer normalIssues=Integer.parseInt(workBreakdownOpenIssuesNormalIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Normal Issues : "+normalIssues);
        Assert.assertTrue(normalIssues<1);
        Integer lowIssues=Integer.parseInt(workBreakdownOpenIssuesLowIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Low Issues : "+lowIssues);
        Assert.assertTrue(lowIssues>1);
        Integer unknownIssues=Integer.parseInt(workBreakdownOpenIssuesUnknownIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Unknown Issues : "+unknownIssues);
        Assert.assertTrue(unknownIssues<1);
        System.out.println("---------------------------------------------------");
    }

    public void checkWorkBreakdownInProgressIssues(){
        Integer openIssues=Integer.parseInt(workBreakdownInProgressIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Open Issues : "+openIssues);
        Assert.assertTrue(openIssues>1);
        Integer criticalIssues=Integer.parseInt(workBreakdownInProgressIssuesCriticalIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Critical Issues : "+criticalIssues);
        Assert.assertTrue(criticalIssues>1);
        Integer importantIssues=Integer.parseInt(workBreakdownInProgressIssuesImportantIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Important Issues : "+importantIssues);
        Assert.assertTrue(importantIssues>1);
        Integer normalIssues=Integer.parseInt(workBreakdownInProgressIssuesNormalIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Normal Issues : "+normalIssues);
        Assert.assertTrue(normalIssues<1);
        Integer lowIssues=Integer.parseInt(workBreakdownInProgressIssuesLowIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Low Issues : "+lowIssues);
        Assert.assertTrue(lowIssues>1);
        Integer unknownIssues=Integer.parseInt(workBreakdownInProgressIssuesUnknownIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Unknown Issues : "+unknownIssues);
        Assert.assertTrue(unknownIssues<1);
        System.out.println("---------------------------------------------------");
    }

    public void checkWorkBreakdownClosedIssues(){
        Integer openIssues=Integer.parseInt(workBreakdownClosedIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Closed Issues : "+openIssues);
        Assert.assertTrue(openIssues>1);
        Integer criticalIssues=Integer.parseInt(workBreakdownClosedIssuesCriticalIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Critical Issues : "+criticalIssues);
        Assert.assertTrue(criticalIssues>1);
        Integer importantIssues=Integer.parseInt(workBreakdownClosedIssuesImportantIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Important Issues : "+importantIssues);
        Assert.assertTrue(importantIssues>1);
        Integer normalIssues=Integer.parseInt(workBreakdownClosedIssuesNormalIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Normal Issues : "+normalIssues);
        Assert.assertTrue(normalIssues<1);
        Integer lowIssues=Integer.parseInt(workBreakdownClosedIssuesLowIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Low Issues : "+lowIssues);
        Assert.assertTrue(lowIssues>1);
        Integer unknownIssues=Integer.parseInt(workBreakdownClosedIssuesUnknownIssues.getText().replaceAll("\\D", ""));
        System.out.println(" Unknown Issues : "+unknownIssues);
        Assert.assertTrue(unknownIssues<1);
        System.out.println("---------------------------------------------------");
    }

    public void checkWorkBreakdownIssues(){
        checkWorkBreakdownOpenIssues();
        checkWorkBreakdownInProgressIssues();
        checkWorkBreakdownClosedIssues();
        checkWorkBreakdownIssuesInfo();
    }

    @FindBy(xpath = "//*[@class=\"info-chart-wrapper\"]//*[@class=\"task-count\"]//label")
    public WebElement workBreakdownTotalIssueCount;

    @FindBy(xpath = "//*[@class=\"info-chart-wrapper\"]//*[@class=\"bug-count\"]//label")
    public WebElement workBreakdownBugCount;

    @FindBy(xpath = "//*[@class=\"info-chart-wrapper\"]//*[@class=\"feature-count\"]//label")
    public WebElement workBreakdownFeatureCount;

    @FindBy(xpath = "//*[@class=\"info-chart-wrapper\"]//*[@class=\"improvement-count\"]//label")
    public WebElement workBreakdownImprovementCount;

    public void checkWorkBreakdownIssuesInfo(){
        Integer totalIssueCount=Integer.parseInt(workBreakdownTotalIssueCount.getText().replaceAll("\\D", ""));
        System.out.println(" Total Issue Count : "+totalIssueCount);
        Assert.assertTrue(totalIssueCount>1);
        Integer bugCount=Integer.parseInt(workBreakdownBugCount.getText().replaceAll("\\D", ""));
        System.out.println(" Bug Count : "+bugCount);
        Assert.assertTrue(bugCount>1);
        Integer featureCount=Integer.parseInt(workBreakdownFeatureCount.getText().replaceAll("\\D", ""));
        System.out.println(" Feature Count : "+featureCount);
        Assert.assertTrue(featureCount>1);
        Integer improvementCount=Integer.parseInt(workBreakdownImprovementCount.getText().replaceAll("\\D", ""));
        System.out.println(" Improvement Count : "+improvementCount);
        Assert.assertTrue(improvementCount>1);
    }
}
