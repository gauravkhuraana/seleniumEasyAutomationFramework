package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class alertsAndModals {

	
	public static class bootstrapModalDemo
	{
		public static WebElement singleModal(WebDriver drv)
		{
			return drv.findElement(By.xpath("(//div[@class='panel-body']/a[text()='Launch modal'])[1]"));
		}
		public static WebElement multipleModal(WebDriver drv)
		{
			return drv.findElement(By.xpath("(//div[@class='panel-body']/a[text()='Launch modal'])[2]"));
		}
		public static WebElement close(WebDriver drv)
		{
			return drv.findElement(By.xpath("//*[text()='Close']"));
		}
		public static WebElement saveChanges(WebDriver drv)
		{
			return drv.findElement(By.xpath("//*[text()='Save changes']"));
		}
		public static WebElement modalTitle(WebDriver drv)
		{
			return drv.findElement(By.className("modal-title"));
		}
		public static WebElement modalBody(WebDriver drv)
		{
			return drv.findElement(By.className("modal-body"));
		}
	}
	
}
