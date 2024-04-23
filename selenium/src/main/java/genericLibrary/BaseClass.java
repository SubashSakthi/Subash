package genericLibrary;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseClass extends UtilityMethods{
	public static ExtentReports report;
	public static ExtentTest test;
	public WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void BS() {
		report = new ExtentReports("./Reports/"+getCurrentDateTime()+".html");
	}

	@BeforeTest(alwaysRun = true)
	public void BT() {
		Reporter.log("Before Test", true);
	}
//	@Parameters({"browser","url"})
	@BeforeClass(alwaysRun = true)
	public void launchBrowser () {
		
		String browser = FileUtility.getProperty("browser");
		String urls=FileUtility.getProperty("url");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(urls);
		getImplicitlyWait(driver, 10);
	//	initObject(driver);
		Reporter.log("Browser Launched Successfully",true);
		
	}

	

	@BeforeMethod(alwaysRun = true)
	public void Login(Method method) {
		
		test = report.startTest(method.getName());
		
		String email = FileUtility.getProperty("email");
		String password = FileUtility.getProperty("password");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		Reporter.log("Log in Successful ", true);
	}

	@AfterMethod(alwaysRun = true)
	public void Logout() {
		
		report.endTest(test);
		
		driver.findElement(By.linkText("Log out")).click();
		Reporter.log("Log out successful", true);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Browser is Closed", true);
	}

	@AfterTest(alwaysRun = true)
	public void AT() {
		Reporter.log("After Test",true);
	}

	@AfterSuite(alwaysRun = true)
	public void AS() {
		
		report.flush();
		
		Reporter.log("Database Connection Closed", true);
	}
}
