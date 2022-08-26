package practicetestng;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRMtestng {
	WebDriver driver;

	@Test(priority = 1)
	public void lunchapp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 2)
	public void loginorangeHRM() throws Exception {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.tagName("button")).click();
	}

	@Test(priority = 3)
	public void myinfo() {
		driver.findElement(By.xpath("//div[@Class='oxd-topbar-header-title']/i")).click();
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active toggle']")).click();

	}

	@Test(priority = 4)
	public void verifymyinfo() {
		boolean actaualvalue = driver.findElement(By.xpath("//h6[text()='Performance Test']")).isDisplayed();
		Assert.assertTrue(actaualvalue);
	}

	@Test(priority = 5)
	public void verifylogin() throws Exception {
		WebElement element = driver.findElement(By.xpath("//h6[text()='PIM']"));
		assertTrue(element.isDisplayed());
		Thread.sleep(3000);
		assertTrue(element.getText().contains("PIM"));
		driver.quit();
	}
	
}
