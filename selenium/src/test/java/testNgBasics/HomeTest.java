package testNgBasics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import genericLibrary.BaseClass;
import objectRepositary.HomePage;


public class HomeTest extends BaseClass {
	
	@Test
	public void Home_001() throws IOException {
		String Time = LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
		// object creation
		HomePage home = new HomePage(driver);
		
		//Enter The Product Name
		home.getSearchField().sendKeys("camera");
		
		//click on search button
		home.getSearchButton().click();
		
		//click camera in camera page
		home.getCameraText().click();
		
		// Take Screenshot
		File temp = home.getCameraPicture().getScreenshotAs(OutputType.FILE);
		File permanent = new File("./Screenshots/"+Time+".png");
		FileHandler.copy(temp, permanent);
		
	}
	
}
