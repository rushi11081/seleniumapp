package sample;

import java.io.FileInputStream;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Title 
{
	WebDriver driver;
//	String browserName=null;
//	static Properties prop;
	@BeforeTest
	public void setup()
	{
		
	//prop =new Properties(); 
      //  FileInputStream fis = new FileInputStream("./src/test/java/config.properties");
      //  prop.load(fis);
      //  String browserName = prop.getProperty("browser");
        
        
//        if(browserName.equals("chrome"))
//        {
//            //System.setProperty("webdriver.chrome.driver", "./Drivers/chrome/chromedriver.exe");
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.get("https://www.amazon.com");
//        }
//        else if(browserName.equals("firefox"))
//        {
//            WebDriverManager.firefoxdriver().setup();
//            //System.setProperty("webdriver.gecko.driver", "./Drivers/firefox/geckodriver.exe");
//            driver = new FirefoxDriver();
//            driver.get("https://www.amazon.com");
//        }
//		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
	}
	
	@Test
	
	public void titlecheck()
	{	
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String test="Amazon.com. Spend less. Smile more.";
	
		Assert.assertEquals(title, test);
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
	}
	
	
	
	
	@Test
	public void checkurl()
	{
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/");
	}
	
	
	@AfterTest
	public void end()
	{
		
		driver.close();
	}
	
}
