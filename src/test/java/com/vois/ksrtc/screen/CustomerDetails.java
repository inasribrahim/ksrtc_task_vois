package com.vois.ksrtc.screen;

import com.vois.ksrtc.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerDetails extends BaseScreen {
    private final By customerDetailsButton = By.id("Forwardprofile-tab");
    private final By mobileNumberFields = By.name("mobileNo");
    private final By emailFields = By.name("email");
    private final By passengerNameFields = By.name("passengerName");
    private final By passengerAgeFields = By.name("passengerAge");

    private final By boardingPointButton = By.xpath("//a[text()='Boarding Point']");
    private final By droppingPointButton = By.xpath("//a[text()='Dropping Point']");
    private final By boardingPointText = By.xpath("//li[@class=\"p-2 Forward-boarding active1\"]");
    private final By droppingPointText = By.xpath("//li[@class=\"p-2 Forward-droping active1\"]");
    private Select select;

    public CustomerDetails scrollToCustomerDetails(){
        scrollToElement(customerDetailsButton);
        return this;
    }

    public String getBoardingPointDetails() throws InterruptedException {
        waitUtils.sleep(2000);
        return getElementText(boardingPointText);
    }

    public String getDroppingPointDetails() throws InterruptedException {
        waitUtils.sleep(2000);
        return getElementText(droppingPointText);
    }
    public void enterEmailAddress(String emailAddress){
        waitUtils.waitUntilElementIsPresence(emailFields).sendKeys(emailAddress);
    }

    public CustomerDetails enterMobileNumber( String mobileNumber) throws InterruptedException {
        waitUtils.sleep(2000);
        waitUtils.waitUntilElementIsPresence(mobileNumberFields).sendKeys(mobileNumber);
        return this;
    }

    public CustomerDetails enterPassengerName(int index ,String passengerName){
        getElements(passengerNameFields).get(index-1).sendKeys(passengerName);
        return this;
    }

    public CustomerDetails enterPassengerAge(int index ,String passengerAge){
        getElements(passengerAgeFields).get(index-1).sendKeys(passengerAge);
        return this;
    }

    public CustomerDetails selectGender(int index,String gender){
        WebElement genderSelector = DriverManager.getWebDriver().findElement(By.id("genderCodeIdForward"+(index-1)));
        select = new Select(genderSelector);
        select.selectByVisibleText(gender);
        return this;
    }
    public CustomerDetails selectConcession(int index,String concession) throws InterruptedException {
        waitUtils.sleep(2000);
        WebElement concessionSelector = DriverManager.getWebDriver().findElement(By.id("concessionIdsForward"+(index-1)));
        select = new Select(concessionSelector);
        select.selectByVisibleText(concession);
        return this;
    }
    public void selectNationality(int index,String nationality){
        WebElement nationalitySelector = DriverManager.getWebDriver().findElement(By.id("nationalityForward"+(index-1)));
        select = new Select(nationalitySelector);
        select.selectByVisibleText(nationality);
    }

    public CustomerDetails clickOnCustomerDetails(){
        waitUtils.waitUntilElementUntilIsClickable(customerDetailsButton).click();
        return this;
    }

    public CustomerDetails clickOnBoardingPointButton(){
        waitUtils.waitUntilElementUntilIsClickable(boardingPointButton).click();
        return this;
    }

    public CustomerDetails clickOnDroppingPointButton(){
        waitUtils.waitUntilElementUntilIsClickable(droppingPointButton).click();
        return this;
    }


}
