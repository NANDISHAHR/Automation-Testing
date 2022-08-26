package com.Apache.pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pdfreaderfrominternet {

	@Test
	public void readPDFfile() throws Exception {

		String filetype = "PDF";
		String filesize = "150 KB";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
		driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a")).click();
		Thread.sleep(6000);
		driver.switchTo().frame(driver.findElement(By.id("google_esf")));
		/*
		 * driver.switchTo().frame(driver.findElement(By.id("aswift_5"))); WebElement
		 * frame = driver.findElement(By.id("ad_iframe"));
		 * driver.switchTo().frame(frame);
		 */
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		driver.findElement(By.xpath("//td[text()='" + filetype + "']/following-sibling::td[2]/a")).click();
		driver.findElement(By.xpath("//td[text()='" + filesize + "']/following-sibling::td[4]/a")).click();
		
		String URLstring = driver.getCurrentUrl();
		URL url = new URL(URLstring);
		
		PDDocument pdfdocument =  PDDocument.load(url.openStream());
		System.out.println(pdfdocument.getPages().getCount());
		
		PDFTextStripper pdftextstripper = new PDFTextStripper();
		pdftextstripper.setStartPage(2);
		pdftextstripper.setEndPage(3);
		String documenttext = pdftextstripper.getText(pdfdocument);
		System.out.println(documenttext);
		Assert.assertTrue(documenttext.startsWith("Lorem ipsum"));
		pdfdocument.close();
		driver.quit();

	}

}