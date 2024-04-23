package testNgBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BooksTestAssertion {
	@Test
	public void book_001() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("BOOKS")).click();
		String actualText = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		String expectedText = "Books";
		
		// Hard Assert
// ( Hard Assert is Static method which is present in Assert class )
	
		org.testng.Assert.assertEquals(actualText, expectedText);
		
// ( if any Exception present HardAssert will stop the execution there itself
		
		// SoftAssert
// ( SoftAssert is a non-static method which is present in SoftAssert class )
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualText, expectedText);
		
// ( if any Exception present SoftAssert won't stop the execution, it will execute completely and finally throw the Exception )
// ( for that we should use one method as "assertAll()" at the end of the script )		
		
		
		
	}
}
