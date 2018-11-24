package com.testing.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "passwordConfirmation")
    private WebElement passwordConfirmationField;

    @FindBy(css = "span.checked")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//button[@type='submit'][@value='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='form-error']/span")
    private WebElement pwdErrorMsg;


    public void enterEmailId(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        passwordField.sendKeys(pwd);
    }

    public void passwordConfirmation(String pwdConfirm){
        passwordConfirmationField.sendKeys(pwdConfirm);
    }

    public void selectCheckBoxes(){
        for (WebElement element:checkBoxes){
            if(!element.isSelected()){
                element.click();
            }
        }
    }

    public void selectsRegister(){
        registerButton.click();
    }

public boolean passwordErrorMsg(String msg){
        return pwdErrorMsg.getText().contains(msg);
}

}
