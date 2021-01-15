package TestingPractices;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForElement {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		
		
		By searchText =By.xpath("//input[@name='q']");
		By suggestList = By.xpath("//ul/li[@class='sbct']//div[@class='sbl1']/span");

		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchText))).sendKeys("naveen Automation");
		
		List<WebElement> suggestionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestList));
		suggestionList.forEach(ele->System.out.println(ele.getText()));
		
		suggestionList.stream().filter(ele->ele.getText().contains("telegram")).findAny().ifPresent(ele->ele.click());
									
							
	}

}
