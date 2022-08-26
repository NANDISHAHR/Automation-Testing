package com.Ex2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenimages {

	public static void main(String[] args) throws Exception {

		verifybrokenimageusingJsoup();

	}

	/*
	 * public static void verifybrokenimageusingselenium() throws IOException {
	 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
	 * ChromeDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * driver.get("https://www.google.com");
	 * 
	 * List<WebElement> images = driver.findElements(By.tagName("img"));
	 * System.out.println(images.size());
	 * 
	 * for (WebElement image : images) { String imagesrc =
	 * image.getAttribute("src");
	 * 
	 * try { URL url = new URL(imagesrc); URLConnection urlconnection =
	 * url.openConnection(); HttpsURLConnection httpURlConnection =
	 * (HttpsURLConnection) urlconnection;
	 * httpURlConnection.setConnectTimeout(5000); httpURlConnection.connect();
	 * 
	 * if (httpURlConnection.getResponseCode() == 200) System.out.println(images +
	 * "--" + httpURlConnection.getResponseCode() + "-" +
	 * httpURlConnection.getResponseMessage()); else System.err.println(images +
	 * "--" + httpURlConnection.getResponseCode() + "-" +
	 * httpURlConnection.getResponseMessage());
	 * 
	 * httpURlConnection.disconnect(); } catch (MalformedURLException e) {
	 * System.err.println(imagesrc); e.printStackTrace(); } catch (IOException e) {
	 * System.err.println(imagesrc); e.printStackTrace(); } } driver.quit(); }
	 */

	public static void verifybrokenimageusingJsoup() throws IOException {
		Document doc = Jsoup.connect("https://www.theworldsworstwebsiteever.com/").get();

		Elements images = doc.select("img");
		for (Element image : images) {
			String imagesrc = image.attr("src");
			if (!imagesrc.startsWith("http"))
				imagesrc = "https://www.theworldsworstwebsiteever.com/"+imagesrc;
				try {
					URL url = new URL(imagesrc);
					URLConnection urlconnection = url.openConnection();
					HttpsURLConnection httpURlConnection = (HttpsURLConnection) urlconnection;
					httpURlConnection.setConnectTimeout(5000);
					httpURlConnection.connect();

					if (httpURlConnection.getResponseCode() == 200)
						System.out.println(imagesrc + "--" + httpURlConnection.getResponseCode() + "-"
								+ httpURlConnection.getResponseMessage());
					else
						System.err.println(imagesrc + "--" + httpURlConnection.getResponseCode() + "-"
								+ httpURlConnection.getResponseMessage());

					httpURlConnection.disconnect();
				} catch (MalformedURLException e) {
					System.err.println(imagesrc);
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println(imagesrc);
					e.printStackTrace();
				}
		}
	}
}
