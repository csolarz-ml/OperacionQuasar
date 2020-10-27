package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;


@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Coordenada {

    @ApiModelProperty("id")
    private Float x;

    @ApiModelProperty("id")
    private Float y;

    public Coordenada(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
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

