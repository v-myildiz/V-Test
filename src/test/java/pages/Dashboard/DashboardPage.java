package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.HighchartsUtils;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "sla-data-range")
    public WebElement dateBox;

    @FindBy(xpath = "//*[text()='Apply Changes']")
    public WebElement applyChangesText;

    @FindBy(xpath = "//*[text()='Last 6 months']")
    public WebElement last6MonthsText;

    @FindBy(id = "project_count")
    public WebElement contributedProjects;

    @FindBy(id = "repo_count")
    public WebElement contributedRepositories;

    @FindBy(id = "dev_count")
    public WebElement activeContributors;

    @FindBy(xpath = "//*[@data-layer=\"average-risk\"]//label")
    public WebElement averageCommitRisk;

    @FindBy(xpath = "//*[@data-layer=\"total-pr\"]//label")
    public WebElement closedPRCount;

    @FindBy(xpath = "//*[@data-layer=\"responsiveness\"]//label")
    public WebElement averageResponsiveness;

    @FindBy(xpath = "//*[@data-layer=\"receptiveness\"]//label")
    public WebElement averageReceptiveness;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"01\"]")
    public WebElement janruaryLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"02\"]")
    public WebElement februaryLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"03\"]")
    public WebElement marchLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"04\"]")
    public WebElement aprilLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"05\"]")
    public WebElement mayLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"06\"]")
    public WebElement juneLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"07\"]")
    public WebElement julyLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"08\"]")
    public WebElement augustLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"09\"]")
    public WebElement septemberLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"10\"]")
    public WebElement octoberLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"11\"]")
    public WebElement novemberLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-1\"]//*[@data-month=\"12\"]")
    public WebElement decemberLeftColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"01\"]")
    public WebElement janruaryRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"02\"]")
    public WebElement februaryRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"03\"]")
    public WebElement marchRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"04\"]")
    public WebElement aprilRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"05\"]")
    public WebElement mayRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"06\"]")
    public WebElement juneRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"07\"]")
    public WebElement julyRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"08\"]")
    public WebElement augustRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"09\"]")
    public WebElement septemberRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"10\"]")
    public WebElement octoberRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"11\"]")
    public WebElement novemberRightColumn;

    @FindBy(xpath = "//*[@id=\"mpr-calendar-2\"]//*[@data-month=\"12\"]")
    public WebElement decemberRightColumn;

    @FindBy(id = "letter_grade")
    public WebElement overallPerformanceScoreText;

    @FindBy(xpath = "//*[@id=\"project-table_wrapper\"]//td[@class=\"best\"]")
    public WebElement codingTime;

    @FindBy(xpath = "//*[@id=\"project-table_wrapper\"]//td[@class=\"arrow medium\"]")
    public WebElement pickupTime;

    @FindBy(xpath = "//*[@id=\"project-table_wrapper\"]//td[@class=\"arrow good\"]")
    public WebElement reviewTime;

    @FindBy(xpath = "(//*[@id=\"project-table_wrapper\"]//td[@class=\"arrow good\"])[2]")
    public WebElement deployTime;

    @FindBy(xpath = "//*[@id=\"most-active-submitters\"]//*[@id=\"row-0\"]//*[@class=\"chart-developer\"]")
    public WebElement firstSubmitter;

    @FindBy(xpath = "//*[@id=\"most-active-submitters\"]//*[@id=\"row-1\"]//*[@class=\"chart-developer\"]")
    public WebElement secondSubmitter;

    @FindBy(xpath = "//*[@id=\"most-active-submitters\"]//*[@id=\"row-2\"]//*[@class=\"chart-developer\"]")
    public WebElement thirdSubmitter;

    @FindBy(xpath = "//*[@id=\"most-active-submitters\"]//*[@id=\"row-3\"]//*[@class=\"chart-developer\"]")
    public WebElement fourthSubmitter;

    @FindBy(xpath = "//*[@id=\"most-active-submitters\"]//*[@id=\"row-4\"]//*[@class=\"chart-developer\"]")
    public WebElement fifthSubmitter;

    @FindBy(xpath = "//*[@id=\"most-active-reviewers\"]//*[@id=\"row-0\"]//*[@class=\"chart-developer\"]")
    public WebElement firstReviewers;

    @FindBy(xpath = "//*[@id=\"most-active-reviewers\"]//*[@id=\"row-1\"]//*[@class=\"chart-developer\"]")
    public WebElement secondReviewers;

    @FindBy(xpath = "//*[@id=\"most-active-reviewers\"]//*[@id=\"row-2\"]//*[@class=\"chart-developer\"]")
    public WebElement thirdReviewers;

    @FindBy(xpath = "//*[@id=\"most-active-reviewers\"]//*[@id=\"row-3\"]//*[@class=\"chart-developer\"]")
    public WebElement fourthReviewers;

    @FindBy(xpath = "//*[@id=\"most-active-reviewers\"]//*[@id=\"row-4\"]//*[@class=\"chart-developer\"]")
    public WebElement fifthReviewers;

    @FindBy(xpath = "//*[@id=\"most-productive-developers-table\"]//*[@id=\"row-0\"]//*[@class=\"chart-developer\"]")
    public WebElement firstContributions;

    @FindBy(xpath = "//*[@id=\"most-productive-developers-table\"]//*[@id=\"row-1\"]//*[@class=\"chart-developer\"]")
    public WebElement secondContributions;

    @FindBy(xpath = "//*[@id=\"most-productive-developers-table\"]//*[@id=\"row-2\"]//*[@class=\"chart-developer\"]")
    public WebElement thirdContributions;

    @FindBy(xpath = "//*[@id=\"most-productive-developers-table\"]//*[@id=\"row-3\"]//*[@class=\"chart-developer\"]")
    public WebElement fourthContributions;

    @FindBy(xpath = "//*[@id=\"most-productive-developers-table\"]//*[@id=\"row-4\"]//*[@class=\"chart-developer\"]")
    public WebElement fifthContributions;

    @FindBy(xpath = "(//*[@data-layer=\"work-breakdown\"]//label)[1]")
    public WebElement workBreakdownNewWork;

    @FindBy(xpath = "(//*[@data-layer=\"work-breakdown\"]//label)[2]")
    public WebElement workBreakdownLegacyRefactor;

    @FindBy(xpath = "(//*[@data-layer=\"work-breakdown\"]//label)[3]")
    public WebElement workBreakdownHelpOthers;

    @FindBy(xpath = "(//*[@data-layer=\"work-breakdown\"]//label)[4]")
    public WebElement workBreakdownChurn;

    @FindBy(id = "line-of-codes-by-days")
    public WebElement workBreakdownGraph;

    @FindBy(xpath = "//*[@id=\"overdue-issue-breakdown\"]//label")
    public WebElement totalCountOfOverdueIssues;

    @FindBy(xpath = "//*[@data-layer=\"overdue\"]//*[text()='There is no data']")
    public WebElement overdueIssuesThereIsNoDataText;

    @FindBy(xpath = "//*[@id=\"planned-issue-breakdown\"]//label")
    public WebElement plannedIssues;

    @FindBy(xpath = "//*[@id=\"opened-issue-breakdown\"]//label")
    public WebElement openedIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[10]")
    public WebElement openedBugIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[11]")
    public WebElement openedFeatureIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[12]")
    public WebElement openedImprovementIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[13]")
    public WebElement openedOtherIssues;

    @FindBy(xpath = "//*[@id=\"closed-issue-breakdown\"]//label")
    public WebElement closedIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[14]")
    public WebElement closedBugIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[15]")
    public WebElement closedImprovementIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[16]")
    public WebElement closedFeatureIssues;

    @FindBy(xpath = "(//*[@data-toggle=\"tooltip\"])[17]")
    public WebElement closedOtherIssues;

}
