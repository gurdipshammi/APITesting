package tajawal.qa.automation.api.data;

import tajawal.qa.automation.api.ApiUtils;

import java.util.Properties;
/**
 * @author Gurdip, July 4, 2019
 */

public class EndPoints {
    static Properties prop = new Properties();

    public static String getbaseURI() {
        String baseURI = ApiUtils.getProperty("baseURI");
        return baseURI;
    }

    public static String getHotel() {
        String hotelSearch = ApiUtils.getProperty("hotelSearch");
        return hotelSearch;
    }

    public static String getHotelBooking() {
        String hotelBooking = ApiUtils.getProperty("hotelBooking");
        return hotelBooking;
    }

    public static String getHotelSearchEP() {
        return getbaseURI() + getHotel();
    }

    public static String postHotelBookingEP() {
        return getbaseURI() + getHotelBooking();
    }
}