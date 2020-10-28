package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(description = "Representation de la Clase respues de posicion")
public class PositionResponse {

    @ApiModelProperty("position")
    private Coordenada position;

    @ApiModelProperty("message")
    private String message;

    public PositionResponse(Coordenada coordenada, String mensaje) {
        this.position = coordenada;
        this.message = mensaje;
    }

    public Coordenada getPosition() {
        return position;
    }

    public void setPosition(Coordenada position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PositionResponse() {
    }
}
