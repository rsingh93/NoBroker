package assignment;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NoBrokerTestNG {
	
	public String baseUrl = "https://www.nobroker.in/";
	String driverPath = "E:\\chromedriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
		 
		 System.setProperty("webdriver.chrome.driver", driverPath);
		 driver = new ChromeDriver();
		 driver.get(baseUrl);
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
//	Step 2- Select “Mumbai” city and type “Malad” in the search Box.
	 @Test(priority = 0)
	  public void selectCity() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='form-inline form-group nb-city-selector']")).click();
        driver.findElement(By.xpath("//a[text()='Mumbai']")).click();
        Thread.sleep(3000);
	 }
	 
//   Step 3- Select “MaladEast-Malkani Estate” and “Malad west-Sundar Ln” from the drop down.
	 @Test(priority = 1)
	  public void selectArea() throws InterruptedException {
        driver.findElement(By.xpath("//input[@class='form-control input-home-search']")).sendKeys("malad");
        driver.findElement(By.xpath("//div[.='Malad East - Malkani Estate']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='form-control input-home-search']")).sendKeys("malad");
		driver.findElement(By.xpath("//div[.='Malad west - Sundar Ln']")).click();
		Thread.sleep(3000);
	 }
	 
//		Step 4 - Click on the Search button after selecting 2 Bhk and 3 Bhk from the BHK types.
	 @Test(priority = 2)
	  public void selectBhk() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='nbBHKSelector']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='nbBHKSelector']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//span[@id='searchButtonHomePage']")).click();
	 }
	 
//   Step 5 - Scroll down on the Property listing page and click on the 4th property.
	 @Test(priority = 3)
	  public void selectCProperty() {
        driver.findElement(By.xpath("//div[@id='prop-8a9f91ba745ca54b01745e04de801abc']")).click();
        
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
       
	 }
	 
//   Step 6 - Inside of the 4th property scroll down and check “description” related section is there or not.
	 @Test(priority = 4)
	  public void checkDescription() {
        {
        if( driver.findElement(By.xpath("//span[text()='Description']")).isDisplayed()){
        	System.out.println("Test Case is Passed");
        	}else{
        	System.out.println("Test Case is Failed");
        	}
                }
	 }
	  @AfterTest
	  public void terminateBrowser() {
		  driver.close();
	  }
		  }
				 
