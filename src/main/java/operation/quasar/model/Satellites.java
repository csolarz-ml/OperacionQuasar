package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

/**
 * Se usa el modelo para request
 */
@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(description = "Representation de la Clase que contiene una lista de Request de satelites")
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
