package stepdefinitions;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import pages.AtlasPage;
import pages.ProjectsPage;
import utilities.ReusableMethods;

public class ProjectsPageStep extends BaseStep{
    ProjectsPage projectsPage=new ProjectsPage(driver);
    AtlasPage atlasPage=new AtlasPage(driver);


}
