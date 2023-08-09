package com.cydeo.step_definitions;

import com.cydeo.pages.EtsySearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Etsy_StepDefinitions {

    EtsySearchPage etsySearchPage = new EtsySearchPage();

    @Given("user is on the Etsy homepage")
    public void user_is_on_the_etsy_homepage() {
        Driver.getDriver().get("https://www.etsy.com");
    }
    @Then("user should see title is as expected")
    public void user_should_see_title_is_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        BrowserUtils.verifyTitle(expectedTitle);
    }


    @When("user type Wooden Spoon in the search box")
    public void userTypeWoodenSpoonInTheSearchBox() {
        etsySearchPage.searchBox.sendKeys("Wooden Spoon");
    }

    @And("user click search button")
    public void userClickSearchButton() {

        etsySearchPage.searchButton.click();
    }

    @Then("user see Wooden spoon in the Title")
    public void userSeeWoodenSpoonInTheTitle() {

        BrowserUtils.sleep(2);
        String expectedTitle1 = "Wooden spoon - Etsy";
        BrowserUtils.verifyTitle(expectedTitle1);
    }

    @When("user type {string} in the search box")
    public void userTypeInTheSearchBox(String keyword) {

        etsySearchPage.searchBox.sendKeys(keyword);
    }

    @Then("user see {string} in the Title")
    public void userSeeInTheTitle(String expectedTitle) {

        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(expectedTitle);
    }
}
