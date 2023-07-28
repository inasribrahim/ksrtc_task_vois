package com.vois.ksrtc.tests;

import com.vois.ksrtc.utils.generate_data.GenerateData;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class KSRTCTest extends BaseTest{
    GenerateData generateData = new GenerateData();

    /*VOIS Scenario 1 */

    @Test
    public void verifyUserCanBookingInKSRTCT() throws InterruptedException {
        GenerateData generateData = new GenerateData();
        String date = "29";
        String rootName = " Chikkamagaluru - Bengaluru";

        browser.ksrtc.bookingHome.scrollToBookYourTicketsNowText()
                                 .clickOnRouteName(rootName);

        browser.ksrtc.bookingHome.scrollToBookYourTicketsNowText()
                                .makePageDown()
                                .makeCurrentDay()
                                .enterArrivalDate(date)
                                .clickOnBusBookButton();

        String seatTimeStart = "12:01";
        String seatTimeArive = "16:45";

        String seatPointNumber = "15";
        browser.ksrtc.bookingHome.getAvailBookScreen()
                                 .scrollToSortBy()
                                 .clickOnSeatByTime(seatTimeStart,seatTimeArive)
                                 .getReservationSeat()
                                 .scrollToSelectedSeat()
                                 .choosePoint(seatPointNumber);

        String mobileNumber = "6789125987";
        browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                                 .scrollToCustomerDetails()
                                 .clickOnCustomerDetails()
                                 .enterMobileNumber(mobileNumber)
                                 .enterEmailAddress(generateData.generateEmail());

        String actualBoardingPoint = "CHIKKAMAGALURU BUS STAND - ".concat(seatTimeStart);
        assertEquals(browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                                        .clickOnBoardingPointButton()
                                        .getBoardingPointDetails(),actualBoardingPoint);

        String actualDroppingPoint = "KEMPEGOWDA BS MAJESTIC - ".concat(seatTimeArive);
        assertEquals(browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                                        .clickOnDroppingPointButton()
                                        .getDroppingPointDetails(),actualDroppingPoint);

        int passengerNumberOne = 1;
        browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                        .enterPassengerName(passengerNumberOne,generateData.generatePassengerName())
                        .enterPassengerAge(passengerNumberOne, String.valueOf(generateData.generateAge()))
                        .selectGender(passengerNumberOne,"MALE".trim())
                        .selectConcession(passengerNumberOne,"GENERAL PUBLIC")
                        .selectNationality(passengerNumberOne,"Egypt");

    }

    @Test
    public void verifyUserCanAddMoreSeats() throws InterruptedException {
        GenerateData generateData = new GenerateData();
        String date = "29";
        String rootName = " Chikkamagaluru - Bengaluru";

        browser.ksrtc.bookingHome.scrollToBookYourTicketsNowText()
                .clickOnRouteName(rootName);

        browser.ksrtc.bookingHome.scrollToBookYourTicketsNowText()
                .makePageDown()
                .makeCurrentDay()
                .enterArrivalDate(date)
                .clickOnBusBookButton();

        String seatTimeStart = "12:01";
        String seatTimeArive = "16:45";

        String seatPointNumber = "15";
        String seatPointNumber2 = "17";
        browser.ksrtc.bookingHome.getAvailBookScreen()
                .scrollToSortBy()
                .clickOnSeatByTime(seatTimeStart,seatTimeArive)
                .getReservationSeat()
                .scrollToSelectedSeat()
                .choosePoint(seatPointNumber)
                .choosePoint(seatPointNumber2);

        String mobileNumber = "6789125987";
        browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                .scrollToCustomerDetails()
                .clickOnCustomerDetails()
                .enterMobileNumber(mobileNumber)
                .enterEmailAddress(generateData.generateEmail());

        String actualBoardingPoint = "CHIKKAMAGALURU BUS STAND - ".concat(seatTimeStart);
        assertEquals(browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                .clickOnBoardingPointButton()
                .getBoardingPointDetails(),actualBoardingPoint);

        String actualDroppingPoint = "KEMPEGOWDA BS MAJESTIC - ".concat(seatTimeArive);
        assertEquals(browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                .clickOnDroppingPointButton()
                .getDroppingPointDetails(),actualDroppingPoint);

        int passengerNumberOne = 1;
        browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                .enterPassengerName(passengerNumberOne,generateData.generatePassengerName())
                .enterPassengerAge(passengerNumberOne, String.valueOf(generateData.generateAge()))
                .selectGender(passengerNumberOne,"MALE".trim())
                .selectConcession(passengerNumberOne,"GENERAL PUBLIC")
                .selectNationality(passengerNumberOne,"Egypt");

        int passengerNumberTwo = 2;
        browser.ksrtc.bookingHome.getAvailBookScreen().getCustomerDetails()
                .enterPassengerName(passengerNumberTwo,generateData.generatePassengerName())
                .enterPassengerAge(passengerNumberTwo, String.valueOf(generateData.generateAge()))
                .selectGender(passengerNumberTwo,"MALE".trim())
                .selectConcession(passengerNumberTwo,"GENERAL PUBLIC")
                .selectNationality(passengerNumberTwo,"Egypt");
    }

}
