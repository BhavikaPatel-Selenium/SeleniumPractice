package TestingPractices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("https://www.dollartree.com/");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		// 1. title
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("DollarTree"));
		System.out.println(driver.getTitle());	
		
		wait.until(ExpectedConditions.titleIs("Glass Vases, Party Supplies, Cleaning & More | DollarTree.com" ));		
		System.out.println(driver.getTitle());	

		// 2. alert
		driver.findElement(By.name("proceed")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());

		alert.accept();
		// alert.dismiss();

		// 3. URL
		wait.until(ExpectedConditions.urlContains("rediff"));
		System.out.println(driver.getCurrentUrl());

		wait.until(ExpectedConditions.urlMatches("login.cgi"));
		System.out.println(driver.getCurrentUrl());

		wait.until(ExpectedConditions.urlToBe("https://mail.rediff.com/cgi-bin/login.cgi"));
		System.out.println(driver.getCurrentUrl());

	}
	
	public static String getTitleUsingContains(int timeOut,String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(value));
		return driver.getTitle();	
	}
	
	
	public static String getTitleUsingTitleIs(int timeOut,String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(value));
		return driver.getTitle();	
	}

	public static Alert moveToAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public static String getalertText(int timeOut) {
		return moveToAlert(timeOut).getText();
	}

	public static void doAcceptAlert(int timeOut) {
		moveToAlert(timeOut).accept();
	}

	public static void doDeclineAlert(int timeOut) {
		moveToAlert(timeOut).dismiss();
	}
	
	public static String getURLUsingContains(int timeOut,String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlContains(value));
		return driver.getCurrentUrl();	
	}
	public static String getURLUsingMatches(int timeOut,String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlMatches(value));
		return driver.getCurrentUrl();	
	}
	public static String getURLToBe(int timeOut,String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlToBe(value));
		return driver.getCurrentUrl();	
	}
	
	
	

}
