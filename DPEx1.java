package Datepicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DPEx1 {

				public static void main(String[] args) throws Exception {
				// TODO Auto-generated method stub

				WebDriver driver= new ChromeDriver();
				
				driver.manage().window().maximize();
				
				driver.get("https://jqueryui.com/datepicker/");
				driver.switchTo().frame(0);
				 WebElement typeddate = driver.findElement(By.id("datepicker"));
				// typeddate.sendKeys("03/07/2025");
				 typeddate.click();
				 String curmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
				 String curyear = driver.findElement(By.className("ui-datepicker-year")).getText();
				 
				 String expdate = "18";
				 String expmonth = "July";
				 String expyear = "2020";
				 
				
				 while(!(curmonth.equals(expmonth)&&curyear.equals(expyear))) 
				 {
						 driver.findElement(By.xpath("//a[@data-handler=\"prev\"]")).click();
						//driver.findElement(By.xpath("//a[@data-handler=\"next\"]")).click();
						 
						 curmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
						 curyear = driver.findElement(By.className("ui-datepicker-year")).getText();
						
					
								 
					 
				 }
				 driver.findElement(By.xpath("//td[@data-handler=\"selectDay\"]/a[contains(text(),'18')]")).click();
				 System.out.println(curyear);
				 System.out.println(curmonth);
				 System.out.println(expdate);
				 
				 
				
				
				
			}


}
