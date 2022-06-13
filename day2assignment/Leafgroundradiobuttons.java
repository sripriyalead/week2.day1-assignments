package week2.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgroundradiobuttons {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Are you enjoying the classes?
		driver.findElement(By.id("yes")).click();

		//Find default selected radio button
		boolean selected = driver.findElement(By.xpath("//input[@value='1' and @name='news']")).isSelected();
		if(selected=true)
		{
			System.out.println("default selectd value is Checked");
		}else
		{
			System.out.println("No default selection");
		}

		//Select your age group (Only if choice wasn't selected)
		WebElement age1 = driver.findElement(By.xpath("//input[@value='0' and @name='age']"));
		WebElement age2 = driver.findElement(By.xpath("//input[@value='1' and @name='age']"));
		WebElement age3 = driver.findElement(By.xpath("//input[@value='2' and @name='age']"));
		if(age1.isSelected())
		{
			System.out.println("Selected age is 1-20 years");
		}else if(age2.isSelected())
		{
			System.out.println("Selected age is 21-40years");
		}else if (age3.isSelected())
		{
			System.out.println("selected age is above 40 years");
		}else
		{
			System.out.println("No default selection");
		}

	}

}


