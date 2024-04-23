package genericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	static Actions action;
	static JavascriptExecutor jse;
	static Robot robo;
	static TakesScreenshot ts;

//Method For Taking ScreenShot	
	public static String getWebPageScreenshot(WebDriver driver) {
		String imagePath = "./Screenshots/" + getCurrentDateTime() + ".png";
		
//		// step-1:convert WebDriver reference into TakesScreenshot type
//		TakesScreenshot ts = (TakesScreenshot) driver;

		// step-2:get the screenshot and store in temp Location
		File temp = ts.getScreenshotAs(OutputType.FILE);

		// step-3:Create a permanent Location
		File perm = new File(imagePath);

		// step-4:Copy paste the image from temp to permanent location
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagePath;
	}

// Method for WebElement Screenshot
	public static String getWebElementScreenshot(WebElement element) {
		String imagePath = "./Screenshots/" + getCurrentDateTime() + ".png";
		File temp = element.getScreenshotAs(OutputType.FILE);
		File perm = new File(imagePath);
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagePath;
	}

// Method for current date and time
	public static String getCurrentDateTime() {
		return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	}

//Methods for Handle DropDowns
	public static void selectOptionByIndex(WebElement dropdown, int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	public static void selectOptionByVisibleText(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	public static void selectOptionByVisibletext(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

//Method for switch window by using Title 
	public static void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}

//Method for switch window by using URL	
	public static void switchToWindowByUrl(WebDriver driver, String url) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(url))
				break;
		}
	}

//Method for JavaScript Code (scrollBy)
	public static void scrollByJavaScript(WebDriver driver, int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

//scrollTo
	public static void sctollToJavaScript(WebDriver driver, int x, int y) {
		jse.executeScript("window.scrollTo(" + x + "," + y + ")");
	}

//scrollIntoView
	public static void scrollIntoElementView(WebDriver driver, WebElement element, boolean position) {
		jse.executeScript("argumrnts[0].scrillIntoView(" + position + ")", element);
	}

//Handle Disabled or Hidden TextField
	public static void handleDisabedOrHiddenTextField(WebElement element, String value) {
		jse.executeScript("arguments[0].value='" + value + "'", element);
	}

//Handle Disabled or Hidden Buttons
	public static void handleHoddenOrDisabledButton(WebElement element) {
		jse.executeScript("aarguments[0].click()", element);
	}

// This initObject method is used to initialize the value.after we have to call this method in @beforeClass 	
	public static void initObject(WebDriver driver) throws AWTException {
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
		robo = new Robot();
		ts=(TakesScreenshot) driver;
	}

// Method for ScrollToElement (Actions Class)[
	public void getScrollToElement(WebDriver driver, WebElement element) {
		action.scrollToElement(element);
	}

// Method for ScrollByAmount	
	public void scrollByAmount(int x, int y) {
		action.scrollByAmount(x, y).perform();
	}

// Method for ScrollFromOrigin
	public static void scrollFormOrign(WebElement element, int x, int y) {
		ScrollOrigin orign = ScrollOrigin.fromElement(element);
		action.scrollFromOrigin(orign, x, y).perform();
	}

// RighClick		
	public static void getRightClick(WebElement element) {
		action.contextClick(element).perform();
	}

//DoubleClick	
	public static void getDoubleClcik(WebElement element) {
		action.doubleClick(element).perform();
	}

//Drag And Drop		
	public static void getDragAndDrop(WebElement from, WebElement to) {
		action.dragAndDrop(from, to).perform();
	}

//Release
	public static void getRelease(WebElement element) {
		action.release(element).perform();
	}

//Key down
	public static void getKeyDown(WebElement element, String keys) {
		action.keyDown(element, keys).perform();
	}

//key up
	public static void getKeyup(WebElement element, String keys) {
		action.keyUp(element, keys);
	}

//KeyPress (Robot Class)
	public static void getKeyPress(WebElement element, int key) throws AWTException {
		 robo.keyPress(key);
	}

// Implicitly Wait (Synchronization)
	public static void getImplicitlyWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

//Explicitly or WebDriver Wait
	public static void getWebDriverWait(WebDriver driver, int seconds, String condition) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	//	 wait.until(ExpectedConditions.condition);
	}

//Fluent Wait
	public static void getFluentWait(WebDriver driver, int seconds, int polingTime, String exception) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(seconds));
		wait.pollingEvery(Duration.ofSeconds(polingTime));
	//s	wait.until(fun);
	//	wait.ignoring(exception.class);
	}
}
