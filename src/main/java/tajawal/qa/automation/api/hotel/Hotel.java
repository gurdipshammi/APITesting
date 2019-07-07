package tajawal.qa.automation.api.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import tajawal.qa.automation.api.ApiUtils;
import tajawal.qa.automation.api.data.*;
import tajawal.qa.automation.api.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

/**
 * @author Gurdip, July 5, 2019
 */

public class Hotel implements GlobalConstants {

    CalDate c = new CalDate();
    String checkinDate = c.getFutureDate(checkinDays);
    String checkoutDate = c.getFutureDate(checkoutDays);

    String current, currentPath;

    {
        try {
            current = new File(".").getCanonicalPath();
            currentPath = current + ApiUtils.getProperty("dir");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response getHotelSearch() throws Exception {
        Response response =
                given()
                        .header("Content-Type", ContentType)
                        .param("query", query)
                        .get(EndPoints.getHotelSearchEP())
                        .then()
                        .extract().response();

        ApiUtils.checkStatusIs200(response, "hotelSearch");
        return response;
    }

    public Response postHotelBooking(int ADTCount, int CHDCount, int childAge) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HotelBooking json = objectMapper.readValue(new File(currentPath + "jsonData/HotelBooking.json"), HotelBooking.class);
        Dates dates = new Dates();
        dates.setCheckin(checkinDate);
        dates.setCheckout(checkoutDate);
        json.setDates(dates);

        List<Room> roomList = new ArrayList<>();
        roomList = setGuests(ADTCount, CHDCount, childAge);
        json.setRoom(roomList);

        Response response =
                given()
                        .header("Content-Type", ContentType)
                        .body(json)
                        .when()
                        .post(EndPoints.postHotelBookingEP())
                        .then()
                        .extract().response();
        System.out.println(json);

        ApiUtils.checkStatusIs200(response, "HotelBooking");
        System.out.println(response.asString());
        return response;
    }

    private List<Room> setGuests(int ADTCount, int CHDCount, int childAge){
        List<Guest> guestList1 = new ArrayList<Guest>();
        Guest guestADT1 = new Guest();
        Guest guestCHD1 = new Guest();
        for(int i=0; i < ADTCount; i++){
            guestADT1.setType("ADT");
            guestList1.add(guestADT1);
        }

        for(int j=0; j < CHDCount; j++){
            guestCHD1.setType("CHD");
            guestCHD1.setAge(childAge);
            guestList1.add(guestCHD1);
        }

        Room room = new Room();
        room.setGuest(guestList1);

        List<Room> roomList1 = new ArrayList<Room>();
        roomList1.add(room);
        return roomList1;
    }
}