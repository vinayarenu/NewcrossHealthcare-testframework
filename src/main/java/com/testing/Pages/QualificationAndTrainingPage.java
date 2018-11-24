package com.testing.Pages;

import com.testing.Utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QualificationAndTrainingPage extends BasePage {

    public QualificationAndTrainingPage() {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//button[@class='btn btn btn-primary full-width'][@testid='addQualificationButton']")
    private WebElement addQualificationButton;

    @FindBy(css = "button.react-date-picker__calendar-button.react-date-picker__button__icon")
    private WebElement calenderButton;

//    @FindBy (xpath = "//input[@name='month']")
//    private WebElement monthPickerBtn;
//
//    @FindBy(xpath = "//input[@name='year']")
//    private WebElement yearPickerBtn;

    @FindBy(xpath = "//div[@class='react-calendar__year-view__months']/button")
    private List<WebElement> datePickerButtons;

    @FindBy(xpath = "//span[@class='checked']")
    private List<WebElement> AtThisTimeICompletedCheckBoxBtns;


    @FindBy(css = "select#title")
    private WebElement selectCareRelatedQualification;


    @FindBy(xpath = "//button[@class='btn btn btn-primary']")
    private WebElement addButton;

    @FindBy(xpath = "//button[@class='btn btn btn-primary full-width'][@value='Next']")
    private WebElement nextButton;


    public void selectAddQualificatiobBtn() {
        addQualificationButton.click( );
    }

    public void fillingQualificationForm(String dateCompleted, String atThisTimeICompleted, String careRelatedQualification) {
        Utils.javaScriptExecutor(calenderButton);

        for (WebElement element : datePickerButtons) {
            if (element.getAttribute("value").contains(dateCompleted) ){
                Utils.waitForElementClickable(element);
                break;
            }
        }


        for (WebElement element : AtThisTimeICompletedCheckBoxBtns) {
            if (element.getText( ).contains(atThisTimeICompleted)) {
                element.click( );
                break;
            }
        }

        Utils.selectFromList(selectCareRelatedQualification, careRelatedQualification);


    }


    public void selectAddBtn() {
        addButton.click( );
    }

    public void clickNxtBtn() {
        nextButton.click( );
    }


}
