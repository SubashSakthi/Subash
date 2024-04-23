package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellphonePage {
	// constructor
	public CellphonePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement cellphoneText;
	
	@FindBy(id = "products-orderby")
	private WebElement shortByDropdown;
	
	public WebElement getCellphoneText() {
		return cellphoneText;
	}

	public WebElement getShortByDropdown() {
		return shortByDropdown;
	}
}
