package pom;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHp
{
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchTab;
	
	@FindBy(xpath="//span[.='Apple iPhone XR (64GB) - Yellow']")
	private WebElement selectmobile;
	
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	private WebElement price;
	
	public AmazonHp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String val)
	{
		searchTab.sendKeys(val);
		searchTab.sendKeys(Keys.ENTER);
	}
	
	public void selectPhone() throws InterruptedException
	{
		selectmobile.click();
		Thread.sleep(3000);
	}
	
	public String getPrice(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		Set<String> allwindow = driver.getWindowHandles();
		for (String str : allwindow) {
			driver.switchTo().window(str);
			System.out.println(driver.getTitle());
		}
		Thread.sleep(3000);
		String apprice = price.getText();
		return apprice;
	}
	
	
	
	
	
	
	
	
	
}
