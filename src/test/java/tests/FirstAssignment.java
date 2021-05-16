package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import config.BaseClass;

public class FirstAssignment extends BaseClass {

	@Test
	public void print() {
		System.out.println("Page title is: " + driver.getTitle());
	}
	
	@Test(priority = 1)
	public void login() throws Exception {
		
		WebElement usernameField = driver.findElement(By.xpath(mapper.getData("usernameFieldXPath")));
		
		WebElement passwordField = driver.findElement(By.xpath(mapper.getData("passwordFieldXPath")));
		
		WebElement loginButton = driver.findElement(By.id(mapper.getData("loginButton")));
		
		usernameField.sendKeys("Admin");
		
		passwordField.sendKeys("admin123");
		
		loginButton.click();
		
		assertEquals(driver.getTitle(), "OrangeHRM");
		
		WebElement dashboardMenu = driver.findElement(By.id(mapper.getData("dashBoardMenu")));
		
		assertTrue(dashboardMenu.isDisplayed());
	}

	@Test
	public void validateAdminText() throws Exception {
		
		WebElement adminButton = driver.findElement(By.id(mapper.getData("adminButton")));
		WebElement userManagementButton = driver.findElement(By.id(mapper.getData("userManagementMenu")));
		WebElement jobButton = driver.findElement(By.id(mapper.getData("jobMenu")));
		WebElement organizationMenu = driver.findElement(By.id(mapper.getData("organizationMenu")));
		WebElement qualificationsMenu = driver.findElement(By.id(mapper.getData("qualificationsMenu")));
		
		adminButton.click();
		System.out.println("Validate admin page");
		assertTrue(userManagementButton.isDisplayed());
		assertTrue(jobButton.isDisplayed());
		assertTrue(organizationMenu.isDisplayed());
		assertTrue(qualificationsMenu.isDisplayed());
	}
	
	@Test
	public void printPageTitles() throws Exception {

		WebElement adminButton = driver.findElement(By.id(mapper.getData("adminButton")));
		WebElement pimButton = driver.findElement(By.id(mapper.getData("pimButton")));
		WebElement leaveDashboardButton = driver.findElement(By.id(mapper.getData("leaveDashboardButton")));
		WebElement directoryButton = driver.findElement(By.id(mapper.getData("directoryButton")));
		WebElement maintenanceButton = driver.findElement(By.id(mapper.getData("maitenanceButton")));
		
		System.out.println("Print pages titles");
		printTitle(adminButton);
		printTitle(pimButton);
		printTitle(leaveDashboardButton);
		printTitle(directoryButton);
		printTitle(maintenanceButton);

	}
	
	void printTitle(WebElement elementToClick) {
		elementToClick.click();
		System.out.println(driver.getTitle());
	}
	
	void minimizeWindow() {
		driver.manage().window().setPosition(new Point(-2000, 0));
	}
}
