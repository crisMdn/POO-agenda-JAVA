import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;
    private int maxSize;

    public Agenda(int maxSize) {
        this.maxSize = maxSize;
        this.contactos = new ArrayList<>();
    }

    public Agenda() {
        this(10);
    }

    public boolean addContacto(Contacto contacto) {
        if (contactos.size() >= maxSize) {
            System.out.println("La agenda está llena. No se puede añadir más contactos.");
            return false;
        }
        if (contactos.contains(contacto)) {
            System.out.println("El contacto ya existe en la agenda.");
            return false;
        }
        contactos.add(contacto);
        return true;
    }

    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    public String buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c.getTelefono();
            }
        }
        return "Contacto no encontrado.";
    }

    public boolean eliminarContacto(Contacto contacto) {
        if (contactos.remove(contacto)) {
            System.out.println("Contacto eliminado.");
            return true;
        } else {
            System.out.println("Contacto no encontrado.");
            return false;
        }
    }

    public boolean estaLlena() {
        return contactos.size() >= maxSize;
    }

    public int espacioDisponible() {
        return maxSize - contactos.size();
    }
}
