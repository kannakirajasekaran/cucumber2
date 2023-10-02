package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
                           //for tutorialninja cucumber framework
@RunWith(Cucumber.class)
@CucumberOptions(
		          features= {"src/test/resources/feature"},
		          glue={"stepDefinitions","hooks"},
		          tags="@validproduct",
//		          dryRun=true,
//		          publish=true,
//		          monochrome=true,
		          plugin={"pretty","html:target/cucumberReport/cucumber_html_Report.html"}
                 )
public class TestRunner {

}
