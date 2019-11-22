package pom;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHp 
{
	@FindBy(xpath = "//button[.='✕']")
	private WebElement close;

	@FindBy(name = "q")
	private WebElement searchTab;

	@FindBy(xpath = "//div[.='Apple iPhone XR (Yellow, 64 GB)']")
	private WebElement appleMobile;

	@FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
	private WebElement price;
	
	public FlipkartHp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickClose()
	{
		close.click();
	}
	
	public void searchProduct(String val)
	{
		searchTab.sendKeys(val);
		searchTab.sendKeys(Keys.ENTER);
	}
	
	public void selectPhone() throws InterruptedException
	{
		Thread.sleep(2000);
		appleMobile.click();
		Thread.sleep(3000);
	}
	
	public String getPrice(WebDriver driver) throws InterruptedException
	{
		Set<String> allwindow = driver.getWindowHandles();
		for (String str : allwindow) {
			driver.switchTo().window(str);
		}
		Thread.sleep(2000);
		String fkprice = price.getText();
		return fkprice;
	}
	
	
	
	
}
