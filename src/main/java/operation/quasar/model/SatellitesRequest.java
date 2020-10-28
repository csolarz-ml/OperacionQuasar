package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Se usa el modelo para request
 */
@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(description = "Representation de la Clase Request Satelite")
public class SatellitesRequest extends SatellitesRequestSplit{

    @ApiModelProperty("name")
    private String name;


    public SatellitesRequest() {
    }

    public SatellitesRequest(Double distance, List<String> menssage) {
        super(distance, menssage);
    }

    public SatellitesRequest(List<String> menssage) {
        super(menssage);
    }

    public SatellitesRequest(Double distance) {
        super(distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SatellitesRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
