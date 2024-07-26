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
import java.util.NoSuchElementException;

public class InsightsPage extends BasePage {
    public InsightsPage(WebDriver driver) {
        super(driver);
    }
    DashboardPage dashboardPage=new DashboardPage(driver);

    @FindBy(xpath = "//*[@data-original-title=\"Insights\"]")
    public WebElement insightsIkon;

    public void intoInsights() {

        insightsIkon.click();
    }

    @FindBy(xpath = "//span[text()='Code Progress']")
    public WebElement codeProgressMenu;

    public void intoCodeProgress() {
        intoInsights();
        codeProgressMenu.click();
    }

    @FindBy(xpath = "//span[text()='Dev. Behaviors']")
    public WebElement devBehaviorsMenu;

    public void intoDevBehaviors() {
        intoInsights();
        devBehaviorsMenu.click();
    }

    @FindBy(xpath = "//span[text()='Project Health']")
    public WebElement projectHealthMenu;

    public void intoProjectHealth() {
        intoInsights();
        projectHealthMenu.click();
    }

    @FindBy(xpath = "//span[text()='Activities']")
    public WebElement activitiesMenu;

    public void intoActivities() {
        intoInsights();
        activitiesMenu.click();

    }


    //OVERVIEW
    @FindBy(xpath = "//*[@id=\"letter_grade\"]")
    public WebElement projectScore;

    public void checkOverviewProjectScore() {
        Assert.assertEquals(TestDataBase.overviewProjectScore, projectScore.getText());

    }

    public void checkOverviewProjectGraph() {
        ReusableMethods.wait(3);
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "overall-performance-score", 0, HighchartsUtils.DataType.Y);

        List<Long> expected = List.of(46L, 57L, 49L, 57L, 70L, 66L, 61L, 59L, 80L, 74L, 64L, 67L, 69L, 73L, 83L, 78L, 92L, 71L, 79L, 59L, 74L, 81L, 74L, 70L, 59L, 62L, 73L, 73L, 82L, 76L, 73L, 74L, 83L, 75L, 77L, 90L, 72L, 81L, 76L, 72L, 65L, 80L, 68L, 58L, 60L, 73L, 82L, 76L, 59L, 64L, 76L, 82L, 75L, 78L, 85L, 72L, 75L, 77L, 83L, 68L, 78L);
        System.out.println("Expected Overall Performance Score Values : " + expected);

