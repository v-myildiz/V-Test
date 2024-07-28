package stepdefinitions.Dashboard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.DashboardPage;
import pages.Insights.InsightsPage;
import utilities.ReusableMethods;

public class DashboardPageSteps extends BaseStep {
    InsightsPage insightsPage=new InsightsPage(driver);
    DashboardPage dashboardPage=new DashboardPage(driver);

    @Given("the user logs into the site by selecting a date range {string}-{string}.")
    public void the_user_logs_into_the_site_by_selecting_a_date_range(String firstMonth, String secondMonth) {
        ReusableMethods.wait(3);
        dashboardPage.dateBox.click();
        dashboardPage.last6MonthsText.click();
        ReusableMethods.wait(2);
        switch (firstMonth) {
            case "January":
                dashboardPage.janruaryRightColumn.click();
                break;

            case "February":
                dashboardPage.februaryRightColumn.click();
                break;

            case "March":
                dashboardPage.marchRightColumn.click();
                break;

            case "April":
                dashboardPage.aprilRightColumn.click();
                break;

            case "May":
                dashboardPage.mayRightColumn.click();
                break;

            case "June":
                dashboardPage.juneRightColumn.click();
                break;

            case "July":
                dashboardPage.julyRightColumn.click();
                break;

            case "August":
                dashboardPage.augustRightColumn.click();
                break;

            case "September":
                dashboardPage.septemberRightColumn.click();
                break;

            case "October":
                dashboardPage.octoberRightColumn.click();
                break;

            case "November":
                dashboardPage.novemberRightColumn.click();
                break;

            case "December":
                dashboardPage.decemberRightColumn.click();
                break;

            default:
                firstMonth = "Invalid Month!";
                break;
        }
        switch (secondMonth) {
            case "January":
                dashboardPage.janruaryRightColumn.click();
                break;

            case "February":
                dashboardPage.februaryRightColumn.click();
                break;

            case "March":
                dashboardPage.marchRightColumn.click();
                break;

            case "April":
                dashboardPage.aprilRightColumn.click();
                break;

            case "May":
                dashboardPage.mayRightColumn.click();
                break;

            case "June":
                dashboardPage.juneRightColumn.click();
                break;

            case "July":
                dashboardPage.julyRightColumn.click();
                break;

            case "August":
                dashboardPage.augustRightColumn.click();
                break;

            case "September":
                dashboardPage.septemberRightColumn.click();
                break;

            case "October":
                dashboardPage.octoberRightColumn.click();
                break;

            case "November":
                dashboardPage.novemberRightColumn.click();
                break;

            case "December":
                dashboardPage.decemberRightColumn.click();
                break;

            default:
                secondMonth = "Invalid Month!";
                break;
        }
        ReusableMethods.wait(2);
        dashboardPage.applyChangesText.click();
    }

}



