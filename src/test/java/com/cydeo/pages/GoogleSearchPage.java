package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    //#1- Create constructor and initialize driver with object
    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //#2- Use @FindBy
    @FindBy(name = "q")
    public WebElement seachBox;

    @FindBy()
    public WebElement appleTitle;
}
