package stepdefinitions.Resource_Distribution;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.AtlasPage;
import pages.Resource_Distribution.ResourceDistributionPage;
import stepdefinitions.Dashboard.BaseStep;

public class ResourcesDistributionPageSteps extends BaseStep {
    ResourceDistributionPage resourceDistributionPage=new ResourceDistributionPage(driver);
    AtlasPage atlasPage=new AtlasPage(driver);

}
