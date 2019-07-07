package tajawal.qa.automation.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "guest"
})
public class Room {

    @JsonProperty("guest")
    private List<Guest> guest = null;

    @JsonProperty("guest")
    public List<Guest> getGuest() {
        return guest;
    }

    @JsonProperty("guest")
    public void setGuest(List<Guest> guest) {
        this.guest = guest;
    }
}