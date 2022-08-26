package practicetestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAttributes {

	@Test()
	public void Testattribute() throws Exception {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://randomuser.me");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println("User Name: "+ driver.findElement(By.cssSelector("#user_value']")).getText());
		
		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println("EMail Address: "+ driver.findElement(By.id("user_value")).getText());
		driver.quit();
		
	}
	
}
