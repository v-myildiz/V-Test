package pages.Dashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;
import utilities.TestData.TestDataBase;

public class BasePage extends ReusableMethods {
    protected static WebDriver driver;
    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}