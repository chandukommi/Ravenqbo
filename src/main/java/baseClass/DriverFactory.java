package baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	/**
	 * Thread local driver is used to maintain synchronization in parallel testing.
	 * Below method is used to instantiate thread local driver.
	 * @param browser parameter to pass as a string.
	 * @return this method will return thread local web driver.
	 */
	
	public WebDriver driver;
	
	private static DriverFactory instance = new DriverFactory();

	   public static DriverFactory getInstance()
	   {
	      return instance;
	   }
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_Driver(String browser) {
		System.out.println("browser value is: "+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		
		else {
			System.out.println("Please enter correct browser name");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return getDriver();
		
	}
	
	/**
	 * this method is used to return driver with ThreadLocal driver.
	 * @return web driver
	 */
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public void removeDriver() // Quits the driver and closes the browser
	   {
		 tlDriver.get().quit();
	     tlDriver.remove();
	   } 
	

}
