package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import config.BaseClass;

@Listeners(listeners.TestListener.class)
public class ValidateDashboard extends BaseClass {

	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void printDashboardHeadingText() throws Exception {
		
		login();
		
		WebElement dashboardHeading = driver.findElement(By.id(mapper.getData("dashboardHeading")));
		
		System.out.println("Dashboard Heading says: " + dashboardHeading.getText());
	}	
}
