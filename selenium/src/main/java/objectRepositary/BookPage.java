package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends BasePage {

	public BookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "products-orderby")
	private WebElement sortbyDropDown;
	
	@FindBy(id = "products-pagesize")
	private WebElement displayDropDown;
	
	@FindBy(id = "products-viewmode")
	private WebElement viewAsSropDown;


	public WebElement getSortbyDropDown() {
		return sortbyDropDown;
	}

	public WebElement getDisplayDropDown() {
		return displayDropDown;
	}

	public WebElement getViewAsSropDown() {
		return viewAsSropDown;
	}
}
