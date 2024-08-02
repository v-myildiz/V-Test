package pages.User_Management;

import com.github.javafaker.Faker;
import log.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.Dashboard.BasePage;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;

public class UserManagementPage extends BasePage {
    public UserManagementPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//*[@class=\"btn btn-outline-primary btn-with-icon\"]")
    public WebElement addAtlasUserButton;

    @FindBy(xpath = "//*[@name=\"fullname\"]")
    public WebElement addAtlasUserNameTextBox;

    @FindBy(xpath = "//*[@name=\"email\"]")
    public WebElement addAtlasUserEMailTextBox;

    @FindBy(xpath = "//*[@class=\"btn btn-main-primary mt-2\"]")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//*[@name=\"error-text\"]")
    public WebElement addAtlasUserError;

    public void addAtlasUserIncorrect(String name,String mail){
        addAtlasUserButton.click();
        ReusableMethods.waitForVisibilityNew(driver,addAtlasUserNameTextBox);
        addAtlasUserNameTextBox.sendKeys(name);
        ReusableMethods.wait(1);
        addAtlasUserEMailTextBox.sendKeys(mail);
        ReusableMethods.wait(2);
        saveChangesButton.click();
        ReusableMethods.waitForVisibilityNew(driver,addAtlasUserError);
        Assert.assertTrue(addAtlasUserError.isDisplayed());
        Assert.assertEquals(addAtlasUserError.getText(), TestDataBase.addAtlasUSerWarningText);
        JSUtilities.scrollToElement(driver,addAtlasUserNameTextBox);
        ReusableMethods.wait(3);
    }

    public void addAtlasUserCorrect(String name,String mail){
        ReusableMethods.waitForVisibilityNew(driver,addAtlasUserButton);
        addAtlasUserButton.click();
        ReusableMethods.waitForVisibilityNew(driver,addAtlasUserNameTextBox);
        addAtlasUserNameTextBox.sendKeys(name);
        ReusableMethods.wait(1);
        addAtlasUserEMailTextBox.sendKeys(mail);
        ReusableMethods.wait(1);
        saveChangesButton.click();
        ReusableMethods.wait(3);
        WebElement userManagementUserName=driver.findElement(By.xpath("//*[@id=\"data-table\"]//*[text()='" + name + "']"));
        WebElement userManagementUserMail=driver.findElement(By.xpath("//*[@id=\"data-table\"]//*[text()='"+mail+"']"));
        ReusableMethods.waitForVisibilityNew(driver,userManagementUserName);
        Assert.assertEquals(name,userManagementUserName.getText());
        Assert.assertEquals(mail,userManagementUserMail.getText());
        ReusableMethods.wait(3);
    }

    @FindBy(xpath ="//*[@class=\"btn btn-main-primary\"]")
    public WebElement okButton;

    public void deleteUser(String name){
        WebElement userRow = driver.findElement(By.xpath("//tr[.//span[text()='"+name+"']]"));
        String userId = userRow.getAttribute("id");
        Logger.info(name+" ID: "+userId);
        WebElement userAddedOptions=driver.findElement(By.xpath("//*[@id="+userId+"]//*[@class=\"s-icon options\"]"));
        userAddedOptions.click();
        WebElement deleteUser=driver.findElement(By.xpath("(//*[@class=\"dropdown show\"]//a)[3]"));
        ReusableMethods.waitForVisibilityNew(driver,deleteUser);
        ReusableMethods.wait(2);
        deleteUser.click();
        ReusableMethods.waitForVisibilityNew(driver,okButton);
        ReusableMethods.wait(2);
        okButton.click();
        ReusableMethods.wait(2);
        try {
            Assert.assertTrue(userRow.isDisplayed());
            Logger.error(name+" User couldn't delete!");
        } catch (Exception e) {
            Logger.info(name+" User deleted!");
        }
    }

}
