package week2.day2assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLinks {

	public static void main(String[] args) {
		//Browser setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Go to Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		
		//Find where am supposed to go without clicking me?
		driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		
		//Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		if(driver.getTitle().contains("404"))
		{
			System.out.println("Link is broken");
		}else
		{
			System.out.println("Not");
		}
		driver.navigate().back();
		
		//Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();                  
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		
		//how many links
		List<WebElement> Elements = driver.findElements(By.tagName("a"));
		System.out.println(Elements.size());
		}
		

	}

