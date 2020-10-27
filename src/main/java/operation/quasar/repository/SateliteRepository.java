package operation.quasar.repository;

import operation.quasar.model.Satelite;

import java.util.List;

public interface SateliteRepository {

    public List<Satelite> getAllSatellite();

    public Satelite getSateliteById(Long id);

    public Satelite getSateliteByName(String name);

    public void update(Satelite satelite);

}
