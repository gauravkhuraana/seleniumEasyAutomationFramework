package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class progressBarAndSlider {

	public static class jQueryDownloadPbar
	{
		public static WebElement downloadButton(WebDriver drv)
		{
		return drv.findElement(By.id("downloadButton"))	;
		}
		public static WebElement closeButton(WebDriver drv)
		{
		return drv.findElement(By.xpath("//button[text()='Close']"))	;
		}
		public static WebElement cancelDownload(WebDriver drv)
		{
		return drv.findElement(By.xpath("//button[text()='Cancel Download']"))	;
		}
		
	}
	public static class bootstrapDownload
	{
		public static WebElement downloadButton(WebDriver drv)
		{
		return drv.findElement(By.id("cricle-btn"))	;
		}
		
		public static WebElement percenttext(WebDriver drv)
		{
		return drv.findElement(By.className("percenttext"))	;
		}
		
		
	}
	public static class dragAndDropRangeSlider
	{
		public static WebElement downloadButton(WebDriver drv)
		{
		return drv.findElement(By.id("cricle-btn"))	;
		}
		
	}
}
