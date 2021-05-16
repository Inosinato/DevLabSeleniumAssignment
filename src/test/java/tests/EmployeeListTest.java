package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import config.BaseClass;

public class EmployeeListTest extends BaseClass {

	@Test
	public void searchEmployee() throws Exception {
		
		login();
		
		WebElement pimButton = driver.findElement(By.id(mapper.getData("pimButton")));

		pimButton.click();
		
		WebElement employeeTextField = driver.findElement(By.id(mapper.getData("employeeNameTextFieldID")));
		WebElement searchEmployeeButton = driver.findElement(By.id(mapper.getData("searchButtonID")));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.attributeContains(employeeTextField, "class", "ac_input inputFormatHint"));
		
		assertTrue(employeeTextField.getAttribute("class").contains("ac_input inputFormatHint"));
		
		employeeTextField.sendKeys("Linda Anderson");
		searchEmployeeButton.click();
		
		WebElement resultTableRow = driver.findElement(By.cssSelector(mapper.getData("resultTableRow")));

		System.out.println(resultTableRow.getText());
		assertTrue(resultTableRow.getText().contains("Linda Jane Anderson"));
	    Shutterbug.shootPage(driver).save();
	}
}
