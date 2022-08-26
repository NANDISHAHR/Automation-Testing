package ui;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtabledemo {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.asx.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"pnProductNavContents\"]/li[2]")).click();
		
		//WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]"));
		//driver.switchTo().frame(frame1);

		// use frame if page contains frames
		// step1 : get the nummber of rows
		// step2 : Get the number of coulumns
		// step3 : iterate through rows and columns and get text and print it

		List<WebElement> rowelement = driver
				.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr"));
		System.out.println(rowelement.size());
		int rowsize = rowelement.size();
		
		List<WebElement> columnelement = driver
				.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[1]/th"));
		System.out.println(columnelement.size());
		int columnsize = columnelement.size();

		for (int i = 2; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
			System.out.print(driver.findElement(
					By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr["+ i +"]/td["+ j +"]"))
					.getText()+"  "); 	
			}
			System.out.println();
		}
	}

}
