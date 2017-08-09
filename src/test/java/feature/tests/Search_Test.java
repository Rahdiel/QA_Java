package feature.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_Test {
	
	private static final Logger log = LoggerFactory.getLogger(Search_Test.class);
	
	@Given("^Open page$")
	public void open_page() throws Throwable {
		log.info("1.");
	}

	@When("^Search for all links$")
	public void search_for_all_links() throws Throwable {
		log.info("2.");
	}

	@Then("^Check all links$")
	public void check_all_links() throws Throwable {
		log.info("3.");
	}
}
