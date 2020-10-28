package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;


@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(description = "Representation de la Clase Coordenada")
public class Coordenada {

    @ApiModelProperty("id")
    private Double x;

    @ApiModelProperty("id")
    private Double y;

    public Coordenada(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

