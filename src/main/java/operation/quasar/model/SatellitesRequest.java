package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SatellitesRequest extends SatellitesRequestSplit{

    @ApiModelProperty("name")
    private String name;


    public SatellitesRequest() {
    }

    public SatellitesRequest(Float distance, List<String> menssage) {
        super(distance, menssage);
    }

    public SatellitesRequest(List<String> menssage) {
        super(menssage);
    }

    public SatellitesRequest(Float distance) {
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
