package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends BasePage {

    @FindBy(css=".input-widget")
    public WebElement pageNumber;


    @FindBy(css = "tr[class='grid-row row-click-action']")
    public List<WebElement> listOfPersons ;

    public WebElement personFinder (String name) {
        for (WebElement elements : listOfPersons) {
            if(elements.getText().contains(name)){
                return elements;
            }
        }
        return null ;
    }

    public WebElement getContactEmail(String email){
        String xpath = "//*[contains(text(), '"+email+"') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }


}
