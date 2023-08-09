package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WT_OrderPage extends WT_BasePAge{

    public WT_OrderPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "product")
    public WebElement productDropdown;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaRadioBtn;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterCardRadioBtn;

    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanExpressRadioBtn;

    @FindBy(xpath = "//div//th[.='1']/following::td[1]")
    public WebElement newOrder;

    @FindBy(xpath = "//option[@value='MoneyCog']")
    public WebElement moneyCogInput;

    @FindBy(xpath = "//option[@value='Familybea']")
    public WebElement familyBeaInput;

    @FindBy(xpath = "//option[@value='Screenable']")
    public WebElement screenableInput;

    @FindBy(name = "quantity")
    public WebElement quantityInput;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateBtn;

    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(name = "street")
    public WebElement streetInput;

    @FindBy(name = "city")
    public WebElement cityInput;

    @FindBy(name = "state")
    public WebElement stateInput;

    @FindBy(name = "zip")
    public WebElement zipInput;

    @FindBy(name = "card")
    public List<WebElement> cardType;

    @FindBy(name = "cardNo")
    public WebElement cardNumberInput;

    @FindBy(name = "cardExp")
    public WebElement cardExpDateInput;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderBtn;


}
