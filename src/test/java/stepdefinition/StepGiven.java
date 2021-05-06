package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import executor.Runner;
import pages.SearchPage;
import repository.Common;

public class StepGiven extends Runner{

	@Given("^search page is having from port and to port with Search button$")
	public void verifySearchPage() throws Throwable {
		searchpage.depisDisplayed();
		searchpage.desisDisplayed();
		
	}
	@Given("^base uri \"([^\"]*)\"$")
	public void base_uri(String arg1) throws Throwable {
	    Runner.com.baseURI(arg1);
	}
}
