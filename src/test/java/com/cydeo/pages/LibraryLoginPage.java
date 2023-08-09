package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibraryLoginPage {

    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signinBtn;

    @FindBy(xpath = "//a[@id='navbarDropdown']//span")
    public WebElement accountName;


    public void librarianLogin(){
        emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
        signinBtn.click();
    }

    public void librarianLogin(String userName, String passWord){
        emailInput.sendKeys(userName);
        passwordInput.sendKeys(passWord);
        signinBtn.click();
    }

}
