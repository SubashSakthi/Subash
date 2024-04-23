package testNgBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest {
	
	@DataProvider(name = "subash")
	public String [][] registerData(){

		String [][] a = new String[5][5];

		a[0][0] = "subash";
		a[0][1] = "sakthi";
		a[0][2] = "subashssk333@gmail.com";
		a[0][3] = "9500300954";
		a[0][4] = "9500300954";

		a[1][0] = "jeya";
		a[1][1] = "murugan";
		a[1][2] = "muruganjeya123@gmail.com";
		a[1][3] = "11022000";
		a[1][4] = "11022000";

		a[2][0] = "gnanesh";
		a[2][1] = "kandhan";
		a[2][2] = "gnaneshandhan@gmail.com";
		a[2][3] = "123456789";
		a[2][4] = "123456789";

		a[3][0] = "tamil";
		a[3][1] = "selvan";
		a[3][2] = "tamilselvan@gmail.com";
		a[3][3] = "123456789";
		a[3][4] = "123456789";

		a[4][0] = "mani";
		a[4][1] = "kandan";
		a[4][2] = "manikandan@gmail.com";
		a[4][3] = "123456789";
		a[4][4] = "123456789";
		
		return a;
	}
	
	@Test(dataProvider = "subash")
	public void register_001(String firstname,String lastname,String email,String password,String confirmpassword) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		// click on male radio button
		driver.findElement(By.id("gender-male")).click();
		
		//click on register button
		driver.findElement(By.linkText("Register")).click();
		
		//Enter first name
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		
		//Enter last name 
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		
		//Enter email
		driver.findElement(By.id("Email")).sendKeys(email);
		
		//Enter password
		driver.findElement(By.id("Password")).sendKeys(password);
		
		//Enter Confirm password
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmpassword);
		
		//click on register button
		driver.findElement(By.id("register-button")).click();
		
		//close browser
		driver.quit();
	}
}
