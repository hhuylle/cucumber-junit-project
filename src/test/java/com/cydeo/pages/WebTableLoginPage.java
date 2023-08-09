package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    //@FindBy(xpath = "//button[@class='button nav__item active']")
    //public WebElement orderPage;


    //Option#1
    public void loginPage(){

        this.username.sendKeys("Test");
        this.password.sendKeys("Tester");
        this.loginButton.click();
    }

    //Option#2
    public void loginPage(String username, String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

}
