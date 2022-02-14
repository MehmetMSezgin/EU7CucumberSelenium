package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

public class NavigationMenuStepDefs {
    @When("the user navigates to Fleet, Vehicle")
    public void the_user_navigates_to_Fleet_Vehicle() {
        System.out.println("user navigates fleet to vehicle");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("title is checking...");
    }

    @When("the user navigates to Marketing, Campaigns")
    public void the_user_navigates_to_Marketing_Campaigns() {
        System.out.println("user navigates to campaigns");

    }

    @Then("the title should be Campaigns")
    public void the_title_should_be_Campaigns() {
        System.out.println("title is checking...");

    }

    @When("the user navigates to Activities , Calendar Events")
    public void the_user_navigates_to_Activities_Calendar_Events() {
        System.out.println("user navigates to Calendar Events");

    }

    @Then("the title should be Calendar Events")
    public void the_title_should_be_Calendar_Events() {
        System.out.println("title is checking...");

    }

    @When("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        DashboardPage dashboard = new DashboardPage();
        dashboard.navigateToModule(tab, module);
        //if you wanna use one time you can use
        //new DashboardPage().navigateToModule(tab,module);
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(3);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNum, actualNumber);

    }


}
