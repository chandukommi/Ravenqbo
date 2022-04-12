package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	//FindBy Locators
	
	@FindBy(name = "username")
	private WebElement Email;
	
	@FindBy(name = "password")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@class='button is-primary is-fullwidth']")
	private WebElement Loginbtn;
	
	//Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions to be performed on login page
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void Login(String username, String password) {
		Email.sendKeys(username);
		Password.sendKeys(password);
	}
	
	public void clickLogin() {
		Loginbtn.click();
	}
	

}
