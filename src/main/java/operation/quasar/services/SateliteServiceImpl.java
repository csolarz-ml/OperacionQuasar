package operation.quasar.services;

import operation.quasar.model.Satelite;
import operation.quasar.model.Coordenada;
import operation.quasar.model.SatellitesRequest;
import operation.quasar.repository.SateliteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SateliteServiceImpl implements SateliteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SateliteServiceImpl.class);


    @Autowired
    private SateliteRepository sateliteRepository;

    @Override
    public List<Satelite> getAllSatelite() {
        return sateliteRepository.getAllSatellite();
    }

    @Override
    public Satelite getSateliteById(Long id) {
        return sateliteRepository.getSateliteById(id);
    }

    @Override
    public Satelite getSateliteByName(String name) {
        return sateliteRepository.getSateliteByName(name);
    }

    @Override
    public Coordenada getLocation(List<Double> distancias) {
        LOGGER.info("getLocation recibe: " + distancias.toString());

        //setea las  distancias a los satelites
        for (int i = 0; i < sateliteRepository.getAllSatellite().size(); i++) {
            sateliteRepository.getAllSatellite().get(i).setDistance(distancias.get(i));
        }
        return this.getUbicacion(sateliteRepository.getAllSatellite());
    }

    /**Metodo de trilaterazion que se utiliza para ubicar un punto entre 3 satelites **/

    @Override
    public Coordenada getUbicacion(List<Satelite> lista) {
        LOGGER.info("getUbicacion recibe: " + lista.toString());

        Double A = 2 * lista.get(1).getCoordenada().getX() - 2 * lista.get(0).getCoordenada().getX();
//        Double A =Math. 2 * lista.get(1).getCoordenada().getX() - 2 * lista.get(0).getCoordenada().getX();

        Double B = 2 * lista.get(1).getCoordenada().getY() - 2 * lista.get(0).getCoordenada().getY();

        Double C = new Double(Math.pow(lista.get(0).getDistance(), 2) -
                Math.pow(lista.get(1).getDistance(), 2) -
                Math.pow(lista.get(0).getCoordenada().getX(), 2) +

                Math.pow(lista.get(1).getCoordenada().getX(), 2) -
                Math.pow(lista.get(0).getCoordenada().getY(), 2) +
                Math.pow(lista.get(1).getCoordenada().getY(), 2));

        Double D = 2 * lista.get(2).getCoordenada().getX() - 2 * lista.get(1).getCoordenada().getX();

        Double E = 2 * lista.get(2).getCoordenada().getY() - 2 * lista.get(1).getCoordenada().getY();

        Double F = new Double(Math.pow(lista.get(1).getDistance(), 2) -
                Math.pow(lista.get(2).getDistance(), 2) -
                Math.pow(lista.get(1).getCoordenada().getX(), 2) +

                Math.pow(lista.get(2).getCoordenada().getX(), 2) -
                Math.pow(lista.get(1).getCoordenada().getY(), 2) +
                Math.pow(lista.get(2).getCoordenada().getY(), 2));

        Double x = (C * E - F * B) / (E * A - B * D);
        Double y = (C * D - A * F) / (B * D - A * E);

        if (Double.isNaN(x) || Double.isNaN(y)){
            x=0.0;
            y=0.0;
        }

        Coordenada coordenada = new Coordenada(x, y);
        return coordenada;


    }

    @Override
    public void updateSatelites(List<SatellitesRequest> satellites) {
        LOGGER.info("updateSatelites recibe: " + satellites.toString());

        Satelite satelite = null;
        for (SatellitesRequest s : satellites) {
            satelite = sateliteRepository.getSateliteByName(s.getName());
            satelite.setDistance(s.getDistance());
            satelite.GetMessage(s.getMessage());
        }
    }

    /** TODO SE PODRIA MEJORAR para que no se rompa en los indices**/

    @Override
    public String getMensajeSatelites(List<Satelite> lista) {

        StringBuilder mensaje=new StringBuilder();

        for (int i=0;i<lista.get(0).getListaMessage().size();i++){
            mensaje= armarMensaje(lista.get(0).getListaMessage().get(i),lista.get(1).getListaMessage().get(i),lista.get(2).getListaMessage().get(i),mensaje);
        }

        mensaje=mensaje.replace(0,1,"");


        return  mensaje.toString();
    }

    @Override
    public void updatSatelite(String name, Double distance, List<String> message) {
        Satelite satelite=sateliteRepository.getSateliteByName(name);
        satelite.setMessage(message);
        satelite.setDistance(distance);
        sateliteRepository.update(satelite);
    }

    /** TODO SE PODRIA MEJORAR**/
    private StringBuilder armarMensaje(String s, String s1, String s2, StringBuilder mensaje) {

        if(!s.isEmpty()){
            mensaje.append(" ");
            mensaje.append(s);
        }

        if(!s1.isEmpty()) {
            if(!mensaje.toString().trim().contentEquals(s1)){
                mensaje.append(" ");
                mensaje.append(s1);
            }
        }

        if(!s2.isEmpty()) {
            if(!mensaje.toString().trim().contentEquals(s2)){
                mensaje.append(" ");
                mensaje.append(s2);
            }
        }

            return mensaje;
    }
}
