package com.vois.ksrtc.screen;

import com.vois.ksrtc.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Calendar;
import java.util.List;

public class BookingHome extends BaseScreen {

    private final AvailBookScreen availBookScreen;

    public BookingHome(){
        availBookScreen = new AvailBookScreen();
    }

    public AvailBookScreen getAvailBookScreen(){
        return availBookScreen;
    }
    private final By bookYourTicketsNowTextField = By.xpath("//div[@class='home-search-title main-booking-titile']");
    private final By arrivalDateField =  By.id("txtReturnJourneyDate");

    private final By currentDateField = By.id("txtJourneyDate");
    private final By searchButton = By.xpath("//button[@class=\"btn btn-primary btn-lg btn-block btn-booking\"]");


    public BookingHome scrollToBookYourTicketsNowText() {
        scrollToElement(bookYourTicketsNowTextField);
        return this;
    }

    public void clickOnRouteName(String name){
        WebElement nextLink = DriverManager.getWebDriver().findElement(By.xpath("//span[text()='Next']"));
        boolean flag = false;
        String xpath = "//*[text()='" + name + "']";
        By rootName = By.xpath(constructXpath(xpath, name));
        do {
            if (elementIsExisted(rootName)) {
                flag = true;
                waitUtils.waitUntilElementUntilIsClickable(rootName).click();
            }
            clickOnElementUsingJS(nextLink);
        } while (!flag);
    }

    public BookingHome enterArrivalDate(String arrivalDate) {
        waitUtils.waitUntilElementUntilIsClickable(arrivalDateField).click();
        List<WebElement> allDates = DriverManager.getWebDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : allDates) {
            String date = ele.getText();
            if (date.equalsIgnoreCase(arrivalDate)) {
                ele.click();
                break;
            }
        }
        return this;
    }

    public BookingHome makePageDown(){
        Actions A = new Actions(DriverManager.getWebDriver());
        A.sendKeys(Keys.PAGE_DOWN).build().perform();
        return this;
    }
    public BookingHome makeCurrentDay() throws InterruptedException {
        waitUtils.sleep(2000);
        waitUtils.waitUntilElementUntilIsClickable(currentDateField).click();
        List<WebElement> allDates = DriverManager.getWebDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : allDates) {
            String date = ele.getText();
            if (date.equalsIgnoreCase(getCurrentDay())) {
                ele.click();
                break;
            }
        }
        return this;
    }

    public String getCurrentDay(){
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
    }
    public  void clickOnBusBookButton() throws InterruptedException {
        waitUtils.sleep(2000);
        waitUtils.waitUntilElementUntilIsClickable(searchButton).click();
    }
}