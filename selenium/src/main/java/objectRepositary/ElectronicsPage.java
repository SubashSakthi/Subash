package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {
	// constructor
	public ElectronicsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement electronicsText;
	
	@FindBy(xpath = "(//a[@href='/cell-phones'])[4]")
	private WebElement cellphoneLink;

	public WebElement getElectronicsText() {
		return electronicsText;
	}

	public void setElectronicsText(WebElement electronicsText) {
		this.electronicsText = electronicsText;
	}

	public WebElement getCellphoneLink() {
		return cellphoneLink;
	}
	
}
