package TestingPractices;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		//By storage = By.xpath("(//div[contains(text(),'Storage')])[3]");
		By womenLink = By.xpath("//div[@class='footer-container']//li[@class='last']//a[contains(text(),'Women')]");
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class);
//		WebElement womenFLink = wait.until(ExpectedConditions.visibilityOfElementLocated(womenLink));
	//	womenFLink.click();
		
		retryingElement(womenLink).click();
		
	}
	
	public static WebElement waitForElementWithFluentWait(int timeout, int pollingTime, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public static WebElement retryingElement(By locator) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < 30) {
			try {
				element = driver.findElement(locator);
				break;
			} 
			catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
			}
			catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
			}
			System.out.println("element is not found : " + (attempts+1));

			attempts++;
		}
		return element;
	}
}
