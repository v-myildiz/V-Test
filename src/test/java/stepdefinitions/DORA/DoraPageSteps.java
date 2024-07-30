package stepdefinitions.DORA;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.AtlasPage;
import pages.DORA.DoraPage;
import stepdefinitions.Dashboard.BaseStep;

public class DoraPageSteps extends BaseStep {
    DoraPage doraPage=new DoraPage(driver);
    AtlasPage atlasPage=new AtlasPage(driver);



}
