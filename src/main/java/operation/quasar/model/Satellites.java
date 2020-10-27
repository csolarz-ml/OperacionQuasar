package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Satellites {

    @ApiModelProperty("Satellites")
    private List<SatellitesRequest> satellites;

    public Satellites() {
        satellites = new ArrayList<SatellitesRequest>();
    }

    public Satellites(List<SatellitesRequest> satellites) {
        this.satellites = satellites;
    }

    public List<SatellitesRequest> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<SatellitesRequest> satellites) {
        this.satellites = satellites;
    }

}
