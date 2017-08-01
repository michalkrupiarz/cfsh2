package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MainPage {
	
	private String mainPageUrl = "http://localhost:4200";
	
	private String tabTitle = "//tabset/ul/li[%d]/a";
	
	private WebDriver driver;
	
	private int numberOfTabs = 7;
	
	private String clickToExapndForCarLocator="//td[contains(.,'%s')]";
	
	private String carsNamesLocat = "//table/tbody/tr/td[2]";
	
	private String unfoldDetailsCarNameLocator = "//div[contains(.,'%s')]/accordion/accordion-group/div/div[2]/div/div/app-car-details/b";
	
 	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
 	 	
	public MainPage openMainPage() {
		driver.get(mainPageUrl);
		return this;
	}
	
	public String getTabTitle(int numberOfTab) {
		String xpath = String.format(tabTitle, numberOfTab);
		String tab = driver.findElement(By.xpath(xpath)).getText();;
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public List<String> getTabsTitles() {
		List<String> tabsName = (List<String>) new ArrayList<String>();
		for (int i=1;i<=numberOfTabs;i++) {
			tabsName.add(getTabTitle(i));
		}
		return tabsName;
	}
	
	public String getCarName(List<String> listOfNames, int numberOfName) {
		return listOfNames.get(numberOfName);
	}
	
	public List<String> getCarsNames(){
		List<WebElement> names = driver.findElements(By.xpath(carsNamesLocat));
		List<String> listOfNames = new ArrayList<String>();
		for (WebElement name : names) {
			listOfNames.add(name.getText());
		}
		return listOfNames;
	}
	
	public MainPage openCarDetails(String carName) {
		String xpath = String.format(clickToExapndForCarLocator,carName);
		driver.findElement(By.xpath(xpath)).click();
		return this;
	}
	
	public String getCarNameFromDetails(String carName) {
		String xpath = String.format(unfoldDetailsCarNameLocator,carName);
		return driver.findElement(By.xpath(xpath)).getText();
	}
}
