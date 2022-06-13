package week2.day2assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadweek2day2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID')]/following::label[text() ='First name:']/following-sibling::div/input[@name='firstName']")).sendKeys("Aml");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")).click();
		String eletitle = driver.getTitle();
		if(eletitle.equalsIgnoreCase("View Lead | opentaps CRM"))
		{
			System.out.println("Pass");
			System.out.println("Title is "+eletitle);
		}
		else
		{
			System.out.println("fail");
			System.out.println("Title is "+eletitle);
		}

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String compname =driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(compname.contains("Testing"))
		{
			System.out.println("Updated Company Name case- Pass" +compname);

		}
		else
		{
			System.out.println("Updated Company Name case- Fail" +compname);
		}
		driver.close();

	}

}
