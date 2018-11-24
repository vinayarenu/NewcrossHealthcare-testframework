package com.testing.stepDefs;

import com.testing.Pages.HomePage;
import com.testing.Pages.PersonalDetailsPage;
import com.testing.Pages.QualificationAndTrainingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegisterSteps {

    HomePage homePage = new HomePage( );
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage( );
    QualificationAndTrainingPage qualificationAndTrainingPage = new QualificationAndTrainingPage( );

    @Given("^User is on the home page$")
    public void user_is_on_the_home_page() {
        String url = homePage.getUrl( );
        Assert.assertEquals("http://test.oaf.healthforcego.com/", url);


    }

    @When("^user enters email as \"([^\"]*)\"$")
    public void user_enters_email_as(String email) {
        homePage.enterEmailId(email);

    }

    @When("^enters password as \"([^\"]*)\"$")
    public void enters_password_as(String pwd) {
        homePage.enterPassword(pwd);
    }

    @When("^enters password confirmation as \"([^\"]*)\"$")
    public void enters_password_confirmation_as(String pwdConfirm) {
        homePage.passwordConfirmation(pwdConfirm);

    }

    @When("^selects all checkboxes$")
    public void selects_all_checkboxes() {
        homePage.selectCheckBoxes( );

    }

    @When("^selects register$")
    public void selects_register() {
        homePage.selectsRegister( );

    }

//    @Then("^user should navigate to personal details page$")
//    public void user_should_navigate_to_personal_details_page() {
//
//    }

    @When("^enters all personal details \"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"$")
    public void enters_all_personal_details_and_and_and(String title, String firstName, String lastName, String mobNo) {
        personalDetailsPage.enterPersonalDetails(title, firstName, lastName, mobNo);

    }

    @When("^enters postcode \"([^\"]*)\"$")
    public void enters_postecode(String postCode) {
        personalDetailsPage.enterPostcode(postCode);

    }

    @When("^selects Lookup address\"([^\"]*)\"$")
    public void selects_Lookup_address(String lookUpAddress) {
        personalDetailsPage.selectsLookUpAddress(lookUpAddress);

    }

    @When("^selects next button$")
    public void selects_next_button() {
        personalDetailsPage.selectNextButton( );

    }

//    @Then("^user should navigate to Qualifications & Training page$")
//    public void user_should_navigate_to_Qualifications_Training_page() {
//
//    }

    @When("^selects Add Qualification$")
    public void selects_Add_Qualification() {
        qualificationAndTrainingPage.selectAddQualificatiobBtn( );


    }

    @When("^fills the qualification form details \"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"$")
    public void fills_the_qualification_form(String dateCompleted, String atThisTimeICompleted, String careRelatedQualification) {
        qualificationAndTrainingPage.fillingQualificationForm(dateCompleted, atThisTimeICompleted, careRelatedQualification);


    }

    @When("^selects add button$")
    public void selects_add_button() {
        qualificationAndTrainingPage.selectAddBtn( );

    }

    @When("^clicks next button$")
    public void clicks_next_button() {
        qualificationAndTrainingPage.clickNxtBtn( );

    }

    //    @Then("^user should navigate to history page$")
//    public void user_should_navigate_to_history_page() {
//
//    }
    @Then("^user should see error message\"([^\"]*)\"$")
    public void user_should_see_error_message(String msg) {
     boolean message =   homePage.passwordErrorMsg(msg);
     Assert.assertTrue(message);


    }

    @Then("^user should see mobile error message in personal details\"([^\"]*)\"$")
    public void user_should_see_error_message_in_personal_details(String msg)  {
       boolean message= personalDetailsPage.mobileErrorMessage(msg);
        Assert.assertTrue(message);
    }

    @Then("^user should see firstname error message in personal details\"([^\"]*)\"$")
    public void user_should_see_firstname_error_message_in_personal_details(String msg)  {
        boolean message = personalDetailsPage.firstNameErrorMessage(msg);
        Assert.assertTrue(message);

    }

    @Then("^user should see lastname error message in personal details\"([^\"]*)\"$")
    public void user_should_see_lastname_error_message_in_personal_details(String msg)  {

        boolean message = personalDetailsPage.lastNameErrorMessage(msg);
        Assert.assertTrue(message);
    }



}
