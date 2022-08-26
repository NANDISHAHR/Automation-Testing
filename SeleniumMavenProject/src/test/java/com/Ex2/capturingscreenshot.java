package com.Ex2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.internal.Utils;

public class capturingscreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com");

		driver.findElement(By.id("navbtn_tutorials")).click();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("./Screenshot/image.png"));

		String base64code = ts.getScreenshotAs(OutputType.BASE64);
		byte[] bytearr = Base64.getDecoder().decode(base64code);

		FileOutputStream fos = new FileOutputStream(new File("./Screenshot/Image1.jpeg"));
		fos.write(bytearr);
		fos.close();

		byte[] byteArr = ts.getScreenshotAs(OutputType.BYTES);
		FileOutputStream fos1 = new FileOutputStream(new File("./Screenshot/Image2.png"));
		fos1.write(byteArr);
		fos1.close();

		driver.quit();

	}
}
