package operation.quasar.services;

import operation.quasar.model.Satelite;
import operation.quasar.model.Coordenada;
import operation.quasar.model.SatellitesRequest;

import java.util.List;

public interface SateliteService {

    List<Satelite> getAllSatelite();

    Satelite getSateliteById(Long id);

    Satelite getSateliteByName(String name);

    Coordenada getLocation(List<Double> distancias);

    Coordenada getUbicacion(List<Satelite> allSatellite);

    void updateSatelites(List<SatellitesRequest> satellites);

    String getMensajeSatelites(List<Satelite> allSatelite);

    void updatSatelite(String name, Double distance, List<String> message);
}
