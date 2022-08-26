package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingauthentiationDemo {

	public static String usename = "admin"; //Reading thing this  from external xls or csv
	public static String password = "admin";//Reading thing this  from external xls or csv
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandish.h.r\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//driver.get("https://admin:admin@the-internet.herikuapp.com/basic_auth");
		driver.manage().window().maximize();
		driver.get("https://"+ usename+":"+ password +"@the-internet.herikuapp.com/basic_auth");
		//https://admin:admin@the-internet.herikuapp.com/basic_auth
		

	}

}
