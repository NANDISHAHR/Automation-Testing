package com.Ex2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");

		
		  WebElement stateElements = driver.findElement(By.id("oldSelectMenu"));
		  
		  Select statename_DD = new Select(stateElements);
		  statename_DD.selectByIndex(0);
		  
		  Thread.sleep(3000); statename_DD.selectByValue("3");
		  
		  Thread.sleep(3000); statename_DD.selectByVisibleText("Purple");
		 

		WebElement CarElements = driver.findElement(By.id("cars"));
		
		Select carname = new Select(CarElements);
		Thread.sleep(3000);
		carname.selectByIndex(0);
		Thread.sleep(3000);
		carname.selectByValue("opel");;
		Thread.sleep(3000);
		carname.selectByVisibleText("Audi");
		
		/*
		 * Thread.sleep(3000);
		 * 
		 * carname.deselectByIndex(0); Thread.sleep(3000);
		 * carname.deselectByValue("opel"); Thread.sleep(3000);
		 * carname.deselectByVisibleText("Audi");
		 */
		List<WebElement> state =  statename_DD.getOptions();
		System.out.println("States Available::");
		for (WebElement webElement : state) {
			System.out.println(webElement.getText());
			
		}
		System.out.println("First Selected options::");
		System.out.println(statename_DD.getFirstSelectedOption());
		
		List<WebElement> Cars =  carname.getAllSelectedOptions();
		System.out.println("Cars Available::");
		for (WebElement webElement : Cars) {
			System.out.println(webElement.getText());
			
		}
		System.out.println();
		
	}

}
