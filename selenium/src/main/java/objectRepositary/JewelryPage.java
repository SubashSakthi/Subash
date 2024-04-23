package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JewelryPage {
	public JewelryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement jewelryText;

	@FindBy(xpath = "(//input[@type='button'])[3]")
	private WebElement addToCartHeartButton;

	@FindBy(xpath = "//img[@alt='Picture of Black & White Diamond Heart']")
	private WebElement diemontHeartImage;

	@FindBy(xpath = "//span[.='Shopping cart']")
	private WebElement shoppingCartButton;

	@FindBy(xpath = "(//input[@type='button'])[3]")
	private WebElement addToCartScrollButton;

	public WebElement getAddToCartScrollButton() {
		return addToCartScrollButton;
	}

	public WebElement getAddToCartHeartButton() {
		return addToCartHeartButton;
	}

	public WebElement getShoppingCartButton() {
		return shoppingCartButton;
	}

	public WebElement getDiemontHeartImage() {
		return diemontHeartImage;
	}

	public WebElement getJewelryText() {
		return jewelryText;
	}

}
