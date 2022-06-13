package week2.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImages {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on this image to go home page
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
		driver.navigate().back();
		
		//Am I Broken Image?
		String attribute = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img")).getAttribute("src");
		driver.get(attribute);
		String title = driver.getTitle();
		if(title.contains("404"))
		{
			System.out.println("Image is Broken");

		}else
		{
			System.out.println("Image is not broken");
		}
		driver.navigate().back();
		
		//Click me using Keyboard or Mouse
		Actions builder=new Actions(driver);
		WebElement img = driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"));
		builder.moveToElement(img).click().perform();
		//img.sendKeys(Keys.ENTER);
	
		
	}

}

