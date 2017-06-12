package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class listBox {

	public static class dataListFilter
	{
		public static WebElement searchBox(WebDriver drv)
		{
			return drv.findElement(By.cssSelector("input.form-control"));
		}
		public static List<WebElement> totalItems(WebDriver drv)
		{
			return (List<WebElement>) drv.findElements(By.xpath("//div[@class='searchable-container']/div"));
		}

	}	

}