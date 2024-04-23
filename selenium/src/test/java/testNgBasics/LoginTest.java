package testNgBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {

	@Test(groups = "smoke")//(priority = 2)
	public void loginn_001() {
		WebDriver driver = new ChromeDriver();
		Reporter.log("Smoke login_001",true);
		driver.manage().window().maximize();
		driver.quit();
	}
	
	@Test(groups = "ST")//(priority = 1)
	
	public void login_002() {
		WebDriver driver = new ChromeDriver();
		Reporter.log("ST login_002",true);
		driver.manage().window().maximize();
		driver.get("webibnc");
		driver.quit();
	}

}
