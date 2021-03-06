package cl.ucn.disc.dsm.mlam.contactos;

import androidx.annotation.NonNull;

public class Contacto {

    private int id;
    private String nombre;
    private String cargo;
    private String unidad;
    private String email;
    private String telefono;
    private String oficina;
    private String direccion;

    @NonNull
    @Override
    public String toString() {
        return "nombre: "+this.nombre+ " id: "+this.id;
    }

    public Contacto(int id, String nombre, String cargo, String unidad, String email, String telefono, String oficina, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.unidad = unidad;
        this.email = email;
        this.telefono = telefono;
        this.oficina = oficina;
        this.direccion = direccion;
    }
}
