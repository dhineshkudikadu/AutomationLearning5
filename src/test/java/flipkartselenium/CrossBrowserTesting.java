package flipkartselenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting 
{
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void cross( String browsrer) throws InterruptedException
	{
		if (browsrer.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		} 
		else if (browsrer.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		}
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.quit();
	}
		
//		@AfterMethod
//		public void tearDown()
//		{
//				driver.quit();	
//		}
}
