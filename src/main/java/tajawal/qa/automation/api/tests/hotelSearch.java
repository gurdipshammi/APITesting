package tajawal.qa.automation.api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import tajawal.qa.automation.api.ApiUtils;
import tajawal.qa.automation.api.data.CalDate;
import tajawal.qa.automation.api.data.GlobalConstants;
import tajawal.qa.automation.api.hotel.*;


/**
 * @author Gurdip, July 6, 2019
 */

public class hotelSearch {

    Hotel hotel = new Hotel();
    ApiUtils apiUtils = new ApiUtils();

    @Test
    public void hotelSearch() throws Exception {
        Response response = hotel.getHotelSearch();
        apiUtils.verifyResponse(response, "hotels.city", GlobalConstants.query);
        apiUtils.verifyResponse(response, "locations.name", GlobalConstants.query);
    }

    @Test
    public void hotelBooking() throws Exception {
        //for(int i =0 ; i<GlobalConstants.roomCount ; i++){
        Response response = hotel.postHotelBooking(GlobalConstants.ADTCount, GlobalConstants.CHDCount, GlobalConstants.childAge);

        String RoomBooking = Integer.toString(GlobalConstants.ADTCount)+"_adult," + Integer.toString(GlobalConstants.CHDCount)+"_child," +Integer.toString(GlobalConstants.childAge)+"_age";
        apiUtils.verifyResponseValue(response, "query", RoomBooking);

        CalDate c = new CalDate();
        String checkinDate = c.getFutureDate(GlobalConstants.checkinDays);
        String checkoutDate = c.getFutureDate(GlobalConstants.checkoutDays);
        apiUtils.verifyResponseValue(response, "query", checkinDate);
        apiUtils.verifyResponseValue(response, "query", checkoutDate);
    }
}
