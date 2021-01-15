package TestingPractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitAutomationPractice {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		By search = By.id("search_query_top");
		By suggestList = By.xpath("//ul/li[contains(@class,'ac_')]");
		
		long startTime = System.currentTimeMillis();
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(search)).sendKeys("dress");
		
		List<WebElement> suggestionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestList));
		//suggestionList.stream().forEach(ele->System.out.println(ele.getText()));-- 1472
		suggestionList.parallelStream().forEach(ele->System.out.println(ele.getText())); //-- 2022
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		//suggestionList.stream().filter(ele->ele.getText().contains("Evening Dresses")).findAny().ifPresent(ele->ele.click());				
		
	}

}
