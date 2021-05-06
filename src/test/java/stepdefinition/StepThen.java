package stepdefinition;

import static org.testng.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import executor.Runner;
import pages.Reserve;
import pages.SearchPage;
public class StepThen extends Runner {
	@Then("^I click search button$")
	public void clearSearchBox() throws Throwable {
		searchpage.submit();
	}

	@Then("^I see flight is booked$")
	public void iSeeFlightBooked() throws Throwable {
		reservePage.isFlightBooked();
	}
	
	@Then("^check youtubeid is \"([^\"]*)\" in response$")
	public void check_youtubeid_is_in_response(String arg1) throws Throwable {
		assertTrue(Runner.com.verifyresponse(arg1),"Something went wring, Respont not correct");
	}
}
