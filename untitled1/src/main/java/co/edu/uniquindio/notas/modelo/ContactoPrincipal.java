package co.edu.uniquindio.notas.modelo;

import java.util.ArrayList;
import java.util.Random;
public class ContactoPrincipal {

    private ArrayList<Contacto> contactos;
    private Random random;


    public ContactoPrincipal(){
        this.contactos = new ArrayList<>();
        this.random = new Random();
    }
    public void agregarContacto (Contacto contacto){

        contactos.add(contacto);

    }
    public void eliminarContacto(int id) throws Exception {
        if (contactos.isEmpty()) {
            throw new Exception("No hay notas disponibles para eliminar.");
        }
        boolean eliminado = contactos.removeIf(contacto -> contacto.getId() == id);
        if (!eliminado) {
            throw new Exception("No se encontró una nota con el ID proporcionado.");
        }
    }

    public ArrayList<Contacto> listarNotas(){
        return this.contactos;
    }
    public  int generarIdAleatorio() {
        return 10 + random.nextInt(90); // Genera un número entre 10 y 99
    }


}
