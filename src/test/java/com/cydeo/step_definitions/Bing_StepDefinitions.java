package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Bing_StepDefinitions {

    BingSearchPage bingSearchPage = new BingSearchPage();

    @Given("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {

        Driver.getDriver().get("https://www.bing.com");
    }
    @When("user enters orange in the Bing search box")
    public void user_enters_orange_in_the_bing_search_box() {
        BrowserUtils.sleep(1);
        bingSearchPage.searchBox.sendKeys("orange" + Keys.ENTER);
    }
    @Then("user should see orange in the title")
    public void user_should_see_orange_in_the_title() {
        BrowserUtils.sleep(1);
        BrowserUtils.verifyTitle("orange - Search");
    }


    @When("user enters {string} in the Bing search box")
    public void userEntersInTheBingSearchBox(String searchKey) {
        BrowserUtils.sleep(1);
        bingSearchPage.searchBox.sendKeys(searchKey + Keys.ENTER);
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String searchKey) {
        BrowserUtils.sleep(1);
        BrowserUtils.verifyTitle(searchKey);
    }
}
