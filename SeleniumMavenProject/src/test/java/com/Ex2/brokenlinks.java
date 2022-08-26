package com.Ex2;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenlinks {

	public static void main(String[] args) throws IOException  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.att.com/mydatarequest/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		/*
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * System.out.println(links.size()); for (WebElement link : links) { String
		 * linkurl = link.getAttribute("href");
		 * 
		 * URL url = new URL(linkurl); URLConnection urlConnection =
		 * url.openConnection(); HttpURLConnection httpurlConnection =
		 * (HttpURLConnection) urlConnection;
		 * httpurlConnection.setConnectTimeout(10000); httpurlConnection.connect();
		 * 
		 * if (httpurlConnection.getResponseCode() == 200) {
		 * 
		 * System.out.println(linkurl + " - " + httpurlConnection.getResponseCode() +
		 * " - " + httpurlConnection.getResponseMessage());
		 * 
		 * } else { System.err.println(linkurl + " - " +
		 * httpurlConnection.getResponseCode() + " - " +
		 * httpurlConnection.getResponseMessage()); httpurlConnection.disconnect(); }
		 * driver.quit(); }
		 */
		
		
		
		Set<String> brokenURL = new HashSet<String>();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (WebElement link : links) {
			String linkurl = link.getAttribute("href");
			
			URL url = new URL(linkurl);
			URLConnection urlConnection = url.openConnection();
			HttpsURLConnection httpsUrlConnection = (HttpsURLConnection) urlConnection;
			httpsUrlConnection.setConnectTimeout(10000);
			httpsUrlConnection.connect();
			
			if(httpsUrlConnection.getResponseCode() == 200) 
				System.out.println(linkurl + " - " + httpsUrlConnection.getResponseCode() +" - " + httpsUrlConnection.getResponseMessage());
			else
				System.err.println(linkurl + " - " + httpsUrlConnection.getResponseCode() + " - "+ httpsUrlConnection.getResponseMessage());
			
			if(httpsUrlConnection.getResponseCode() != 200)
				brokenURL.add(linkurl);
			httpsUrlConnection.disconnect();
		}
		driver.quit();
		
		for (String BrokenURLs : brokenURL) {
			System.err.println(BrokenURLs);
			
		}
	}
}
