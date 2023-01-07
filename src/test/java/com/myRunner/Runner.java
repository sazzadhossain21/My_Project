package com.myRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/"},//path of the feature file
		glue = {"com.stepDef","hooks"},//step defination pakagename ,"hooks"
		dryRun =false,
		monochrome = true,
		//report formate like json,html,testng
		plugin = {"pretty","json:target/reports.json","html:target/reports.html","testng:target/reports.xml"},
		
		tags = "@NegativeTest" //@NegativeTest, @SmokeTest, FuntionalTest
		)
public class Runner extends AbstractTestNGCucumberTests{
	//How to run more than one tag
	//Ans: By using or (new way). example: "@SmokeTest or @NegativeTest"   Old way {"@SmokeTest","@NegativeTest"}
	//How to skip specific tag
	//Ans: By using not (new way). exmple: "not @SmokeTest"  Old way "~@SmokeTest"

}
