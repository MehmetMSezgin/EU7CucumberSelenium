package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage login = new LoginPage();

        login.login(username,password);

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        Thread.sleep(4000);
        DashboardPage dashboard = new DashboardPage();
        String actualtitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualtitle);
    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() throws InterruptedException {
        String username = ConfigurationReader.get("sale_manager_username");
        String password = ConfigurationReader.get("sale_manager_password");
        LoginPage login = new LoginPage();

        login.login(username,password);
        Thread.sleep(3000);
    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        LoginPage login = new LoginPage();

        login.login(username,password);
    }

    @Then("Database Check")
    public void database_Check() {
        System.out.println("Database is checking...");
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));

    }

}
