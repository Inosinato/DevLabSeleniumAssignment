package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberSetUp.Hooks;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Mapper;
import cucumber.api.java.en.And;

public class Exercise16 {
	
	WebDriver driverInside = Hooks.driver;
	protected Mapper mapper = new Mapper("src\\test\\resources\\locators.properties");

	
  @Given("^I am in OrangeHR Application$")
  public void whenIAmInOrangeHRApplication() throws Throwable {
	  driverInside.get("https://opensource-demo.orangehrmlive.com/");
	  assertTrue(driverInside.getTitle().contains("OrangeHRM"));
  }

  @When("^I login to Application$")
  public void iLoginToApplication() throws Throwable {
	  	
	WebElement usernameField = driverInside.findElement(By.xpath(mapper.getData("usernameFieldXPath")));
		
	WebElement passwordField = driverInside.findElement(By.xpath(mapper.getData("passwordFieldXPath")));
	
	WebElement loginButton = driverInside.findElement(By.id(mapper.getData("loginButton")));
	
	usernameField.sendKeys("Admin");
	
	passwordField.sendKeys("admin123");
	
	loginButton.click();
	
  }

  @Then("^The dashboard page is available$")
  public void theDashboardPageIsAvailable() throws Throwable {
	WebElement dashboardHeading = driverInside.findElement(By.cssSelector(mapper.getData("dashboardHeading")));
	assertTrue(dashboardHeading.isDisplayed());
  }

  @And("^I click on admin menu$")
  public void iClickOnAdminMenu() throws Throwable {
	  WebElement adminButton = driverInside.findElement(By.id(mapper.getData("adminButton")));
	  adminButton.click();
  }

}
