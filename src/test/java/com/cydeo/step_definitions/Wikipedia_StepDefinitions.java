package com.cydeo.step_definitions;

import com.cydeo.pages.WikiResultPage;
import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("user is on the Wikipedia homepage")
    public void user_is_on_the_wikipedia_homepage() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }

    @When("user types {string} in Wikipedia search box")
    public void userTypesInWikipediaSearchBox(String searchValue) {
        wikiSearchPage.searchBox.sendKeys(searchValue);
    }

    @When("user click Wiki search box")
    public void user_click_wiki_search_box() {
        wikiSearchPage.searchButton.click();
    }

    @Then("user sees {string} is in the Wikipedia title")
    public void userSeesIsInTheWikipediaTitle(String expectedInTitle) {
        BrowserUtils.verifyTitleContains(expectedInTitle);
    }

    WikiResultPage wikiResultPage = new WikiResultPage();

    @Then("user sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String expectedText) {

        String actualHeaderText = wikiResultPage.mainHeader.getText();

        Assert.assertEquals(actualHeaderText,expectedText);
    }

    @Then("user sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String expectedText){

        String actualImageText = wikiResultPage.imageHeader.getText();
        Assert.assertEquals(actualImageText,expectedText);
    }
}
