package testNgBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DisableScripts {
	
	@Test(enabled = false)// This method is used to skip the execution,it will not consider
	public void test1() {
		System.out.println("Test Case 1");
	}
	

	@Test(groups = "IT")//(invocationCount = 3) // it will run this script for 5 times
	public void test2() {
		WebDriver drive = new ChromeDriver();
		Reporter.log("IT Test Case 2",true);
		drive.manage().window().maximize();
		drive.quit();
	}
	
	@Test(groups = "IT")//(invocationCount = 4,threadPoolSize = 5) // it will run this script for 6 times in 5 browsers
	public void test3() {
		WebDriver driver = new ChromeDriver();
		Reporter.log("IT Test Case 3",true);
		driver.manage().window().maximize();
		driver.quit();
	}
	
	@Test(groups = "FT")
	public void test4() throws InterruptedException {
		Reporter.log("FT Test Case 4",true);
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
}
