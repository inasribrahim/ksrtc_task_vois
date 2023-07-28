package com.vois.ksrtc.screen;

import com.vois.ksrtc.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.Objects;

public class AvailBookScreen extends BaseScreen{

    private final ReservationSeat reservationSeat;
    private final CustomerDetails customerDetails;
    private final By scrollToSortBy = By.id("sortby");

    public AvailBookScreen(){
        reservationSeat = new ReservationSeat();
        customerDetails = new CustomerDetails();
    }

    private String getStartTimeXpath(String startTime){
        return "//*[text()='"+startTime+"']";
    }

    private String getAvailTimeXpath(String availTime){
        return "//*[text()='"+availTime+"']";
    }

    public ReservationSeat getReservationSeat(){
        return reservationSeat;
    }

    public CustomerDetails getCustomerDetails(){
        return customerDetails;
    }

    public AvailBookScreen scrollToSortBy() throws InterruptedException {
        waitUtils.sleep(2000);
        scrollToElement(scrollToSortBy);
        return this;
    }
    public AvailBookScreen clickOnSeatByTime(String startTime, String availTime) throws InterruptedException {
        String index ;
        waitUtils.sleep(3000);
        String indexStartTime = DriverManager.getWebDriver().findElement(By.xpath(getStartTimeXpath(startTime))).getAttribute("id");
        String indexAriveTime = DriverManager.getWebDriver().findElement(By.xpath(getAvailTimeXpath(availTime))).getAttribute("id");
        if(Objects.equals(indexStartTime.split("bPtsDiv_Forward")[1], indexAriveTime.split("aPtsDiv_Forward")[1])) {
            index =indexStartTime.split("bPtsDiv_Forward")[1];
            WebElement seatButton = DriverManager.getWebDriver().findElement(By.id("SrvcSelectBtnForward" + index));
            clickOnElementUsingJS(seatButton);
             }
        return this;
        }

}



