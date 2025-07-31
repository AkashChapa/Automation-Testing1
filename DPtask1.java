package Datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DPtask1 {

	public static void main(String[] args) {

		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		
		//26/09/2024
		String curyear = driver.findElement(By.className("ui-datepicker-year")).getText();//2025
		String curmonth = driver.findElement(By.className("ui-datepicker-month")).getText();//july
		
		String expdate = "26";
		String expmonth = "September";
		String expyear = "2024";
				
		
		while(!(curmonth.equals(expmonth) && curyear.equals(expyear))) {
			
		
			
			driver.findElement(By.xpath("//a[@data-handler=\"prev\"]")).click();
			curyear = driver.findElement(By.className("ui-datepicker-year")).getText();//2025
			curmonth = driver.findElement(By.className("ui-datepicker-month")).getText();//july
			
		}
		driver.findElement(By.xpath("//td[@data-handler=\"selectDay\"]/a[contains(text(),'20')]")).click();
		System.out.println(curyear);
		
		
	}

}
