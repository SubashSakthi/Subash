package testNgBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginTestDataProvider {
	
	@DataProvider(name="subash")
	public String [][] LoginData(){
		String[][] a = new String[3][2];
		
		a[0][0] = "subahssk333@gmail.com";
		a[0][1] = "9500300954";
		
		a[1][0] = "subash1512000@gmail.com";
		a[1][1] = "subash s.s.k";
		
		a[2][0] = "6379600649";
		a[2][1] = "9500300954";
		
		return a;
	}
	
	@Test(dataProvider = "subash")
	public void login_001(String email,String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		driver.quit();
	}
}
