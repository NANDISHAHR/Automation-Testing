package com.Ex2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarcontrols {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");

		Calendar calendar = Calendar.getInstance();

		String targetdate = "01-Aug-2024";
		SimpleDateFormat targetdateformat = new SimpleDateFormat("dd-MMM-yyyy");
		Date formatedtargetdate;
		try {
			targetdateformat.setLenient(false);
			formatedtargetdate = targetdateformat.parse(targetdate);
			calendar.setTime(formatedtargetdate);

			int targetday = calendar.get(Calendar.DAY_OF_MONTH);
			int targetmonth = calendar.get(Calendar.MONTH);
			int targetyear = calendar.get(Calendar.YEAR);

			driver.findElement(By.id("datepicker")).click();
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
