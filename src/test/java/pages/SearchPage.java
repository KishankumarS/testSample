package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import executor.Runner;
import repository.SeleniumObj;
import repository.SingleDriver;

public class SearchPage {

	SeleniumObj sobj = null;
	By departure = By.name("fromPort");
	By destination = By.name("toPort");
	By submit = By.xpath("//input[@value='Find Flights']");
	SingleDriver driver1 = null;
	WebDriver driver = null;
	
	public SearchPage() {
		driver1 = SingleDriver.getInstanceOfSingletonBrowserClass();
		driver = driver1.getDriver();
		sobj = new SeleniumObj();
	}

	public void depisDisplayed() {

		assertTrue(driver.findElement(departure).isDisplayed(), "Depature dropdown not found!");
	}

	public void desisDisplayed() {
		assertTrue(driver.findElement(By.name("toPort")).isDisplayed(),
				"Destination dropdown not found!");
	}

	public void selectfrom(String value) {
		sobj.selectByvalue(driver.findElement(departure), value);
	}

	public boolean verifyFrom(String value) {
		return driver.findElement(departure).getAttribute("value").equalsIgnoreCase(value) ? true
				: false;
	}

	public void selectto(String value) {
		sobj.selectByvalue(driver.findElement(destination), value);
	}

	public boolean verifyTo(String value) {
		return driver.findElement(destination).getAttribute("value").equalsIgnoreCase(value) ? true
				: false;
	}

	public void submit() {
		driver.findElement(submit).click();
		System.out.println("clicked on submit");
	}

}