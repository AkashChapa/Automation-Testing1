package Datepicker;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DPEx2 {	
		
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.makemytrip.com/");
			Thread.sleep(5000);	
			driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
			WebElement e = driver.findElement(By.xpath("//input[@id='departure']"));

			Actions ac=new Actions(driver);
			ac.moveToElement(e).click().build().perform();

			String expected_month="June";
			String expected_year="2026";
			String expected_date="4";


			WebDriverWait wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			String actual_month =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")))).getText();

			String[] mon_Year=actual_month.split(" ");

			String act_month=mon_Year[0];
			String act_year=mon_Year[1];

			while(true) {

				if(act_year.equals(expected_year) && act_month.equals(expected_month)) {

					 

						List<WebElement> dates=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div/p[1]"));

						for(WebElement d:dates) {
							if(d.getText().equals(expected_date)) {
								d.click();
								return;
							}
						}
					}
				else {
					driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/span[2]")).click();
					actual_month =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")))).getText();
					mon_Year=actual_month.split(" ");
					act_month=mon_Year[0];
					act_year=mon_Year[1];
					}
			}

		}
	}
