package stepdefinitions.Sprint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.AtlasPage;
import pages.Sprint.SprintPage;
import stepdefinitions.Dashboard.BaseStep;
import utilities.ReusableMethods;

public class SprintPageSteps extends BaseStep {
    SprintPage sprintPage=new SprintPage(driver);
    AtlasPage atlasPage=new AtlasPage(driver);

}
