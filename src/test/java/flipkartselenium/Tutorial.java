package flipkartselenium;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tutorial
{
	@Test(priority = 4)
	public void brwser() throws IOException
	
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.hotstar.com/in/explore");
			TakesScreenshot take=(TakesScreenshot)driver;
			File src=take.getScreenshotAs(OutputType.FILE);
			File des=new File("./Screenshot.PNG");
			FileHandler.copy(src, des);
		WebElement ele=	driver.findElement(By.id("searchBar"));
		File src1=ele.getScreenshotAs(OutputType.FILE);
		File des1=new File("./Screenshot/first.PNG");
		FileHandler.copy(src1, des1);
			driver.quit();
			
	}
	//JavaScript popup's
	@Test(priority = 3, invocationCount = 5, enabled = true)
	public void popUps() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://demo.automationtesting.in/Alerts.html");
			//Alert popup's
//			driver.findElement(By.xpath("//button[@onclick='alertbox()']  ")).click();
//			driver.switchTo().alert().accept();
			//confirmation popup's
//			driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
//			driver.findElement(By.xpath("(//button[contains(text(),'click the button')])[2]")).click();
//			driver.switchTo().alert().dismiss();
			//Prompt popup's
			driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
			driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
			driver.switchTo().alert().sendKeys("hello dinesh");	
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.quit();
	}
	//File upload popup's
	@Test
	public void fileUpload()
	{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://smallpdf.com/word-to-pdf");
			File fis =new File("./Screenshot.PNG");
				String path	=fis.getAbsolutePath();
				System.out.println(path);
				//driver.findElement(By.xpath("//span [contains(text(),'Choose Files')]")).sendKeys(path);
				driver.quit();
	}
	@Test(priority = 2)
	public void driverSize()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//set the size of the window
		Dimension dim=new Dimension(400, 500);
		driver.manage().window().setSize(dim);
		//to set the position of the window
		Point p =new Point(250,250);
		driver.manage().window().setPosition(p);
	}
	@Test(priority = 1)
	public void robotClass() throws AWTException, InterruptedException
	{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://smallpdf.com/word-to-pdf");
		List<WebElement> tags=driver.findElements(By.tagName("a"));
		System.out.println(tags.size());
//		for (WebElement webElement : tags) 
//		{
//			System.out.println(webElement.getAttribute("href"));
//		}  
		
	}
	@Test(priority = 1)
	public void propertyFile() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		FileInputStream fis =new FileInputStream("./PropertyFile/DataDrivenProperties.txt");
		Properties b=new Properties();
		b.load(fis);
		String url=	b.getProperty("url");
		driver.get(url);	
	}
	
	@Test 
	private void excelFile() throws EncryptedDocumentException, IOException
	{
		
			FileInputStream fis =new FileInputStream("./ExcelFile/worksheet.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
//			System.out.println(wb.getSheet("Sheet1").getRow(0).getCell(0).toString());	
			Sheet sheet=wb.getSheet("Sheet1");
			System.out.println(sheet);
			int row	=sheet.getPhysicalNumberOfRows();
			System.out.println(row);
			int cells=sheet.getRow(0).getPhysicalNumberOfCells();
			for (int i = 1; i <row; i++) 
			{
				for (int j = 0; j <cells; j++) 
				{
					try {
					String value=	wb.getSheet("Sheet1").getRow(i).getCell(j).toString();
					System.out.println("value "+ value);
						
					} catch (NullPointerException e) 
					{
						
					}
				}
			}
	}
	

}
