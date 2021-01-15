package TestingPractices;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {
	
	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		By list= By.tagName("a");
		
//		List<WebElement> amazonLinkList = driver.findElements(By.tagName("a"));
//		List<String> amozonFilterList=
//				amazonLinkList.stream()
//					  .filter(ele->!ele.getText().isEmpty())
//					  .filter(ele->ele.getText().contains("Amazon"))
//					  .map(ele->ele.getText().trim())
//					  .collect(Collectors.toList());
//		
//		amozonFilterList.stream().forEach(ele->System.out.println(ele));
//		System.out.println(getFilterLinkList(list, "Amazon"));
		
		List<String> filterLinksList =getFilterLinkList(list, "Amazon");
		filterLinksList.stream().forEach(ele->System.out.println(ele));
		
	}
	
	public static List<String> getFilterLinkList(By locator, String value) {
		List<WebElement> linksList = driver.findElements(locator);
		List<String> filterList=
				linksList.stream()
					  .filter(ele->!ele.getText().isEmpty())
					  .filter(ele->ele.getText().contains(value))
					  .map(ele->ele.getText().trim())
					  .collect(Collectors.toList());
		return filterList;
	}

}
