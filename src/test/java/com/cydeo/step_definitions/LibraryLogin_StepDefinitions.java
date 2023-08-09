package com.cydeo.step_definitions;

import com.cydeo.pages.LibraryLoginDashboardPage;
import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LibraryLogin_StepDefinitions {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));

    }
    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        //libraryLoginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
        //libraryLoginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
        //libraryLoginPage.signinBtn.click();

        //libraryLoginPage.librarianLogin();

        libraryLoginPage.librarianLogin(ConfigurationReader.getProperty("lib22_user"), ConfigurationReader.getProperty("lib22_pass"));

    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expectedDashboardURL = "dashboard";

        wait.until(ExpectedConditions.urlContains(expectedDashboardURL));

        String actualDashboardURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualDashboardURL.contains(expectedDashboardURL));
    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
        libraryLoginPage.librarianLogin(ConfigurationReader.getProperty("student55_user"), ConfigurationReader.getProperty("student55_pass"));
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {

        String expectedBooksURL = "books";

        wait.until(ExpectedConditions.urlContains(expectedBooksURL));

        String actualBooksURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualBooksURL.contains(expectedBooksURL));
    }


    LibraryLoginDashboardPage loginDashboardPage = new LibraryLoginDashboardPage();

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        libraryLoginPage.emailInput.sendKeys(username);
        BrowserUtils.sleep(1);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        libraryLoginPage.passwordInput.sendKeys(password);
    }


    @And("click the sign in button")
    public void clickTheSignInButton() {
        libraryLoginPage.signinBtn.click();
    }

    @And("there should be {string} users")
    public void thereShouldBeUsers(String num) {

        String expectedUserNum = "2903";
        String actualUserNum = loginDashboardPage.userNum.getText();
        Assert.assertTrue(actualUserNum.contains(expectedUserNum));
    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int num) {

        String expectedUserNum = String.valueOf(num);
        String actualUserNum = loginDashboardPage.userNum.getText();
        Assert.assertTrue(actualUserNum.contains(expectedUserNum));
    }


    @And("I click on {string} link")
    public void iClickOnLink(String arg0) {

        loginDashboardPage.users.click();
    }

    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<WebElement> columnNames) {

    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String email, String password) {

        libraryLoginPage.librarianLogin(email, password);

    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String name) {
        //String expectedName = name;
        wait.until(ExpectedConditions.visibilityOf(libraryLoginPage.accountName));
        String actualName = libraryLoginPage.accountName.getText();
        Assert.assertEquals(name, actualName);
    }
}
