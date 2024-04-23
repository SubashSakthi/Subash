package testNgBasics;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;
import objectRepositary.BookPage;
import objectRepositary.HomePage;

public class BooksTest extends BaseClass {
	@Test
	public void Book_001() {
	//	launchBeowser(null, null);
		driver.findElement(By.linkText("BOOKS")).click();
		String actualText = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		// hard assert
		Assert.assertEquals(actualText, "computers", "Book Page is not Displayed");
		test.log(LogStatus.INFO,test.addScreenCapture(getWebPageScreenshot(driver)));
		Reporter.log("Book page is displayed", true);
	}

	@Test
	public void Computers_001() {
		driver.findElement(By.linkText("COMPUTERS")).click();
		test.log(LogStatus.INFO,"To Click On Books","CLICKED ON COMPUTERS LINK");
		String computer = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		// soft assert
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(computer, "Computers", "Computer Page Is Not Display");
		Reporter.log("Computer Page is Displayed", true);
	}

	@Test(enabled = false)
	public void Desktop_001() {
		driver.findElement(By.linkText("COMPUTERS")).click();
		String desktop = driver.findElement(By.xpath("(//h2[@class='title']/a)[1]")).getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(desktop, "Desktops", "Desktop Is Not Display");
		Reporter.log("Desktop is Dispalyed", true);
	}

	@Test
	public void Notebooks_001() {
		HomePage home = new HomePage(driver);
		driver.findElement(By.linkText("COMPUTERS")).click();
		test.log(LogStatus.INFO, test.addScreenCapture(getWebPageScreenshot(driver)));
		String note = driver.findElement(By.xpath("(//h2[@class='title']/a)[2]")).getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(note, "Notebooks", "Notebooks Is Not Display");
		test.log(LogStatus.INFO, test.addScreenCapture(getWebElementScreenshot(home.getComputersLink())));
		test.log(LogStatus.INFO, "NOTEBOOKS LINK IS DISPALYED");
		Reporter.log("Notebooks is Dispalyed", true);
	}

	@Test
	public void Accessories_001() {
		driver.findElement(By.linkText("COMPUTERS")).click();
		String note = driver.findElement(By.xpath("(//h2[@class='title']/a)[3]")).getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(note, "Accessories", "Accessories Is Not Display");
		test.log(LogStatus.INFO, "ACCESSORIES LINK IS DIAPLAYED");
		Reporter.log("Accessories is Dispalyed", true);
	}
	
	@Test(priority = 1)
	public void books_002() {
		HomePage home = new HomePage(driver);
		BookPage book = new BookPage(driver);
		
		home.getBooksLink().click();
		test.log(LogStatus.INFO, "CLICKED ON BOOKS LINK");
		selectOptionByIndex(book.getSortbyDropDown(), 2);
		selectOptionByVisibletext(book.getDisplayDropDown(),"12");
		selectOptionByVisibleText(book.getViewAsSropDown(), "List");
		
	}
}
