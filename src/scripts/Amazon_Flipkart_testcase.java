package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pom.AmazonHp;
import pom.FlipkartHp;

public class Amazon_Flipkart_testcase
{
	@Test
	public void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"./softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		AmazonHp ap = new AmazonHp(driver);
		ap.searchProduct("Iphone xr 64gb yellow ");
		ap.selectPhone();
		double aPrice=0.00;
		try
		{
		String apprice = ap.getPrice(driver).substring(1);
		System.out.println(apprice);
		aPrice = Double.parseDouble(apprice);
		System.out.println(aPrice);
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		
		driver.get("https://www.flipkart.com");

		FlipkartHp fp = new FlipkartHp(driver);
		fp.clickClose();
		fp.searchProduct("Iphone xr 64gb yellow");
		fp.selectPhone();
		double fPrice=0.00;
		try
		{
		String fkprice = fp.getPrice(driver).substring(1);
		System.out.println(fkprice);
		 fPrice = Double.parseDouble(fkprice);
		System.out.println(fPrice);
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		if(aPrice>fPrice)
		{
			System.out.println("purchase in flipkart");
		}
		else
		{
			System.out.println("purchase in amazon");
		}
	}

	
	
	
	
	
	
	
	
	
}
