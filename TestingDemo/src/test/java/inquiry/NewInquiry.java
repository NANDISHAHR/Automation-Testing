package inquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewInquiry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://e-tst3.stage.att.com/mydatarequest/");
		driver.findElement(By.linkText("Submit an inquiry")).click();
		driver.findElement(By.xpath("//*[@id=\"SELECT_SERVICES1\"]/div/div/div/div/div[1]/span/a")).click();
		driver.findElement(By.id("what-issue-are-you-having")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[2]/div/div[2]/div/div/div/div/div/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"32ee88a9-04ec-1757-12c8-ab552262fc21\"]")).sendKeys("test");
		driver.findElement(By.id("firstName")).sendKeys("TEST");
		driver.findElement(By.id("lastName")).sendKeys("TESTREQUEST");
		driver.findElement(By.id("phoneNumber")).sendKeys("1231231231");
		driver.findElement(By.id("alternatePhoneNumber")).sendKeys("2342342342");
		driver.findElement(By.id("emailAddress")).sendKeys("dl_ccpa_uf1@list.att.com");
		driver.findElement(By.id("confirmEmailAddress")).sendKeys("dl_ccpa_uf1@list.att.com");
		driver.findElement(By.id("line1")).sendKeys("TEST");
		driver.findElement(By.id("line2")).sendKeys("TEST1");
		driver.findElement(By.id("city")).sendKeys("Los Angeles");
		driver.findElement(By.id("state")).click();
		driver.findElement(By.xpath("//*[@id=\"state\"]/text()")).click();
		driver.findElement(By.id("zipCode")).sendKeys("90007");
		driver.findElement(By.xpath("//*[@id=\"language\"]")).click();
		
		
		
	}

}
