package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import executor.Runner;
import pages.Reserve;
import pages.SearchPage;

public class StepWhen extends Runner{
	
	@When("^select fromport \"(.*?)\" and toport \"(.*?)\"$")
	public void selectfromAndTo(String from, String to) throws Throwable {
		searchpage.selectfrom(from);
		searchpage.selectto(to);
	}
	
	@When("^I select by flight number \"(.*?)\"$")
	public void iSelectFlight(String flightId) throws Throwable {
		reservePage.clickSelectedFlight(flightId);
		System.out.println("Flight selected!!");
	}
	
	@When("^I enter name as \"(.*?)\"$")
	public void entername(String name) throws Throwable {
		reservePage.enterName(name);
	}
	
	@When("^I enter address as \"(.*?)\"$")
	public void enteraddress(String address) throws Throwable {
		reservePage.enterAddress(address);
	}
	
	@When("^I enter city as \"(.*?)\"$")
	public void entercity(String city) throws Throwable {
		reservePage.enterCity(city);
	}
	
	@When("^I enter state as \"(.*?)\"$")
	public void enterstate(String state) throws Throwable {
		reservePage.enterState(state);
	}
	
	@When("^I enter zip code as \"(.*?)\"$")
	public void enterzip(String zipCode) throws Throwable {
		reservePage.enterzipCode(zipCode);
	}
	
	@When("^I enter card number as \"(.*?)\"$")
	public void entercardno(String creditCardNumber) throws Throwable {
		reservePage.enterCardNumber(creditCardNumber);
	}
	
	@When("^I enter name on card as \"(.*?)\"$")
	public void enternameoncard(String nameOnCard) throws Throwable {
		reservePage.enternameOnCard(nameOnCard);
	}
	
	@When("^I click Purchase Flight button$")
	public void clickpurchaseflightbutton() throws Throwable {
		reservePage.clickPurchaseFlight();
	}

	@When("^method \"([^\"]*)\"$")
	public void method(String arg1) throws Throwable {
		Runner.com.get();
	}

	

}
