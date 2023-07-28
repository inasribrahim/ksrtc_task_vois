package com.vois.ksrtc.tests;

import com.vois.ksrtc.browser.Browser;
import com.vois.ksrtc.driver.Driver;
import com.vois.ksrtc.utils.read_properties.ReadProperties;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    protected static Browser browser = new Browser();
    public static String getBrowserName() throws IOException {
        return ReadProperties.setkarnatakeStateRoadTransportCorporationConfig().getProperty("browserName");
    }

    @BeforeTest(alwaysRun = true)
    protected void setUp() throws IOException {
        Driver.initDriver(getBrowserName());
        Driver.setBrowserResolution();
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {
        Driver.closeDriver();
    }
}
