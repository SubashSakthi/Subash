package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='/electronics'])[1]")
	private WebElement electronicsLink;

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}
	
	@FindBy(linkText = "BOOKS")
	private WebElement booksLink;

	public WebElement getBooksLink() {
		return booksLink;
	}

	@FindBy(css = "img[alt='Tricentis Demo Web Shop']")
	private WebElement Logo;

	@FindBy(linkText = "Register")
	private WebElement RegisterLink;

	@FindBy(xpath = "//span[.='Wishlist']")
	private WebElement WishListLink;

	@FindBy(id = "small-searchterms")
	private WebElement searchField;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;
	
	@FindBy(linkText = "Digital SLR Camera 12.2 Mpixel")
	private WebElement cameraText;
	
	@FindBy(id = "main-product-img-17")
	private WebElement cameraPicture;
	
	@FindBy(linkText = "JEWELRY")
	private WebElement jewelryLink;
	
	@FindBy(linkText = "COMPUTERS")
	private WebElement computersLink;
	
	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getJewelryLink() {
		return jewelryLink;
	}

	public WebElement getLogo() {
		return Logo;
	}
	
	public WebElement getRegisterLink() {
		return RegisterLink;
	}

	public WebElement getWishListLink() {
		return WishListLink;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCameraText() {
		return cameraText;
	}

	public WebElement getCameraPicture() {
		return cameraPicture;
	}
	

}
