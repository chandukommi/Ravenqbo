package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonSteps;

public class HomePage extends CommonSteps {
	
	//CommonSteps cs = new CommonSteps(); 
	private WebDriver driver;
	
	//FindBy locators
	
	@FindBy(xpath = "//h1[@class='title home-title' and contains(text(), \"Hello\")]")
	private WebElement DashboardText;
	
	//Constructor
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions to be performed on login page
	
	public String verifyDashboardText() {
		//waitForElementtoVisible(5, DashboardText);
		return DashboardText.getText();
	}

}
