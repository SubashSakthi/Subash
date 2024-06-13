package testNgBasics;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;
import objectRepositary.HomePage;
import objectRepositary.JewelryPage;

public class JewelryTest extends BaseClass {
	
	@Test
	public void jewelry_001() {
		HomePage homepage = new HomePage(driver);
		JewelryPage jewelryPage = new JewelryPage(driver);

		homepage.getJewelryLink().click();
		test.log(LogStatus.INFO, "Jewelry Link Clicked");
		try {
			Assert.assertEquals(jewelryPage.getJewelryText().getText(), "asjbfb","Jewelry Page is not Disaplaye");
			Reporter.log("Jewelry Page Is Dispalyed");
			getWebPageScreenshot(driver);
			}
			catch (AssertionError e) {
				getWebPageScreenshot(driver);
			}
		getScrollToElement(driver, jewelryPage.getAddToCartScrollButton());
//Take Heart image screenshot		
		getWebElementScreenshot(jewelryPage.getDiemontHeartImage());
//Take AddToCart Button Screenshot		
		getWebElementScreenshot(jewelryPage.getAddToCartHeartButton());
//Click on AddToCart Button
		jewelryPage.getAddToCartHeartButton().click();
//Click on Shopping cart link
		jewelryPage.getShoppingCartButton().click();
//Take ShoppingCart Page ScreenShot
		getWebPageScreenshot(driver);

	}

}
