package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions {

    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruitsAndVegetables) {
        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);
        System.out.println("fruitsAndVegetables.get(1) = " + fruitsAndVegetables.get(1));
    }

    @Then("I share my list's love")
    public void i_share_my_list_s_love(List<String> listOfAnimals) {
        System.out.println("listOfAnimals = " + listOfAnimals);
    }

    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String, String> driverInfo) {
        System.out.println("driverInfo = " + driverInfo);
        System.out.println("driverInfo.get(\"name\") = " + driverInfo.get("name"));
        System.out.println("driverInfo.get(\"zipcode\") = " + driverInfo.get("zipcode"));
        System.out.println("driverInfo.size() = " + driverInfo.size());
    }

    DropdownPage dropdownPage = new DropdownPage();

    @Given("user is on the dropdown page")
    public void user_is_on_the_dropdown_page() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    @Then("user should see below info of month dropdown")
    public void user_should_see_below_info_of_month_dropdown(List<String> expectedMonths) {

        List<String> actualMonths = BrowserUtils.dropdownOptions_as_STRING(dropdownPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualMonths);
    }
}
