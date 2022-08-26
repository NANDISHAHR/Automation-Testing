package com.Ex2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarcontrolswithutility {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");

		Thread.sleep(3000);
		driver.findElement(By.id("datepicker")).click();
		selectDate(driver, "30/Aug/2021", "dd/MMM/yyyy");
		
		Thread.sleep(3000);
		driver.findElement(By.id("datepicker")).click();
		selectDate(driver, "05/Feb/2021", "dd/MMM/yyyy");
		
		Thread.sleep(3000);
		driver.findElement(By.id("datepicker")).click();
		selectDate(driver, "15/Mar/2025", "dd/MMM/yyyy");
	}

	public static void selectDate(WebDriver driver, String targetdate, String dateformat) throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetdateformat = new SimpleDateFormat(dateformat);
		Date formatedtargetdate;
		try {
			targetdateformat.setLenient(false);
			formatedtargetdate = targetdateformat.parse(targetdate);
			calendar.setTime(formatedtargetdate);

			int targetday = calendar.get(Calendar.DAY_OF_MONTH);
			int targetmonth = calendar.get(Calendar.MONTH);
			int targetyear = calendar.get(Calendar.YEAR);

			
			String actualdate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualdate));

			int actualmonth = calendar.get(Calendar.MONTH);
			int actualyear = calendar.get(Calendar.YEAR);

			while (targetmonth < actualmonth || targetyear < actualyear) {
				driver.findElement(By.className("ui-datepicker-prev")).click();
				actualdate = driver.findElement(By.className("ui-datepicker-title")).getText();

				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualdate));
				actualmonth = calendar.get(Calendar.MONTH);
				actualyear = calendar.get(Calendar.YEAR);
			}

			while (targetmonth > actualmonth || targetyear > actualyear) {
				driver.findElement(By.className("ui-datepicker-next")).click();
				actualdate = driver.findElement(By.className("ui-datepicker-title")).getText();

				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualdate));
				actualmonth = calendar.get(Calendar.MONTH);
				actualyear = calendar.get(Calendar.YEAR);
			}

			// Thread.sleep(3000);
			driver.findElement(By.xpath(
					"//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()="
							+ targetday + "]"))
					.click();

		} catch (ParseException e) {
			throw new Exception("Invalid date is provided, please check input date");
		}

	}
}
