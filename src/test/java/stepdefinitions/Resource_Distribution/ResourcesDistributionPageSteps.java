package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AtlasPage;
import pages.ResourceDistributionPage;

public class ResourcesDistributionPageSteps extends BaseStep{
    ResourceDistributionPage resourceDistributionPage=new ResourceDistributionPage(driver);
    AtlasPage atlasPage=new AtlasPage(driver);

}
