package com.vytrack.step_definitions;

import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before //Make sure it is cucumber method. NOT J UNIT!!!!!!
    public void setUp() {

        System.out.println("hooks before method");
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }



    //I will define a custom hooks
    //it will run just with defined tag
    @Before("@Database") //This is for database
    public void setUpDatabase() {
        System.out.println("this is before---------------");
        //DBUtils.createConnection();
    }

    @After("@Database")
    public void tearDownDatabase() {
        System.out.println("this is after-----------");
        //DBUtils.closeConnection();
    }
}
