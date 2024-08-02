package pages.Dashboard;

import com.github.javafaker.Faker;
import log.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;



public class AtlasPage extends BasePage {
    public AtlasPage(WebDriver driver) {

        super(driver);
    }

    Faker faker=new Faker();

    @FindBy(xpath = "//*[@type=\"email\"]")
    public WebElement mailBox;

    @FindBy(xpath = "//*[@type=\"password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//form[@id]//button")
    public WebElement signInText;

    @FindBy(xpath = "//*[@class=\"main-logo mobile-logo active\"]")
    public WebElement atlasLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Dashboard\"]")
    public WebElement dashboardLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Insights\"]")
    public WebElement insightsLogo;

    @FindBy(xpath = "//*[@data-original-title=\"DORA\"]")
    public WebElement doraLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Resource Distribution\"]")
    public WebElement resourceDistributionLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Sprint\"]")
    public WebElement sprintLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Contributors\"]")
    public WebElement contributorsLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Projects\"]")
    public WebElement projectsLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Automations\"]")
    public WebElement automationsLogo;

    @FindBy(xpath = "//*[@data-original-title=\"Connected Applications\"]")
    public WebElement connectedApplicationsLogo;

    @FindBy(xpath = "//*[@class=\"avatar\"]")
    public WebElement avatar;

    @FindBy(xpath = "(//*[@class=\"dropdown-item\"])[1]")
    public WebElement demoMode;

    @FindBy(xpath = "(//*[@class=\"dropdown-item\"])[2]")
    public WebElement settings;

    @FindBy(xpath = "(//*[@class=\"dropdown-item\"])[3]")
    public WebElement userManagement;

    @FindBy(id = "logout-form")
    public WebElement logOut;

    @FindBy(xpath = "//*[@class=\"breadcrumb-question-icon\"]")
    public WebElement helpFeedbackQuestionMarkButton;

    @FindBy(id = "companies")
    public WebElement avatarCompanies;

    @FindBy(xpath = "//*[@id=\"companies\"]//*[@value=12752]")
    public WebElement vTestCompany;

    @FindBy(xpath = "//*[@id=\"companies\"]//*[@value=33355]")
    public WebElement bahceCompany;

    @FindBy(xpath = "//*[@id=\"companies\"]//*[@value=1280]")
    public WebElement omerCompany;

    public void loginN2() {
        loadHomePageN2();
        mailBox.sendKeys(TestDataBase.valvenEmailTester01);
        passwordBox.sendKeys(TestDataBase.valvenPassword);
        signInText.click();
    }

    public void selectDemoMode(){
        avatar.click();
        ReusableMethods.wait(3);
        demoMode.click();
        ReusableMethods.wait(3);
    }

    public void loadHomePageN2() {

        driver.get(TestDataBase.valvenUrlN2);
    }

    public void loadHomePageN3() {

        driver.get(TestDataBase.valvenUrlN3);
    }

    public void loginUserDataAccessTestN3() {
        loadHomePageN3();
        mailBox.sendKeys(TestDataBase.valvenEmailDataAccessTestN3);
        passwordBox.sendKeys(TestDataBase.valvenPassword);
        signInText.click();
    }

    @FindBy(xpath = "//*[@class=\"btn btn-outline-primary btn-with-icon\"]")
    public WebElement addAtlasUserButton;

    public void goToUserManagement(){
        ReusableMethods.waitForVisibilityNew(driver,avatar);
        avatar.click();
        ReusableMethods.waitForVisibilityNew(driver,userManagement);
        userManagement.click();
        ReusableMethods.waitForVisibilityNew(driver,addAtlasUserButton);
    }

    @FindBy(xpath = "//*[@selected=\"selected\"]")
    public WebElement selectedCompany;

    public void loginWithCompanyAndGoToPage(String company,String page) {
        ReusableMethods.waitForElementToBeClickableNew(driver, avatar);
        avatar.click();
        ReusableMethods.waitForVisibilityNew(driver,avatarCompanies);
        avatarCompanies.click();
        ReusableMethods.wait(1);
        if (selectedCompany.getText().equals(company)){
            System.out.println("Seçili Company : "+selectedCompany.getText());
            Logger.info("The company has already been selected.");
            avatar.click();
        }
        else { switch (company) {
            case "Bahce":
                bahceCompany.click();
                break;

            case "V-Test":
                vTestCompany.click();
                break;

            case "omer company":
                omerCompany.click();
                break;

            default:
                company = "Invalid Company!";
                break;
        }}
        ReusableMethods.wait(2);
        ReusableMethods.waitForVisibilityNew(driver,avatar);
        avatar.click();
        ReusableMethods.wait(1);
        avatar.click();
        switch (page) {
            case "Insights":
                insightsLogo.click();
                break;

            case "DORA":
                doraLogo.click();
                break;

            case "Resource Distribution":
                resourceDistributionLogo.click();
                break;

            case "Sprint":
                sprintLogo.click();
                break;

            case "Contributors":
                contributorsLogo.click();
                break;

            case "Projects":
                projectsLogo.click();
                break;

            case "Automations":
                automationsLogo.click();
                break;

            case "Connected Applications":
                connectedApplicationsLogo.click();
                break;

            case "User Management":
                goToUserManagement();
                break;

            default:
                page = "Invalid Page!";
                break;
        }
        ReusableMethods.wait(2);
    }

    public void checkHelpFeedbackButtonDashboard(){

        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonInsights(){
         insightsLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonDORA(){
        doraLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonResourceDistribution(){
        resourceDistributionLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonSprint(){
        sprintLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonContributors(){
        contributorsLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonProjects(){
        projectsLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonAutomations(){
        automationsLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonConnectedApplications(){
        connectedApplicationsLogo.click();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
    }

    public void checkHelpFeedbackButtonAllPages(){
        checkHelpFeedbackButtonDashboard();
        checkHelpFeedbackButtonInsights();
        checkHelpFeedbackButtonDORA();
        checkHelpFeedbackButtonResourceDistribution();
        checkHelpFeedbackButtonSprint();
        checkHelpFeedbackButtonContributors();
        checkHelpFeedbackButtonProjects();
        checkHelpFeedbackButtonAutomations();
        checkHelpFeedbackButtonConnectedApplications();
    }

    @FindBy(xpath = "(//*[@class=\"help-and-feedback-card-wrapper\"])[1]")
    public WebElement helpFeedbackHelpCenterContent;

    @FindBy(xpath = "(//*[@class=\"help-and-feedback-card-wrapper\"])[2]")
    public WebElement helpFeedbackBlogContent;

    public void checkHelpFeedbackContentOnlyHelpCenterAndBlog() {
        helpFeedbackQuestionMarkButton.click();
        ReusableMethods.waitForVisibility(helpFeedbackBlogContent);
        Assert.assertTrue(helpFeedbackHelpCenterContent.isDisplayed());
        Assert.assertTrue(helpFeedbackBlogContent.isDisplayed());
    }

    @FindBy(xpath = "//*[@class=\"form-group\"]")
    public WebElement helpFeedbackPermissionContent;

    @FindBy(xpath = "//*[@class=\"switch ml-sm-2\"]")
    public WebElement dataAccessPermissionButton;

    @FindBy(xpath = "//*[@class=\"s-icon close-white\"]")
    public WebElement helpFeedbackCloseButton;

    //Company Permission: Restrict and View Only without permission switch.

    public void checkDashboardHelpFeedbackContentWithoutPermissionSwitch() {
        dashboardLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in Dashboard.");
            } else {
                System.out.println("Data Access Permission Button is displayed in Dashboard.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in Dashboard.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkInsightsHelpFeedbackContentWithoutPermissionSwitch(){
        insightsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in Insights.");
            } else {
                System.out.println("Data Access Permission Button is displayed in Insights.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in Insights.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkDoraHelpFeedbackContentWithoutPermissionSwitch(){
        doraLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in DORA.");
            } else {
                System.out.println("Data Access Permission Button is displayed in DORA.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in DORA.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkResourceDistributionHelpFeedbackContentWithoutPermissionSwitch(){
        resourceDistributionLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in R.Distribution.");
            } else {
                System.out.println("Data Access Permission Button is displayed in R.Distribution.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in R.Distribution.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkSprintHelpFeedbackContentWithoutPermissionSwitch(){
        sprintLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in Sprint.");
            } else {
                System.out.println("Data Access Permission Button is displayed in Sprint.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in Sprint.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkContributorsHelpFeedbackContentWithoutPermissionSwitch(){
        contributorsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in Contributors.");
            } else {
                System.out.println("Data Access Permission Button is displayed in Contributors.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in Contributors.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkProjectsHelpFeedbackContentWithoutPermissionSwitch(){
        projectsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in Projects.");
            } else {
                System.out.println("Data Access Permission Button is displayed in Projects.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in Projects.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkAutomationsHelpFeedbackContentWithoutPermissionSwitch(){
        automationsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in Automations.");
            } else {
                System.out.println("Data Access Permission Button is displayed in Automations.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in Automations.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkConnectedApplicationsHelpFeedbackContentWithoutPermissionSwitch(){
        connectedApplicationsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        try {
            if (!dataAccessPermissionButton.isDisplayed()) {
                System.out.println("Data Access Permission Button couldn't display in Connected Apps.");
            } else {
                System.out.println("Data Access Permission Button is displayed in Connected Apps.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Data Access Permission Button couldn't find in Connected Apps.");
        }
        helpFeedbackCloseButton.click();
    }

    public void checkHelpFeedbackContentWithoutPermissionSwitch(){
        checkDashboardHelpFeedbackContentWithoutPermissionSwitch();
        checkInsightsHelpFeedbackContentWithoutPermissionSwitch();
        checkDoraHelpFeedbackContentWithoutPermissionSwitch();
        checkResourceDistributionHelpFeedbackContentWithoutPermissionSwitch();
        checkSprintHelpFeedbackContentWithoutPermissionSwitch();
        checkContributorsHelpFeedbackContentWithoutPermissionSwitch();
        checkProjectsHelpFeedbackContentWithoutPermissionSwitch();
        checkAutomationsHelpFeedbackContentWithoutPermissionSwitch();
        checkConnectedApplicationsHelpFeedbackContentWithoutPermissionSwitch();
    }

    //Company Permission: Edit & Manage with permission switch.

    public void checkDashboardHelpFeedbackContentWithPermissionSwitch(){
        dashboardLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkInsightsHelpFeedbackContentWithPermissionSwitch(){
        insightsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkDoraHelpFeedbackContentWithPermissionSwitch(){
        doraLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkResourceDistributionHelpFeedbackContentWithPermissionSwitch(){
        resourceDistributionLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkSprintHelpFeedbackContentWithPermissionSwitch(){
        sprintLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkContributorsHelpFeedbackContentWithPermissionSwitch(){
        contributorsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkProjectsHelpFeedbackContentWithPermissionSwitch(){
        projectsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkAutomationsHelpFeedbackContentWithPermissionSwitch(){
        automationsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkConnectedApplicationsHelpFeedbackContentWithPermissionSwitch(){
        connectedApplicationsLogo.click();
        checkHelpFeedbackContentOnlyHelpCenterAndBlog();
        Assert.assertTrue(helpFeedbackQuestionMarkButton.isDisplayed());
        dataAccessPermissionButton.click();
        ReusableMethods.wait(1);
        dataAccessPermissionButton.click();
        helpFeedbackCloseButton.click();
    }

    public void checkHelpFeedbackContentWithPermissionSwitch(){
        checkDashboardHelpFeedbackContentWithPermissionSwitch();
        checkInsightsHelpFeedbackContentWithPermissionSwitch();
        checkDoraHelpFeedbackContentWithPermissionSwitch();
        checkResourceDistributionHelpFeedbackContentWithPermissionSwitch();
        checkSprintHelpFeedbackContentWithPermissionSwitch();
        checkContributorsHelpFeedbackContentWithPermissionSwitch();
        checkProjectsHelpFeedbackContentWithPermissionSwitch();
        checkAutomationsHelpFeedbackContentWithPermissionSwitch();
        checkConnectedApplicationsHelpFeedbackContentWithPermissionSwitch();
    }

    // Case-Insensitive Search in Atlas Pages
    @FindBy(xpath = "//*[@class=\"select2-results__option select2-results__message\"]")
    public WebElement projectSearchNoResultFoundText;

    @FindBy(xpath = "//*[@class=\"app-subsidebar active\"]//*[text()='Code Progress']")
    public WebElement codeProgressInsights;

    @FindBy(xpath = "//*[@class=\"app-subsidebar active\"]//*[text()='Dev. Behaviors']")
    public WebElement devBehaviorsInsights;

    @FindBy(xpath = "//*[@class=\"app-subsidebar active\"]//*[text()='Project Health']")
    public WebElement projectHealthInsights;

    @FindBy(xpath = "//*[@class=\"app-subsidebar active\"]//*[text()='Activities']")
    public WebElement activitiesInsights;

    @FindBy(id = "select2-project_filter-container")
    public WebElement projectFilterBox;

    @FindBy(xpath = "(//*[@id=\"select2-project_filter-results\"]//li)[1]")
    public WebElement firstProjectInProjectFilter;

    @FindBy(xpath = "//*[@class=\"select2-results__option select2-results__option--highlighted\"]")
    public WebElement projectSearchResultText;

    @FindBy(id = "select2-team_filter-container")
    public WebElement teamFilterBox;

    @FindBy(xpath = "(//*[@id=\"select2-team_filter-results\"]//li)[2]")
    public WebElement firstTeamInTeamFilter;

    @FindBy(xpath = "//*[@class=\"select2-results__option select2-results__option--highlighted\"]")
    public WebElement teamSearchResultText;

    @FindBy(id = "select2-epic_filter-container")
    public WebElement epicFilterBox;

    @FindBy(xpath = "(//*[@id=\"select2-epic_filter-results\"]//li)[2]")
    public WebElement firstEpicInEpicFilter;

    @FindBy(xpath = "//*[@type=\"search\"]")
    public WebElement searchBox;

    public void projectSearch(){
        ReusableMethods.waitForVisibilityNew(driver,projectFilterBox);
        projectFilterBox.click();
        String firstProjectUpperCase=firstProjectInProjectFilter.getText().toUpperCase();
        searchBox.sendKeys(firstProjectUpperCase);
        ReusableMethods.wait(2);
        if(projectSearchResultText.getText().toUpperCase().contains(firstProjectUpperCase)){
            Logger.info("Project Search Box Result Are Case-InSensitive!");
        }else {Logger.error("Project Search Box Result Are Case-Sensitive!");}
    }

    public void teamSearch(){
        ReusableMethods.waitForVisibilityNew(driver,teamFilterBox);
        teamFilterBox.click();
        ReusableMethods.waitForVisibilityNew(driver,searchBox);
        String firstTeamUpperCase=firstTeamInTeamFilter.getText().toUpperCase();
        searchBox.sendKeys(firstTeamUpperCase);
        ReusableMethods.wait(2);
        if(teamSearchResultText.getText().toUpperCase().contains(firstTeamUpperCase)){
            Logger.info("Team Search Box Result Are Case-InSensitive!");
        }else {Logger.error("Team Search Box Result Are Case-Sensitive!");}
    }

    public void overviewInsight(){
        projectSearch();

    }

    public void codeProgressInsight(){
        codeProgressInsights.click();
        projectSearch();
        teamSearch();

    }

    public void devBehaviorsInsight(){}

    public void projectHealthInsight(){}

    public void activitiesInsight(){}

    public void checkSearchCaseInSensitiveInsights(){
        overviewInsight();
        codeProgressInsight();







    }

    public void checkSearchCaseInSensitiveDORA(){}

    public void checkSearchCaseInSensitiveResourceDistribution(){}

    public void checkSearchCaseInSensitiveSprint(){}

    public void checkSearchCaseInSensitiveContributors(){}

    public void checkSearchCaseInSensitiveProjects(){}

    public void checkSearchCaseInSensitiveAutomations(){}

    public void checkSearchCaseInSensitiveSettings(){}

    public void checkSearchCaseInSensitiveUserManagement(){}


}