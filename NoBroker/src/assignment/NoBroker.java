package assignment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class NoBroker {
	 WebDriver driver;
	  @BeforeTest
	  
	  public void setUp()  {
		  
		  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		  
		  driver = new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		  driver.get("https://www.nobroker.in/");
		  
		// Step 2- Select “Mumbai” city and type “Malad” in the search Box.
          driver.findElement(By.xpath("//div[@class='form-inline form-group nb-city-selector']")).click();
          driver.findElement(By.xpath("//a[text()='Mumbai']")).click();
          WebElement location = driver.findElement(By.xpath("//input[@class='form-control input-home-search']"));
		  location.sendKeys("malad");
		  
}
	  
}