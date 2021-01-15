package TestingPractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreshworksHomePage {
	
static WebDriver driver;

	@BeforeTest
	public void iniBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.freshworks.com/");
	}
	@Test
	public void bannerNotificationTest() {
		WebElement bannerText = driver.findElement(By.xpath("//a[contains(@href,'covid')]"));
		Assert.assertTrue(bannerText.isDisplayed());
	}
	
	@Test
	public void tellMeMoreBtnTest() {
		WebElement tellMeMoreBtn = driver.findElement(By.xpath("//a[contains(text(),' WOW! TELL ME MORE')]"));
		tellMeMoreBtn.click();
		WebElement requestDemo = driver.findElement(By.xpath("//a[contains(text(),'REQUEST DEMO')]"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement requestDemoBtn = wait.until(ExpectedConditions.visibilityOf(requestDemo));
		Assert.assertTrue(requestDemoBtn.isDisplayed());
	}

	@Test
	public void productsMenuLinkTest() {
		WebElement productsLink = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
		Assert.assertTrue(productsLink.isDisplayed());	
	}
	
	@Test
	public void headerTextTest() {
		WebElement headerText = driver.findElement(By.xpath("//h2[contains(text(),'Refreshing business software that your teams will love')]"));
		Assert.assertTrue(headerText.isDisplayed());	
	}
	
	@Test
	public void subHeaderTextTest() {
		WebElement subHeaderText = driver.findElement(By.xpath("//p[contains(@class,'sub-text') and contains(text(),'All of our products')]"));
		Assert.assertTrue(subHeaderText.isDisplayed());	
	}
	@Test
	public void siteLogoTest() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='nav-logo-wrapper']//img[@alt='Freshworks']"));
		Assert.assertTrue(logo.isDisplayed());	
	}
	
	@Test
	public void menuLinksTest() {
		List<WebElement> menuLinksList = driver.findElements(By.xpath("//ul[contains(@class,'nav-main-menu')]/li"));
		
		for (WebElement e : menuLinksList) {
			if(!e.getText().isEmpty()) {
				Assert.assertTrue(e.isDisplayed());
			}
		}
	}
	@Test
	public void footerLinksTest() {
		List<WebElement> menuLinksList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])/li/a"));
		
		for (WebElement e : menuLinksList) {
			if(!e.getText().isEmpty()) {
				Assert.assertTrue(e.isDisplayed());
			}
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
