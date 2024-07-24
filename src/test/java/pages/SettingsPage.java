package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;

public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver driver) {

        super(driver);
    }

    AtlasPage atlasPage = new AtlasPage(driver);

    @FindBy(id = "companies")
    public WebElement avatarCompanies;

    @FindBy(xpath = "//*[@id=\"companies\"]//*[@value=12752]")
    public WebElement vTestCompany;

    @FindBy(xpath = "//*[@id=\"companies\"]//*[@value=33355]")
    public WebElement bahceCompany;

    @FindBy(xpath = "//*[@id=\"companies\"]//*[@value=1280]")
    public WebElement omerCompany;

    @FindBy(xpath = "//*[@class=\"subitem-main active\"]//*[text()='Profile']")
    public WebElement profileSettings;

    @FindBy(xpath = "//*[text()='Company Settings']")
    public WebElement companySettings;

    @FindBy(xpath = "//*[text()='Teams']")
    public WebElement teamsSettings;

    @FindBy(xpath = "//*[text()='Configurations']")
    public WebElement configurationsSettings;

    @FindBy(xpath = "//*[text()='Outliers']")
    public WebElement outliersSettings;

    @FindBy(xpath = "//*[text()='DORA']")
    public WebElement doraSettings;

    @FindBy(id = "companyName")
    public WebElement companyNameCompanySettings;

    @FindBy(xpath = "//*[@type=\"search\"]")
    public WebElement searchTextBoxCompanySettings;

    @FindBy(xpath = "//*[@id=\"select2-industry-container\"]")
    public WebElement industryCompanySettings;

    @FindBy(id = "select2-timezone-container")
    public WebElement timezoneCompanySettings;

    @FindBy(id = "#cbWrapper")
    public WebElement workingDaysCompanySettings;

    @FindBy(xpath = "//*[@id=\"#cbWrapper\"]/label[0]/input")
    public WebElement sundayWorkingDays;

    @FindBy(xpath = "//*[@id=\"#cbWrapper\"]/label[1]/input")
    public WebElement mondayWorkingDays;

    @FindBy(xpath = "//*[@id=\"#cbWrapper\"]/label[2]/input")
    public WebElement tuesdayWorkingDays;

    @FindBy(xpath = "//*[@id=\"#cbWrapper\"]/label[3]/input")
    public WebElement wednesdayWorkingDays;

    @FindBy(xpath = "//*[@id=\"#cbWrapper\"]/label[4]/input")
    public WebElement thursdayWorkingDays;

    @FindBy(xpath = "//*[@id=\"#cbWrapper\"]/label[5]/input")
    public WebElement fridayWorkingDays;

    @FindBy(xpath = "//*[@id=\"#cbWrapper\"]/label[6]/input")
    public WebElement saturdayWorkingDays;

    @FindBy(id = "#hrWrapper")
    public WebElement workingsHoursCompanySettings;

    @FindBy(id = "workingHourStart")
    public WebElement workingHourStartCompanySettings;

    @FindBy(id = "workingHourEnd")
    public WebElement workingHourEndCompanySettings;

    @FindBy(id = "averageManDayCost")
    public WebElement averageManDayCostCompanySettings;

    @FindBy(xpath = "//*[@class=\"switch ml-sm-2\"]//*[@class=\"slider round\"]")
    public WebElement twoFactorAuthenticationButtonCompanySettings;

    @FindBy(xpath = "//*[text()='Save Changes']")
    public WebElement saveChangesButtonCompanySettings;

    @FindBy(id = "fullname")
    public WebElement fullNameProfileSettings;

    @FindBy(xpath = "//*[@data-cc=\"show-preferencesModal\"]")
    public WebElement showCookiePreferencesProfileSettings;

    @FindBy(xpath = "//*[@class=\"section__toggle-wrapper\"]//*[@value=\"analytics\"]")
    public WebElement performanceAndAnalyticsButtonCookiePreferencesProfileSettings;

    @FindBy(xpath = "//*[@class=\"pm__footer\"]//*[@data-role=\"save\"]")
    public WebElement acceptCurrentSelectionCookiePreferencesProfileSetting;

    //PROFILE SETTINGS
    public void checkFullNameProfileSettings(String name) {
        ReusableMethods.waitForClickablility(atlasPage.avatar);
        atlasPage.avatar.click();
        avatarCompanies.click();
        ReusableMethods.wait(2);
        vTestCompany.click();
        ReusableMethods.wait(2);
        atlasPage.avatar.click();
        ReusableMethods.wait(2);
        atlasPage.settings.click();
        fullNameProfileSettings.clear();
        ReusableMethods.wait(1);
        fullNameProfileSettings.sendKeys(name);
        ReusableMethods.wait(1);
        saveChangesButtonCompanySettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        ReusableMethods.wait(1);
        System.out.println("Expected Name : " + name + " / " + "Actual Name : " + fullNameProfileSettings.getAttribute("value"));
        Assert.assertEquals(name, fullNameProfileSettings.getAttribute("value"));
    }

    public void checkShowCookiePreferencesProfileSettings() {
        ReusableMethods.wait(3);
        Assert.assertTrue(showCookiePreferencesProfileSettings.isDisplayed());
        showCookiePreferencesProfileSettings.click();
        ReusableMethods.wait(1);
        String backgroundColorSelected = performanceAndAnalyticsButtonCookiePreferencesProfileSettings.getCssValue("background-color");
        System.out.println("buton seçili iken background: " + backgroundColorSelected);
        performanceAndAnalyticsButtonCookiePreferencesProfileSettings.click();
        ReusableMethods.wait(1);
        acceptCurrentSelectionCookiePreferencesProfileSetting.click();
        saveChangesButtonCompanySettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        ReusableMethods.wait(1);
        showCookiePreferencesProfileSettings.click();
        ReusableMethods.wait(2);
        String backgroundColorNotSelected = performanceAndAnalyticsButtonCookiePreferencesProfileSettings.getCssValue("background-color");
        System.out.println("buton seçili değil iken background: " + backgroundColorNotSelected);
        ReusableMethods.wait(3);

    }

    // COMPANY SETTINGS
    public void checkCompanyName(String companyName) {
        ReusableMethods.waitForClickablility(atlasPage.avatar);
        atlasPage.avatar.click();
        avatarCompanies.click();
        ReusableMethods.wait(2);
        vTestCompany.click();
        driver.navigate().refresh();
        atlasPage.avatar.click();
        ReusableMethods.wait(2);
        atlasPage.settings.click();
        companySettings.click();
        ReusableMethods.wait(1);
        companyNameCompanySettings.clear();
        ReusableMethods.wait(1);
        companyNameCompanySettings.sendKeys(companyName);
        ReusableMethods.wait(1);
        saveChangesButtonCompanySettings.click();
        driver.navigate().refresh();
        String actualCompanyName = companyNameCompanySettings.getAttribute("value");
        System.out.println("Expected Company Name : " + companyName);
        System.out.println("Actual Company Name : " + actualCompanyName);
        Assert.assertEquals(companyName, actualCompanyName);
        ReusableMethods.wait(1);
    }

    public void checkIndustry(String industry) {
        industryCompanySettings.click();
        ReusableMethods.wait(2);
        searchTextBoxCompanySettings.sendKeys(industry, Keys.ENTER);
        ReusableMethods.wait(1);
        saveChangesButtonCompanySettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        String actualIndustryName = industryCompanySettings.getAttribute("title");
        System.out.println();
        System.out.println("Expected Industry Name : " + industry);
        System.out.println("Actual Industry Name : " + actualIndustryName);
        Assert.assertEquals(industry, actualIndustryName);
    }

    public void checkTimeZone(String timezone) {
        timezoneCompanySettings.click();
        ReusableMethods.wait(1);
        searchTextBoxCompanySettings.sendKeys(timezone, Keys.ENTER);
        ReusableMethods.wait(1);
        saveChangesButtonCompanySettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        String actualTimezoneName = timezoneCompanySettings.getAttribute("title");
        System.out.println();
        System.out.println("Expected Timezone Name : " + timezone);
        System.out.println("Actual Timezone Name : " + actualTimezoneName);
        Assert.assertEquals(timezone, actualTimezoneName);

    }

    public void checkWorkingDays(String day1, String day2, String day3, String day4, String day5) {
        String checked = "true";
        String notChecked = "null";
        clickOnDay(day1);
        clickOnDay(day2);
        clickOnDay(day3);
        clickOnDay(day4);
        clickOnDay(day5);
        saveChangesButtonCompanySettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        ReusableMethods.wait(3);
        String actualMondayCheckStatus = mondayWorkingDays.getAttribute("checked");
        String actualTuesdayCheckStatus = tuesdayWorkingDays.getAttribute("checked");
        String actualWednesdayCheckStatus = wednesdayWorkingDays.getAttribute("checked");
        String actualThursdayCheckStatus = thursdayWorkingDays.getAttribute("checked");
        String actualFridayCheckStatus = fridayWorkingDays.getAttribute("checked");
        System.out.println();
        System.out.println("Expected Monday Check Status : " + notChecked + " / " + " Actual Monday Check Status : " + actualMondayCheckStatus);
        System.out.println("Expected Tuesday Check Status : " + checked + " / " + " Actual Tuesday Check Status : " + actualTuesdayCheckStatus);
        System.out.println("Expected Wednesday Check Status : " + checked + " / " + " Actual Wednesday Check Status : " + actualWednesdayCheckStatus);
        System.out.println("Expected Thursday Check Status : " + checked + " / " + " Actual Thursday Check Status : " + actualThursdayCheckStatus);
        System.out.println("Expected Friday Check Status : " + checked + " / " + " Actual Friday Check Status : " + actualFridayCheckStatus);
        ReusableMethods.wait(2);
        Assert.assertNotEquals(checked, actualMondayCheckStatus);
        Assert.assertEquals(checked, actualTuesdayCheckStatus);
        Assert.assertEquals(checked, actualWednesdayCheckStatus);
        Assert.assertEquals(checked, actualThursdayCheckStatus);
        Assert.assertEquals(checked, actualFridayCheckStatus);
    }

    public void clickOnDay(String day) {
        WebElement dayElement = driver.findElement(By.xpath("//*[@id=\"#cbWrapper\"]//*[text()='" + day + "']"));
        dayElement.click();
    }

    public void checkWorkingHours(String startHour, String endHour) {
        ReusableMethods.wait(1);
        workingHourStartCompanySettings.clear();
        ReusableMethods.wait(1);
        workingHourStartCompanySettings.sendKeys(startHour);
        ReusableMethods.wait(1);
        workingHourEndCompanySettings.clear();
        ReusableMethods.wait(1);
        workingHourEndCompanySettings.sendKeys(endHour);
        ReusableMethods.wait(1);
        saveChangesButtonCompanySettings.click();
        driver.navigate().refresh();
        String startValue = workingHourStartCompanySettings.getAttribute("value");
        String endValue = workingHourEndCompanySettings.getAttribute("value");
        System.out.println();
        System.out.print("Expected Working Hours Start :" + startHour);
        System.out.print("     Expected Working Hours End :" + endHour);
        System.out.println();
        System.out.print("Actual Working Hours Start : " + startValue);
        System.out.print("     Actual Working Hours End : " + endValue);
        Assert.assertEquals(startHour, startValue);
        Assert.assertEquals(endHour, endValue);

    }

    public void checkAverageManDayCost(String cost) {
        averageManDayCostCompanySettings.clear();
        ReusableMethods.wait(1);
        averageManDayCostCompanySettings.sendKeys(cost, Keys.ENTER);
        ReusableMethods.wait(1);
        saveChangesButtonCompanySettings.click();
        driver.navigate().refresh();
        String actualAverageManDayCost = averageManDayCostCompanySettings.getAttribute("value");
        System.out.println();
        System.out.println();
        System.out.println("Expected Average Man Day Cost : " + cost + " $");
        System.out.println("Actual Expected Man Day Cost : " + actualAverageManDayCost + " $");
        Assert.assertEquals(cost, actualAverageManDayCost);
    }

    public void checkTwoFactorAuthenticationButton() {
        ReusableMethods.wait(1);
        String backgroundColor = twoFactorAuthenticationButtonCompanySettings.getCssValue("background-color");
        System.out.println("button is not selected background color : " + backgroundColor);
        twoFactorAuthenticationButtonCompanySettings.click();
        ReusableMethods.wait(2);
        saveChangesButtonCompanySettings.click();
        driver.navigate().refresh();
        ReusableMethods.wait(2);
        String backgroundColorSelected = "rgba(0, 34, 255, 1)";
        System.out.println("button is selected background color : " + backgroundColorSelected);
        Assert.assertEquals(backgroundColorSelected, twoFactorAuthenticationButtonCompanySettings.getCssValue("background-color"));
    }

    @FindBy(xpath = "//*[@class=\"s-icon download\"]")
    public WebElement importFromRepoTeamsSettings;

    @FindBy(xpath = "//*[@id=\"data-table_wrapper\"]//*[text()='core']")
    public WebElement coreTeam;

    @FindBy(xpath = "//*[text()='Apply']")
    public WebElement applyButtonTeamsSettings;

    @FindBy(xpath = "//*[@class=\"tx-bold text-left l_0 sorting_1\"]")
    public WebElement importedTeamNameFromRepo;

    @FindBy(xpath = "//*[@class=\"s-icon add\"]")
    public WebElement createTeamTeamsSettings;

    //TEAM SETTINGS
    public void clickImportTeam(String team) {
        WebElement dayElement = driver.findElement(By.xpath("//*[@id=\"data-table_wrapper\"]//*[text()='" + team + "']"));
        dayElement.click();
    }

    public void checkImportTeamFromRepositories(String teamNameFromRepo) {
        ReusableMethods.waitForClickablility(atlasPage.avatar);
        atlasPage.avatar.click();
        atlasPage.settings.click();
        teamsSettings.click();
        importFromRepoTeamsSettings.click();
        ReusableMethods.waitForVisibility(coreTeam);
        clickImportTeam(teamNameFromRepo);
        applyButtonTeamsSettings.click();
        ReusableMethods.wait(2);
        driver.navigate().refresh();
        ReusableMethods.waitForVisibility(importedTeamNameFromRepo);
        System.out.println("Expected Imported Team Name : " + teamNameFromRepo + " / " + "Actual Imported Team Name : " + importedTeamNameFromRepo.getText());
        Assert.assertEquals(teamNameFromRepo, importedTeamNameFromRepo.getText());
    }

    @FindBy(xpath = "(//*[@class=\"form-control\"])[3]")
    public WebElement teamNameCreateTeam;

    @FindBy(xpath = "(//*[@class=\"form-control\"])[4]")
    public WebElement descriptionNameCreateTeam;

    @FindBy(xpath = "//*[@class=\"select-checkbox sorting_disabled\"]")
    public WebElement allUsersButtonCreateTeam;

    @FindBy(xpath = "//*[@class=\"btn btn-main-primary mt-2\"]")
    public WebElement saveTeamButtonTeamsSettings;

    public void checkCreateTeam(String teamName) {
        ReusableMethods.waitForVisibility(createTeamTeamsSettings);
        createTeamTeamsSettings.click();
        teamNameCreateTeam.sendKeys(teamName);
        descriptionNameCreateTeam.sendKeys(teamName + " Test");
        allUsersButtonCreateTeam.click();
        saveTeamButtonTeamsSettings.click();
        ReusableMethods.wait(3);
        driver.navigate().refresh();
        ReusableMethods.waitForVisibility(importedTeamNameFromRepo);
        WebElement createdTeamName = driver.findElement(By.xpath("//*[@id=\"data-table\"]//*[text()='" + teamName + "']"));
        System.out.println("Expected Created Team Name : " + teamName + " / " + "Actual Created Team Name : " + createdTeamName.getText());
        Assert.assertEquals(teamName, createdTeamName.getText());
    }

    //CONFIGURATION SETTINGS
    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[1]")
    public WebElement bugMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[2]")
    public WebElement featureMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[3]")
    public WebElement improvementMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[4]")
    public WebElement taskMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[5]")
    public WebElement epicMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[6]")
    public WebElement openMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[7]")
    public WebElement inProgressMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[8]")
    public WebElement closedMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[9]")
    public WebElement analysisMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[10]")
    public WebElement UXUIMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[11]")
    public WebElement developmentMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[12]")
    public WebElement reviewMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[13]")
    public WebElement QAMapping;

    @FindBy(xpath = " (//*[@class=\"col-md-3 pl-0 mg-b-20\"])[14]")
    public WebElement CICDMapping;

    @FindBy(id = "add-condition")
    public WebElement addConditionConfigurationsSettings;

    @FindBy(xpath = "//*[@class=\"selectize-input items not-full\"]")
    public WebElement mapEntryTextBoxConfigurationsSettings;

    @FindBy(xpath = "//*[@data-value=\"Task\"]")
    public WebElement typeIsTask;

    @FindBy(xpath = "//*[@data-value=\"Improvement\"]")
    public WebElement typeIsImprovement;

    @FindBy(xpath = "//*[@data-value=\"Epic\"]")
    public WebElement typeIsEpic;

    @FindBy(xpath = "//*[@data-value=\"Security Vulnerability\"]")
    public WebElement typeIsSecurityVulnerability;

    @FindBy(xpath = "//*[@data-value=\"Bug\"]")
    public WebElement typeIsBug;

    @FindBy(xpath = "//*[@data-value=\"Investigation Task\"]")
    public WebElement typeIsInvestigationTask;

    @FindBy(xpath = "//*[@data-value=\"Patch\"]")
    public WebElement typeIsPatch;

    @FindBy(xpath = "//*[@data-value=\"Story\"]")
    public WebElement typeIsStory;

    @FindBy(xpath = "//*[@data-value=\"Dependency Problem\"]")
    public WebElement typeIsDependencyProblem;

    @FindBy(xpath = "//*[@data-value=\"New Feature\"]")
    public WebElement typeIsNewFeature;

    @FindBy(xpath = "//*[@data-value=\"Verified\"]")
    public WebElement typeIsVerified;

    @FindBy(xpath = "//*[@data-value=\"To Do\"]")
    public WebElement typeIsToDo;

    @FindBy(xpath = "//*[@data-value=\"Done\"]")
    public WebElement typeIsDone;

    @FindBy(xpath = "//*[@data-value=\"Closed\"]")
    public WebElement typeIsClosed;

    @FindBy(xpath = "//*[@data-value=\"Open\"]")
    public WebElement typeIsOpen;

    @FindBy(name = "submit")
    public WebElement saveChangesConfigurationsSettings;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement okButtonAlertConfigurationsSettings;

    @FindBy(xpath = "//*[@class=\"item\"]")
    public WebElement entryMapItem;

    public void checkBugMappingConfigurationsSettings() {
        ReusableMethods.waitForVisibilityNew(driver, atlasPage.avatar);
        atlasPage.avatar.click();
        ReusableMethods.waitForVisibilityNew(driver, avatarCompanies);
        avatarCompanies.click();
        ReusableMethods.waitForVisibilityNew(driver, vTestCompany);
        vTestCompany.click();
        ReusableMethods.waitForVisibilityNew(driver, atlasPage.avatar);
        ReusableMethods.wait(5);
        atlasPage.avatar.click();
        ReusableMethods.waitForVisibilityNew(driver, atlasPage.settings);
        atlasPage.settings.click();
        configurationsSettings.click();
        ReusableMethods.wait(1);
        bugMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsBug.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        bugMapping.click();
        ReusableMethods.wait(1);
        Assert.assertEquals("Bug", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Bug Mapping Issue : Bug / " + "Actual Bug Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkFeatureMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        featureMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsStory.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        featureMapping.click();
        ReusableMethods.wait(1);
        Assert.assertEquals("Story", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Feature Mapping Issue : Story / " + "Actual Feature Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkImprovementMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        improvementMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsPatch.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        improvementMapping.click();
        ReusableMethods.wait(1);
        Assert.assertEquals("Patch", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Improvement Mapping Issue : Patch / " + "Actual Improvement Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkTaskMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        taskMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsTask.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        taskMapping.click();
        ReusableMethods.wait(1);
        Assert.assertEquals("Task", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Task Mapping Issue : Task / " + "Actual Task Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkEpicMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        epicMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsEpic.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        epicMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Epic", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Epic Mapping Issue : Epic / " + "Actual Epic Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkOpenMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        openMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(2);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsOpen.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        openMapping.click();
        ReusableMethods.wait(2);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Open", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Open Mapping Issue : Open / " + "Actual Open Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkInProgressMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        inProgressMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsVerified.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        inProgressMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Verified", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected In Progress Mapping Issue : Verified / " + "Actual In Progress Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkClosedMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        closedMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsClosed.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        closedMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Closed", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Closed Mapping Issue : Closed / " + "Actual Closed Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkAnalysisMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        analysisMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsToDo.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        analysisMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("To Do", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Analysis Mapping Issue : To Do / " + "Actual Analysis Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkUXUIMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        UXUIMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsDone.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        UXUIMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Done", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected UX / UI Mapping Issue : Done / " + "Actual UX / UI Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkDevelopmentMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        developmentMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsDone.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        developmentMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Done", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Development Mapping Issue : Done / " + "Actual Development Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkReviewMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        reviewMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsDone.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        reviewMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Done", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected Review Mapping Issue : Done / " + "Actual Review Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkQAMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        QAMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsClosed.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        QAMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("Closed", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected QA Mapping Issue : Closed / " + "Actual QA Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    public void checkCICDMappingConfigurationsSettings() {
        ReusableMethods.wait(1);
        CICDMapping.click();
        ReusableMethods.wait(1);
        addConditionConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, mapEntryTextBoxConfigurationsSettings);
        ReusableMethods.waitForElementToBeClickableNew(driver, mapEntryTextBoxConfigurationsSettings);
        mapEntryTextBoxConfigurationsSettings.click();
        ReusableMethods.wait(1);
        typeIsToDo.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ESCAPE).perform();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        CICDMapping.click();
        ReusableMethods.wait(1);
        ReusableMethods.waitForVisibilityNew(driver, entryMapItem);
        Assert.assertEquals("To Do", entryMapItem.getAttribute("data-value"));
        System.out.println("Expected CI / CD Mapping Issue : To Do / " + "Actual CI / CD  Mapping Issue : " + entryMapItem.getAttribute("data-value"));
        driver.navigate().back();
    }

    //OUTLIERS SETTINGS
    @FindBy(xpath = "(//*[@class=\"slider round\"])[2]")
    public WebElement prOutliersButtonOutliersSettings;

    @FindBy(xpath = "(//*[@class=\"slider round\"])[3]")
    public WebElement commitOutliersButtonOutliersSettings;

    @FindBy(id = "pr_outlier_name")
    public WebElement prOutliersTitleTextBoxOutliersSettings;

    @FindBy(id = "pr_outlier_label-selectized")
    public WebElement prOutliersLabelDropdownMenuOutliersSettings;

    @FindBy(xpath = "//*[@class=\"item\"]")
    public WebElement prOutliersLabelSelectedItem;

    @FindBy(id = "commit_outlier_message")
    public WebElement commitOutliersMessageTextBoxOutliersSettings;

    @FindBy(id = "commit_outlier_filecount")
    public WebElement commitOutliersFileCountDropdownMenuOutliersSettings;

    public void checkPROutliersTitleOutliersSettings(String title) {
        ReusableMethods.waitForClickablility(atlasPage.avatar);
        atlasPage.avatar.click();
        ReusableMethods.wait(1);
        atlasPage.settings.click();
        ReusableMethods.wait(1);
        outliersSettings.click();
        ReusableMethods.wait(1);
        prOutliersButtonOutliersSettings.click();
        ReusableMethods.wait(1);
        prOutliersTitleTextBoxOutliersSettings.click();
        ReusableMethods.wait(1);
        prOutliersTitleTextBoxOutliersSettings.sendKeys(title);
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        System.out.println("Expected PR Outliers Title : " + title + " / " + " Actual PR Outliers Title : " + prOutliersTitleTextBoxOutliersSettings.getText());
        Assert.assertEquals(title, prOutliersTitleTextBoxOutliersSettings.getText());
    }

    public void checkPROutliersLabelOutliersSettings(String label) {
        ReusableMethods.wait(1);
        prOutliersLabelDropdownMenuOutliersSettings.click();
        ReusableMethods.wait(1);
        prOutliersLabelDropdownMenuOutliersSettings.sendKeys(label + Keys.ENTER);
        ReusableMethods.wait(1);
        prOutliersTitleTextBoxOutliersSettings.click();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        System.out.println("Expected PR Outliers Label : " + label + " / " + " Actual PR Outliers Label : " + prOutliersLabelSelectedItem.getAttribute("data-value"));
        Assert.assertEquals(label, prOutliersLabelSelectedItem.getAttribute("data-value"));
    }

    public void checkCommitOutliersMessageOutliersSettings(String message) {
        ReusableMethods.wait(1);
        commitOutliersButtonOutliersSettings.click();
        ReusableMethods.wait(1);
        commitOutliersMessageTextBoxOutliersSettings.click();
        ReusableMethods.wait(1);
        commitOutliersMessageTextBoxOutliersSettings.sendKeys(message);
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        System.out.println("Expected Commit Outliers Message : " + message + " / " + " Actual Commit Outliers Message : " + commitOutliersMessageTextBoxOutliersSettings.getText());
        Assert.assertEquals(message, commitOutliersMessageTextBoxOutliersSettings.getText());
    }

    public void checkCommitOutliersFileCountOutliersSettings(String fileCount) {
        ReusableMethods.wait(1);
        commitOutliersFileCountDropdownMenuOutliersSettings.click();
        ReusableMethods.wait(1);
        commitOutliersFileCountDropdownMenuOutliersSettings.sendKeys(fileCount + Keys.ENTER);
        ReusableMethods.wait(1);
        commitOutliersMessageTextBoxOutliersSettings.click();
        ReusableMethods.wait(1);
        saveChangesConfigurationsSettings.click();
        ReusableMethods.wait(1);
        okButtonAlertConfigurationsSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        System.out.println("Expected Commit Outliers File Count : " + fileCount + " / " + " Actual Commit Outliers File Count : " + commitOutliersFileCountDropdownMenuOutliersSettings.getAttribute("value"));
        Assert.assertEquals(fileCount, commitOutliersFileCountDropdownMenuOutliersSettings.getAttribute("value"));
    }

    //DORA SETTINGS
    @FindBy(xpath = "//*[@data-select2-id=\"2\"]")
    public WebElement releaseDetectionDropdownDoraSettings;

    @FindBy(xpath = "//*[@class=\"form-control select2-no-search select2-hidden-accessible\"]//*[text()='Merge Pull Request']")
    public WebElement mergePullRequestValueInReleaseDetectionDoraSettings;

    @FindBy(id = "releaseValue")
    public WebElement releaseDetectionTextBoxDoraSettings;

    @FindBy(xpath = "//*[@data-select2-id=\"5\"]")
    public WebElement failureDetectionDropdownDoraSettings;

    @FindBy(xpath = "//*[@class=\"select2-results__options\"]//*[text()='Issue']")
    public WebElement issueValueInFailureDetectionDoraSettings;

    @FindBy(id = "failureTypeIssueValue")
    public WebElement failureDetectionTextBoxDoraSettings;

    @FindBy(xpath = "//*[@data-select2-id=\"14\"]")
    public WebElement recoverDetectionDropdownDoraSettings;

    @FindBy(xpath = "//*[@class=\"select2-results__options\"]//*[text()='Destination Branch']")
    public WebElement destinationBranchInRecoverDetectionDoraSettings;

    @FindBy(id = "recoverTypeDestinationBranchValue")
    public WebElement recoverDetectionTextBoxDoraSettings;

    @FindBy(xpath = "//*[text()='Save Changes']")
    public WebElement saveChangesButtonDoraSettings;

    public void checkReleaseDetectionMergePullRequestDoraSettings(String version) {
        ReusableMethods.waitForClickablility(atlasPage.avatar);
        atlasPage.avatar.click();
        ReusableMethods.wait(1);
        atlasPage.settings.click();
        ReusableMethods.wait(1);
        doraSettings.click();
        ReusableMethods.wait(1);
        releaseDetectionDropdownDoraSettings.click();
        ReusableMethods.wait(1);
        mergePullRequestValueInReleaseDetectionDoraSettings.click();
        ReusableMethods.wait(1);
        releaseDetectionTextBoxDoraSettings.clear();
        releaseDetectionTextBoxDoraSettings.sendKeys(version);
        ReusableMethods.wait(1);
        saveChangesButtonDoraSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        ReusableMethods.wait(1);
        System.out.println("Expected Release Detection Version : " + version + " / " + "Actual Release Detection Version : " + releaseDetectionTextBoxDoraSettings.getAttribute("value"));
        ReusableMethods.wait(1);
        Assert.assertEquals(version, releaseDetectionTextBoxDoraSettings.getAttribute("value"));
    }

    public void checkFailureDetectionIssueDoraSettings(String version) {
        ReusableMethods.wait(1);
        failureDetectionDropdownDoraSettings.click();
        ReusableMethods.wait(1);
        issueValueInFailureDetectionDoraSettings.click();
        ReusableMethods.wait(1);
        failureDetectionTextBoxDoraSettings.sendKeys(version);
        ReusableMethods.wait(1);
        saveChangesButtonDoraSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        ReusableMethods.wait(1);
        System.out.println("Expected Failure Detection Version : " + version + " / " + "Actual Failure Detection Version : " + failureDetectionTextBoxDoraSettings.getAttribute("value"));
        ReusableMethods.wait(1);
        Assert.assertEquals(version, failureDetectionTextBoxDoraSettings.getAttribute("value"));
    }

    public void checkRecoverDetectionDestinationBranchDoraSettings(String version) {
        ReusableMethods.wait(1);
        recoverDetectionDropdownDoraSettings.click();
        ReusableMethods.wait(1);
        destinationBranchInRecoverDetectionDoraSettings.click();
        ReusableMethods.wait(1);
        recoverDetectionTextBoxDoraSettings.sendKeys(version);
        ReusableMethods.wait(1);
        saveChangesButtonDoraSettings.click();
        ReusableMethods.wait(1);
        driver.navigate().refresh();
        ReusableMethods.wait(1);
        System.out.println("Expected Recover Detection Version : " + version + " / " + "Actual Recover Detection Version : " + recoverDetectionTextBoxDoraSettings.getAttribute("value"));
        ReusableMethods.wait(1);
        Assert.assertEquals(version, recoverDetectionTextBoxDoraSettings.getAttribute("value"));
    }
}
