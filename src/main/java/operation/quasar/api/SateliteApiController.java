package operation.quasar.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import operation.quasar.model.Coordenada;
import operation.quasar.model.PositionResponse;
import operation.quasar.model.Satellites;
import operation.quasar.model.SatellitesRequestSplit;
import operation.quasar.services.SateliteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class SateliteApiController implements SateliteApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(SateliteApiController.class);


    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private SateliteServiceImpl sateliteService;


    public SateliteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    @Override

    public ResponseEntity<PositionResponse> topsecret(@ApiParam(value = "object that needs to be added to the store", required = true)
                                                      @Valid @RequestBody Satellites requestSatelites) {

        LOGGER.info("topsecret recibe: " + requestSatelites.toString());

        sateliteService.updateSatelites(requestSatelites.getSatellites());
        Coordenada coordenada = sateliteService.getUbicacion(sateliteService.getAllSatelite());

        String mensaje = sateliteService.getMensajeSatelites(sateliteService.getAllSatelite());

        return ResponseEntity.ok().body(new PositionResponse(coordenada, mensaje));
    }

    @Override
    public ResponseEntity<Void> topsecretSplit(@PathVariable("name") String name, @Valid @RequestBody SatellitesRequestSplit satellitesRequestSplit) {

        LOGGER.info("topsecretSplit recibe: name: "+name +" mas "+ satellitesRequestSplit.toString());

        sateliteService.updatSatelite(name, satellitesRequestSplit.getDistance(), satellitesRequestSplit.getMessage());

        return null;
    }


    public ResponseEntity<PositionResponse> topsecretSplitGet() {

        String mensaje = sateliteService.getMensajeSatelites(sateliteService.getAllSatelite());
        Coordenada coordenada = sateliteService.getUbicacion(sateliteService.getAllSatelite());

        return ResponseEntity.ok().body(new PositionResponse(coordenada, mensaje));

    }
}
