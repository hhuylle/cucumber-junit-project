package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginDashboardPage {

    public LibraryLoginDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//h2[.='2903']")
    public WebElement userNum;

    @FindBy(xpath = "//span[.='Users']")
    public WebElement users;


}
