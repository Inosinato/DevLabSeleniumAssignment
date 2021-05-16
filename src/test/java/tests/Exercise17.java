package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberSetUp.Hooks;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import config.Mapper;
import cucumber.api.java.en.And;

public class Exercise17 {
	
	WebDriver driverInside = Hooks.driver;
	protected Mapper mapper = new Mapper("src\\test\\resources\\locators.properties");
	
  @Given("^I click on Admin link$")
  public void iClickOnAdminLink() throws Throwable {
	WebElement adminMenuButton = driverInside.findElement(By.xpath(mapper.getData("adminMenuButton")));
	adminMenuButton.click();
  }

  @Then("^I click on Job$")
  public void iCLickOnJob() throws Throwable {
	Actions action = new Actions(driverInside);
	WebElement jobMenuButton = driverInside.findElement(By.id(mapper.getData("jobMenu")));
	action.moveToElement(jobMenuButton).build().perform();
	WebElement viewJobsButton = driverInside.findElement(By.id(mapper.getData("viewJobTitlesButton")));
	viewJobsButton.click();
  }

  @And("validate text \"([^\"]*)\"")
  public void validateTextJob(String jobName) throws Throwable {
	  List<WebElement> jobTitlesResults = driverInside.findElements(By.cssSelector(mapper.getData("jobTitlesResults")));
	  Boolean isJobInList = false;
	  
		for(WebElement job: jobTitlesResults) {
			if(job.getText().contains(jobName))
			{
				isJobInList = true;
			}	
		}
		assertTrue(isJobInList);
  }
  
  @Given("I am login in OrangeHR Application")
  public void iAmLoginIntoOrangeHRApplication() throws Exception {
		  	
	WebElement usernameField = driverInside.findElement(By.xpath(mapper.getData("usernameFieldXPath")));
		
	WebElement passwordField = driverInside.findElement(By.xpath(mapper.getData("passwordFieldXPath")));
	
	WebElement loginButton = driverInside.findElement(By.id(mapper.getData("loginButton")));
	
	usernameField.sendKeys("Admin");
	
	passwordField.sendKeys("admin123");
	
	loginButton.click();
		
  }

}
