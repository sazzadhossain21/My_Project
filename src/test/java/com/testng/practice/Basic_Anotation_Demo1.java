package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basic_Anotation_Demo1 {
	@BeforeSuite
public void BeforeSuiteDemo() {
	System.out.println("Before suite");
}
	@BeforeTest
public void BeforeTestDemo() {
	System.out.println("Before Test");
}
	@BeforeClass
public void BeforeClassDemo() {
	System.out.println("Before Class");
}
	@BeforeMethod
public void BeforeMethodDemo() {
	System.out.println("Before Method");
}
	@Test
public void TestDemo() {
	System.out.println("Test");
}

	@AfterMethod
public void AfterMethodDemo() {
	System.out.println("After Method");
}
	@AfterClass
public void AfterClassDemo() {
	System.out.println("After Class");
}
	@AfterTest
public void AfterTestDemo() {
	System.out.println("After Test");
}
@AfterSuite
public void AfterSuiteDemo() {
	System.out.println("After Suite");
}
}
class Basic_Anotation_Demo2{
	
	@Test(enabled=true,priority=2)
	public void enableDemo() {
		System.out.println("Hi I m enabled true, hence I m running");
	}
	
	@Test(dependsOnMethods={"descriptionDemo","invocationCountDemo"},priority=3)
	public void dependOnMethodDemo() {
		System.out.println("I m depend on descriptionDemo method ");
	}
	@Test(invocationCount=5,priority=1)
	public void invocationCountDemo() {
		System.out.println("I am running 5 times");
	}
	//description attribute used for writing any description about that method
	@Test(description="this is descriptionDemo testcase")
	public void descriptionDemo() {
		Assert.assertTrue(true);
		System.out.println("this is description method");
	}
}
class Basic_Anotation_Demo3  {  
	
@Test(groups= {"software company"})  
public void infosys()  
{  
System.out.println("Infosys");  
}  
@Test  
public void technip()  
{  
System.out.println("Technip India Ltd");  
}  
@Test(groups= {"software company"})  
public void wipro()  
{  
System.out.println("Wipro");  
}  
}  
//If one of the test cases is taking a long time 
//due to which other test cases are failing. 
//To overcome such situation, you need to mark the test case 
//as fail to avoid the failure of other test cases. The timeOut is a time period 
//provided to the test case to completely execute its test case.

class Basic_Anotation_Demo4   {  
	
@Test(timeOut=200)  
public void testcase1() throws InterruptedException  
{  
Thread.sleep(500);  
System.out.println("This is testcase1");  
}  
@Test    
public void testcaes2()  
{  
System.out.println("This is testcase2");  
    }  
@Test  
public void testcase3()  
{  
System.out.println("This is testcase3");  
}  
}  
