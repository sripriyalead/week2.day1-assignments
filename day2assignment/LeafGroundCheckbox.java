package week2.day2assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckbox {

	public static void main(String[] args) {
		//Browser sEtup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		//Select the languages that you know?
		List<WebElement> language = driver.findElements(By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input"));
		for(int i=0;i<=language.size();i++) {
			language.get(2).click();
			language.get(3).click();
			break;
		}

		//Confirm Selenium is checked
		WebElement sel = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input"));
		if(sel.isSelected())
		{System.out.println("'I am Selected' is selected");
		}else
		{System.out.println("Selenium is not selected");
		}

		//DeSelect only checked
		List<WebElement> deselect = driver.findElements(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input"));
		System.out.println(deselect.size());
		for(int i=0;i<deselect.size();i++)
		{
			boolean boo=deselect.get(i).isSelected();
			System.out.println(boo);
			if(boo==true)
			{
				deselect.get(i).click();
				System.out.println(boo);
				System.out.println("It is Deselected");
			}

		}
		//Select all below checkboxes
		List<WebElement> select = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::input"));
		for(WebElement eachOption:select)
		{
			eachOption.click();
		}
		driver.close();
	}

}
