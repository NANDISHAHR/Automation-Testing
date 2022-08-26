import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Democlass {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\eclipse-workspace1\\Hello\\server\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\nandish.h.r\\eclipse-workspace1\\Hello\\server\\geckodriver.exe");
		
		//System.setProperty("webdriver.edge.driver", C:\Users\nandish.h.r\eclipse-workspace1\Hello\server\msedgedriver.exe");
		
		//ChromeDriver driver = new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();
		
		
		driver.get("http://www.google.com");

	}

}
