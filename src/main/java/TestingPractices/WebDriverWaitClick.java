package TestingPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitClick {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://www.dollartree.com/");
		By trackOrders = By.xpath("//span[contains(@id,'track-order-element')]/a/span");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement track = wait.until(ExpectedConditions.elementToBeClickable(trackOrders));
		
		Actions act = new Actions(driver);
		act.moveToElement(track).click().build().perform();
	}
}
