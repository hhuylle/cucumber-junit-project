package com.cydeo.step_definitions;

import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WT_ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class WebTableLogin_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on the Web Table app login page")
    public void user_is_on_the_web_table_app_login_page() {

        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }
    @When("user enters correct username")
    public void user_enters_correct_username() {

        webTableLoginPage.username.sendKeys("Test");
    }
    @When("user enters correct password")
    public void user_enters_correct_password() {

        webTableLoginPage.password.sendKeys("Tester");
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();
    }
    @Then("user should see orders word in the URL")
    public void user_should_see_orders_word_in_the_url() {

        String expectedURL = "orders";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
    }


    @When("user enters {string} username and {string} password")
    public void userEntersUsernameAndPassword(String username, String password) {

        webTableLoginPage.username.sendKeys(username);
        webTableLoginPage.password.sendKeys(password);
    }

    @When("User enters below credentials")
    public void userEntersBelowCredentials(Map<String, String> credentials) {

        webTableLoginPage.username.sendKeys(credentials.get("username"));
        webTableLoginPage.password.sendKeys(credentials.get("password"));
    }

    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {

        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        webTableLoginPage.loginPage();
    }

    WT_OrderPage orderPage = new WT_OrderPage();

    @When("user is on the “Order” page")
    public void user_is_on_the_order_page() {

        orderPage.ordersLink.click();
        //BrowserUtils.sleep(2);
    }

    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedOptions) {

        List<String> actualOptions = BrowserUtils.dropdownOptions_as_STRING(orderPage.productDropdown);

        Assert.assertEquals(actualOptions, expectedOptions);
    }


    @Then("user see Visa as enabled payment options")
    public void userSeeVisaAsEnabledPaymentOptions() {

        Assert.assertTrue(orderPage.visaRadioBtn.isEnabled());
    }

    @Then("user see MasterCard as enabled payment options")
    public void userSeeMasterCardAsEnabledPaymentOptions() {

        Assert.assertTrue(orderPage.masterCardRadioBtn.isEnabled());
    }

    @Then("user see American Express as enabled payment options")
    public void userSeeAmericanExpressAsEnabledPaymentOptions() {

        Assert.assertTrue(orderPage.americanExpressRadioBtn.isEnabled());
    }


    @Then("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {

        orderPage.quantityInput.clear();

        orderPage.quantityInput.sendKeys(quantity);
    }

    @Then("user clicks to calculate button")
    public void userClicksToCalculateButton() {

        orderPage.calculateBtn.click();
    }

    @Then("user enters customer name {string}")
    public void userEntersCustomerName(String name) {

        orderPage.nameInput.sendKeys(name);
    }

    @Then("user enters street {string}")
    public void userEntersStreet(String street) {

        orderPage.streetInput.sendKeys(street);
    }

    @Then("user enters city {string}")
    public void userEntersCity(String city) {

        orderPage.cityInput.sendKeys(city);
    }

    @Then("user enters in state {string}")
    public void userEntersInState(String state) {

        orderPage.stateInput.sendKeys(state);
    }


    @Then("user enters in zip {string}")
    public void userEntersInZip(String zip) {

        orderPage.zipInput.sendKeys(zip);
    }

    @Then("user select Payment Option {string}")
    public void userSelectPaymentOption(String cardType) {
        //orderPage.masterCardRadioBtn.click(); without parameterization
        BrowserUtils.clickRadioButton(orderPage.cardType, cardType);
    }

    @Then("user enter credit card number {string}")
    public void userEnterCreditCardNumber(String cardNumber) {

        orderPage.cardNumberInput.sendKeys(cardNumber);
    }

    @Then("user chooses expiration date {string}")
    public void userChoosesExpirationDate(String expDate) {

        orderPage.cardExpDateInput.sendKeys(expDate);
    }

    @Then("user clicks to process order button")
    public void userClicksToProcessOrderButton() {

        orderPage.processOrderBtn.click();
    }

    WT_ViewAllOrdersPage viewAllOrdersPage = new WT_ViewAllOrdersPage();

    @Then("user should see {string} in the first row if the web table")
    public void userShouldSeeInTheFirstRowIfTheWebTable(String expectedName){

        String actualName = viewAllOrdersPage.newCustomerOrder.getText();
        Assert.assertEquals(actualName, expectedName);
    }
}
