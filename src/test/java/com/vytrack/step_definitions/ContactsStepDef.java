package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
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
}
