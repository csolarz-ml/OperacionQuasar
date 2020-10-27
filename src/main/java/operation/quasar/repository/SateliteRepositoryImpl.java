package operation.quasar.repository;

import operation.quasar.model.Coordenada;
import operation.quasar.model.Satelite;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SateliteRepositoryImpl implements SateliteRepository {

    private List<Satelite> satelites;

    public SateliteRepositoryImpl() {

        satelites = new ArrayList<Satelite>();

        satelites.add(this.createSateliteKenobi());
        satelites.add(this.createSateliteSato());
        satelites.add(this.createSateliteSkywalker());

    }

    public Satelite createSateliteKenobi() {

        Long id = 1L;
        String nombre = "Kenobi";
        Coordenada coordenada = new Coordenada(-500.0F, -200.0F);
        Satelite satelite = new Satelite(id, nombre, null, null, coordenada);

        return satelite;
    }

    public Satelite createSateliteSato() {

        Long id = 2L;
        String nombre = "Sato";
        Coordenada coordenada = new Coordenada(500.0F, 100.0F);
        Satelite satelite = new Satelite(id, nombre, null, null, coordenada);

        return satelite;

    }

    private Satelite createSateliteSkywalker() {

        Long id = 3L;
        String nombre = "Skywalker";
        Coordenada coordenada = new Coordenada(100F, -100F);
        Satelite satelite = new Satelite(id, nombre, null, null, coordenada);

        return satelite;

    }

    @Override
    public List<Satelite> getAllSatellite() {
        return satelites;
    }

    @Override
    public Satelite getSateliteById(Long id) {
        return satelites.stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst().orElse(null);
    }

    @Override
    public Satelite getSateliteByName(String name) {
        return satelites.stream()
                .filter(x -> name.equalsIgnoreCase(x.getName()))
                .findFirst().orElse(null);
    }

    @Override
    public void update(Satelite satelite) {
        for (Satelite s: this.satelites ) {
            if(s.getName().equalsIgnoreCase(s.getName())){
                satelites.remove(s);
                break;
            }
        }
        satelites.add(satelite);
    }


}
