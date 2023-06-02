package amazon.com;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentAmazon 
{

	WebDriver driver;
	Select s;
	Logger log= Logger.getLogger("amazon");
	
	@BeforeMethod
	public void setUp() throws IOException
	{

		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		PropertyConfigurator.configure("log4j.properties");
		log.info("browser is opened");
		
		driver.manage().window().maximize();
		log.info("browser is maximized");
		
		driver.get("https://www.amazon.in/");
		log.info("amazon URL is opened");
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("mayursurwase57@gmail.com");
		log.info("entered email ID");
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("7028069157");
		log.info("entered password");

		
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		log.info("Click on sign in button");
		ScreenshotClass.takeScreenshot(driver);


	}
	
	@Test
	public void verifyLoginFunctionality() throws InterruptedException, IOException
	{
				
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("i photo 14 pro max 128");
		log.info("Text enterd in search box text");

		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		log.info("Clicked on search icon");
		
		WebElement resultfor = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
		String expectedresult = "i photo 14 pro max 128";
		String actualresult = resultfor.getText();
		String actualresult1 = actualresult.replace('"', ' ').trim();
		
		Assert.assertEquals(actualresult1, expectedresult);
		ScreenshotClass.takeScreenshot(driver);
		log.info("Verifying search box actual result and expected result");


		
		
		driver.findElement(By.xpath("//*[@id=\"p_36/1318507031\"]/span/a/span")).click();
		log.info("select the price renge over 20000");

		
		List<WebElement> allProductsprice = driver.findElements(By.xpath("//*[@class='a-price-whole']"));
		for(int i=0;i<allProductsprice.size();i++)
		{
			String price = allProductsprice.get(i).getText();
			
		}
		
		ScreenshotClass.takeScreenshot(driver);
		driver.findElement(By.xpath("//*[text()='Apple iPhone 14 Pro Max (128 GB) - Space Black']")).click();
		log.info("Click on the Apple iPhone 14 Pro Max (128 GB)");

		
		List<String> address1 = new ArrayList <String>(driver.getWindowHandles());
		driver.switchTo().window(address1.get(2));
		String actualtitle = driver.getTitle();
		String expectetitle = "Apple iPhone 14 Pro Max (128 GB) - Space Black : Amazon.in: Electronics";
		Assert.assertEquals(actualtitle, expectetitle);
		ScreenshotClass.takeScreenshot(driver);

		
		driver.findElement(By.xpath("//*[@id=\"a-autoid-16-announce\"]/div/div[1]/p")).click();
		log.info("Changed the size 128GB to 256 GB");
		Thread.sleep(2000);
		ScreenshotClass.takeScreenshot(driver);
		WebElement Selectedprodutprice = driver.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[1]/span[2]/span[2]"));
		String productprice = Selectedprodutprice.getText();

		driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
		log.info("Click on add to cart");
		Thread.sleep(2000);

		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input"));
		checkout.click();
		log.info("Click on checkout button");
		ScreenshotClass.takeScreenshot(driver);

	
		driver.findElement(By.xpath("//*[@id='add-new-address-popover-link']")).click();
		log.info("Click on add new address button");

		
		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressFullName']")).sendKeys("Mayur Surwase");
		log.info("entered Full Name");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("7028069157");
		log.info("entered Phone Number");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("411033");
		log.info("entered Postal Code");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("Near Ganpati Mandir Ganesh Nagar, Dange Chowk, Pune");
		log.info("entered Address Line 1");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressLine2']")).sendKeys("Near Ganpati Mandir Ganesh Nagar, Dange Chowk, Pune");
		log.info("entered Address Line 2");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-landmark']")).sendKeys("Near Ganpati Mandir Ganesh Nagar, Dange Chowk, Pune");
		log.info("entered landmark");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressCity']")).sendKeys("PIMPRI CHINCHWAD");
		log.info("entered Address City");


		
		WebElement State = driver.findElement(By.xpath("//*[@name='address-ui-widgets-enterAddressStateOrRegion']"));
		s = new Select(State);
		s.selectByVisibleText("MAHARASHTRA");
		log.info("Select State");

		ScreenshotClass.takeScreenshot(driver);
		WebElement usethisadress = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input"));
		usethisadress.click();
		log.info("Click on use this address button");		
		
		driver.findElement(By.xpath("//*[contains(@id,'-94')]")).click();
		log.info("Select payment method Pay with Debit/Credit/ATM Cards ");		

		driver.findElement(By.xpath("//*[contains(@id,'-97')]")).click();
		log.info("Click on enter card details");		
		WebElement frame = driver.findElement(By.xpath("//*[contains(@id,'-98')]"));
		driver.switchTo().frame(frame);


		WebElement Cardnumber = driver.findElement(By.xpath("//*[@id='a-popover-1']//*[@id='a-popover-content-1']//*[contains(@id,'-15')]"));
		Cardnumber.sendKeys("6522623015138238");
		log.info("enter card number");		

		WebElement date = driver.findElement(By.xpath("//*[contains(@id,'-18')]"));
		
		s = new Select(date);
		s.selectByVisibleText("06");
		log.info("Select card Expiry date");		


		WebElement year = driver.findElement(By.xpath("//*[contains(@id,'-20')]"));

		s = new Select(year);
		s.selectByVisibleText("2025");
		log.info("Select card Expiry year");		

		ScreenshotClass.takeScreenshot(driver);
		driver.findElement(By.xpath("//*[contains(@id,'-25')]")).click();
		log.info("Click on enter card details button");		

		driver.switchTo().defaultContent();
		
		WebElement frame1 = driver.findElement(By.xpath("//*[contains(@id,'-112')]"));
		frame1.isEnabled();
		frame1.click();
		frame1.sendKeys("578");	
		log.info("enter card CVC Number");		

		ScreenshotClass.takeScreenshot(driver);
		driver.findElement(By.xpath("//*[contains(@id,'-171')]/span/input")).click();
		log.info("Click on use thes payment method button");
		
		
		String checkoutactualtitle = driver.getTitle();
		String checkoutexpectetitle = "Amazon.in Checkout";
		Assert.assertEquals(checkoutactualtitle, checkoutexpectetitle);
		log.info("Verifying the checkout page title");

		



	}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
	       
		}

	


}
