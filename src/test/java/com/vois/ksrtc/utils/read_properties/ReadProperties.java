package com.vois.ksrtc.utils.read_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
   private ReadProperties(){}
   private static final String ROOT_PATH = System.getProperty("user.dir") +"/src/test/resources/";
   private static final String BOOKING_CONFIG_PATH=ROOT_PATH.concat("booking_config.properties");
    public static Properties setkarnatakeStateRoadTransportCorporationConfig() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(BOOKING_CONFIG_PATH);
        configProperties.load(inputStream);
        return configProperties;
    }
}
