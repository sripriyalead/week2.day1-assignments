package week2.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class faceBook {

	public static void main(String[] args) {
		 {
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver= new ChromeDriver();
				driver.get("https://en-gb.facebook.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(By.linkText("Create New Account")).click();
				driver.findElement(By.name("firstname")).sendKeys("Sri");
				driver.findElement(By.name("lastname")).sendKeys("priya");
				driver.findElement(By.name("reg_email__")).sendKeys("sriya.m89@gmail.com");
				driver.findElement(By.id("password_step_input")).sendKeys("Facebook@1431");
				WebElement eleday = driver.findElement(By.id("day"));
				Select dd1=new Select(eleday);
				dd1.selectByValue("19");
				WebElement elemonth = driver.findElement(By.id("month"));
				Select dd2=new Select(elemonth);
				dd2.selectByVisibleText("Nov");
				WebElement eleyear = driver.findElement(By.id("year"));
				Select dd3=new Select(eleyear);
				dd3.selectByIndex(33);
				driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//input[@value='1']")).click();
				driver.findElement(By.xpath("//button[text()='Sign Up']")).click();	
				

	}

}
}
