package flipkartselenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClass 
{
	@Test
	public void data() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		FileInputStream fis =new FileInputStream("./PropertyFile/DataDrivenProperties.txt");
		Properties p=new Properties();
		p.load(fis);
		String str=	p.getProperty("url");
		System.out.println(str);
		driver.get(str);	
	}
	
}
