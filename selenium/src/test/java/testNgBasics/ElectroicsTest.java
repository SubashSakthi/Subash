package testNgBasics;


import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectRepositary.CellphonePage;
import objectRepositary.ElectronicsPage;
import objectRepositary.HomePage;

public class ElectroicsTest extends BaseClass {
	@Test
	public void electronics_cellphone_001(){
		HomePage home = new HomePage(driver);
		ElectronicsPage electronic = new ElectronicsPage(driver);
		CellphonePage cell = new CellphonePage(driver);
		
		// click on electronic link
		home.getElectronicsLink().click();
		
		// Verify Electronics page is displayed
		Assert.assertEquals(electronic.getElectronicsText().getText(), "Electronics","Electronics page is not Displayed");
		Reporter.log("Electronics page is Dispalyed",true);
		
		// click on cell phone link
		electronic.getCellphoneLink().click();
		
		// Verify Cell phone page is Displayed
		Assert.assertEquals(cell.getCellphoneText().getText(), "Cell phones","Cell phones Page is not Displayed");
		Reporter.log("Cell phones page is Dispalyed",true);
		
		// sort the options by Name A to Z
		Select select = new Select(cell.getShortByDropdown());
		select.selectByIndex(1);
		
		// sort by options by Name Z to A
		select.selectByIndex(2);
	
	}
}
