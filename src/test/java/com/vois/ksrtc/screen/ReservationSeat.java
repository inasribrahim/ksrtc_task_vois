package com.vois.ksrtc.screen;

import org.openqa.selenium.By;

public class ReservationSeat extends BaseScreen{

    private final By scrollToClickOnSeatToSelectDeSelectSeatText = By.xpath("//h6[text()='Click on seat to select/deselect seat']");

    private String getSeatNumberXpath(String seatNumber){
        return "//*[text()='"+seatNumber+"']";
    }

    public ReservationSeat scrollToSelectedSeat() throws InterruptedException {
        waitUtils.sleep(2000);
        scrollToElement(scrollToClickOnSeatToSelectDeSelectSeatText);
        return this;
    }

    public ReservationSeat choosePoint(String seatNumber){
        waitUtils.waitUntilElementUntilIsClickable(By.xpath(getSeatNumberXpath(seatNumber))).click();
        return this;
    }
}
