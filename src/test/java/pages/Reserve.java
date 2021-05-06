package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import executor.Runner;
import repository.SeleniumObj;
import repository.SingleDriver;

public class Reserve {
	SeleniumObj sobj = null;
	By purchaseFlight = By.xpath("//input[@value='Purchase Flight']");
	SingleDriver driver1 = null;
	public By identifyFlightByFlightId(String flightId) {
		return By.xpath("//td[text()='" + flightId + "']/preceding-sibling::td[1]/input");
	}
	WebDriver driver = null;
	public Reserve() {
		driver1 = SingleDriver.getInstanceOfSingletonBrowserClass();
		driver = driver1.getDriver();
		sobj = new SeleniumObj();
	}

	public void clickSelectedFlight(String flightId) {
		driver.findElement(identifyFlightByFlightId(flightId)).click();
	}

	public void enterName(String name) {
		driver.findElement(By.id("inputName")).sendKeys(name);
	}

	public void enterAddress(String address) {
		driver.findElement(By.name("address")).sendKeys(address);
	}

	public void enterCity(String city) {
		driver.findElement(By.id("city")).sendKeys(city);
	}

	public void enterState(String state) {
		driver.findElement(By.id("state")).sendKeys(state);
	}

	public void enterzipCode(String zipCode) {
		driver.findElement(By.id("zipCode")).sendKeys(zipCode);
	}

	public void enterCardNumber(String creditCardNumber) {
		driver.findElement(By.id("creditCardNumber")).sendKeys(creditCardNumber);
	}

	public void enternameOnCard(String nameOnCard) {
		driver.findElement(By.id("nameOnCard")).sendKeys(nameOnCard);
	}

	public void clickPurchaseFlight() {
		driver.findElement(purchaseFlight).click();
	}

	public void isFlightBooked() {
		boolean isFlightBooked = driver.findElement(By.xpath("//h1[text()='Thank you for your purchase today!']")).isDisplayed();
		if (isFlightBooked) {
			String bookingId = driver.findElement(By.xpath("//td[text()='Id']/following-sibling::td[1]")).getText();
			System.out.println("Flight booked and booking id is "+bookingId);
		} else {
			System.out.println("Flight NOT booked");
		}
	}
}
