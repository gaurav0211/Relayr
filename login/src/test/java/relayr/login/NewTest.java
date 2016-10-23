package relayr.login;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {
	static String driverPath = "C:\\Users\\gaurav\\workspace\\login\\";
	public String appURL="https://stackoverflow.com";
	public static WebDriver driver;
	public String message="";
		
 @BeforeClass
  public void setup() throws Exception {
	 System.setProperty("webdriver.chrome.driver", driverPath
			+ "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
  }
 @Test(priority=3)
 public void positiveTest() throws Exception {
	 	driver.findElement(By.id("email")).sendKeys("gaurav.scorpio.86@gmail.com");
	 	driver.findElement(By.id("password")).sendKeys("abcxyz123");
	 	driver.findElement(By.id("submit-button")).submit();
	 	Assert.assertTrue(driver.getPageSource().contains("GauravTest"));
 }
 
 @Test(priority=0)
 public void negativeTestEmptyMail() throws Exception{
	 	Assert.assertEquals("Stack Overflow", driver.getTitle()); //Verifying correct page is loaded
	 	driver.findElement(By.linkText("log in")).click();
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	driver.findElement(By.id("email")).sendKeys("");
	 	driver.findElement(By.id("password")).sendKeys("abcxyz123");
	 	driver.findElement(By.id("submit-button")).submit();
	 	message=driver.findElement(By.className("message-text")).getText();
	 	Assert.assertEquals(message, "Email cannot be empty.");
}
 @Test(priority=1)
 public void negativeTestEmptyPassword() throws Exception{
	 	Assert.assertEquals("Stack Overflow", driver.getTitle()); //Verifying correct page is loaded
	 	driver.findElement(By.linkText("log in")).click();
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	driver.findElement(By.id("email")).sendKeys("gaurav.scorpio.86@gmail.com");
	 	driver.findElement(By.id("password")).clear();
	 	driver.findElement(By.id("submit-button")).submit();
	 	message=driver.findElement(By.className("message-text")).getText();
	 	Assert.assertEquals(message, "Password cannot be empty.");
}
 
 @Test(priority=2)
 public void negativeTestInvalidMail() throws Exception{
	 	Assert.assertEquals("Stack Overflow", driver.getTitle()); //Verifying correct page is loaded
	 	driver.findElement(By.linkText("log in")).click();
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	driver.findElement(By.id("email")).sendKeys("gaurav.scorpio.86gmail.com");
	 	driver.findElement(By.id("password")).clear();
	 	driver.findElement(By.id("submit-button")).submit();
	 	message=driver.findElement(By.className("message-text")).getText();
	 	Assert.assertEquals(message, "The email is not a valid email address.");
}

  @AfterClass
  public void close() throws Exception {
	  driver.quit();
  }

}
