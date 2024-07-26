package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AtlasPage;
import pages.SprintPage;
import utilities.ReusableMethods;

public class SprintPageSteps extends BaseStep{
    SprintPage sprintPage=new SprintPage(driver);
    AtlasPage atlasPage=new AtlasPage(driver);

}