        System.out.print("Actual Overall Performance Score Values :   ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    @FindBy(xpath = "//*[@data-layer=\"contributors\"]//label")
    public WebElement overviewContributors;

    public void checkOverviewContributors() {
        Assert.assertEquals(TestDataBase.overviewContributors, overviewContributors.getText());

    }

    @FindBy(xpath = "//*[@data-layer=\"number-of-issues\"]//label")
    public WebElement overviewNumberOfActiveIssues;

    public void checkOverviewNumberOfActiveIssues() {
        Assert.assertEquals(TestDataBase.overviewNumberOfActiveIssues, overviewNumberOfActiveIssues.getText());

    }

    @FindBy(xpath = "(//*[@id=\"insights\"]//*[@role=\"alert\"])[1]")
    public WebElement insightsAlert1;

    @FindBy(xpath = "(//*[@id=\"insights\"]//*[@role=\"alert\"])[2]")
    public WebElement insightsAlert2;

    @FindBy(xpath = "(//*[@id=\"insights\"]//*[@role=\"alert\"])[3]")
    public WebElement insightsAlert3;

    public void checkInsightsAlerts() {
        Assert.assertEquals(TestDataBase.overviewInsightsAlert1, insightsAlert1.getText());
        Assert.assertEquals(TestDataBase.overviewInsightsAlert2, insightsAlert2.getText());
        Assert.assertEquals(TestDataBase.overviewInsightsAlert3, insightsAlert3.getText());
    }

    @FindBy(xpath = "//*[@id=\"code_progress_letter_grade\"]")
    public WebElement overviewCodeProgress;

    @FindBy(xpath = "//*[@id=\"development_behaviors_letter_grade\"]")
    public WebElement overviewDevelopmentBehaviors;

    @FindBy(xpath = "//*[@id=\"project_health_letter_grade\"]")
    public WebElement overviewProjectHealth;

    public void checkCategories() {
        Assert.assertEquals(TestDataBase.overviewCodeProgress, overviewCodeProgress.getText());
        Assert.assertEquals(TestDataBase.overviewDevelopmentBehaviors, overviewDevelopmentBehaviors.getText());
        Assert.assertEquals(TestDataBase.overviewProjectHealth, overviewProjectHealth.getText());
    }

    @FindBy(xpath = "//*[@data-layer=\"throughput\"]")
    public WebElement overviewThroughput;

    @FindBy(xpath = "(//*[@id=\"code_impact_insights\"]//*[@role=\"alert\"])[1]")
    public WebElement codeImpactAlert1;

    @FindBy(xpath = "(//*[@id=\"code_impact_insights\"]//*[@role=\"alert\"])[2]")
    public WebElement codeImpactAlert2;

    @FindBy(xpath = "(//*[@id=\"code_impact_insights\"]//*[@role=\"alert\"])[3]")
    public WebElement codeImpactAlert3;

    public void checkCodeImpactGraph() {
        JSUtilities.scrollToElement(driver, overviewThroughput);
        ReusableMethods.wait(3);
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "code-impact", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(0L, 0L, 0L, 30.797101449275367, 0L, 76.19047619047619, 0L, 0L, 55.357142857142854, 9.25925925925926, 76.19047619047619, 4.444444444444444, 22.161505768063144, 21.642808452624404, 0L, 64.28571428571429, 0L, 0L, 50.12315270935961, 0L, 9.848484848484848, 12.05065359477124, 0L, 0.3752063634999249, 62.40601503759399, 0L, 0L, 66.89895470383274, 0L, 56.2807881773399, 7.977951842181607, 64.28571428571429, 26.39218791237794, 100L);
        System.out.println();
        System.out.println("Expected Code Impact Values : " + expected);
        System.out.print("Actual Code Impact Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkCodeImpactAlerts() {
        JSUtilities.scrollToElement(driver, codeImpactAlert3);
        Assert.assertEquals(TestDataBase.overviewCodeImpactAlert1, codeImpactAlert1.getText());
        Assert.assertEquals(TestDataBase.overviewCodeImpactAlert2, codeImpactAlert2.getText());
        Assert.assertEquals(TestDataBase.overviewCodeImpactAlert3, codeImpactAlert3.getText());
    }

    public void checkThroughputGraph() {
        JSUtilities.scrollToElement(driver, overviewThroughput);
        ReusableMethods.wait(3);
        // Efficiency
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "throughput", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(100L, 100L, 80L, 98.75, 98.57673262499999, 100L, 100L, 100L, 100L, 66.59861480000001, 16.666665000000002, 79.16666666666666, 57.84313666666666, 98.97978640000001, 92.8571425, 100L, 100L, 98.69791666666666, 99.30384615, 50L, 100L, 84.89999999999999, 67.06618710000001, 86L, 67.99620108333335, 58.333333333333336, 94.98587562499999, 99.72764215, 100L, 99.47604787499999, 100L, 100L, 92.22222216666665, 83.33333333333334, 87.61370215555556, 98.88888883333334, 93.86688961, 80L, 84.65498771, 91.923260125, 77.22222288, 93.98148125, 90L, 73.02631533333333, 65.01965914285715, 99.074074075, 100L, 100L, 76.66666666666666, 25L, 100L, 100L, 100L, 79.5652174, 94.25287333333333, 88.88888888888889, 83.33333333333334, 97.22222225, 99.25925926, 60.89743566666667, 100L);
        System.out.println();
        System.out.println("Expected Throughput Efficiency Values : " + expected);
        System.out.print("Actual Throughput Efficiency Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-  -  -");
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "throughput", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L, 0L, 20L, 1.25, 1.4232673750000089, 0L, 0L, 0L, 0L, 33.40138519999999, 83.333335, 20.833333333333343, 42.15686333333334, 1.020213599999991, 7.142857500000005, 0L, 0L, 1.3020833333333428, 0.6961538500000017, 50L, 0L, 15.100000000000009, 32.93381289999999, 14L, 32.00379891666665, 41.666666666666664, 5.014124375000009, 0.2723578500000059, 0L, 0.5239521250000081, 0L, 0L, 7.777777833333346, 16.666666666666657, 12.386297844444442, 1.1111111666666602, 6.133110389999999, 20L, 15.34501229, 8.076739875000001, 22.777777119999996, 6.018518749999998, 10L, 26.97368466666667, 34.98034085714285, 0.9259259250000014, 0L, 0L, 23.333333333333343, 75L, 0L, 0L, 0L, 20.434782600000005, 5.747126666666674, 11.111111111111114, 16.666666666666657, 2.7777777499999985, 0.7407407400000068, 39.10256433333333, 0L);
        System.out.println();
        System.out.println("Expected Throughput Churn Values : " + expected);
        System.out.print("Actual Throughput Churn Values : ");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");


    }

    @FindBy(xpath = "//*[@data-layer=\"average-throughput\"]//label")
    public WebElement averageThroughput;

    @FindBy(xpath = "//*[@data-layer=\"average-efficiency\"]//label")
    public WebElement averageEfficiency;

    @FindBy(xpath = "//*[@data-layer=\"least-productive-week\"]//label")
    public WebElement leastProductiveWeek;

    public void checkThroughputDetails() {
        Assert.assertEquals(TestDataBase.averageThroughput, averageThroughput.getText());
        Assert.assertEquals(TestDataBase.averageEfficiency, averageEfficiency.getText());
        Assert.assertEquals(TestDataBase.leastProductiveWeek, leastProductiveWeek.getText());
        driver.quit();
    }

    // CODE PROGRESS
    public void checkPullRequests() {
        ReusableMethods.wait(3);
        // Pull Request 1
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "pull-requests", 1, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(1L, 7L, 8L);
        System.out.println();
        System.out.println("Expected Pull Request Values : " + expected);
        System.out.print("Actual Pull Request Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-  -  -");
        // Pull Request 2
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "pull-requests", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(5L, 5L, 5L);
        System.out.println();
        System.out.println("Expected Pull Request Values : " + expected2);
        System.out.print("Actual Pull Request Values : ");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    @FindBy(xpath = "//*[@id=\"time-to-close\"]")
    public WebElement timeToClosePullRequestGraph;

    public void checkTimeToCloseByPullRequests() {
        JSUtilities.scrollToElement(driver, timeToClosePullRequestGraph);
        ReusableMethods.wait(3);
        // Merged
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "time-to-close", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(0.3960648148148148, 1.560758101851852, 0.6447762345679012, 0.7294444444444445, 1.0062847222222222, 1.5900405092592593, 0.04756172839506173, 0.8286033950617284, 0.05130401234567901, 1.2918113425925926, 0.29333333333333333, 0.11120370370370371, 0.14082947530864198, 0.00047453703703703704, 0.2858024691358025, 1.6771202256944444, 1.908281914813187, 1.098778935185185, 1.2686863425925927, 0.9549768518518519, 0.07317129629629629, 0.02943672839506173, 0.19830246913580246, 1.9849950540469241, 0.8452006172839506, 0.8647029320987655, 0.07228395061728395, 0.7042746913580247, 0.8920987654320988, 0.9484104938271605, 0.37721064814814814, 0.6282716049382716, 0.7416126543209877, 1.8685989583333333, 1.9018408231482244, 1.911616853570615, 1.9143184024070408, 0.6461728395061729, 0.36224151234567903, 1.1721894290123456, 0.0954591049382716, 0.3398263888888889, 0.1851118827160494, 0.06771990740740741, 0.6986188271604938, 0.0994675925925926, 0.1764158950617284, 0.17651234567901233, 0.2323070987654321, 0.35649305555555555, 0.6260725308641976, 0.6195177469135802, 0.587079475308642, 0.3166126543209877, 0.42192901234567903, 0.5956172839506173, 0.052739197530864194, 1.9003888391578263, 0.0494483024691358, 0.3076273148148148, 0.40241512345679015, 0.0006712962962962962, 0.3355131172839506, 0.18916666666666668, 0.47596450617283953, 0.5211574074074075, 0.8264506172839506, 1.4214872685185185, 1.9005422792620228, 0.2820949074074074, 0.7480516975308642, 0.9808526234567901, 1.1744733796296296, 0.18641203703703704, 0.1865162037037037, 0.11959490740740741, 0.6742978395061728, 0.07363425925925926, 0.09018132716049383, 0.34955632716049384, 0.3904899691358025, 0.3903780864197531, 0.7131288580246914, 0.3173996913580247, 0.2674652777777778, 0.3154513888888889, 0.40612654320987657, 0.4099421296296296, 0.6019984567901234, 1.9169498926163822, 0.19003086419753087, 0.19018132716049382, 0.8820216049382716, 1.0708159722222221, 1.709740306712963, 1.901179123893102, 0.3193557098765432, 0.1517091049382716, 0.2565046296296296, 1.1373823302469135, 1.1300520833333334, 0.5001080246913581, 0.5696219135802469, 1.8980555555555554, 0.3066087962962963, 0.3989043209876543, 0.1703125, 0.5623302469135802, 1.9181317065678791, 1.7767230902777778, 0.9780787037037038, 0.6182561728395062, 0.05137731481481481, 1.4601060956790124, 0.06430941358024692, 0.3866203703703704, 0.16700617283950617, 0.229375, 0.04527777777777778, 0.16812114197530864, 0.26114197530864197, 0.30156635802469134, 0.07905478395061728, 0.05196373456790124, 0.11878086419753087, 0.3201813271604938, 0.8111304012345679, 0.3007175925925926, 0.5475308641975308, 0.1354706790123457, 1.89308984375, 0.11752314814814815, 1.4212345679012346, 1.281988811728395, 0.5158757716049382, 0.30137731481481483, 0.19606095679012345, 0.08401234567901235, 0.03369598765432099, 0.13387731481481482, 0.2647878086419753, 0.03675925925925926, 0.6307137345679013, 1.5033883101851853, 0.019540895061728396, 0.07650848765432099, 0.9762037037037037, 1.9020708455294415, 0.38263503086419753, 0.42779706790123456, 0.30378472222222225, 0.9376967592592592, 0.047530864197530866, 0.05935570987654321, 0.030381944444444444, 0.3587114197530864, 0.2630131172839506, 1.785029513888889, 0.131875, 0.3240895061728395, 0.6685609567901235, 0.23783564814814814, 0.4974189814814815, 0.33013503086419754, 0.38862654320987655, 1.5590878182870371, 0.04616512345679012, 0.046253858024691355, 0.43416666666666665, 0.11262731481481482, 0.0955054012345679, 0.02812885802469136, 0.02915895061728395, 0.3471180555555556, 0.08158950617283951, 0.08153935185185185, 0.24760416666666665, 0.24775462962962963, 0.24904320987654321, 0.07461419753086419, 0.15486496913580247, 0.9357600308641976, 0.6047183641975309, 0.5885493827160494, 0.5615123456790123, 0.9236111111111112, 0.11450231481481482, 0.03358024691358025, 0.06044367283950617, 0.06033950617283951, 0.8785223765432099, 0.6020949074074075);
        System.out.println();
        System.out.println("Expected Merged Values : " + expected);
        System.out.print("Actual Merged Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-  -  -");
        // Declined
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "time-to-close", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(2L, 0.0006404320987654321, 0.08871141975308643, 0.009591049382716049, 0.10812114197530864, 1.6057081886574074, 1.929145549622157, 0.33794367283950616, 1.9130177264515094, 1.911783241087752, 1.96665512455952, 0.05986111111111111, 0.060223765432098765, 1.9002686028473905, 0.0056674382716049385, 1.6224131944444444, 0.3306327160493827, 0.3470177469135802, 0.6843094135802469, 0.6842824074074074, 0.6843788580246913, 1.0681867283950617);
        System.out.println();
        System.out.println("Expected Declined Values : " + expected1);
        System.out.print("Actual Declined Values : ");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ");
        }
        System.out.println();
        System.out.println("-  -  -");
        // Declined
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "time-to-close", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(1.9313652749007184, 1.9226184311985877, 1.9029834814225979, 1.9000443394644275, 1.9017673304773248, 1.9001841088365248, 1.869286892361111, 0.35249614197530865, 0.4050347222222222, 0.8055748456790124, 1.2952623456790122, 1.7812239583333334, 1.9008257618178208, 0.589849537037037, 1.5048726851851852, 1.6214655671296296, 1.9005177484094125, 1.909425940505208, 1.9049483606952915, 1.6116015625, 0.1820871913580247, 0.2260841049382716, 0.5342746913580247, 1.1141608796296296, 1.0040104166666666, 0.8481905864197531, 0.917716049382716, 0.6875771604938271, 0.8795833333333334, 0.3633101851851852, 0.30907021604938273);
        System.out.println();
        System.out.println("Expected Trend Values : " + expected2);
        System.out.print("Actual Trend Values : ");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");

    }

    @FindBy(xpath = "(//*[@id=\"pr-insights\"]//*[@role=\"alert\"])[1]")
    public WebElement codeProgressInsightsAlert1;

    @FindBy(xpath = "(//*[@id=\"pr-insights\"]//*[@role=\"alert\"])[2]")
    public WebElement codeProgressInsightsAlert2;

    @FindBy(xpath = "(//*[@id=\"pr-insights\"]//*[@role=\"alert\"])[3]")
    public WebElement codeProgressInsightsAlert3;

    @FindBy(xpath = "(//*[@id=\"pr-insights\"]//*[@role=\"alert\"])[4]")
    public WebElement codeProgressInsightsAlert4;

    public void checkCodeProgressInsights() {
        JSUtilities.scrollToElement(driver, codeProgressInsightsAlert4);
        Assert.assertEquals(TestDataBase.codeProgressInsightsAlert1, codeProgressInsightsAlert1.getText());
        Assert.assertEquals(TestDataBase.codeProgressInsightsAlert2, codeProgressInsightsAlert2.getText());
        Assert.assertEquals(TestDataBase.codeProgressInsightsAlert3, codeProgressInsightsAlert3.getText());
        Assert.assertEquals(TestDataBase.codeProgressInsightsAlert4, codeProgressInsightsAlert4.getText());
    }

    @FindBy(xpath = "//*[@id=\"time-to-resolve\"]")
    public WebElement timeToResolve;

    public void checkTimeToResolve() {
        JSUtilities.scrollToElement(driver, timeToResolve);
        ReusableMethods.wait(2);
        // Time to Resolve
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "time-to-resolve", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(62L, 19L, 40L, 93L);
        System.out.println();
        System.out.println("Expected Time to Resolve Values : " + expected);
        System.out.print("Actual Time to Resolve Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkTimeToFirstComment() {
        ReusableMethods.wait(2);
        // Time to First Comment
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "time-to-first-comment", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(64L, 11L, 7L, 30L);
        System.out.println();
        System.out.println("Expected Time to First Comment Values : " + expected);
        System.out.print("Actual Time to First Comment Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");

    }

    public void checkFollowOnCommits() {
        ReusableMethods.wait(2);
        // Follow on Commits
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "follow-on-commits", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(147L, 48L, 9L, 3L, 2L, 1L, 1L, 1L, 1L, 1L);
        System.out.println();
        System.out.println("Expected Follow on Commits Values : " + expected);
        System.out.print("Actual Follow on Commits Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");

    }

    public void checkReviewerComments() {
        JSUtilities.scrollToElement(driver, submitterCommitsPushed);
        ReusableMethods.wait(2);
        // Reviewer Comments
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "reviewer-comments", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(113L, 46L, 25L, 9L, 4L, 3L, 2L, 3L, 4L, 2L, 1L, 1L, 1L);
        System.out.println();
        System.out.println("Expected Reviewer Comments Values : " + expected);
        System.out.print("Actual Reviewer Comments Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");

    }

    public void checkReviewers() {
        ReusableMethods.wait(2);
        // Reviewers
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "reviewers", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(1L, 76L, 67L, 39L, 23L, 4L, 3L, 1L);
        System.out.println();
        System.out.println("Expected Reviewers Values : " + expected);
        System.out.print("Actual Reviewers Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");

    }

    public void checkAvgCommentsPerReviewer() {
        ReusableMethods.wait(2);
        // Avg.Comments Per Reviewer
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "avg-comments", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(113L, 5L, 11L, 24L, 1L, 5L, 2L, 30L, 1L, 2L, 1L, 2L, 1L, 1L, 1L, 1L, 1L, 5L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
        System.out.println();
        System.out.println("Expected Avg.Comments Per Reviewer Values : " + expected);
        System.out.print("Actual Avg.Comments Per Reviewer Values : ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    @FindBy(id = "submitter-commits-pushed")
    public WebElement submitterCommitsPushed;

    @FindBy(id = "submitter-comments-added")
    public WebElement submitterCommentsAdded;

    @FindBy(id = "responsiveness")
    public WebElement responsiveness;

    @FindBy(id = "comments-addressed")
    public WebElement commentsAddressed;

    @FindBy(id = "receptiveness")
    public WebElement receptiveness;

    @FindBy(id = "unreviewed-prs")
    public WebElement unreviewedPrs;

    public void checkSubmitterMetrics() {
        Assert.assertEquals(TestDataBase.commitsPushed, submitterCommitsPushed.getText());
        Assert.assertEquals(TestDataBase.commentsAdded, submitterCommentsAdded.getText());
        Assert.assertEquals(TestDataBase.responsiveness, responsiveness.getText());
        Assert.assertEquals(TestDataBase.commentsAddressed, commentsAddressed.getText());
        Assert.assertEquals(TestDataBase.receptiveness, receptiveness.getText());
        Assert.assertEquals(TestDataBase.unreviewedPRs, unreviewedPrs.getText());
    }

    @FindBy(id = "reviewer-comments-added")
    public WebElement reviewerCommentsAdded;

    @FindBy(id = "reaction-time")
    public WebElement reactionTime;

    @FindBy(id = "involvement")
    public WebElement involvement;

    @FindBy(id = "influence")
    public WebElement influence;

    public void checkReviewerMetrics() {
        JSUtilities.scrollToElement(driver, influence);
        Assert.assertEquals(TestDataBase.commentsAddedReviewerMetrics, reviewerCommentsAdded.getText());
        Assert.assertEquals(TestDataBase.reactionTimeReviewerMetrics, reactionTime.getText());
        Assert.assertEquals(TestDataBase.involvementReviewerMetrics, involvement.getText());
        Assert.assertEquals(TestDataBase.influenceReviewerMetrics, influence.getText());
    }

    @FindBy(id = "review-collaboration")
    public WebElement insightsReviewCollaborationTable;

    public void insightsSubmittersCheck() {
        List<WebElement> personElements = driver.findElements(By.xpath("//*[@id='review-collaboration']//*[@class='rc-list submitter']//*[@class='rc-person']"));
        List<String> expected = List.of("dependabot[bot]106", "Basil Crow58", "renovate[bot]53", "Jan Faracik46", "Jesse Glick29", "Daniel Beck28", "Markus Winter15", "Tim Jacomb10", "Alexander Brandes9", "James Nord8", "Bob Du7", "Stefan Spieker6", "Abhishek Kumar6", "krisstern6", "A. Regnander5", "Anh Duy5", "Anski15", "Allan Burdajewicz4", "Jakub Wojnarowicz4", "Minghao Li4", "Mustafa Ulu4", "jean pierre Lerbscher4", "Zongle Wang4", "Lutz Neugebauer4", "ALONUCLEAR4", "PierreSchwang4", "Vincent Latombe3", "Zbynek Konecny3", "growfrow3", "Valentin Delaye3", "purushotham993", "hypery2k3", "Mikel Ortega2", "Fredrik932", "jaimeavl2", "Marek Pastierik2");
        List<String> result = new ArrayList<>();
        for (WebElement personElement : personElements) {
            result.add(personElement.getText());
        }
        System.out.println("Expected Submitter Name : " + expected);
        System.out.print("Actual Submitter Name: ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------");
    }

    public void insightsReviewersCheck() {
        List<WebElement> personElements = driver.findElements(By.xpath("//*[@id='review-collaboration']//*[@class='rc-list reviewer']//*[@class='rc-person']"));
        List<String> expected = List.of("Alexander Brandes106", "Mark Waite102", "Basil Crow71", "Tim Jacomb53", "Stefan Spieker29", "Daniel Beck23", "welcome[bot]18", "Jesse Glick9", "Markus Winter9", "github-actions[bot]7", "Vincent Latombe7", "Jan Faracik4", "yaroslavafenkin3", "Kevin Martens2", "res0nance2", "Kevin Guerroudj2", "Ullrich Hafner2", "jdicke2", "Hervé Le Meur2", "Valentin Delaye2", "aneveux1", "mattiassluis1", "Robert Sandell1", "Wadeck1", "Adrien Lecharpentier1", "ghost1", "krisstern1", "comment-ops-bot[bot]1", "Zbynek Konecny1");
        List<String> result = new ArrayList<>();
        for (WebElement personElement : personElements) {
            result.add(personElement.getText());
        }
        System.out.println("Expected Reviewers Name : " + expected);
        System.out.print("Actual Reviewers Name: ");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------");
    }

    public void scrollToCollaborations() {
        List<WebElement> personElements = driver.findElements(By.cssSelector(".rc-person"));
        Actions actions = new Actions(driver);
        for (WebElement personElement : personElements) {
            actions.moveToElement(personElement).perform();
        }
    }

    public void checkReviewCollaboration() {
        ReusableMethods.wait(1);
        scrollToCollaborations();
        insightsSubmittersCheck();
        insightsReviewersCheck();
    }

    // DEV. BEHAVIORS
    public void checkChurn() {
        ReusableMethods.wait(5);
        // Churn value of the contributor
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "churn_by_developer", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(100L, 67L, 67L, 54L, 50L, 50L, 47L, 39L, 37L, 30L, 18L, 16L, 13L, 13L, 7L, 6L, 6L, 5L, 3L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);
        System.out.println();
        System.out.println("Expected Churn Contributor Values : " + expected);
        System.out.print("Actual Churn Contributor Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Churn company average
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "churn_by_developer", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L, 11L);
        System.out.println();
        System.out.println("Expected Churn Company Average Values : " + expected1);
        System.out.print("Actual Churn Company Average Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");

    }

    @FindBy(xpath = "(//*[@id=\"insights\"]//*[@class=\"alert alert-solid-warning\"])[1]")
    public WebElement insightDevBehaviorWarningAlert1;

    @FindBy(xpath = "(//*[@id=\"insights\"]//*[@class=\"alert alert-solid-warning\"])[2]")
    public WebElement insightDevBehaviorWarningAlert2;

    @FindBy(xpath = "//*[@id=\"insights\"]//*[@class=\"alert alert-solid-info\"]")
    public WebElement insightDevBehaviorInfoAlert;

    @FindBy(xpath = "(//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-warning\"])[1]")
    public WebElement insightContributorWarningAlert1;

    public void checkDevBehaviorsInsights() {
        Assert.assertTrue(insightDevBehaviorWarningAlert1.isDisplayed());
        Assert.assertTrue(insightDevBehaviorWarningAlert2.isDisplayed());
        Assert.assertTrue(insightDevBehaviorInfoAlert.isDisplayed());
    }

    @FindBy(xpath = "//*[@id=\"focus-new-work\"]//label")
    public WebElement newWorkPercent;

    @FindBy(xpath = "//*[@id=\"focus-legacy-refactor\"]//label")
    public WebElement legacyRefactorPercent;

    @FindBy(xpath = "//*[@id=\"focus-help-others\"]//label")
    public WebElement helpOthersPercent;

    @FindBy(xpath = "//*[@id=\"focus-churn\"]//label")
    public WebElement churnPercent;

    public void checkFocusByDaysIssues() {
        ReusableMethods.wait(3);
        Assert.assertEquals(TestDataBase.devBehaviorsNewWorkPercent, newWorkPercent.getText());
        Assert.assertEquals(TestDataBase.devBehaviorsLegacyRefactorPercent, legacyRefactorPercent.getText());
        Assert.assertEquals(TestDataBase.devBehaviorsHelpOthersPercent, helpOthersPercent.getText());
        Assert.assertEquals(TestDataBase.devBehaviorsChurnPercent, churnPercent.getText());
    }

    @FindBy(xpath = "//*[@data-layer=\"focus-by-days\"]")
    public WebElement focusByDaysTable;

    public void checkFocusByDaysGraph() {
        JSUtilities.scrollToElement(driver, focusByDaysTable);
        ReusableMethods.wait(5);
        // New Work
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "focus_by_days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(2.2, 0L, 95.2, 58.1, 97.6, 100L, 66.7, 99L, 90.8, 0L, 36.4, 61.5, 86L, 35.7, 74.9, 77L, 0L, 0L, 12.9, 1L, 27.1, 4.6, 9.1, 56.1, 30L, 0L, 33.4, 12.3, 45.6, 50L, 41.7, 5.6, 83.1, 43.6, 8.5, 77.6, 44.2, 7.4, 27.3, 17.6, 46.9, 93.1, 100L, 23.1, 0L, 0L, 6.5, 41.4, 36.4, 71.4, 0L, 96L, 2L, 30L);
        System.out.println();
        System.out.println("Expected New Work Values : " + expected);
        System.out.print("Actual New Work Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Legacy Refactor
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "focus_by_days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(62.4, 52.6, 1.6, 32.7, 2.4, 0L, 33.3, 1L, 3.5, 31.3, 18.2, 2.6, 12.1, 50L, 19.2, 21.8, 0L, 100L, 81.9, 96.3, 34.2, 21.6, 21.2, 34.1, 69.6, 33.3, 64.5, 87.7, 46.7, 43.8, 54.7, 93.1, 12.2, 23.8, 89.6, 4L, 31.3, 67.8, 45.5, 2L, 12.6, 3.4, 0L, 23.1, 20L, 100L, 90.3, 41.4, 54.5, 16.9, 97.3, 2L, 32.7, 70L);
        System.out.println();
        System.out.println("Expected Legacy Refactor Values : " + expected1);
        System.out.print("Actual Legacy Refactor Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Help Others
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "focus_by_days", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(35.5, 21.1, 1.6, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0.8, 0L, 0L, 0L, 9.1, 0.4, 0L, 66.7, 0L, 0L, 2.2, 0L, 0L, 0L, 0L, 32.2, 0L, 8.3, 0L, 1.6, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4.1, 0L);
        System.out.println();
        System.out.println("Expected Help Others Values : " + expected2);
        System.out.print("Actual Help Others Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Churn
        List<Long> result3 = (List<Long>) HighchartsUtils.getChartData(driver, "focus_by_days", 3, HighchartsUtils.DataType.Y);
        List<Number> expected3 = List.of(0L, 26.3, 1.6, 9.3, 0L, 0L, 0L, 0L, 5.7, 68.8, 45.5, 35.9, 1.9, 14.3, 6L, 1.2, 100L, 0L, 4.5, 2.7, 38.7, 73.8, 60.6, 9.3, 0.4, 0L, 2.1, 0L, 5.5, 6.3, 3.6, 1.4, 4.7, 0.5, 1.9, 10.2, 24.5, 23.3, 27.3, 80.4, 40.6, 3.4, 0L, 53.8, 80L, 0L, 3.2, 17.2, 9.1, 11.7, 2.7, 2L, 61.2, 0L);
        System.out.println();
        System.out.println("Expected Churn Values : " + expected3);
        System.out.print("Actual Churn Values :   [");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected3.get(i), result3.get(i));
            System.out.print(result3.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checksFocusByDays() {
        checkFocusByDaysIssues();
        checkFocusByDaysGraph();
    }

    @FindBy(xpath = "//*[@id=\"monthly-average-commits\"]//label")
    public WebElement monthlyAverageCommitsIssue;

    @FindBy(xpath = "//*[@id=\"daily-average-commits\"]//label")
    public WebElement dailyAverageCommitsIssue;

    @FindBy(xpath = "//*[@id=\"most-frequent-push-times\"]//label")
    public WebElement mostFrequentPushTimesIssue;

    public void checkRegularCommitIssues() {
        Assert.assertEquals(TestDataBase.devBehaviorsMonthlyAverageCommits, monthlyAverageCommitsIssue.getText());
        Assert.assertEquals(TestDataBase.devBehaviorsDailyAverageCommits, dailyAverageCommitsIssue.getText());
        Assert.assertEquals(TestDataBase.devBehaviorsMostFrequentPushTimes, mostFrequentPushTimesIssue.getText());
    }

    @FindBy(xpath = "//*[@data-layer=\"commits-by-days\"]")
    public WebElement regularCommitsTable;

    public void checkRegularCommitGraph() {
        JSUtilities.scrollToElement(driver, regularCommitsTable);
        ReusableMethods.wait(5);
        // Daily Total Commit Count
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "regular_commits_by_days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(4L, 15L, 5L, 5L, 9L, 5L, 3L, 7L, 7L, 12L, 7L, 7L, 8L, 8L, 3L, 1L, 1L, 15L, 15L, 2L, 5L, 22L, 12L, 15L, 15L, 10L, 19L, 12L, 14L, 8L, 2L, 10L, 17L, 14L, 14L, 10L, 12L, 15L, 18L, 19L, 16L, 18L, 4L, 17L, 15L, 12L, 3L, 3L, 3L, 6L, 2L, 2L, 4L, 7L, 15L, 9L, 11L, 5L, 5L, 13L, 10L);
        System.out.println();
        System.out.println("Expected Daily Total Commit Count Values : " + expected);
        System.out.print("Actual Daily Total Commit Count Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Daily Average Commit Count
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "regular_commits_by_days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(1.33, 3L, 1L, 1.25, 1.13, 1.67, 1.5, 1.4, 1.4, 2.4, 3.5, 2.33, 2.67, 2L, 1.5, 1L, 1L, 2.5, 3L, 1L, 1.67, 4.4, 2L, 3L, 2.5, 1.67, 2.38, 3L, 2.8, 2L, 2L, 2L, 2.83, 2.33, 1.56, 1.67, 3L, 3L, 2.57, 2.38, 3.2, 4.5, 1.33, 5.67, 2.14, 3L, 1.5, 1.5, 1L, 3L, 1L, 2L, 1.33, 1.4, 5L, 1L, 1.83, 1.25, 1L, 2.17, 3.33);
        System.out.println();
        System.out.println("Expected Daily Average Commit Count Values : " + expected1);
        System.out.print("Actual Daily Average Commit Count Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkRegularCommitByDays() {
        checkRegularCommitIssues();
        checkRegularCommitGraph();
    }

    @FindBy(id = "activity-log")
    public WebElement activityLogTable;

    @FindBy(xpath = "(//*[@class=\"ac-row\"])[1]")
    public WebElement janFaracik;

    @FindBy(xpath = "(//*[@class=\"ac-row\"])[192]")
    public WebElement aRegnander;

    @FindBy(xpath = "(//*[@class=\"ac-row\"])[80]")
    public WebElement bobDu;

    @FindBy(xpath = "(//*[@class=\"ac-row\"])[98]")
    public WebElement allanBurdajewicz;

    @FindBy(xpath = "(//*[@class=\"ac-row\"])[187]")
    public WebElement mikelOrtega;

    public void checkActivityLogJanFaracik() {
        List<WebElement> divElements = driver.findElements(By.xpath("(//*[@class=\"ac-row\"])[1]//div[@data-id]"));
        List<Integer> expected = new ArrayList<>(Arrays.asList(187498, 186896, 187341, 187308, 187310, 187303, 187344, 187306, 187561, 187564, 187560, 187695, 187694, 187696, 186763, 187563, 186769, 187562, 187773, 187774, 187742, 186770, 187740, 187741, 187743, 187746, 187744, 187440, 187448, 187457, 187747, 187748, 186791, 186793, 187449, 187438, 187771, 187775, 187772, 187462, 187451, 187461, 187459, 187460, 187467, 187442, 187445, 187447, 187452, 187373, 187411, 187446, 187469, 187466, 187454, 187453, 187794, 187795, 187636, 186603, 187634, 187640, 187637, 187641, 187635, 186612, 187374, 187409, 187474, 187475, 187638, 187380, 186639, 187629, 187627, 187455, 264230, 263433, 263891, 267106, 263518, 263523, 263527, 263719, 263721, 263524, 263788, 263718, 263750, 263751, 263753, 263754, 263760, 263762, 263763, 263752, 263787, 263499, 263497));
        List<Integer> result = new ArrayList<>();
        for (WebElement div : divElements) {
            String dataIdStr = div.getAttribute("data-id");
            int dataId = Integer.parseInt(dataIdStr);
            result.add(dataId);
        }
        System.out.println("Expected Jan Faracik Data-Id: " + expected);
        System.out.print("Actual Jan Faracik Data-Id:   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkActivityLogARegnander() {
        JSUtilities.scrollToElement(driver, aRegnander);
        List<WebElement> divElements = driver.findElements(By.xpath("(//*[@class=\"ac-row\"])[192]//div[@data-id]"));
        List<Integer> expected = new ArrayList<>(Arrays.asList(187709, 187711, 187721, 187723, 187702, 187715, 187712, 187700, 187704, 187706, 187716, 187724, 187705, 186783, 263728, 263730, 263726, 263732));
        List<Integer> result = new ArrayList<>();
        for (WebElement div : divElements) {
            String dataIdStr = div.getAttribute("data-id");
            int dataId = Integer.parseInt(dataIdStr);
            result.add(dataId);
        }
        System.out.println("Expected A. Regnander Data-Id: " + expected);
        System.out.print("Actual A. Regnander Data-Id:   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkActivityLogBobDu() {
        JSUtilities.scrollToElement(driver, bobDu);
        List<WebElement> divElements = driver.findElements(By.xpath("(//*[@class=\"ac-row\"])[80]//div[@data-id]"));
        List<Integer> expected = new ArrayList<>(Arrays.asList(187757, 187749, 187758, 187761, 187759, 187760, 187750, 187751, 187752, 187753, 187754, 187755, 187756, 186732, 187796, 186618, 263613, 263776, 263769, 263778, 263772, 263782, 263780, 263805));
        List<Integer> result = new ArrayList<>();
        for (WebElement div : divElements) {
            String dataIdStr = div.getAttribute("data-id");
            int dataId = Integer.parseInt(dataIdStr);
            result.add(dataId);
        }
        System.out.println("Expected Bob Du Data-Id: " + expected);
        System.out.print("Actual Bob Du Data-Id:   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkActivityLogAllanBurdajewicz() {
        JSUtilities.scrollToElement(driver, allanBurdajewicz);
        List<WebElement> divElements = driver.findElements(By.xpath("(//*[@class=\"ac-row\"])[98]//div[@data-id]"));
        List<Integer> expected = new ArrayList<>(Arrays.asList(187779, 187780, 187781, 186605, 187623, 81146, 79817, 81009, 81354, 81356, 82924, 82925, 81525, 82928, 81510));
        List<Integer> result = new ArrayList<>();
        for (WebElement div : divElements) {
            String dataIdStr = div.getAttribute("data-id");
            int dataId = Integer.parseInt(dataIdStr);
            result.add(dataId);
        }
        System.out.println("Expected Allan Burdajewicz Data-Id: " + expected);
        System.out.print("Actual Allan Burdajewicz Data-Id:   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkActivityLogMikelOrtega() {
        JSUtilities.scrollToElement(driver, mikelOrtega);
        List<WebElement> divElements = driver.findElements(By.xpath("(//*[@class=\"ac-row\"])[187]//div[@data-id]"));
        List<Integer> expected = new ArrayList<>(Arrays.asList(186862));
        List<Integer> result = new ArrayList<>();
        for (WebElement div : divElements) {
            String dataIdStr = div.getAttribute("data-id");
            int dataId = Integer.parseInt(dataIdStr);
            result.add(dataId);
        }
        System.out.println("Expected Mikel Ortega Data-Id: " + expected);
        System.out.print("Actual Mikel Ortega Data-Id:   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkActivityLog() {
        JSUtilities.scrollToElement(driver, activityLogTable);
        ReusableMethods.wait(2);
        checkActivityLogJanFaracik();
        checkActivityLogARegnander();
        checkActivityLogBobDu();
        checkActivityLogAllanBurdajewicz();
        checkActivityLogMikelOrtega();
    }

    @FindBy(xpath = "//*[text()='There is no data']")
    public WebElement thereIsNoDataText;

    @FindBy(xpath = "//*[@data-layer=\"worklogs\"]")
    public WebElement worklogsTable;

    public void checkWorklogs() {
        JSUtilities.scrollToElement(driver, worklogsTable);
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.thereIsNoData, thereIsNoDataText.getText());

    }

    // PROJECT HEALTH

    @FindBy(xpath = "//*[@id=\"commit-risk-total\"]//label")
    public WebElement projectHealthTotalCount;

    @FindBy(xpath = "//*[@id=\"commit-risk-low\"]//label")
    public WebElement projectHealthLowRisk;

    @FindBy(xpath = "//*[@id=\"commit-risk-medium\"]//label")
    public WebElement projectHealthMediumRisk;

    @FindBy(xpath = "//*[@id=\"commit-risk-high\"]//label")
    public WebElement projectHealthHighRisk;

    public void checkCommitRiskIssues() {
        ReusableMethods.wait(5);
        Assert.assertEquals(TestDataBase.projectHealthTotalCount, projectHealthTotalCount.getText());
        Assert.assertEquals(TestDataBase.projectHealthLowRisk, projectHealthLowRisk.getText());
        Assert.assertEquals(TestDataBase.projectHealthMediumRisk, projectHealthMediumRisk.getText());
        Assert.assertEquals(TestDataBase.projectHealthHighRisk, projectHealthHighRisk.getText());
    }

    public void checkCommitRiskBreakdownGraph() {
        ReusableMethods.wait(2);
        // Low Risk
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-chart", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(100L, 93.3, 100L, 100L, 77.8, 100L, 100L, 85.7, 100L, 75L, 85.7, 100L, 87.5, 87.5, 100L, 100L, 100L, 93.3, 93.3, 100L, 100L, 95.5, 91.7, 93.3, 86.7, 100L, 89.5, 91.7, 100L, 100L, 100L, 90L, 94.1, 100L, 85.7, 100L, 91.7, 100L, 88.9, 73.7, 100L, 100L, 100L, 94.1, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 71.4, 100L, 100L, 90.9, 100L, 100L, 76.9, 100L);
        System.out.println();
        System.out.println("Expected Low Risk Values : " + expected);
        System.out.print("Actual Low Risk Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Medium Risk
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-chart", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L, 0L, 0L, 0L, 11.1, 0L, 0L, 14.3, 0L, 8.3, 14.3, 0L, 12.5, 12.5, 0L, 0L, 0L, 6.7, 6.7, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 5.3, 0L, 0L, 0L, 0L, 0L, 5.9, 0L, 7.1, 0L, 0L, 0L, 5.6, 15.8, 0L, 0L, 0L, 5.9, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 28.6, 0L, 0L, 9.1, 0L, 0L, 23.1, 0L);
        System.out.println();
        System.out.println("Expected Medium Risk Values : " + expected1);
        System.out.print("Actual Medium Risk Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // High Risk
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "commit-risk-chart", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(0L, 6.7, 0L, 0L, 11.1, 0L, 0L, 0L, 0L, 16.7, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4.5, 8.3, 6.7, 13.3, 0L, 5.3, 8.3, 0L, 0L, 0L, 10L, 0L, 0L, 7.1, 0L, 8.3, 0L, 5.6, 10.5, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);
        System.out.println();
        System.out.println("Expected High Risk Values : " + expected2);
        System.out.print("Actual High Risk Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }

    public void checkCommitRiskBreakdownByDays() {
        checkCommitRiskIssues();
        checkCommitRiskBreakdownGraph();

    }

    @FindBy(xpath = "//*[@id=\"insights\"]//*[@class=\"alert alert-solid-warning\"]")
    public WebElement projectInsightsWarningAlert;

    @FindBy(xpath = "//*[@id=\"insights\"]//*[@class=\"alert alert-solid-danger\"]")
    public WebElement projectInsightsDangerAlert;

    @FindBy(xpath = "//*[@id=\"insights\"]//*[@class=\"alert alert-solid-info\"]")
    public WebElement projectInsightsInfoAlert;

    public void checkProjectInsights() {
        Assert.assertEquals(TestDataBase.projectHealthInsightsWarningAlert, projectInsightsWarningAlert.getText());
        Assert.assertEquals(TestDataBase.projectHealthInsightsDangerAlert, projectInsightsDangerAlert.getText());
        Assert.assertEquals(TestDataBase.projectHealthInsightsInfoAlert, projectInsightsInfoAlert.getText());
    }

    @FindBy(id = "proficiency-by-days")
    public WebElement churnRateLanguagesTable;

    public void checkChurnRateByLanguages() {
        JSUtilities.scrollToElement(driver, churnRateLanguagesTable);
        ReusableMethods.wait(2);
        // Go
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(0L, 50L, 100L, 0L, 100L);
        System.out.println();
        System.out.println("Expected Go Values : " + expected);
        System.out.print("Actual Go Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Java
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(0L, 0L, 1.5999999999999943, 10.099999999999994, 0L, 0L, 0L, 0L, 9.599999999999994, 0L, 7.400000000000006, 1.2000000000000028, 100L, 0L, 4.700000000000003, 96L, 20L, 7.400000000000006, 70.4, 9.5, 0.4000000000000057, 0L, 2.0999999999999943, 0L, 4.400000000000006, 3.200000000000003, 4.400000000000006, 0L, 10L, 1.2999999999999972, 1.9000000000000057, 0L, 11.299999999999997, 5.900000000000006, 27.299999999999997, 0L, 35.2, 3.700000000000003, 53.8, 100L, 0L, 0L, 2.700000000000003, 2.4000000000000057, 32.099999999999994, 0L);
        System.out.println();
        System.out.println("Expected Java Values : " + expected1);
        System.out.print("Actual Java Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");

        // Other
        List<ArrayList> result2 = (List<ArrayList>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = Arrays.asList(100L, 0L, 0L, 0L, 1.5999999999999943, 0L, 100L, 10L, 0L, 0L, 1.7999999999999972, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 15.200000000000003, 0L, 0L, 0L, 100L, 100L);
        System.out.println();
        System.out.println("Expected Other Values : " + expected2);
        System.out.print("Actual Other Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // JavaScript
        List<ArrayList> result3 = (List<ArrayList>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 3, HighchartsUtils.DataType.Y);
        List<Number> expected3 = Arrays.asList(null, 100L, 1.4000000000000057, 0L, 0L, null, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 25L, 3.9000000000000057, 92L, 76.4, 53.1, 0L, 0L, 2.200000000000003, 0L, 0L, 100L
        );
        System.out.println();
        System.out.println("Expected JavaScript Values : " + expected3);
        System.out.print("Actual JavaScript Values :   [");
        for (int i = 0; i < result3.size(); i++) {
            Assert.assertEquals(expected3.get(i), result3.get(i));
            System.out.print(result3.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // XML
        List<Long> result4 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 4, HighchartsUtils.DataType.Y);
        List<Number> expected4 = List.of(0L, 2.0999999999999943, 0L, 100L, 50L);
        System.out.println();
        System.out.println("Expected XML Values : " + expected4);
        System.out.print("Actual XML Values :   [");
        for (int i = 0; i < result4.size(); i++) {
            Assert.assertEquals(expected4.get(i), result4.get(i));
            System.out.print(result4.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // HTML
        List<Long> result5 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 5, HighchartsUtils.DataType.Y);
        List<Number> expected5 = List.of(7.400000000000006, 27.299999999999997, 0L, 25L, 69.4, 84.6, 0L);
        System.out.println();
        System.out.println("Expected HTML Values : " + expected5);
        System.out.print("Actual HTML Values :   [");
        for (int i = 0; i < result5.size(); i++) {
            Assert.assertEquals(expected5.get(i), result5.get(i));
            System.out.print(result5.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // YAML
        List<Long> result6 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 6, HighchartsUtils.DataType.Y);
        List<Number> expected6 = List.of(100L, 66.7, 100L, 100L, 50L, 50L, 0L, 100L);
        System.out.println();
        System.out.println("Expected YAML Values : " + expected6);
        System.out.print("Actual YAML Values :   [");
        for (int i = 0; i < result6.size(); i++) {
            Assert.assertEquals(expected6.get(i), result6.get(i));
            System.out.print(result6.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // CSS
        List<Long> result7 = (List<Long>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 7, HighchartsUtils.DataType.Y);
        List<Number> expected7 = List.of(0L, 0L, 0L, 7.099999999999994, 10.299999999999997, 6.200000000000003, 31L, 44.4, 11.799999999999997, 1.4000000000000057, 15.599999999999994, 5.900000000000006, 87.7, 90.5, 18.5, 0L, 15L, 0L, 100L);
        System.out.println();
        System.out.println("Expected CSS Values : " + expected7);
        System.out.print("Actual CSS Values :   [");
        for (int i = 0; i < result7.size(); i++) {
            Assert.assertEquals(expected7.get(i), result7.get(i));
            System.out.print(result7.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Company Average
        List<ArrayList> result8 = (List<ArrayList>) HighchartsUtils.getChartData(driver, "proficiency-by-days", 8, HighchartsUtils.DataType.Y);
        List<Number> expected8 = Arrays.asList(0L, 50L, 0.8, null, 0L, 0L, 0L, 0L, 29.7, 83.3, 50L, 42.4, 33.8, 17.5, 1.9, 1.1, 100L, 0L, null, 48.9, 29.8, 38.4, 56.8, 4.7, null, 0L, 2.1, 0L, 3.8, null, 4.9, 2.1, 10.3, 15.2, 9.7, 11.8, 39.6, 29.4, 27.3, 35.2, 45.1, 1.9, 0L, 53.8, 75L, 0L, 51.1, 9.3, 33.3, 5L, 2.7, 0.8, 83L, 0L
        );
        System.out.println();
        System.out.println("Expected Company Average Values : " + expected8);
        System.out.print("Actual Company Average Values :   [");
        for (int i = 0; i < result8.size(); i++) {
            Assert.assertEquals(expected8.get(i), result8.get(i));
            System.out.print(result8.get(i) + " ,");
        }
        System.out.println();
        System.out.println("--------------------------------------------");
    }

    @FindBy(xpath = "(//*[@data-layer=\"time-in-state\"]//label)[1]")
    public WebElement timeInStateOpenTime;

    @FindBy(xpath = "(//*[@data-layer=\"time-in-state\"]//label)[2]")
    public WebElement timeInStateInProgressTime;

    public void checkTimeInState() {
        Assert.assertEquals(TestDataBase.projectHealthTimeInStateOpenTime, timeInStateOpenTime.getText());
        Assert.assertEquals(TestDataBase.projectHealthTimeInStateInProgressTime, timeInStateInProgressTime.getText());
    }

    @FindBy(xpath = "//*[@id=\"bug-priority-critical\"]//label")
    public WebElement criticalBugPriority;

    @FindBy(xpath = "//*[@id=\"bug-priority-important\"]//label")
    public WebElement importantBugPriority;

    @FindBy(xpath = "//*[@id=\"bug-priority-normal\"]//label")
    public WebElement normalBugPriority;

    @FindBy(xpath = "//*[@id=\"bug-priority-low\"]//label")
    public WebElement lowBugPriority;

    public void checkBugPriority() {
        Assert.assertEquals(TestDataBase.projectHealthCriticalBugs, criticalBugPriority.getText());
        Assert.assertEquals(TestDataBase.projectHealthImportantBugs, importantBugPriority.getText());
        Assert.assertEquals(TestDataBase.projectHealthNormalBugs, normalBugPriority.getText());
        Assert.assertEquals(TestDataBase.projectHealthLowBugs, lowBugPriority.getText());
    }

    @FindBy(xpath = "//*[@id=\"bug-count-total\"]//label")
    public WebElement totalBugCount;

    @FindBy(xpath = "//*[@id=\"bug-count-newly\"]//label")
    public WebElement newlyOpenedBugs;

    @FindBy(xpath = "//*[@id=\"bug-count-closed\"]//label")
    public WebElement closedBugs;

    @FindBy(id = "bug-count-chart")
    public WebElement bugCountTable;

    public void checkBugCount() {
        JSUtilities.scrollToElement(driver, bugCountTable);
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.projectHealthTotalBugCount, totalBugCount.getText());
        Assert.assertEquals(TestDataBase.projectHealthNewlyOpenedBugs, newlyOpenedBugs.getText());
        Assert.assertEquals(TestDataBase.projectHealthClosedBugs, closedBugs.getText());
        // Closed
        List<Long> result = (List<Long>) HighchartsUtils.getChartData(driver, "bug-count-chart", 0, HighchartsUtils.DataType.Y);
        List<Number> expected = List.of(2L, 0L, 0L, 5L, 4L, 5L, 6L, 2L, 4L, 0L, 4L, 7L, 1L, 2L, 4L, 10L, 0L, 0L, 7L, 0L, 2L, 3L, 4L, 0L, 2L, 6L, 3L, 4L, 4L, 2L, 0L, 1L, 2L, 5L, 2L, 0L, 3L, 0L, 0L, 3L, 3L, 1L, 1L, 0L, 2L, 7L, 4L, 0L, 0L, 2L, 1L, 0L, 4L, 6L, 1L, 3L, 1L, 0L, 0L, 2L, 3L);
        System.out.println();
        System.out.println("Expected Closed Bugs Values : " + expected);
        System.out.print("Actual Closed Bugs Values :   [");
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
            System.out.print(result.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // New
        List<Long> result1 = (List<Long>) HighchartsUtils.getChartData(driver, "bug-count-chart", 1, HighchartsUtils.DataType.Y);
        List<Number> expected1 = List.of(3L, 0L, 1L, 5L, 7L, 7L, 7L, 5L, 1L, 0L, 8L, 2L, 5L, 4L, 7L, 3L, 0L, 1L, 6L, 2L, 7L, 4L, 0L, 2L, 6L, 8L, 3L, 2L, 0L, 1L, 1L, 2L, 4L, 4L, 5L, 4L, 2L, 0L, 2L, 4L, 1L, 4L, 4L, 1L, 2L, 2L, 7L, 8L, 4L, 5L, 1L, 0L, 3L, 3L, 4L, 1L, 3L, 0L, 2L, 4L, 1L);
        System.out.println();
        System.out.println("Expected New Opened Bugs Values : " + expected1);
        System.out.print("Actual New Opened Bugs Values :   [");
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(expected1.get(i), result1.get(i));
            System.out.print(result1.get(i) + " ,");
        }
        System.out.println();
        System.out.println("- - - - -");
        // Total
        List<Long> result2 = (List<Long>) HighchartsUtils.getChartData(driver, "bug-count-chart", 2, HighchartsUtils.DataType.Y);
        List<Number> expected2 = List.of(522L, 523L, 523L, 524L, 524L, 527L, 529L, 530L, 533L, 530L, 530L, 534L, 529L, 533L, 535L, 538L, 531L, 531L, 532L, 531L, 533L, 538L, 539L, 535L, 537L, 541L, 543L, 543L, 541L, 537L, 536L, 537L, 538L, 540L, 539L, 542L, 546L, 545L, 545L, 547L, 548L, 546L, 549L, 552L, 553L, 553L, 548L, 551L, 559L, 563L, 566L, 566L, 566L, 565L, 562L, 565L, 563L, 565L, 565L, 567L, 569L);
        System.out.println();
        System.out.println("Expected Total Bug Counts Values : " + expected2);
        System.out.print("Actual Total Bug Counts Values :   [");
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(expected2.get(i), result2.get(i));
            System.out.print(result2.get(i) + " ,");
        }
        System.out.println();
        System.out.println("-------------------------------");


    }

    // ACTIVITIES
    @FindBy(xpath = "//*[@id=\"commits-chart_info\"]")
    public WebElement showingEntries;

    @FindBy(id = "commits-chart_next")
    public WebElement activitiesNextButton;

    @FindBy(xpath = "//*[@class=\"s-icon left-arrow\"]")
    public WebElement activitiesBackButton;

    @FindBy(xpath = "//*[@class=\"chart-developer\"]")
    public WebElement activitiesCommitAuthor;

    @FindBy(xpath = "//*[@role=\"alert\"]")
    public WebElement activitiesCommitRisk;

    @FindBy(xpath = "//*[@class=\"col-lg-10 p-0 tx-12 d-flex align-items-center hash\"]")
    public WebElement activitiesCommitHash;

    @FindBy(xpath = "//*[@class=\"tx-black tx-normal commit-date\"]")
    public WebElement activitiesCommitDate;

    public void checkTotalEntries() {
        ReusableMethods.wait(3);
        Assert.assertEquals(TestDataBase.activitiesTotalEntries, showingEntries.getText());
    }

    @FindBy(id = "186649")
    public WebElement id186649;

    @FindBy(id = "187153")
    public WebElement id187153;

    @FindBy(id = "187627")
    public WebElement id187627;

    public void checkActivities186649() {
        id186649.click();
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.activities186649Author, activitiesCommitAuthor.getText());
        Assert.assertEquals(TestDataBase.activities186649Risk, activitiesCommitRisk.getText());
        Assert.assertEquals(TestDataBase.activities186649Hash, activitiesCommitHash.getText());
        Assert.assertEquals(TestDataBase.activities186649CommitDate, activitiesCommitDate.getText());
        driver.navigate().back();
        ReusableMethods.wait(2);
        activitiesNextButton.click();
    }

    public void checkActivities187153() {
        ReusableMethods.wait(2);
        id187153.click();
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.activities187153Author, activitiesCommitAuthor.getText());
        Assert.assertEquals(TestDataBase.activities187153Risk, activitiesCommitRisk.getText());
        Assert.assertEquals(TestDataBase.activities187153Hash, activitiesCommitHash.getText());
        Assert.assertEquals(TestDataBase.activities187153CommitDate, activitiesCommitDate.getText());
        driver.navigate().back();
        ReusableMethods.wait(2);
        activitiesNextButton.click();
        ReusableMethods.wait(2);
        activitiesNextButton.click();
    }

    public void checkActivities187627() {
        ReusableMethods.wait(2);
        id187627.click();
        ReusableMethods.wait(2);
        Assert.assertEquals(TestDataBase.activities187627Author, activitiesCommitAuthor.getText());
        Assert.assertEquals(TestDataBase.activities187627Risk, activitiesCommitRisk.getText());
        Assert.assertEquals(TestDataBase.activities187627Hash, activitiesCommitHash.getText());
        Assert.assertEquals(TestDataBase.activities187627CommitDate, activitiesCommitDate.getText());
    }

    public void checkActivitiesCommits() {
        checkTotalEntries();
        checkActivities186649();
        checkActivities187153();
        checkActivities187627();

    }

    @FindBy(id = "select2-project_filter-container")
    public WebElement projectFilterInsights;

    @FindBy(xpath = "//li[text()='Issue Link Insight Test with Git/Issue Repo']")
    public WebElement withGitAndIssueRepoProject;

    @FindBy(xpath = "//li[text()='Issue Link Insight Test with Git without Issue Repo']")
    public WebElement withGitAndWithoutIssueRepoProject;

    @FindBy(id = "97303")
    public WebElement vOdemirContributorWithGitAndIssueRepo;

    @FindBy(id = "97005")
    public WebElement vOdemirContributorWithGitAndWithoutIssueRepo;

    public void chooseProjectWithGitAndIssueRepo(){
        projectFilterInsights.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForElementToBeClickableNew(driver,withGitAndIssueRepoProject);
        withGitAndIssueRepoProject.click();
        ReusableMethods.wait(1);
    }

    public void chooseProjectWithGitAndWithoutIssueRepo(){
        projectFilterInsights.click();
        ReusableMethods.wait(1);
        withGitAndWithoutIssueRepoProject.click();
        ReusableMethods.wait(1);
    }

    public void controlIssueLinkWithGitAndIssueRepo(){
        devBehaviorsMenu.click();
        ReusableMethods.wait(2);
        dashboardPage.dateBox.click();
        ReusableMethods.wait(1);
        dashboardPage.last6MonthsText.click();
        ReusableMethods.wait(1);
        dashboardPage.applyChangesText.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(insightDevBehaviorWarningAlert1.getText().contains("of the commits are pushed without issue codes."));
        System.out.println("Project With Git and Issue Repo : Dev. Behaviors Insights -->"+insightDevBehaviorWarningAlert1.getText());
    }

    public void controlIssueLinkWithGitWithoutIssueRepo(){
        devBehaviorsMenu.click();
        ReusableMethods.wait(2);
        dashboardPage.dateBox.click();
        ReusableMethods.wait(1);
        dashboardPage.last6MonthsText.click();
        ReusableMethods.wait(1);
        dashboardPage.applyChangesText.click();
        ReusableMethods.wait(2);
        System.out.println("Project With Git and Without Issue Repo : Dev. Behaviors Insights -->"+insightDevBehaviorWarningAlert1.getText());
        Assert.assertFalse(insightDevBehaviorWarningAlert1.getText().contains("of the commits are pushed without issue codes."));
    }

    public void chooseContributorWithGitAndIssueRepo(){
        projectFilterInsights.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForElementToBeClickableNew(driver,withGitAndIssueRepoProject);
        withGitAndIssueRepoProject.click();
        ReusableMethods.wait(1);
        vOdemirContributorWithGitAndIssueRepo.click();
        ReusableMethods.waitForVisibilityNew(driver,insightContributorWarningAlert1);
    }

    public void controlContributorWithGitAndIssueRepo(){
        dashboardPage.dateBox.click();
        ReusableMethods.wait(1);
        dashboardPage.last6MonthsText.click();
        ReusableMethods.wait(1);
        dashboardPage.applyChangesText.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(insightContributorWarningAlert1.getText().contains("Commits are made without a reference to issue"));
        System.out.println("Project With Git and Issue Repo : Contributor Insights -->"+insightContributorWarningAlert1.getText());
    }

    public void chooseContributorWithGitAndWithoutIssueRepo(){
        dashboardPage.dateBox.click();
        ReusableMethods.wait(1);
        dashboardPage.last6MonthsText.click();
        ReusableMethods.wait(1);
        dashboardPage.applyChangesText.click();
        ReusableMethods.wait(2);
        ReusableMethods.waitForElementToBeClickableNew(driver,vOdemirContributorWithGitAndWithoutIssueRepo);
        vOdemirContributorWithGitAndWithoutIssueRepo.click();

    }

    @FindBy(xpath = "//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-danger\"]")
    public WebElement insightContributorDangerAlert1;

    public void controlContributorWithGitAndWithoutIssueRepo(){

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"developer_insights\"]//*[@class=\"alert alert-solid-danger\"]"));
        Assert.assertTrue(elements.isEmpty());


    }

}
