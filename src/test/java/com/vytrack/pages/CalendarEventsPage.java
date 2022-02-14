package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsPage extends BasePage {

//PageFactory.initElements(Driver.get(), this);
    //i did it in basepage no need second time

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//input[@data-name='recurrence-repeat'])")
    public WebElement repeat ;

}
