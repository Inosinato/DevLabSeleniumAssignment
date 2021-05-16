package tests;

import cucumber.api.java.en.When;
import cucumberSetUp.Hooks;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Mapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Exercise18 {
	
	WebDriver driverInside = Hooks.driver;
	protected Mapper mapper = new Mapper("src\\test\\resources\\locators.properties");
	
  @When("I click on Admin menu")
  public void iClickOnAdminMenu() throws Throwable {
	WebElement adminMenuButton = driverInside.findElement(By.xpath(mapper.getData("adminMenuButton")));
	adminMenuButton.click();
  }

  @Then("Qualifications menu is displayed")
  public void qualificationsMenuIsDisplayed() throws Throwable {
	WebElement qualificationsMenu = driverInside.findElement(By.id(mapper.getData("qualificationsMenu")));
	assertTrue(qualificationsMenu.isDisplayed());
  }

  @When("I click on PIM menu")
  public void iClickOnPIMMenu() throws Throwable {
	WebElement pimMenuButton = driverInside.findElement(By.id(mapper.getData("pimMenu")));
	pimMenuButton.click();
  }

  @Then("Employee List menu is displayed")
  public void employeeListMenuIsDisplayed() throws Throwable {
	WebElement employeeListMenu = driverInside.findElement(By.id(mapper.getData("employeeListMenu")));
	assertTrue(employeeListMenu.isDisplayed());
  }

  @When("I click on Time menu")
  public void iClickOnTimeMenu() throws Throwable {
	WebElement timeMenuButton = driverInside.findElement(By.id(mapper.getData("timeMenu")));
	timeMenuButton.click();
  }

  @Then("Reports menu is displayed")
  public void reportsMenuIsDisplayed() throws Throwable {
	WebElement reportsMenu = driverInside.findElement(By.id(mapper.getData("reportsMenu")));
	assertTrue(reportsMenu.isDisplayed());
  }

  @Then("Attendance menu is displayed")
  public void attendanceMenuIsDisplayed() throws Throwable {
	WebElement attendanceMenu = driverInside.findElement(By.id(mapper.getData("attendanceMenu")));
	assertTrue(attendanceMenu.isDisplayed());
  }
  
  @Given("I have log into OrangeHR Application")
  public void iHaveLogIntoOrangeHRApplication() throws Exception {
		  	
	WebElement usernameField = driverInside.findElement(By.xpath(mapper.getData("usernameFieldXPath")));
		
	WebElement passwordField = driverInside.findElement(By.xpath(mapper.getData("passwordFieldXPath")));
	
	WebElement loginButton = driverInside.findElement(By.id(mapper.getData("loginButton")));
	
	usernameField.sendKeys("Admin");
	
	passwordField.sendKeys("admin123");
	
	loginButton.click();
  }

}
