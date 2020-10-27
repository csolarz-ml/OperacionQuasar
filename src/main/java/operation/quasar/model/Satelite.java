package operation.quasar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * User
 */
@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Satelite {
    @ApiModelProperty("id")
    private Long id = null;

    @ApiModelProperty("name")
    private String name = null;

    @ApiModelProperty("distance")
    private Float distance = null;

    @ApiModelProperty("message")
    private List<String> message = null;

    @ApiModelProperty("coordenada")
    private Coordenada coordenada;

    public Satelite(Long id, String name, Float distance, List<String> menssage, Coordenada coordenada) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.message = menssage;
        this.coordenada = coordenada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public List<String> getListaMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    /*
    // input: distancia al emisor tal cual se recibe en cada satélite
    // output: las coordenadas ‘x’ e ‘y’ del emisor del mensaje
    func GetLocation(distances ...float32) (x, y float32)    * */
    public Coordenada GetLocation(Float distance) {
        return this.getCoordenada();
    }


    // input: el mensaje tal cual es recibido en cada satélite
    // output: el mensaje tal cual lo genera el emisor del mensaje
    //    func GetMessage(messages ...[]string) (msg string)
    public String GetMessage(List<String> messages) {
        this.message=messages;
        StringBuilder mensaje = new StringBuilder();

        for (String m : messages) {
            if (!m.isEmpty()) {
                mensaje.append(" ");
                mensaje.append(m);
            }
        }
        mensaje=mensaje.replace(0,1,"");
        return mensaje.toString();
    }


    @Override
    public String toString() {
        return "Satelite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", message=" + message +
                ", coordenada=" + coordenada +
                '}';
    }
}

