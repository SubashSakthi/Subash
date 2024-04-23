package testNgBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependencyTest {
	@Test(groups = "FT")
	public void register() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log(" FT Register"); // it will print the message in Report only
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(groups = "smoke")//(dependsOnMethods = "Register")

	public void login() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log(" Smoke Login",true); // if we use ,true it will print the message in console and also Report
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "smoke")//(dependsOnMethods = "Login")
	
	public void AdddToCart() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("smoke Add_To_Cart");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
		
	}
	
}
