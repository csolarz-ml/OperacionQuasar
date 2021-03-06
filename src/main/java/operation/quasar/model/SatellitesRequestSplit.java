package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(description = "Representation de la Clase request Split Satelite")

public class SatellitesRequestSplit {
    @ApiModelProperty("distance")
    private Double distance;

    @ApiModelProperty("message")
    private List<String> message;

    public SatellitesRequestSplit() {

    }

    public SatellitesRequestSplit(Double distance, List<String> menssage) {
        this.distance = distance;
        this.message = menssage;
    }


    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }


    public SatellitesRequestSplit(List<String> menssage) {
        this.message = menssage;
    }

    public SatellitesRequestSplit(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "SatellitesRequestSplit{" +
                "distance=" + distance +
                ", message=" + message +
                '}';
    }


}
