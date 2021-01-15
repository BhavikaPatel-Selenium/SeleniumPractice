package TestingPractices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPreferences {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BS- Connect with db");
	}
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("BT- Create a sample user in Db");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BC- Launch browser and app");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BM- login app");
	}
	
	@Test
	public void test() {
		System.out.println("test --checking logo");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method--logout app");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class--close browser");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test--remove user from DB");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite--disconnect connection with DB");
	}

}
