package pages.User_Management;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


}
