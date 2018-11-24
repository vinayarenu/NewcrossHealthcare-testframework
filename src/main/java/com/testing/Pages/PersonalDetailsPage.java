package com.testing.Pages;

import com.testing.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalDetailsPage extends BasePage {


    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = " //*[@id='root']/div/div[2]/div/div/div[1]/div[3]/div")
    private WebElement confirmationMessage;

   // @FindBy(css = "select.form-control")
    @FindBy(css = "select[name='title']")
    private WebElement selectTitle;

    @FindBy(css = "input[name='firstName']")
    private WebElement firstNameField;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastNameField;

    @FindBy(css = "input[name='mobile']")
    private WebElement mobileNoField;

    @FindBy(css = "input[name='postcode']")
    private WebElement postcodeField;

    @FindBy(css = "div.button-content-padding-05")
    private WebElement lookUpAddressButton;

    @FindBy(xpath = "//div[@class='list-group modalLookup']/button")
    private List<WebElement> laneAddresses;


    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;

    @FindBy(css = "button[value='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@class='form-error']/span")
    private WebElement mobErrorMsg;


    @FindBy(xpath = "//div[@class='form-error']/span")
    private WebElement firstNameErrorMsg;

    @FindBy(xpath = "//div[@class='form-error']/span")
    private WebElement lastNameErrorMsg;


    public void enterPersonalDetails(String title, String firstName, String lastName, String mobNo) {

        Utils.selectFromList(selectTitle, title);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        mobileNoField.sendKeys(mobNo);

    }

    public void enterPostcode(String postCode) {
        postcodeField.sendKeys(postCode);
    }

    public void selectsLookUpAddress(String lookUpAddress) {
        lookUpAddressButton.click( );

        for(WebElement element:laneAddresses){
            if(element.getText().contains(lookUpAddress)){
                Utils.javaScriptExecutor(element);
                break;
            }
        }

        saveButton.click( );


    }

    public void selectNextButton(){
        nextButton.click();
    }

    public boolean mobileErrorMessage(String msg){
        return mobErrorMsg.getText().contains(msg);
    }

    public boolean firstNameErrorMessage(String msg){
        return firstNameErrorMsg.getText().contains(msg);
    }

    public boolean lastNameErrorMessage(String msg){
        return lastNameErrorMsg.getText().contains(msg);
    }




}
