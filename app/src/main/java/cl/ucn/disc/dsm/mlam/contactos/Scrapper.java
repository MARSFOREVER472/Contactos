package cl.ucn.disc.dsm.mlam.contactos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scrapper {

    public static final Logger log = LoggerFactory.getLogger(Scrapper.class);
    private final int maxId = 30000;
    private List<Contacto> contactos;

    public List<Contacto> getContactos() {
        return contactos;
    }

    public Scrapper() {
        this.contactos = new ArrayList<Contacto>();

    }

    public void startScrapper() {
        for(int id = 0; id <= maxId; id++){
            log.info("Buscando contacto con id: "+id);
            Contacto contacto = getContactoFromUrl(id);
            if (contacto != null){
                this.contactos.add(contacto);
            }
            Random random = new Random();
            int delay = 1000 + random.nextInt(500);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private Contacto getContactoFromUrl(int id) {
        final String url = "http://admision01.ucn.cl/directoriotelefonicoemail/fichaGenerica/?cod=";
        Contacto contacto = null;
        try{
            Document doc = Jsoup.connect(url+id).get();
            String nombre =  doc.getElementById("lblNombre").text();
            String cargo =  doc.getElementById("lblCargo").text();
            String unidad =  doc.getElementById("lblUnidad").text();
            String email =  doc.getElementById("lblEmail").text();
            String telefono =  doc.getElementById("lblTelefono").text();
            String oficina =  doc.getElementById("lblOficina").text();
            String direccion =  doc.getElementById("lblDireccion").text();
            if(!nombre.isEmpty()){
                contacto = new Contacto(id, nombre, cargo, unidad, email, telefono, oficina, direccion);
            }
        }catch(Exception e){
            log.error(e.getMessage());
        }

        return contacto;
    }
}
