package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputForms {

	
	public static class SimpleFormDemo
	{
		public static WebElement user_message(WebDriver drv)
		{
			return drv.findElement(By.id("user-message"));
		}
		
		public static WebElement showMessage(WebDriver drv)
		{
			return drv.findElement(By.xpath("//*[text()='Show Message']"));
		}
		public static WebElement yourMessage(WebDriver drv)
		{
			return drv.findElement(By.id("display"));
		}
		public static WebElement formcontrol(WebDriver drv)
		{
			return drv.findElement(By.className("form-control"));
		}

	}
	
	
	

}
