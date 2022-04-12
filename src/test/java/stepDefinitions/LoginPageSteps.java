package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseClass.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageSteps{
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	WebDriver driver = DriverFactory.getInstance().getDriver(); 
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.get("https://raven-release.unscrambl.com/chai/#/sign-in/");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is:"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) throws InterruptedException {
		Thread.sleep(5000);
		String title = loginPage.getLoginPageTitle();		
//		Assert.assertTrue(title.contains(expectedTitle));
		Assert.assertTrue(title.equals(expectedTitle));
		
		
	}

	@When("user enters the following credentials for Login")
	public void user_enters_the_following_credentials_for_login(DataTable dataTable) throws InterruptedException {
		List<List<String>> loginDetails = dataTable.asLists(String.class);
		String un = loginDetails.get(1).get(0);
		String pw = loginDetails.get(1).get(1);
		Thread.sleep(10000);
		loginPage.Login(un,pw);
	}

	@Then("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickLogin();
	}
	
	@Then("page should contain {string} text")
	public void page_should_contain_text(String expectedText) {
	    String text = homePage.verifyDashboardText();
	    Assert.assertTrue(text.contains(expectedText));
	}

}
