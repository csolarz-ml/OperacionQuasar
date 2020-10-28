
package operation.quasar.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import operation.quasar.model.ApiError;
import operation.quasar.model.PositionResponse;
import operation.quasar.model.Satellites;
import operation.quasar.model.SatellitesRequestSplit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/v2")
public interface SateliteApi {


    @ApiOperation(value = "Metodo para consultar la distancia", nickname = "getDistance", response = PositionResponse.class, tags = {"topsecret_split",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PositionResponse.class),
            @ApiResponse(code = 404, message = "Satelite not found", response = ApiError.class)})

    @GetMapping(value = "/topsecret_split")
    ResponseEntity<PositionResponse> topsecretSplitGet();


    @ApiOperation(value = "Se realiza la carga de los mensajes y distancias de los satelites", nickname = "Carga Principal", notes = "", response = PositionResponse.class, tags = {"topsecret",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PositionResponse.class),
            @ApiResponse(code = 404, message = "Satelite not found", response = ApiError.class)})

    @PostMapping(value = "/topsecret")
    ResponseEntity<PositionResponse> topsecret(@ApiParam(value = "Reques que se necesita para realizar la carga principal", required = true)
                                               @Valid @RequestBody Satellites requestSatelites);


    @ApiOperation(value = "Agrego la distancia de un satelite", nickname = "CargaSatelite", notes = "", tags = {"topsecret_split",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PositionResponse.class),
            @ApiResponse(code = 404, message = "Satelite not found", response = ApiError.class)})

    @PostMapping(value = "/topsecret_split/{name}")
    ResponseEntity<Void> topsecretSplit(@ApiParam(value = "Metodo que se usa para Agregor la distancia de un satelite", required = true)
                                        @PathVariable("name") String name, @Valid @RequestBody SatellitesRequestSplit satellitesRequestSplit);
}
