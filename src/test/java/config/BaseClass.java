package config;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	protected Mapper mapper = new Mapper("src\\test\\resources\\locators.properties");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void login() throws Exception {
		WebElement usernameField = driver.findElement(By.xpath(mapper.getData("usernameFieldXPath")));
		
		WebElement passwordField = driver.findElement(By.xpath(mapper.getData("passwordFieldXPath")));
		
		WebElement loginButton = driver.findElement(By.id(mapper.getData("loginButton")));
		
		usernameField.sendKeys("Admin");
		
		passwordField.sendKeys("admin123");
		
		loginButton.click();
		
		assertEquals(driver.getTitle(), "OrangeHRM");
	}
}
