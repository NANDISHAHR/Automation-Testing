import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertsdemo {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

		// simple alert
		driver.findElement(By.name("alert")).click();
		Alert simple_alert = driver.switchTo().alert();
		System.out.println(simple_alert.getText());
		Thread.sleep(3000);
		simple_alert.accept();
		Thread.sleep(3000);

		// Confirmation Alert

		driver.findElement(By.name("confirmation")).click();
		Alert confirmation_alert = driver.switchTo().alert();
		System.out.println(confirmation_alert.getText());
		Thread.sleep(3000);
		// confirmation_alert.accept();
		confirmation_alert.dismiss();
		Thread.sleep(3000);
		
		//promt
		
		driver.findElement(By.name("prompt")).click();
		Alert promot_alert = driver.switchTo().alert();
		System.out.println(promot_alert.getText());
		promot_alert.sendKeys("TEST");
		promot_alert.accept();
		driver.quit();

	}

}
