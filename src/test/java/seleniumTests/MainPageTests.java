package seleniumTests;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MainPage;

public class MainPageTests {
  
  private WebDriver driver;
  
  private List<String> tabsHead   = new ArrayList<String>();
  
  private List <String> carNames = new ArrayList<String>();
  
  @BeforeMethod
  public void before(){
	System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver\\geckodriver.exe");
	driver = new FirefoxDriver();
	carNames.add("Ford");
	carNames.add("Toyota");
	carNames.add("Honda");
	carNames.add("GM");
	
	tabsHead.add("Cars");
	tabsHead.add("Repairs");
	tabsHead.add("Lends");
	tabsHead.add("Checkouts");
	tabsHead.add("Insurances");
	tabsHead.add("Tires");
	tabsHead.add("Documents");
  }
  @AfterMethod
  public void after() {
	driver.close();
  }
  
  @Test
  public void checkTabsTitles() throws InterruptedException {
	  	  	 
	MainPage mP = new MainPage(driver);
	mP.openMainPage();
	int i = 0;
	List<String> listOfTabs = mP.getTabsTitles();
	for (String item : tabsHead) {
		Assert.assertTrue(isItemOnTheList(item, listOfTabs),"Tab name "+item+" was not found on the list");
	}
  }
  @Test
  public void checkAllCarNames() {
	  MainPage mP = new MainPage(driver);
	  List<String> listOfNames = mP.openMainPage().getCarsNames();
	  int i=0;
	  for (String name:carNames) {
		  Assert.assertTrue(isItemOnTheList(name, listOfNames),"Car name "+name+" was not found on the list.");
	  }
	  	
  }
  @Test
  public void openCarDetails() throws InterruptedException {
	  MainPage mP = new MainPage(driver);
	  mP.openMainPage().openCarDetails("Ford");
	  Assert.assertEquals(mP.getCarNameFromDetails("Ford"), "Ford");
  }
  
  public boolean isItemOnTheList(String item, List<String> List) {
	  boolean result = false;
	  for (String thing : List) {
		  if (thing.contains(item)) {
			  result = true;
		  }
	  }
	  return result;
  }
  
}
