package pages.Dashboard;

import log.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;


public class AtlasPage extends BasePage {
    public AtlasPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@type=\"email\"]")
    public WebElement mailBox;

    @FindBy(xpath = "//*[@type=\"password\"]")
    public WebElement passwordBox;

    @FindBy(id = "opt_input_0_632")
    public WebElement otpField;

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

    @FindBy(xpath = "//*[@class=\"demo\"]//*[@class=\"btn btn-outline-primary\"]")
    public WebElement disableDemoModeButton;

    public void selectDemoMode(){
        avatar.click();
        ReusableMethods.waitForVisibilityNew(driver,demoMode);
        demoMode.click();
        ReusableMethods.waitForVisibilityNew(driver,disableDemoModeButton);
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

    @FindBy(xpath = "(//*[@id=\"select2-project_filter-results\"]//li)[2]")
    public WebElement secondProjectInProjectFilter;

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

    @FindBy(xpath = "//*[@class=\"select2-search select2-search--dropdown\"]//*[@type=\"search\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"issues-table_filter\"]//*[@type=\"search\"]")
    public WebElement searchBoxTimeInState;

    @FindBy(xpath = "//*[@class=\"breadcrumb-item active\"]")
    public WebElement pageTitleDefault;

    @FindBy(xpath = "(//*[@class=\"breadcrumb-item\"])[1]")
    public WebElement pageTitle1;

    @FindBy(xpath = "(//*[@class=\"breadcrumb-item\"])[2]")
    public WebElement pageTitle2;

    public void projectSearch(){
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.waitForVisibilityNew(driver,projectFilterBox);
        projectFilterBox.click();
        ReusableMethods.wait(1);
        String firstProjectUpperCase=firstProjectInProjectFilter.getText().toUpperCase();
        String secondProjectUpperCase=secondProjectInProjectFilter.getText().toUpperCase();
        if(firstProjectInProjectFilter.getText().equalsIgnoreCase("all")){
            firstProjectUpperCase=secondProjectUpperCase;
        }
        searchBox.sendKeys(firstProjectUpperCase);
        ReusableMethods.wait(1);
        if(projectSearchResultText.getText().toUpperCase().contains(firstProjectUpperCase)){
            Logger.infoWithPage("Project Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Project Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    public void teamSearch(){
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.waitForVisibilityNew(driver,teamFilterBox);
        teamFilterBox.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,searchBox);
        String firstTeamUpperCase=firstTeamInTeamFilter.getText().toUpperCase();
        searchBox.sendKeys(firstTeamUpperCase);
        ReusableMethods.wait(1);
        if(teamSearchResultText.getText().toUpperCase().contains(firstTeamUpperCase)){
            Logger.infoWithPage("Team Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Team Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    public void epicSearch(){
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.waitForVisibilityNew(driver,epicFilterBox);
        epicFilterBox.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,searchBox);
        String firstEpicUpperCase=firstEpicInEpicFilter.getText().toUpperCase();
        searchBox.sendKeys(firstEpicUpperCase);
        ReusableMethods.wait(1);
        if(teamSearchResultText.getText().toUpperCase().contains(firstEpicUpperCase)){
            Logger.infoWithPage("Epic Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Epic Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    public void overviewInsight(){
        projectSearch();

    }

    public void codeProgressInsight(){
        codeProgressInsights.click();
        projectSearch();
        teamSearch();
        epicSearch();
    }

    public void devBehaviorsInsight(){
        devBehaviorsInsights.click();
        projectSearch();
        teamSearch();
        epicSearch();
    }

    @FindBy(xpath = "//*[@id=\"issues-table\"]//td")
    public WebElement firstIssueInTimeInState;

    @FindBy(xpath = "//*[text()='There is no data']")
    public WebElement thereIsNoDataText;

    @FindBy(id = "select2-project_filter-results")
    public WebElement projectsInTheProjectsList;

    @FindBy(xpath = "(//*[@id=\"issues-table\"]//td)[1]")
    public WebElement issueTimeInStateSearchResultText;

    public void timeInStateSearch(){
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        JSUtilities.scrollToElement(driver,searchBoxTimeInState);
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,searchBoxTimeInState);
        String firstIssueLowerCase=firstIssueInTimeInState.getText().toLowerCase();
        searchBoxTimeInState.sendKeys(firstIssueLowerCase);
        ReusableMethods.wait(1);
        if(issueTimeInStateSearchResultText.getText().toLowerCase().contains(firstIssueLowerCase)){
            Logger.infoWithPage("Time In State Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Time In State Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    public void projectHealthInsight(){
        projectHealthInsights.click();
        projectSearch();
        teamSearch();
        epicSearch();
        timeInStateSearch();
    }

    @FindBy(id = "select2-activities_switcher-container")
    public WebElement activitiesFilterBox;

    @FindBy(id = "select2-repo_filter-container")
    public WebElement repositoryFilterBox;

    @FindBy(id = "ms-list-1")
    public WebElement multipleRepositoriesFilterBox;

    @FindBy(xpath = "(//*[@id=\"select2-repo_filter-results\"]//li)[2]")
    public WebElement firstRepository;

    @FindBy(xpath = "(//*[@id=\"multiple-repositories\"]//li)[1]")
    public WebElement firstMultipleRepository;

    @FindBy(xpath = "(//*[@id=\"select2-repo_filter-results\"]//li)[1]")
    public WebElement repositorySearchResultText;

    @FindBy(xpath = "//*[@id=\"ms-list-1\"]//*[@type=\"text\"]")
    public WebElement searchBoxRepositoryDORA;

    public void repositorySearch(){
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.wait(1);
        if(isElementDisplayed(repositoryFilterBox)){
            repositoryFilterBox=repositoryFilterBox;
        } else {
            repositoryFilterBox=multipleRepositoriesFilterBox;
        }
        ReusableMethods.waitForVisibilityNew(driver,repositoryFilterBox);
        repositoryFilterBox.click();
        ReusableMethods.wait(1);
        String firstRepoUpperCase="";
        String firstMultipleRepoUpperCase="";
        if (isElementDisplayed(firstRepository)){
             firstRepoUpperCase=firstRepository.getText().toUpperCase();
        }
        else {
            firstMultipleRepoUpperCase=firstMultipleRepository.getText().toUpperCase();
            firstRepoUpperCase=firstMultipleRepoUpperCase;
        }

        if (!isElementDisplayed(searchBox)){
            searchBox=searchBoxRepositoryDORA;
        }
        searchBox.sendKeys(firstRepoUpperCase);
        ReusableMethods.wait(1);
        if(isElementDisplayed(repositorySearchResultText)){
            repositorySearchResultText=repositorySearchResultText;
        }
        else {
            repositorySearchResultText=firstMultipleRepository;
        }
        if(repositorySearchResultText.getText().toUpperCase().contains(firstRepoUpperCase)){
            Logger.infoWithPage("Repository Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Repository Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    @FindBy(xpath = "//*[@id=\"commits-chart_filter\"]//*[@type=\"search\"]")
    public WebElement searchBoxCommit;

    @FindBy(xpath = "(//*[@id=\"commits-chart\"]//tr//td)[2]")
    public WebElement firstCommitMessage;

    public void commitSearch(){
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,searchBoxCommit);
        String firstCommitMessageUpperCase=firstCommitMessage.getText().toUpperCase();
        searchBoxCommit.sendKeys(firstCommitMessageUpperCase);
        ReusableMethods.wait(2);
        if(firstCommitMessage.getText().toUpperCase().contains(firstCommitMessageUpperCase)){
            Logger.infoWithPage("Commit Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Commit Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    public void activitiesInsight(){
        activitiesInsights.click();
        projectSearch();
        repositorySearch();
        teamSearch();
        commitSearch();
    }

    public void checkSearchCaseInSensitiveInsights(){
        overviewInsight();
        codeProgressInsight();
        devBehaviorsInsight();
        projectHealthInsight();
        activitiesInsight();
    }

    public void checkSearchCaseInSensitiveDORA(){
        doraLogo.click();
        selectDemoMode();
        ReusableMethods.waitForVisibilityNew(driver,projectFilterBox);
        projectSearch();
        repositorySearch();
        ReusableMethods.waitForVisibilityNew(driver,disableDemoModeButton);
        JSUtilities.scrollToElement(driver,disableDemoModeButton);
        JSUtilities.clickWithJS(driver,disableDemoModeButton);
        try {
            Assert.assertTrue(isElementDisplayed(disableDemoModeButton));
        } catch (Exception e) {
            Logger.info("DEMO Mode is Disabled!");
        }
    }

    public void checkSearchCaseInSensitiveResourceDistribution(){
        resourceDistributionLogo.click();
        selectDemoMode();
        ReusableMethods.waitForVisibilityNew(driver,projectFilterBox);
        projectSearch();
        teamSearch();
        ReusableMethods.waitForVisibilityNew(driver,disableDemoModeButton);
        JSUtilities.scrollToElement(driver,disableDemoModeButton);
        JSUtilities.clickWithJS(driver,disableDemoModeButton);
        try {
            Assert.assertTrue(isElementDisplayed(disableDemoModeButton));
        } catch (Exception e) {
            Logger.info("DEMO Mode is Disabled!");
        }
    }

    @FindBy(xpath = "//*[@id=\"data-table_filter\"]//*[@type=\"search\"]")
    public WebElement sprintSearchBox;

    @FindBy(xpath = "(//*[@id=\"data-table\"]//td)[1]")
    public WebElement firstSprintInDataTable;

    public void sprintSearch(){
        projectFilterBox.click();
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,sprintSearchBox);
        String firstSprintUpperCase=firstSprintInDataTable.getText().toUpperCase();
        ReusableMethods.wait(3);
        sprintSearchBox.sendKeys(firstSprintUpperCase);
        ReusableMethods.wait(3);
        if(firstSprintInDataTable.getText().toUpperCase().contains(firstSprintUpperCase)){
            Logger.infoWithPage("Sprint Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Sprint Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    public void checkSearchCaseInSensitiveSprint(){
        sprintLogo.click();
        projectSearch();
        sprintSearch();
    }

    @FindBy(xpath = "//*[@id=\"data-table_filter\"]//*[@type=\"search\"]")
    public WebElement contributorSearchBox;

    @FindBy(xpath = "(//*[@id=\"data-table\"]//*[@class=\"chart-developer\"])[1]")
    public WebElement firstContributorInDataTable;

    public void contributorSearch(){
        teamFilterBox.click();
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,contributorSearchBox);
        String firstContributorUpperCase=firstContributorInDataTable.getText().toUpperCase();
        ReusableMethods.wait(3);
        contributorSearchBox.sendKeys(firstContributorUpperCase);
        ReusableMethods.wait(3);
        if(firstContributorInDataTable.getText().toUpperCase().contains(firstContributorUpperCase)){
            Logger.infoWithPage("Contributor Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Contributor Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    @FindBy(xpath = "//*[@id=\"data-table_wrapper\"]//*[@class=\"btn btn-primary text-button manage-developer\"]")
    public WebElement manageContributorsButton;

    @FindBy(xpath = "(//*[@id=\"data-table\"]//*[@class=\"text sorting_1\"])[2]")
    public WebElement secondContributorInManageContributorList;

    @FindBy(xpath = "(//*[@id=\"data-table\"]//*[@class=\"text sorting_1\"])[1]")
    public WebElement firstContributorInManageContributorList;

    public void manageContributorSearch(){
        manageContributorsButton.click();
        ReusableMethods.waitForVisibilityNew(driver,contributorSearchBox);
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,contributorSearchBox);
        String firstContributorInManageContributorUpperCase=secondContributorInManageContributorList.getText().toUpperCase();
        ReusableMethods.wait(3);
        contributorSearchBox.sendKeys(firstContributorInManageContributorUpperCase);
        ReusableMethods.wait(3);
        if(firstContributorInManageContributorList.getText().toUpperCase().contains(firstContributorInManageContributorUpperCase)){
            Logger.infoWithPage("Manage Contributor Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Manage Contributor Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    public void checkSearchCaseInSensitiveContributors(){
        contributorsLogo.click();
        projectSearch();
        teamSearch();
        contributorSearch();
        manageContributorSearch();
    }

    @FindBy(xpath = "//*[@id=\"data-table_filter\"]//*[@type=\"search\"]")
    public WebElement projectSearchBoxInProjectPage;

    @FindBy(xpath = "(//*[@id=\"data-table\"]//*[@class=\"sorting_1\"])[1]")
    public WebElement firstProjectInProjectPage;

    public void projectSearchBoxInProjectPage(){
        ReusableMethods.waitForVisibilityNew(driver,projectSearchBoxInProjectPage);
        String activePageText="";
        if (isElementDisplayed(pageTitle2)&isElementDisplayed(pageTitle1)){
            activePageText=pageTitle2.getText()+"-"+pageTitle1.getText();
        } else if (isElementDisplayed(pageTitle1)) {
            activePageText=pageTitle1.getText();
        }
        else {
            activePageText=pageTitleDefault.getText();
        }
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver,projectSearchBoxInProjectPage);
        String firstProjectInProjectPageUpperCase=firstProjectInProjectPage.getText().toUpperCase();
        ReusableMethods.wait(3);
        projectSearchBoxInProjectPage.sendKeys(firstProjectInProjectPageUpperCase);
        ReusableMethods.wait(3);
        if(firstProjectInProjectPage.getText().toUpperCase().contains(firstProjectInProjectPageUpperCase)){
            Logger.infoWithPage("Project Search Box Result Are Case-InSensitive",activePageText);
        }else {
            Logger.errorWithPage("Project Search Box Result Are Case-Sensitive",activePageText);
            Assert.fail();
        }
    }

    @FindBy(xpath = "//*[@class=\"btn btn-outline-primary btn-with-icon\"]")
    public WebElement addProjectButton;

    @FindBy(xpath = "//*[@id=\"project-setup-form\"]//*[@name=\"name\"]")
    public WebElement projectNameTextBox;

    @FindBy(xpath = "//*[@id=\"project-setup-form\"]//*[@name=\"description\"]")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//*[@class=\"btn btn-main-primary mt-2\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"data-table_filter\"]//*[@type=\"search\"]")
    public WebElement addRepositoriesSearchBox;

    @FindBy(xpath = "(//*[@id=\"data-table\"]//td)[2]")
    public WebElement firstRepositoryNameGitProvider;

    @FindBy(id = "save-button")
    public WebElement saveRepositoriesButton;

    @FindBy(xpath = "//*[@data-target=\"#delete-confirm\"]")
    public WebElement deleteProjectButton;

    @FindBy(id = "confirm-delete")
    public WebElement confirmDeleteTextBox;

    @FindBy(id = "confirm-btn")
    public WebElement confirmButton;

    public void addRepositoriesSearch(){
        addProjectButton.click();
        ReusableMethods.waitForVisibilityNew(driver,projectNameTextBox);
        projectNameTextBox.sendKeys("Case-InSensitive Test");
        ReusableMethods.wait(1);
        descriptionTextBox.sendKeys("Add Repositories Search Box Control");
        ReusableMethods.wait(1);
        continueButton.click();
        ReusableMethods.waitForVisibilityNew(driver,addRepositoriesSearchBox);
        String firstRepoInAddRepositoriesPageUpperCase=firstRepositoryNameGitProvider.getText().toUpperCase();
        ReusableMethods.wait(3);
        addRepositoriesSearchBox.sendKeys(firstRepoInAddRepositoriesPageUpperCase);
        ReusableMethods.wait(3);
        if(firstRepositoryNameGitProvider.getText().toUpperCase().contains(firstRepoInAddRepositoriesPageUpperCase)){
            Logger.info("Add Repositories Search Box Result Are Case-InSensitive in Add Repositories!");
        }else {
            Logger.error("Add Repositories Search Box Result Are Case-Sensitive in Add Repositories!");
            Assert.fail();
        }
        firstRepositoryNameGitProvider.click();
        saveRepositoriesButton.click();
        ReusableMethods.waitForVisibilityNew(driver,deleteProjectButton);
        deleteProjectButton.click();
        ReusableMethods.waitForVisibilityNew(driver,confirmButton);
        confirmDeleteTextBox.sendKeys("DELETE");
        confirmButton.click();
    }

    public void checkSearchCaseInSensitiveProjects(){
        projectsLogo.click();
        projectSearchBoxInProjectPage();
        addRepositoriesSearch();








    }

    public void checkSearchCaseInSensitiveAutomations(){}

    public void checkSearchCaseInSensitiveSettings(){}

    public void checkSearchCaseInSensitiveUserManagement(){}


}