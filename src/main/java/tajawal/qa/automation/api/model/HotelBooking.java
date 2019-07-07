package tajawal.qa.automation.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dates",
        "destination",
        "room",
        "placeId"
})
public class HotelBooking {

    @JsonProperty("dates")
    private Dates dates;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("room")
    private List<Room> room = null;
    @JsonProperty("placeId")
    private String placeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dates")
    public Dates getDates() {
        return dates;
    }

    @JsonProperty("dates")
    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("room")
    public List<Room> getRoom() {
        return room;
    }

    @JsonProperty("room")
    public void setRoom(List<Room> room) {
        this.room = room;
    }

    @JsonProperty("placeId")
    public String getPlaceId() {
        return placeId;
    }

    @JsonProperty("placeId")
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}