package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class OptionsTags {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2-hp/?d=cta-jumbotron-1-freetrial-p_slack");
		driver.manage().window().maximize();
		driver.findElement(By.name("UserFirstName")).sendKeys("Tetsing");
		driver.findElement(By.name("UserLastName")).sendKeys("Test");
		driver.findElement(By.name("UserTitle")).sendKeys("Software");
		//WebElement jobtile = driver.findElement(By.name("UserTitle"));
		//driver.findElement(with(By.tagName("input")).below(jobtile)).click();
		//driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[6]/div[1]/div[2]/div/div/div[2]/div/div/div/form/div[4]/div[1]/div[2]/a")).click();
		driver.navigate().to("https://www.salesforce.com/form/signup/freetrial-elf-v2-hp/?d=cta-jumbotron-1-freetrial-p_slack");
		String windowhandle = driver.getWindowHandle();
		List<WebElement> alltags = driver.findElements(By.tagName("option"));
		System.out.println("Total number of all Tags are " +alltags.size());
		
		for(int i=0;i<alltags.size();i++)
		{
			System.out.println("options are" +alltags.get(i).getAttribute("value"));
			System.out.println("Text on page is" +alltags.get(i).getText());
		}
		
		
		driver.quit();

	}

}
