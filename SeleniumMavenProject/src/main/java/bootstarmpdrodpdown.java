import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bootstarmpdrodpdown {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.att.com/mydatarequest/");
		
		//driver.findElement(By.xpath("//button[@aria-autocomplete='list']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.evaluate(\"//button[@aria-autocomplete='list']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.click();");
		js.executeScript("window.scrollBy(0,500)");
		List<WebElement> States = driver.findElements(By.xpath("//div[@class='optionWrapper open _2OEMw overflow-y-scroll']/button"));
		

		for (WebElement state : States) {
			
			String statename = state.getText();
			System.out.println(state.getText());
			if(statename.equals("Wyoming")) {
				//state.click();
				js.executeScript("arguments[0].click()",state );
				break;
			}
		}
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[@aria-label='Continue']")).click();
		//driver.findElement(By.xpath("//a[text()='Get report']")).click();
		
		js.executeScript("document.getElementsByClassName(\"btn btn-arrow color-ui-white\")[1].click()");
		//driver.findElement(By.xpath("//a[text()='Wireless or home services from AT&T  >']")).Click();
		
		List<WebElement> services = driver.findElements(By.cssSelector("div.row>div>div>div>div>span>a"));
		
		for (WebElement service : services) {
			//System.out.println(service);
			String servicelist = service.getText();
			System.out.println(servicelist);
			System.out.println(service.getAttribute("href"));
			
			if(servicelist.equals("No services from AT&T or DIRECTV in the past 12 months")) {
				js.executeScript("window.scrollBy(0,1100)");
				//service.click();
				js.executeScript("arguments[0].click()",service );
				break;
				
			}	
		}
		driver.findElement(By.id("emailTextField")).sendKeys("dl-dl_ccpa_uf5@att.com");
		driver.findElement(By.xpath("//button[@title='Continue']")).click();
		driver.findElement(By.linkText("Back to datarequest")).click();
		driver.quit();
	}

}
