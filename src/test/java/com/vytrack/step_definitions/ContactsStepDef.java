package com.vytrack.step_definitions;

import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ContactsStepDef {
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String usertype) {
        Driver.get().get(ConfigurationReader.get("url"));
        String username = null;
        String password = null;

        if (usertype.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (usertype.equals("sales manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (usertype.equals("store manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }

        new LoginPage().login(username, password);
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        //get the list of web elements and convert them to String
        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualOptions = BrowserUtils.getElementsText(dashboardPage.menuOptions);

        //or you can use
        /*List<String> ActualMenuOptions = null;
        for (int i = 0; i < (dashboardPage.menuOptions.size()-1); i++) {
            ActualMenuOptions.add(dashboardPage.menuOptions.get(i).getText());

        }*/

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);


    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> userInfo) {
        System.out.println(userInfo);
        //use map information to login and also verify firstname and lastname
        //login with map info
        new LoginPage().login(userInfo.get("username"), userInfo.get("password"));
        //verify firstname and lastname
        String actualName = new DashboardPage().getUserName();
        String expectedName = userInfo.get("firstname") + " " + userInfo.get("lastname");

        Assert.assertEquals(expectedName, actualName);
        System.out.println("expectedName = " + expectedName);
        System.out.println("actualName = " + actualName);
    }

    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {
        BrowserUtils.waitFor(10);
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail(email).click();
    }

    @Then("information should ben same with database")
    public void information_should_ben_same_with_database() {
        BrowserUtils.waitFor(5);
        //get info from ui
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        //database Connection
        DBUtils.createConnection(); //Normally I should put in hooks

        //we are getting only one row of result
        String query = "select concat (first_name, ' ' , last_name) as \"full_name\" , e.email , phone\n" +
                "from orocrm_contact c  join orocrm_contact_email e\n" +
                "on c.id = e.owner_id join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email='mbrackstone9@example.com'";
        Map<String,Object> rowMap = DBUtils.getRowMap(query);
        String expectedFullName = (String) rowMap.get("full_name"); //casting
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");
        System.out.println(expectedFullName + expectedEmail + expectedPhone);
        DBUtils.closeConnection(); //Normally I should put in hooks

        //assertion
        Assert.assertEquals(expectedFullName,actualFullName);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);




    }




}
