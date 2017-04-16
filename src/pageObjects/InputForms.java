package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputForms {

	
	public static class singleInputField
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
	
	public static class TwoInputFields
	{
		public static WebElement aValue(WebDriver drv)
		{
			return drv.findElement(By.id("sum1"));
		}
		
		public static WebElement bValue(WebDriver drv)
		{
			return drv.findElement(By.id("sum2"));
		}
		public static WebElement getTotal(WebDriver drv)
		{
			return drv.findElement(By.xpath("//*[text()='Get Total']"));
		}
		public static WebElement displayvalue(WebDriver drv)
		{
			return drv.findElement(By.id("displayvalue"));
		}
	}
	
	public static class BootstrapAlertMessages
	{
		public static WebElement autoclosable_btn_success(WebDriver drv)
		{
			return drv.findElement(By.id("autoclosable-btn-success"));
		}
		
		public static WebElement normal_btn_success(WebDriver drv)
		{
			return drv.findElement(By.id("normal-btn-success"));
		}
		public static WebElement autoclosable_btn_warning(WebDriver drv)
		{
			return drv.findElement(By.id("autoclosable-btn-warning"));
		}
		public static WebElement normal_btn_warning(WebDriver drv)
		{
			return drv.findElement(By.id("normal-btn-warning"));
		}
		public static WebElement autoclosable_btn_danger(WebDriver drv)
		{
			return drv.findElement(By.id("autoclosable-btn-danger"));
		}
		public static WebElement normal_btn_danger(WebDriver drv)
		{
			return drv.findElement(By.id("normal-btn-danger"));
		}
		public static WebElement autoclosable_btn_info(WebDriver drv)
		{
			return drv.findElement(By.id("autoclosable-btn-info"));
		}
		public static WebElement normal_btn_info(WebDriver drv)
		{
			return drv.findElement(By.id("normal-btn-info"));
		}
	}

}
